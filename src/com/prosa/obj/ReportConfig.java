package com.prosa.obj;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReportConfig {

	private String reportName;
	private Map<String, String> params;
	private String pdfName;
	private char periodicity;
	private String transmitionWay;
	private String interchangeFlow;

	public ReportConfig() {
		params = new HashMap<>();
		periodicity = 'D';
		transmitionWay = "B";
		interchangeFlow = "C";
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

	public char getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(char periodicity) {
		this.periodicity = periodicity;
	}

	public String getTransmitionWay() {
		return transmitionWay;
	}

	public void setTransmitionWay(String transmitionWay) {
		this.transmitionWay = transmitionWay;
	}

	public String getInterchangeFlow() {
		return interchangeFlow;
	}

	public void setInterchangeFlow(String interchangeFlow) {
		this.interchangeFlow = interchangeFlow;
	}
	
	public String getPdfNameReal() {
		DateFormat df = new SimpleDateFormat("yyMMdd");
		String dateString = df.format(new Date());
		return this.pdfName.replace("AAMMDD", dateString).replace('H', this.periodicity)
				.replaceFirst("I", this.transmitionWay).replaceFirst("I", this.interchangeFlow);
	}

}
