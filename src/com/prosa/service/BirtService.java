package com.prosa.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.prosa.birt.BirtImplementation;
import com.prosa.obj.ReportParams;
import com.prosa.obj.Constants;
import com.prosa.obj.ReportConfig;
import com.prosa.obj.ReportDb;

public class BirtService {
	
	private static Logger logger = LoggerFactory.getLogger(BirtService.class);
	
	
	public void generateReport(Integer reportNum, String initDate, String endDate) {
		logger.debug("Gerating report {} ...", reportNum);
		try {
			
			ReportConfig reportConfig = new ReportConfig(reportNum);
			
			if(ReportDb.REPORT_CONFIG.contains(reportConfig)) {
				logger.debug("Report exist in list, retriving params ..."); 
				int reportIndex = ReportDb.REPORT_CONFIG.indexOf(reportConfig);
				logger.debug("Getting report in position: {}", reportIndex);
				ReportDb.copyAttr(reportIndex, reportConfig);
				
				// Add param destination: /aplic/prod/pmt/rpt/sal/PMTRPTB999HAAMMDDII01.PDF
				reportConfig.setPdfName(String.format("%s/%s", BirtImplementation.PDF_DESTINATION, reportConfig.getPdfName()));
				
				if(reportConfig.getParams().containsKey(ReportParams.RANGO_FECHA_INI)) {
					reportConfig.getParams().put(ReportParams.RANGO_FECHA_INI, initDate);
					reportConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, endDate);
				}
				
				if(reportConfig.getParams().containsKey(ReportParams.RANGO_FECHA_INI_ORIG)) {
					reportConfig.getParams().put(ReportParams.RANGO_FECHA_INI_ORIG, initDate);
					reportConfig.getParams().put(ReportParams.RANGO_FECHA_FIN_ORIG, endDate);
				}
				
				
				BirtImplementation birtImplementation = new BirtImplementation();
				// Add param log config: /aplic/prod/pmt/rpt/log
				birtImplementation.buildPdf(null, null, reportConfig.getReportName(), reportConfig.getPdfName(), reportConfig.getParams());
			} else {
				System.out.println("Report no exist in list"); 
				logger.error("Report {} not supported", reportNum);
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void generateReport(String args[]) {
		BirtImplementation birtImplementation = new BirtImplementation();
		// Add param log config: /aplic/prod/pmt/rpt/log
		// Add param destination: /aplic/prod/pmt/rpt/sal/PMTRPTB999HAAMMDDII01.PDF
		String destination = String.format("%s/%s", BirtImplementation.PDF_DESTINATION, args[1]);
		birtImplementation.buildPdf(null, null, args[0], destination, buildParams(args));
		
	}
	
	private Map<String, String> buildParams(String args[]) {
		System.out.println("Building params with " + args.length + " params!");
		Map<String, String> params = new HashMap<>();
		
		setDbParams(args, params);
		
		setRepParams(args, params);
		
		System.out.println("Params build\n" + params);
		
		return params;
		
	}

	private void setDbParams(String[] args, Map<String, String> params) {
		// Database params
		String dbHost = args[2];
		String dbPort = args[3];
		String dbName = args[4];
		String dbUser = args[5];
		String dbPswd = args[6];
		if(dbHost.equalsIgnoreCase(Constants.EMPTY_VALUE) 
				|| dbPort.equalsIgnoreCase(Constants.EMPTY_VALUE)
				|| dbName.equalsIgnoreCase(Constants.EMPTY_VALUE)
				|| dbUser.equalsIgnoreCase(Constants.EMPTY_VALUE)
				|| dbPswd.equalsIgnoreCase(Constants.EMPTY_VALUE)) {
			logger.warn("Data base params incomplete...");
		} else {
			params.put(Constants.DB_HOST, dbHost);
			params.put(Constants.DB_PORT, dbPort);
			params.put(Constants.DB_NAME, dbName);
			params.put(Constants.DB_USER, dbUser);
			params.put(Constants.DB_PSWD, dbPswd);
		}
	}
	
	private void setRepParams(String[] args, Map<String, String> params) {
		int index = 7;
		
		// Report params
		setValue(ReportParams.USUARIO, args[index++], params);
		setValue(ReportParams.RANGO_FECHA_INI, args[index++], params); 
		setValue(ReportParams.RANGO_FECHA_FIN, args[index++], params); 
		setValue(ReportParams.RANGO_FECHA_INI_ORIG, args[index++], params); 
		setValue(ReportParams.RANGO_FECHA_FIN_ORIG, args[index++], params); 
		setValue(ReportParams.BANCO, args[index++], params); 
		setValue(ReportParams.NATURALEZA_CONTABLE, args[index++], params); 
		setValue(ReportParams.TIPO_LIQUIDACION, args[index++], params); 
		setValue(ReportParams.ROLE, args[index++], params); 
		setValue(ReportParams.MISC, args[index++], params); 
		setValue(ReportParams.TIPO_PROCESO, args[index++], params); 
		setValue(ReportParams.TIPO_EMISOR_ADQ, args[index++], params); 
		
		
	}
	
	private void setValue(String key, String value, Map<String, String> params) {
		if(!value.equalsIgnoreCase(Constants.EMPTY_VALUE))
			params.put(key, value);
	}
	
	public void dummy() {
		
//		BirtImplementation birtImplementation = new BirtImplementation();
//		birtImplementation.buildPdf(null, null, null, null, null); // Report hello world
//		
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("srvImgRmt", "https://aplicpm.prosa.com.mx/imgpmr");
//		params.put("srvImgLcl", "http://10.255.198.61:38080");
//		params.put("initDateOrig", "28/03/2023");
//		params.put("endDateOrig", "29/03/2023");
//		params.put("banco", "0");
//		birtImplementation.buildPdf(null, null, "SICLIR0060", null, params);
//		params.remove("banco");
//		params.put("agrDia", "01");
//		birtImplementation.buildPdf(null, null, "SICLIR0077", null, params);

	}

}
