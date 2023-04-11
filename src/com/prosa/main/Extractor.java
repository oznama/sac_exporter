package com.prosa.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prosa.obj.Constants;
import com.prosa.service.BirtService;


public class Extractor {
	
	private static Logger logger = LoggerFactory.getLogger(Extractor.class);
	
	public static void main(String args[]) {
		logger.info("Starting extractor");
		
		if( args.length > 0 && args.length == Constants.ARGS_LEGTH ) {
			System.out.println("Generating report ...");
			
			BirtService birtService = new BirtService();
			birtService.generateReport(args);
			
			
		} else if(args.length == 0) {
			logger.error("Params empty");
		}
		
		
		logger.info("Extraction finished!");
	}
}
