package com.prosa.birt;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.PDFRenderOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BirtImplementation {
	
	private static Logger logger = LoggerFactory.getLogger(BirtImplementation.class);
	
	private final String BIRT_HOME = "./ReportEngine";
	private final String LOG_CONFIG = "./logs";
	private final String REPORT_EXT = "rptdesign";
	private final String REPORT_SAMPLES = "ReportEngine/samples";
	private final String REPORT_HELLO_WORD = String.format("%s/hello_world.%s", REPORT_SAMPLES, REPORT_EXT);
	public static final String PDF_DESTINATION = "./tmp/report";
	private final String PDF_EXT = "pdf";
	public final String REPORT_SAC = "reports/%s.%s";
	
	private IReportEngine engine;
	private EngineConfig config;
	private PDFRenderOption pdfOptions;
	
	private String birtHome;
	private String logConfig;
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
	public void buildPdf(String birtHome, String logConfig, String report, String destination, Map<String, String> params) {
		validateInputs(birtHome, logConfig, report, destination, params);
		try {
			initConfig();
			Platform.startup(this.config);
			initEngine();
			initPdfOptions();
			IRunAndRenderTask task = engine.createRunAndRenderTask(engine.openReportDesign(this.report));
			if(params != null && !params.isEmpty()) {
				task.setParameterValues(params);
			}
			task.setRenderOption(pdfOptions);
			task.run();
			task.close();
			engine.destroy();
		} catch (final Exception EX) {
			EX.printStackTrace();
		} finally {
			Platform.shutdown();
		}
	}
	
	private void validateInputs(String birtHome, String logConfig, String report, String destination, 
			Map<String, String> params) {
		this.birtHome = birtHome != null ? birtHome : BIRT_HOME;
		logger.debug("Setting birt home: {}", this.birtHome);
		
		this.logConfig = logConfig != null ? logConfig : LOG_CONFIG;
		logger.debug("Setting log config: {}", this.logConfig);
		
		this.report = report != null ? String.format(REPORT_SAC, report, REPORT_EXT) : REPORT_HELLO_WORD;
		
		String date = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss").format(LocalDateTime.now());
		this.destination = destination != null ? String.format("%s.%s", destination, PDF_EXT.toUpperCase()) : 
			String.format("%s/%s_%s.%s", PDF_DESTINATION, getFileDestinationName(this.report), date, PDF_EXT);
		logger.debug("Saving report to: {}", this.destination);
		logger.debug("Params: {}", params);
	}

	private void initConfig() throws BirtException {
		this.config = new EngineConfig();
		this.config.setBIRTHome(birtHome);
		this.config.setLogConfig(logConfig, Level.FINE);
		logger.debug("Config: {}", config);
	}
	
	private void initEngine() {
		final IReportEngineFactory FACTORY = (IReportEngineFactory) Platform
				.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
		engine = FACTORY.createReportEngine(config);
		logger.debug("Engine: {}", engine);
	}
	
	private void initPdfOptions() {
		pdfOptions = new PDFRenderOption();
		pdfOptions.setOutputFileName(destination);
		pdfOptions.setOutputFormat(PDF_EXT);
	}
	
	private String getFileDestinationName(final String report) {
		final String reportName = report.substring(report.lastIndexOf("/")+1, report.indexOf(REPORT_EXT)-1);
		logger.debug("Report name: {}", reportName);
		return reportName;
	}

}
