package com.prosa.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.prosa.birt.BirtImplementation;
import com.prosa.obj.Constants;
import com.prosa.obj.ReportConfig;
import com.prosa.obj.BirtReports;

public class BirtService {
	
	private static Logger logger = LoggerFactory.getLogger(BirtService.class);
	
	private ReportConfig reportConfig;
	
	public void generateReport(String args[]) {
		String reportNum = args[0];
		logger.debug("Gerating report {} ...", reportNum);
		try {
			
			selectReport(args);
			
			if(reportConfig != null) {
				
				// Add param destination: /aplic/prod/pmt/rpt/sal/PMTRPTB999HAAMMDDII01.PDF
				reportConfig.setPdfName(String.format("%s/%s", BirtImplementation.PDF_DESTINATION, reportConfig.getPdfNameReal()));
				
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
	
	public void selectReport(String[] args) {
		String reportName = args[0];
		System.out.println("Searching report: " + reportName);
		BirtReports reportDb = new BirtReports();
		switch (reportName) {
		case "SICLIR0060":
			this.reportConfig = reportDb.createSICLIR0060(args);
			break;
		case "SICLIR0077":
			this.reportConfig = reportDb.createSICLIR0077(args);
			break;
		case "SICLIR0010":
			this.reportConfig = reportDb.createSICLIR0010(args);
			break;
		case "SICLIR0011":
			this.reportConfig = reportDb.createSICLIR0011(args);
			break;
		case "SICLIR0030":
			this.reportConfig = reportDb.createSICLIR0030(args);
			break;
		case "SICLIR0040":
			this.reportConfig = reportDb.createSICLIR0040(args);
			break;
		case "SICCMR0060":
			this.reportConfig = reportDb.createSICCMR0060(args);
			break;
		case "SICCMR0077":
			this.reportConfig = reportDb.createSICCMR0077(args);
			break;
		case "SICLIR0090":
			this.reportConfig = reportDb.createSICLIR0090(args);
			break;
		case "SICLIR0050":
			this.reportConfig = reportDb.createSICLIR0050(args);
			break;
		case "SICLIR0087":
			this.reportConfig = reportDb.createSICLIR0087(args);
			break;
		case "SICLIR0320":
			this.reportConfig = reportDb.createSICLIR0320(args);
			break;
		case "SICLIR0350":
			this.reportConfig = reportDb.createSICLIR0350(args);
			break;
		case "SICLIR0360":
			this.reportConfig = reportDb.createSICLIR0360(args);
			break;
		case "SICMOR0280":
			this.reportConfig = reportDb.createSICMOR0280(args);
			break;
		case "SICMOR0350":
			this.reportConfig = reportDb.createSICMOR0350(args);
			break;
		case "SICMIR0300":
			this.reportConfig = reportDb.createSICMIR0300(args);
			break;
		case "SICLIR0200":
			this.reportConfig = reportDb.createSICLIR0200(args);
			break;
		case "SICLIR0020":
			this.reportConfig = reportDb.createSICLIR0020(args);
			break;
		case "SICMOR0200":
			this.reportConfig = reportDb.createSICMOR0200(args);
			break;
		case "SICMOR0170":
			this.reportConfig = reportDb.createSICMOR0170(args);
			break;
		case "SICMIR0290":
			this.reportConfig = reportDb.createSICMIR0290(args);
			break;
		case "SICDCC0100":
			this.reportConfig = reportDb.createSICDCC0100(args);
			break;
		case "SICMOR0100":
			this.reportConfig = reportDb.createSICMOR0100(args);
			break;
		case "SICPRO002 ":
			this.reportConfig = reportDb.createSICPRO002(args);
			break;
		case "SICLIR0130":
			this.reportConfig = reportDb.createSICLIR0130(args);
			break;
		case "SICLIR0140":
			this.reportConfig = reportDb.createSICLIR0140(args);
			break;
		case "SICLIRP320":
			this.reportConfig = reportDb.createSICLIRP320(args);
			break;
		case "SICLIR002":
			this.reportConfig = reportDb.createSICLIR002(args);
			break;
		case "SICLIRI0050":
			this.reportConfig = reportDb.createSICLIRI0050(args);
			break;
		case "SICLIRI0060":
			this.reportConfig = reportDb.createSICLIRI0060(args);
			break;
		case "SICLIRI0020":
			this.reportConfig = reportDb.createSICLIRI0020(args);
			break;
		case "SICLIRI0130":
			this.reportConfig = reportDb.createSICLIRI0130(args);
			break;
		case "SICLIRD0050":
			this.reportConfig = reportDb.createSICLIRD0050(args);
			break;
		case "SICLIRD0060":
			this.reportConfig = reportDb.createSICLIRD0060(args);
			break;
		case "SICLIRD0020":
			this.reportConfig = reportDb.createSICLIRD0020(args);
			break;
		case "SICLIRD0130":
			this.reportConfig = reportDb.createSICLIRD0130(args);
			break;
		case "SICLICE0300":
			this.reportConfig = reportDb.createSICLICE0300(args);
			break;
		case "SICLICA0170":
			this.reportConfig = reportDb.createSICLICA0170(args);
			break;
		case "SICLICE0170":
			this.reportConfig = reportDb.createSICLICE0170(args);
			break;
		default:
			System.out.println("Report "+ reportName +" not match!");
			this.reportConfig = null;
		}
	}

}
