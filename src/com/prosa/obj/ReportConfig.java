package com.prosa.obj;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ReportConfig {

	private Integer reportNum;
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

	public ReportConfig(Integer reportNum) {
		this();
		this.reportNum = reportNum;
	}

	public Integer getReportNum() {
		return reportNum;
	}

	public void setReportNum(Integer reportNum) {
		this.reportNum = reportNum;
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

	@Override
	public int hashCode() {
		return Objects.hash(reportNum);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReportConfig other = (ReportConfig) obj;
		return Objects.equals(reportNum, other.reportNum);
	}

}
