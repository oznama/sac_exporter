package com.prosa.obj;

public class BirtReports {

	/**
	 * Reporte 1
	 * LIBERACIÓN SALIENTE
	 * SICLIR0060 Reporte de la Compensación Saliente
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICLIR0060(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName("PMTRPTB999HAAMMDDII01");
		repConfig.getParams().put(ReportParams.BANCO, args[1]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI_ORIG, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN_ORIG, args[3]);
		return repConfig;
	}

	/**
	 * Reporte 2
	 * LIBERACIÓN SALIENTE
	 * SICLIR0077 Consolidado Saliente E-Global
	 */
	public ReportConfig createSICLIR0077(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName("PMTRPTB999HAAMMDDII02");
		repConfig.getParams().put(ReportParams.NATURALEZA_CONTABLE, args[1]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI_ORIG, args[2]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN_ORIG, args[3]);
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
		repConfig.setPdfName("PMTRPTB999HAAMMDDII03");
		repConfig.getParams().put(ReportParams.BANCO, args[1]);
		repConfig.getParams().put(ReportParams.TIPO_LIQUIDACION, args[2]);
		repConfig.getParams().put(ReportParams.ROLE, args[3]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[4]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[5]);
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
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Reporte 5
	 * CIRCUITO LOCAL
	 * SICLIR0030 Reporte Consolidado de la Compensación Circuito Local
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICLIR0030(String[] args) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Reporte 7
	 * COMPENSACION Y LIBERACION MASTERCARD NACIONAL
	 * SICCMR0060 Reporte de la Compensación Cámaras Prosa-Mastercard
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICCMR0060(String[] args) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Reporte 8
	 * COMPENSACION Y LIBERACION MASTERCARD NACIONAL
	 * SICCMR0077 Reporte Consolidado Cámara
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICCMR0077(String[] args) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Reporte 9
	 * COMPENSACION Y LIBERACION MASTERCARD NACIONAL
	 * SICLIR0090 Reporte de Compensación
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICLIR0090(String[] args) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Reporte 10
	 * COMPENSACIÓN Y LIBERACION ENTRANTE
	 * SICLIR0050 Reporte de la Compensación Entrante
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICLIR0050(String[] args) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Reporte 11
	 * COMPENSACIÓN Y LIBERACION ENTRANTE
	 * SICLIR0087 Consolidado Entrante E-Global
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICLIR0087(String[] args) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Reporte 12
	 * COMPENSACIÓN Y LIBERACION ENTRANTE
	 * SICLIR0320 Reporte Consolidado de Saldos
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICLIR0320(String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Reporte 13, 14
	 * ACLARACIONES POS
	 * SICLIR0350 Reporte de Misceláneos
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICLIR0350(String args[]) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(args[0]);
		repConfig.setPdfName("PMTRPTB999HAAMMDDII11");
		repConfig.getParams().put(ReportParams.BANCO, args[1]);
		repConfig.getParams().put(ReportParams.MISC, args[2]);
		repConfig.getParams().put(ReportParams.TIPO_PROCESO, args[3]);
		repConfig.getParams().put(ReportParams.TIPO_EMISOR_ADQ, args[4]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[5]);
		repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[6]);
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
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
		return null;
	}
	
	public ReportConfig createSICMIR0300(String[] args) {
		return null;
	}
	
	public ReportConfig createSICLIR0200(String[] args) {
		return null;
	}
	
	public ReportConfig createSICLIR0020(String[] args) {
		return null;
	}
	
	public ReportConfig createSICMOR0200(String[] args) {
		return null;
	}
	
	public ReportConfig createSICMOR0170(String[] args) {
		return null;
	}
	
	public ReportConfig createSICMIR0290(String[] args) {
		return null;
	}
	
	public ReportConfig createSICDCC0100(String[] args) {
		return null;
	}
	
	public ReportConfig createSICMOR0100(String[] args) {
		return null;
	}
	
	public ReportConfig createSICPRO002(String[] args) {
		return null;
	}
	
	public ReportConfig createSICLIR0130(String[] args) {
		return null;
	}
	
	public ReportConfig createSICLIR0140(String[] args) {
		return null;
	}
	
	public ReportConfig createSICLIRP320(String[] args) {
		return null;
	}
	
	public ReportConfig createSICLIR002(String[] args) {
		return null;
	}
	
	public ReportConfig createSICLIRI0050(String[] args) {
		return null;
	}
	
	public ReportConfig createSICLIRI0060(String[] args) {
		return null;
	}
	
	public ReportConfig createSICLIRI0020(String[] args) {
		return null;
	}
	
	public ReportConfig createSICLIRI0130(String[] args) {
		return null;
	}
	
	public ReportConfig createSICLIRD0050(String[] args) {
		return null;
	}
	
	public ReportConfig createSICLIRD0060(String[] args) {
		return null;
	}
	
	public ReportConfig createSICLIRD0020(String[] args) {
		return null;
	}
	
	public ReportConfig createSICLIRD0130(String[] args) {
		return null;
	}
	
	public ReportConfig createSICLICE0300(String[] args) {
		return null;
	}
	
	public ReportConfig createSICLICA0170(String[] args) {
		return null;
	}
	
	public ReportConfig createSICLICE0170(String[] args) {
		return null;
	}
	
}
