package com.prosa.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prosa.service.BirtService;


public class Extractor {
	
	private static Logger logger = LoggerFactory.getLogger(Extractor.class);
	
	public static void main(String args[]) {
		logger.info("Starting extractor");
		
		if( args.length > 0 ) {
			
			String reportName = args[0];
			String initDate = args[1];
			String endDate = args[2];
			
			BirtService birtService = new BirtService();
			birtService.generateReport(reportName, initDate, endDate);
			
			
		} else if(args.length == 0) {
			logger.error("Params empty");
		}
		
		
		logger.info("Extraction finished!");
	}
}
