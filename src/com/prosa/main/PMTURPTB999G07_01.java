package com.prosa.main;

import org.apache.log4j.Logger;

import com.prosa.service.BirtService;

public class PMTURPTB999G07_01 {
	
	private static Logger logger = Logger.getLogger(PMTURPTB999G07_01.class);
	
	public static void main(String args[]) {
		logger.info("Starting extraction");
		if( args.length > 0 ) {
			BirtService birtService = new BirtService();
			birtService.generateReport(args);
		} else if(args.length == 0) {
			logger.error("Params empty");
		}
		logger.info("Extraction finished!");
	}
}
