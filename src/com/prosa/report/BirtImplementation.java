package com.prosa.report;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.logging.Level;

import org.apache.log4j.Logger;
import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.IEngineTask;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.PDFRenderOption;

import com.prosa.obj.Constants;

/**
 * BIRT Implementation
 * drops versions: https://archive.eclipse.org/birt/downloads/drops/
 * @author oziel
 *
 */

public class BirtImplementation {
	
	private static final Logger logger = Logger.getLogger(BirtImplementation.class);
	
	private final String BIRT_HOME = "./ReportEngine";
	private final String LOG_CONFIG = "./logs";
	private final String REPORT_EXT = "rptdesign";
	private final String REPORT_SAMPLES = "ReportEngine/samples";
	private final String REPORT_HELLO_WORD = String.format("%s/hello_world.%s", REPORT_SAMPLES, REPORT_EXT);
	private final String REPORT_PATH = "reports";
	
	
	private IReportEngine engine;
	private EngineConfig config;
	private PDFRenderOption pdfOptions;
	
	private String birtHome;
	private String logConfig;
	private String pathReports;
	private String report;
	private String destination;
	
	/**
	 * 
	 * @param birtHome
	 * @param logConfig
	 * @param report
	 * @param destination
	 * @param params
	 */
	public void buildPdf(String birtHome, String logConfig, String pathReports, String report, String destination, Map<String, String> params, boolean isRedund) {
		validateInputs(birtHome, logConfig, pathReports, report, destination, params);
		logger.info("Setting Report Engine ...");
		boolean hasError = false;
		try {
			initConfig();
			Platform.startup(this.config);
			initEngine();
			initPdfOptions();
			IRunAndRenderTask task = engine.createRunAndRenderTask(engine.openReportDesign(this.report));
			if(params != null && !params.isEmpty()) {
				logger.debug("Params: " + params);
				task.setParameterValues(params);
			}
			task.setRenderOption(pdfOptions);
			logger.info("Report Engine READY!");
			logger.info("Report will be created as: " + this.destination);
			logger.info("Running and Rendering report: " + this.report);
			task.run();
			
			logger.info("Status: " + task.getStatus());
			hasError = task.getStatus() == IEngineTask.STATUS_FAILED;
			
			if(task.getStatus() == IEngineTask.STATUS_SUCCEEDED)
				logger.info("Report saved to: " + this.destination);
			else {
				logger.info("Errors: " + task.getErrors().size());
				for(Object error : task.getErrors()) {
					logger.error("Error code: " + error.hashCode() + " ::: " + error.toString());
				}
			}
			
			task.close();
			engine.destroy();
			
			if(hasError)
				Runtime.getRuntime().halt(2);
		} catch (final BirtException e) {
			if(e.getMessage().contains("can not be found") && isRedund) {
				buildPdf(birtHome, logConfig, pathReports, report.toLowerCase(), destination, params, false);
			} else {
				logger.error("Error creating BIRT report", e);
				Runtime.getRuntime().halt(2);
			}
		} finally {
			Platform.shutdown();
		}
	}
	
	private void validateInputs(String birtHome, String logConfig, String pathReports, String report, String destination, 
			Map<String, String> params) {
		logger.debug("Checking BIRT setting ...");
		this.birtHome = birtHome != null ? birtHome : BIRT_HOME;
		logger.debug("BIRT home: " + this.birtHome);
		
		this.logConfig = logConfig != null ? logConfig : LOG_CONFIG;
		logger.debug("BIRT log path: " + this.logConfig);
		
		this.pathReports = pathReports != null ? pathReports : REPORT_PATH;
		logger.debug("BIRT report path: " + this.pathReports);
		
		this.report = report != null ? String.format(Constants.REPORT_SAC, this.pathReports, report, REPORT_EXT) : REPORT_HELLO_WORD;
		
		String date = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss").format(LocalDateTime.now());
		this.destination = destination != null ? String.format("%s.%s", destination, Constants.PDF_EXT.toUpperCase()) : 
			String.format("%s/%s_%s.%s", Constants.PDF_DESTINATION, getFileDestinationName(this.report), date, Constants.PDF_EXT);
	}

	private void initConfig() throws BirtException {
		this.config = new EngineConfig();
		this.config.setBIRTHome(birtHome);
		this.config.setLogConfig(logConfig, Level.ALL);
		logger.debug("Config: " + config);
	}
	
	private void initEngine() {
		final IReportEngineFactory FACTORY = (IReportEngineFactory) Platform
				.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
		engine = FACTORY.createReportEngine(config);
		logger.debug("Engine: " + engine.getVersion());
	}
	
	private void initPdfOptions() {
		pdfOptions = new PDFRenderOption();
		pdfOptions.setOutputFileName(destination);
		pdfOptions.setOutputFormat(Constants.PDF_EXT);
	}
	
	private String getFileDestinationName(final String report) {
		final String reportName = report.substring(report.lastIndexOf("/")+1, report.indexOf(REPORT_EXT)-1);
		logger.debug("Report name: " + reportName);
		return reportName;
	}

}
