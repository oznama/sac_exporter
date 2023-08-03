package com.prosa.obj;

import java.util.HashMap;
import java.util.Map;

public class ReportConfig {

	private String reportName;
	private Map<String, String> params;
	private String pdfName;
	private ReportType reportType;

	public ReportConfig() {
		params = new HashMap<>();
		reportType = ReportType.BIRT;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}

	public String getPdfName() {
		return pdfName;
	}

	public void setPdfName(String pdfName) {
		this.pdfName = pdfName;
	}
	
	public ReportType getReportType() {
		return reportType;
	}

	public void setReportType(ReportType reportType) {
		this.reportType = reportType;
	}

}
