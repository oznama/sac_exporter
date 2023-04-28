package com.prosa.obj;

public class ReportSetting {

	/**
	 * Reporte 1
	 * LIBERACI�N SALIENTE
	 * SICLIR0060 Reporte de la Compensaci�n Saliente
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICLIR0060(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCO, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI_ORIG, args[3]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN_ORIG, args[4]);
		return repConfig;
	}

	/**
	 * Reporte 2
	 * LIBERACI�N SALIENTE
	 * SICLIR0077 Consolidado Saliente E-Global
	 */
	public ReportConfig createSICLIR0077(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.NATURALEZA_CONTABLE, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI_ORIG, args[3]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN_ORIG, args[4]);
		return repConfig;
	}

	/**
	 * Reporte 3
	 * CIRCUITO LOCAL
	 * SICLIR0010 Reporte de Compensaciones Complementarias
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICLIR0010(String args[]) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCO, args[2]);
		repConfig.getParams().put(ReportParams.TIPO_LIQUIDACION, args[3]);
		repConfig.getParams().put(ReportParams.ROLE, args[4]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[5]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[6]);
		return repConfig;
	}

	/**
	 * Reporte 4
	 * CIRCUITO LOCAL
	 * SICLIR0011 Reporte de Compensaciones Complementarias PROSA
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICLIR0011(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCO, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
		return repConfig;
	}
	
	/**
	 * Reporte 5
	 * CIRCUITO LOCAL
	 * SICLIR0030 Reporte Consolidado de la Compensaci�n Circuito Local
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICLIR0030(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[3]);
		return repConfig;
	}
	
	/**
	 * Reporte 6
	 * CIRCUITO LOCAL
	 * SICLIR0040 Reporte de Saldos Diarios
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICLIR0040(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[3]);
		return repConfig;
	}

	/**
	 * Reporte 7
	 * COMPENSACION Y LIBERACION MASTERCARD NACIONAL
	 * SICCMR0060 Reporte de la Compensaci�n C�maras Prosa-Mastercard
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICCMR0060(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[3]);
		return repConfig;
	}
	
	/**
	 * Reporte 8
	 * COMPENSACION Y LIBERACION MASTERCARD NACIONAL
	 * SICCMR0077 Reporte Consolidado C�mara
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICCMR0077(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportType(ReportType.JASPER);
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.ROLE, args[2]);
		repConfig.getParams().put(ReportParams.NUM_FIID, args[3]);
		repConfig.getParams().put(ReportParams.LOGIN, args[4]);
		repConfig.getParams().put(ReportParams.CAMARA_ADQ, args[5]);
		repConfig.getParams().put(ReportParams.MARCA, args[6]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[7]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[8]);
		return repConfig;
	}
	
	/**
	 * Reporte 9
	 * COMPENSACION Y LIBERACION MASTERCARD NACIONAL
	 * SICLIR0090 Reporte de Compensaci�n
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICLIR0090(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCO, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
		return repConfig;
	}
	
	/**
	 * Reporte 10
	 * COMPENSACI�N Y LIBERACION ENTRANTE
	 * SICLIR0050 Reporte de la Compensaci�n Entrante
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICLIR0050(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCO, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
		return repConfig;
	}
	
	/**
	 * Reporte 11
	 * COMPENSACI�N Y LIBERACION ENTRANTE
	 * SICLIR0087 Consolidado Entrante E-Global
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICLIR0087(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.NATCONTABLE, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
		return repConfig;
	}
	
	/**
	 * Reporte 12
	 * COMPENSACI�N Y LIBERACION ENTRANTE
	 * SICLIR0320 Reporte Consolidado de Saldos
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICLIR0320(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.TIPO_LIQUIDACION, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
		return repConfig;
	}

	/**
	 * Reporte 13, 14
	 * ACLARACIONES POS
	 * SICLIR0350 Reporte de Miscel�neos
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICLIR0350(String args[]) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCO, args[2]);
		repConfig.getParams().put(ReportParams.MISC, args[3]);
		repConfig.getParams().put(ReportParams.TIPO_PROCESO, args[4]);
		repConfig.getParams().put(ReportParams.TIPO_EMISOR_ADQ, args[5]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[6]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[7]);
		return repConfig;
	}
	
	/**
	 * Reporte 15, 16, 17
	 * ACLARACIONES POS
	 * SICLIR0360 Reporte de Contracargos y Representaciones
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICLIR0360(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCO, args[2]);
		repConfig.getParams().put(ReportParams.TIPO_PROCESO, args[3]);
		repConfig.getParams().put(ReportParams.TIPO_EMISOR_ADQ, args[4]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[5]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[6]);
		return repConfig;
	}
	
	/**
	 * Reporte 18
	 * CONCILIACION SCOTIABANK
	 * SICMOR0280 Reporte de Cifras de Control de Archivos de Salida
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICMOR0280(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCO, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
		return repConfig;
	}
	
	/**
	 * Reporte 19
	 * CONCILIACION SCOTIABANK
	 * SICMOR0350 Reporte de Transacciones con Reversos
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICMOR0350(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCO, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
		return repConfig;
	}
	
	public ReportConfig createSICMIR0300(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCO, args[2]);
		repConfig.getParams().put(ReportParams.TIPO_TRANSACCION, args[3]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[4]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[5]);
		return repConfig;
	}
	
	public ReportConfig createSICLIR0200(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCO, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
		return repConfig;
	}
	
	public ReportConfig createSICLIR0020(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCO, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
		return repConfig;
	}
	
	public ReportConfig createSICMOR0200(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCO_ADQUIRENTE, args[2]);
		repConfig.getParams().put(ReportParams.BANCO_EMISOR, args[3]);
		repConfig.getParams().put(ReportParams.FUENTE, args[4]);
		repConfig.getParams().put(ReportParams.TIPO_DE_TRANSACCION, args[5]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[6]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[7]);
		return repConfig;
	}
	
	public ReportConfig createSICMOR0170(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCO, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
		return repConfig;
	}
	
	public ReportConfig createSICMIR0290(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCO, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
		return repConfig;
	}
	
	public ReportConfig createSICDCC0100(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCO, args[2]);
		repConfig.getParams().put(ReportParams.FUENTE, args[3]);
		repConfig.getParams().put(ReportParams.TTR, args[4]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[5]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[6]);
		return repConfig;
	}
	
	public ReportConfig createSICMOR0100(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCOADQ, args[2]);
		repConfig.getParams().put(ReportParams.AFILIACION, args[3]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[4]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[5]);
		return repConfig;
	}
	
	public ReportConfig createSICPRO002(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCO, args[2]);
		repConfig.getParams().put(ReportParams.TIPO, args[3]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[4]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[5]);
		return repConfig;
	}
	
	public ReportConfig createSICLIR0130(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[3]);
		return repConfig;
	}
	
	public ReportConfig createSICLIR0140(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[3]);
		return repConfig;
	}
	
	public ReportConfig createSICLIRP320(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[3]);
		return repConfig;
	}
	
	public ReportConfig createSICLIR002(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCO_ADQUIRENTE, args[2]);
		repConfig.getParams().put(ReportParams.MARCA, args[3]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[4]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[5]);
		return repConfig;
	}
	
	public ReportConfig createSICLIRI0050(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCO, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
		return repConfig;
	}
	
	public ReportConfig createSICLIRI0060(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCO, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
		return repConfig;
	}
	
	public ReportConfig createSICLIRI0020(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCO, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
		return repConfig;
	}
	
	public ReportConfig createSICLIRI0130(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[3]);
		return repConfig;
	}
	
	public ReportConfig createSICLIRD0050(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCO, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
		return repConfig;
	}
	
	public ReportConfig createSICLIRD0060(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCO, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
		return repConfig;
	}
	
	public ReportConfig createSICLIRD0020(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCO, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
		return repConfig;
	}
	
	public ReportConfig createSICLIRD0130(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCO, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
		return repConfig;
	}
	
	public ReportConfig createSICLICE0300(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCO_ADQUIRENTE, args[2]);
		repConfig.getParams().put(ReportParams.BANCO_EMISOR, args[3]);
		repConfig.getParams().put(ReportParams.FUENTE, args[4]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[5]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[6]);
		return repConfig;
	}
	
	public ReportConfig createSICLICA0170(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCO, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
		return repConfig;
	}
	
	public ReportConfig createSICLICE0170(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCO, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
		return repConfig;
	}
	
	public ReportConfig createSICMIR0420(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName(args[1]);
		repConfig.getParams().put(ReportParams.BANCOADQ, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
		return repConfig;
	}
	
}
