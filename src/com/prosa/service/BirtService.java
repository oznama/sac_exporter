package com.prosa.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.prosa.birt.BirtImplementation;
import com.prosa.obj.Constants;
import com.prosa.obj.ReportConfig;
import com.prosa.obj.ReportDb;

public class BirtService {
	
	private static Logger logger = LoggerFactory.getLogger(BirtService.class);
	
	public void generateReport(String reportName, String initDate, String endDate) {
		logger.debug("Gerating report {} ...", reportName);
		try {
			
			ReportConfig reportConfig = new ReportConfig(reportName);
			
			if(ReportDb.REPORT_CONFIG.contains(reportConfig)) {
				logger.debug("Report exist in list, retriving params ..."); 
				int reportIndex = ReportDb.REPORT_CONFIG.indexOf(reportConfig);
				logger.debug("Getting report in position: {}", reportIndex);
				ReportDb.copyAttr(reportIndex, reportConfig);
				
				// Add param destination: /aplic/prod/pmt/rpt/sal/PMTRPTB999HAAMMDDII01.PDF
				reportConfig.setPdfName(String.format("%s/%s", BirtImplementation.PDF_DESTINATION, reportConfig.getPdfName()));
				
				reportConfig.getParams().put(Constants.PARAM_RANGO_FECHA_INI, initDate);
				reportConfig.getParams().put(Constants.PARAM_RANGO_FECHA_FIN, endDate);
				
				BirtImplementation birtImplementation = new BirtImplementation();
				// Add param log config: /aplic/prod/pmt/rpt/log
				birtImplementation.buildPdf(null, null, reportName, reportConfig.getPdfName(), reportConfig.getParams());
			} else {
				System.out.println("Report no exist in list"); 
				logger.error("Report {} not supported", reportName);
			}
					
		} catch (Exception e) {
			
		}
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
