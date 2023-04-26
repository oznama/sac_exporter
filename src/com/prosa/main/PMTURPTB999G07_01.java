package com.prosa.main;

import org.apache.log4j.Logger;

import com.prosa.service.ReportService;

public class PMTURPTB999G07_01 {
	
	private static Logger logger = Logger.getLogger(PMTURPTB999G07_01.class);
	
	public static void main(String args[]) {
		logger.info("Starting extraction");
		if( args.length > 0 ) {
			ReportService reportService = new ReportService();
			reportService.generateReport(args);
		} else if(args.length == 0) {
			logger.error("Params empty");
		}
		logger.info("Extraction finished!");
	}
}
