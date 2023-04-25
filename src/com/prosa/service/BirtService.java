package com.prosa.service;

import org.apache.log4j.Logger;

import com.prosa.birt.BirtImplementation;
import com.prosa.main.Properties;
import com.prosa.obj.Constants;
import com.prosa.obj.ReportConfig;
import com.prosa.obj.BirtReports;

public class BirtService {
	
	private static Logger logger = Logger.getLogger(BirtService.class);
	
	private ReportConfig reportConfig;
	
	// Load with properties
	private String pathBirtHome = null;
	
	public void generateReport(String args[]) {
		String reportNum = args[0];
		logger.debug("Gerating report " + reportNum + " ...");
		try {
			selectReport(args);
			if(reportConfig != null) {
				setDbParams();
				reportConfig.setPdfName(String.format("%s/%s", Properties.PATH_DEST == null ? 
						BirtImplementation.PDF_DESTINATION : Properties.PATH_DEST, reportConfig.getPdfNameReal()));
				BirtImplementation birtImplementation = new BirtImplementation();
				birtImplementation.buildPdf(pathBirtHome, Properties.PATH_LOG, Properties.PATH_REPORTS, 
						reportConfig.getReportName(), reportConfig.getPdfName(), reportConfig.getParams());
			} else {
				logger.error("Report "+ reportNum +" not supported");
			}
					
		} catch (Exception e) {
			logger.error("Error to generate report", e);
		}
	}
	

	private void setDbParams() {
		reportConfig.getParams().put(Constants.DB_HOST, Properties.DB_HOST);
		reportConfig.getParams().put(Constants.DB_PORT, Properties.DB_PORT);
		reportConfig.getParams().put(Constants.DB_NAME, Properties.DB_NAME);
		reportConfig.getParams().put(Constants.DB_USER, Properties.DB_USER);
		reportConfig.getParams().put(Constants.DB_PSWD, Properties.DB_PSWD);
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
			logger.warn("Report not "+ reportName +" match");
			this.reportConfig = null;
		}
	}

}
