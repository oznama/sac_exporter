package com.prosa.obj;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;

public class ReportDb {

	public static final List<ReportConfig> REPORT_CONFIG = new ArrayList<>();

	static {
		add001(); // Corresponde al reporte SICLIR0060
		add002(); // Corresponde al reporte SICLIR0077
		add003(); // Corresponde al reporte SICLIR0010

		add013();
		add014();
	}

	public static void copyAttr(int reportIndex, ReportConfig target) {
		ReportConfig source = REPORT_CONFIG.get(reportIndex);
		target.setReportName(source.getReportName());
		target.setPdfName(processReportDate(source));
		target.setParams(source.getParams());
	}

	private static String processReportDate(ReportConfig source) {
		DateFormat df = new SimpleDateFormat("yyMMdd");
		String dateString = df.format(new Date());
		return source.getPdfName().replace("AAMMDD", dateString).replace('H', source.getPeriodicity())
				.replaceFirst("I", source.getTransmitionWay()).replaceFirst("I", source.getInterchangeFlow());
	}

	/**
	 * Genera configuracion del reporte SICLIR0060
	 */
	private static void add001() {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportNum(1);
		repConfig.setReportName("SICLIR0060");
		repConfig.setPdfName("PMTRPTB999HAAMMDDII01");

		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI_ORIG, null);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN_ORIG, null);

		repConfig.getParams().put(ReportParams.BANCO, "0");

		REPORT_CONFIG.add(repConfig);
	}

	/**
	 * Genera configuracion del reporte SICLIR0077
	 */
	private static void add002() {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportNum(2);
		repConfig.setReportName("SICLIR0077");
		repConfig.setPdfName("PMTRPTB999HAAMMDDII02");

		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI_ORIG, null);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN_ORIG, null);
		repConfig.getParams().put(ReportParams.NATURALEZA_CONTABLE, "01");

		REPORT_CONFIG.add(repConfig);
	}

	private static void add003() {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportNum(3);
		repConfig.setReportName("SICLIR0010");
		repConfig.setPdfName("PMTRPTB999HAAMMDDII03");

		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, null);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, null);
		repConfig.getParams().put(ReportParams.TIPO_LIQUIDACION, "22");
		repConfig.getParams().put(ReportParams.ROLE, "banco");

		REPORT_CONFIG.add(repConfig);
	}

	private static void add013() {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportNum(13);
		repConfig.setReportName("SICLIR0350");
		repConfig.setPdfName("PMTRPTB999HAAMMDDII11");

		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, null);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, null);
		repConfig.getParams().put(ReportParams.MISC, "105");
		// TODO Buscar valor para tipo proceso Circuito local
		repConfig.getParams().put(ReportParams.TIPO_PROCESO, "100");
		// TODO Buscar valor para tipo de emisor adquirente a favot de banco
		repConfig.getParams().put(ReportParams.TIPO_EMISOR_ADQ, "EMI");

		REPORT_CONFIG.add(repConfig);
	}

	private static void add014() {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportNum(14);
		repConfig.setReportName("SICLIR0350");
		repConfig.setPdfName("PMTRPTB999HAAMMDDII12");

		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, null);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, null);
		repConfig.getParams().put(ReportParams.MISC, "105");
		// TODO Buscar valor para tipo proceso Entrante
		repConfig.getParams().put(ReportParams.TIPO_PROCESO, "100");
		// TODO Buscar valor para tipo de emisor adquirente a favot de banco
		repConfig.getParams().put(ReportParams.TIPO_EMISOR_ADQ, "EMI");

		REPORT_CONFIG.add(repConfig);
	}

}
