package com.prosa.report;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import com.prosa.dao.SICCMRDAO;

import com.prosa.jasper.beans.CriteriosObj;
import com.prosa.jasper.beans.SICCMRObj;
import com.prosa.main.Properties;
import com.prosa.obj.Constants;
import com.prosa.obj.ReportConfig;
import com.prosa.obj.ReportParams;
import com.prosa.service.SACException;

import javax.swing.ImageIcon;

import org.apache.log4j.Logger;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.imageio.ImageIO;

public class JasperImplementation {

	private static final Logger logger = Logger.getLogger(JasperImplementation.class);

	private final String REPORT_EXT = "jrxml";
	
	private ReportConfig reportConfig;

	public void processRequest(ReportConfig reportConfig) throws SACException {

		logger.debug("Gerating report " + reportConfig.getReportName() + " ...");

		this.reportConfig = reportConfig;

		switch (this.reportConfig.getReportName()) {
		case "SICCMR0077":
			generateReportSICCMR0077();
			break;
		}

	}

	private void generateReportSICCMR0077() throws SACException {
		String grupo = this.reportConfig.getParams().get(ReportParams.ROLE);
		String fiidUsuario = this.reportConfig.getParams().get(ReportParams.NUM_FIID);
		String usuario = this.reportConfig.getParams().get(ReportParams.LOGIN);
		String[] camaraAdq = this.reportConfig.getParams().get(ReportParams.CAMARA_ADQ).split(",");
		String[] marca = this.reportConfig.getParams().get(ReportParams.MARCA).split(",");

		SICCMRDAO modelo = new SICCMRDAO();
		CriteriosObj criterios = new CriteriosObj();

		String owner = grupo.equalsIgnoreCase("administrador") || grupo.equalsIgnoreCase("operador") ? "%"
				: fiidUsuario;
		String rutaImagenes = "image"; // getServletContext().getRealPath("pics");

		criterios.setIni(this.reportConfig.getParams().get(ReportParams.RANGO_FECHA_INI));
		criterios.setFin(this.reportConfig.getParams().get(ReportParams.RANGO_FECHA_FIN));
		criterios.setCamaraAdq(camaraAdq);
		criterios.setMarca(marca);
		criterios.setOwner(owner);
		List<SICCMRObj> resultados = modelo.consultarSICCMR0077(criterios);

		Map<String, Object> params = new HashMap<>();
		try {
			ImageIcon icono = new ImageIcon(ImageIO.read(new File(rutaImagenes + "/logoProsa.png")));
			params.put("logo", icono.getImage());
		} catch (IOException e) {
			throw new SACException("IO Exception", e);
		}

		params.put("usuario", usuario);
		params.put("ini", criterios.getIni());
		params.put("fin", criterios.getFin());
		if (criterios.getMarca().length() != 4) {
			params.put("marca", modelo.descripcionesListaMarcas(marca));
		} else {
			params.put("marca", "TODAS");
		}
		params.put("camara", modelo.descripcionesListaCamaras(camaraAdq));
		params.put("titulo", Integer.valueOf(1));

		JRBeanCollectionDataSource dsR = new JRBeanCollectionDataSource(resultados);

		generatePDF(params, dsR);
	}

	private void generatePDF(Map<String, Object> params, JRBeanCollectionDataSource dsR) throws SACException {
		String reportPath = String.format(Constants.REPORT_SAC, Properties.getPATH_REPORTS(), this.reportConfig.getReportName(),
				REPORT_EXT);
		String pdfPath = String.format("%s.%s", reportConfig.getPdfName(), Constants.PDF_EXT.toUpperCase());
		logger.debug("Generating file " + reportPath);
		InputStream inputReport = null;
		try {
			inputReport = new FileInputStream(reportPath);
			JasperReport jasperReport = JasperCompileManager.compileReport(inputReport);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dsR);
			JasperExportManager.exportReportToPdfFile(jasperPrint, pdfPath);
			logger.debug("File " + pdfPath + " created!");
		} catch (FileNotFoundException e) {
			throw new SACException("File exception", e);
		} catch (JRException e) {
			throw new SACException("Jasper exception", e);
		} finally {
			if( inputReport != null ) {
				try {
					inputReport.close();
				} catch (IOException e) {
					logger.error("Impossible close Jasper report: " + reportPath);
				}
			}
		}
	}

}
