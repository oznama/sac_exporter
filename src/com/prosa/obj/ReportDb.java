package com.prosa.obj;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;

public class ReportDb {

	public static final List<ReportConfig> REPORT_CONFIG = new ArrayList<>();

	static {
		add001();
		add002();
	}
	
	public static void copyAttr(int reportIndex, ReportConfig target) {
		ReportConfig source = REPORT_CONFIG.get(reportIndex);
		target.setReportName(source.getPdfName());
		target.setPdfName(processReportDate(source));
		target.setParams(source.getParams());
	}
	
	private static String processReportDate(ReportConfig source) {
		DateFormat df = new SimpleDateFormat("yyMMdd");
		String dateString = df.format(new Date());
		return source.getPdfName()
				.replace("AAMMDD", dateString)
				.replace('H', source.getPeriodicity())
				.replaceFirst("I", source.getTransmitionWay())
				.replaceFirst("I", source.getInterchangeFlow());
	}
	
	
	
	private static void add001() {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName("SICLIR0060");
		repConfig.setPdfName("PMTRPTB999HAAMMDDII01");
		repConfig.getParams().put(Constants.PARAM_BANCO, "0");
		REPORT_CONFIG.add(repConfig);
	}

	private static void add002() {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName("SICLIR0077");
		repConfig.setPdfName("PMTRPTB999HAAMMDDII02");
		repConfig.getParams().put(Constants.PARAM_NATURALEZA_CONTABLE, "01");
		REPORT_CONFIG.add(repConfig);
	}

}
