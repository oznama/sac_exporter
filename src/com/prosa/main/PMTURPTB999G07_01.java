package com.prosa.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prosa.service.BirtService;

public class PMTURPTB999G07_01 {
	
	private static Logger logger = LoggerFactory.getLogger(PMTURPTB999G07_01.class);
	
	public static void main(String args[]) {
		logger.info("Starting extractor");
		
		if( args.length > 0 ) {
			System.out.println("Generating report ...");
			
			BirtService birtService = new BirtService();
			birtService.generateReport(args);
			
			
		} else if(args.length == 0) {
			logger.error("Params empty");
		}
		
		
		logger.info("Extraction finished!");
	}
}
