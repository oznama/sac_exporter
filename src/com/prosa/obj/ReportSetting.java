package com.prosa.obj;

public class ReportSetting {

	private String reportName;
	private int numReport;

	public ReportSetting(String arg0) {
		String[] firstParam = arg0.split("_"); // SICLIR0060_1
		String reportName = firstParam[0]; // SICLIR0060
		int numReport = Integer.valueOf(firstParam[1]); // 1
		this.reportName = reportName;
		this.numReport = numReport;
	}

	public String getReportName() {
		return this.reportName;
	}

	/**
	 * Reporte 1 LIBERACI�N SALIENTE SICLIR0060 Reporte de la Compensaci�n
	 * Saliente
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICLIR0060(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 1:
			repConfig.getParams().put(ReportParams.BANCO, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI_ORIG, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN_ORIG, args[4]);
			break;
		}
		return repConfig;
	}

	/**
	 * Reporte 2 LIBERACI�N SALIENTE SICLIR0077 Consolidado Saliente E-Global
	 */
	public ReportConfig createSICLIR0077(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 2:
			repConfig.getParams().put(ReportParams.NATCONTABLE, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
			break;
		}
		return repConfig;
	}

	/**
	 * Reporte 3 CIRCUITO LOCAL SICLIR0010 Reporte de Compensaciones Complementarias
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICLIR0010(String args[]) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 3:
			repConfig.getParams().put(ReportParams.BANCO, args[2]);
			repConfig.getParams().put(ReportParams.TIPO_LIQUIDACION, args[3]);
			repConfig.getParams().put(ReportParams.ROLE, args[4]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[5]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[6]);
			break;
		}
		return repConfig;
	}

	/**
	 * Reporte 4 CIRCUITO LOCAL SICLIR0011 Reporte de Compensaciones Complementarias
	 * PROSA
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICLIR0011(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 4:
			repConfig.getParams().put(ReportParams.BANCO, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
			break;
		}
		return repConfig;
	}

	/**
	 * Reporte 5 CIRCUITO LOCAL SICLIR0030 Reporte Consolidado de la Compensaci�n
	 * Circuito Local
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICLIR0030(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 5:
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[3]);
			break;
		}

		return repConfig;
	}

	/**
	 * Reporte 6 CIRCUITO LOCAL SICLIR0040 Reporte de Saldos Diarios
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICLIR0040(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 6:
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[3]);
			break;
		}
		return repConfig;
	}

	/**
	 * Reporte 7 COMPENSACION Y LIBERACION MASTERCARD NACIONAL SICCMR0060 Reporte de
	 * la Compensaci�n C�maras Prosa-Mastercard
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICCMR0060(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 7:
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[3]);
			break;
		}
		return repConfig;
	}

	/**
	 * Reporte 8 COMPENSACION Y LIBERACION MASTERCARD NACIONAL SICCMR0077 Reporte
	 * Consolidado C�mara
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICCMR0077(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportType(ReportType.JASPER);
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 8:
			repConfig.getParams().put(ReportParams.ROLE, args[2]);
			repConfig.getParams().put(ReportParams.NUM_FIID, args[3]);
			repConfig.getParams().put(ReportParams.LOGIN, args[4]);
			repConfig.getParams().put(ReportParams.CAMARA_ADQ, args[5]);
			repConfig.getParams().put(ReportParams.MARCA, args[6]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[7]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[8]);
			break;
		}
		return repConfig;
	}

	/**
	 * Reporte 9 COMPENSACION Y LIBERACION MASTERCARD NACIONAL SICLIR0090 Reporte de
	 * Compensaci�n
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICLIR0090(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 9:
			repConfig.getParams().put(ReportParams.BANCO, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
			break;
		}
		return repConfig;
	}

	/**
	 * Reporte 10 COMPENSACI�N Y LIBERACION ENTRANTE SICLIR0050 Reporte de la
	 * Compensaci�n Entrante
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICLIR0050(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 10:
		case 70:
		case 79:
		case 80:
		case 81:
		case 82:
			repConfig.getParams().put(ReportParams.BANCO, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
			break;
		}
		return repConfig;
	}

	/**
	 * Reporte 11 COMPENSACI�N Y LIBERACION ENTRANTE SICLIR0087 Consolidado
	 * Entrante E-Global
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICLIR0087(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 11:
			repConfig.getParams().put(ReportParams.NATCONTABLE, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
			break;
		}
		return repConfig;
	}

	/**
	 * Reporte 12 COMPENSACI�N Y LIBERACION ENTRANTE SICLIR0320 Reporte
	 * Consolidado de Saldos
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICLIR0320(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 12:
		case 67:
			repConfig.getParams().put(ReportParams.TIPO_LIQUIDACION, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
			break;
		}
		return repConfig;
	}

	/**
	 * Reporte 13, 14 ACLARACIONES POS SICLIR0350 Reporte de Miscel�neos
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICLIR0350(String args[]) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 13:
		case 14:
			repConfig.getParams().put(ReportParams.BANCO, args[2]);
			repConfig.getParams().put(ReportParams.MISC, args[3]);
			repConfig.getParams().put(ReportParams.TIPO_PROCESO, args[4]);
			repConfig.getParams().put(ReportParams.TIPO_EMISOR_ADQ, args[5]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[6]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[7]);
			break;
		}
		return repConfig;
	}

	/**
	 * Reporte 15, 16, 17 ACLARACIONES POS SICLIR0360 Reporte de Contracargos y
	 * Representaciones
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICLIR0360(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 15:
		case 16:
		case 17:
			repConfig.getParams().put(ReportParams.BANCO, args[2]);
			repConfig.getParams().put(ReportParams.TIPO_PROCESO, args[3]);
			repConfig.getParams().put(ReportParams.TIPO_ES, args[4]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[5]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[6]);
			break;
		case 35:
			repConfig.getParams().put(ReportParams.BANCO, args[2]);
			repConfig.getParams().put(ReportParams.CAMARA_ADQ, args[3]);
			repConfig.getParams().put(ReportParams.TIPO_PROCESO, args[4]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[5]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[6]);
			break;
		}
		return repConfig;
	}

	/**
	 * Reporte 18 CONCILIACION SCOTIABANK SICMOR0280 Reporte de Cifras de Control de
	 * Archivos de Salida
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICMOR0280(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 18:
		case 68:
		case 75:
		case 76:
			repConfig.getParams().put(ReportParams.BANCO, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
			break;
		}
		return repConfig;
	}

	/**
	 * Reporte 19 CONCILIACION SCOTIABANK SICMOR0350 Reporte de Transacciones con
	 * Reversos
	 * 
	 * @param args
	 * @return
	 */
	public ReportConfig createSICMOR0350(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 19:
			repConfig.getParams().put(ReportParams.BANCO, args[2]);
			repConfig.getParams().put(ReportParams.TIPO_TRANSACCION, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[4]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[5]);
			break;
		}
		return repConfig;
	}

	public ReportConfig createSICMIR0300(String[] args) {
		/*ReportConfig repConfig = new ReportConfig();

		String[] firstParam = args[0].split("_");
		String reportName = firstParam[0]; // SICLIR0060
		int numReport = Integer.valueOf(firstParam[1]); // 1
		repConfig.setReportName(reportName);
		repConfig.setPdfName(args[1]);*/
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 20:
			repConfig.getParams().put(ReportParams.BANCOEMI, args[2]);
			repConfig.getParams().put(ReportParams.TIPO_TRANSACCION, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[4]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[5]);
			break;
		case 69:
			repConfig.getParams().put(ReportParams.BIN, args[2]); // T
			repConfig.getParams().put(ReportParams.BANCOEMI, args[3]);
			repConfig.getParams().put(ReportParams.TLIQUIDACION, args[4]);
			repConfig.getParams().put(ReportParams.BANCOADQ, args[5]);// T
			repConfig.getParams().put(ReportParams.TIPO_TRANSACCION, args[6]); //T
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[7]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[8]);
			break;
		case 72:
			repConfig.getParams().put(ReportParams.BIN, args[2]); // T
			repConfig.getParams().put(ReportParams.BANCOEMI, args[3]);
			repConfig.getParams().put(ReportParams.TLIQUIDACION, args[4]);
			repConfig.getParams().put(ReportParams.BANCOADQ, args[5]); //T
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[6]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[7]);
			break;
		}
		return repConfig;
	}

	public ReportConfig createSICLIR0200(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 21:
			repConfig.getParams().put(ReportParams.BANCOADQUIRENTE, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
			break;
		}
		return repConfig;
	}

	public ReportConfig createSICLIR0020(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 22:
		case 71:
		case 83:
		case 84:
			repConfig.getParams().put(ReportParams.BANCO, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
			break; 
		}
		return repConfig;
	}

	public ReportConfig createSICMOR0200(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 23:
			repConfig.getParams().put(ReportParams.BANCO_ADQUIRENTE, args[2]);
			repConfig.getParams().put(ReportParams.BANCO_EMISOR, args[3]);
			repConfig.getParams().put(ReportParams.FUENTE, args[4]);
			repConfig.getParams().put(ReportParams.TIPO_DE_TRANSACCION, args[5]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[6]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[7]);
			break;
		case 31:
			repConfig.getParams().put(ReportParams.BANCO_ADQUIRENTE, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
			break;
		case 36:
			repConfig.getParams().put(ReportParams.BANCO_ADQUIRENTE, args[2]);
			repConfig.getParams().put(ReportParams.BANCO_EMISOR, args[3]);
			repConfig.getParams().put(ReportParams.FUENTE, args[4]);
			repConfig.getParams().put(ReportParams.TLIQUIDACION, args[5]);
			repConfig.getParams().put(ReportParams.TIPO_DE_TRANSACCION, args[6]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[7]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[8]);
			break;
		case 98:
		case 99:
		case 100:
		case 101:
		case 102:
		case 103:
		case 104:
		case 105:
		case 106:
		case 107:
		case 108:
		case 109:
			repConfig.getParams().put(ReportParams.BANCO_ADQUIRENTE, args[2]);
			repConfig.getParams().put(ReportParams.BANCO_EMISOR, args[3]);
			repConfig.getParams().put(ReportParams.FUENTE, args[4]);
			repConfig.getParams().put(ReportParams.TLIQUIDACION, args[5]);
			repConfig.getParams().put(ReportParams.TIPO_DE_TRANSACCION, args[6]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[7]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[8]);
			break;
		}
		return repConfig;
	}

	public ReportConfig createSICMOR0170(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 24:
		case 25:
		case 26:
			repConfig.getParams().put(ReportParams.BANCO, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
			break;
		case 43:
			repConfig.getParams().put(ReportParams.MONEDA, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
		}
		return repConfig;
	}

	public ReportConfig createSICMIR0290(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 27:
		case 28:
		case 74:
			repConfig.getParams().put(ReportParams.BANCO, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
			break;
		}
		return repConfig;
	}

	public ReportConfig createSICDCC0100(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 29:
		case 30:
			repConfig.getParams().put(ReportParams.BANCO, args[2]);
			repConfig.getParams().put(ReportParams.FUENTE, args[3]);
			repConfig.getParams().put(ReportParams.TTR, args[4]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[5]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[6]);
			break;
		}
		return repConfig;
	}

	public ReportConfig createSICMOR0100(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 32:
			repConfig.getParams().put(ReportParams.BANCOADQ, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
			break;
		case 38:
			repConfig.getParams().put(ReportParams.BANCOADQ, args[2]);
			repConfig.getParams().put(ReportParams.TIPO_TRANS, args[3]);
			repConfig.getParams().put(ReportParams.ARCHIVO, args[4]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[5]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[6]);
			break;
		}
		return repConfig;
	}

	public ReportConfig createSICPRO002(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 33:
			repConfig.getParams().put(ReportParams.BANCO, args[2]);
			repConfig.getParams().put(ReportParams.TIPO, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[4]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[5]);
			break;
		}
		return repConfig;
	}
	
	public ReportConfig createSICMOF0100(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 34:
			repConfig.getParams().put(ReportParams.BANCO, args[2]);
			repConfig.getParams().put(ReportParams.TIPO, args[3]);
			repConfig.getParams().put(ReportParams.ARCHIVO, args[4]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[5]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[6]);
			break;
		}
		return repConfig;
	}
	
	public ReportConfig createSICLIR0130(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 39:
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[3]);
			break;
		}
		return repConfig;
	}

	public ReportConfig createSICLIR0140(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 40:
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[3]);
			break;
		}
		return repConfig;
	}

	public ReportConfig createSICLIRP320(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 41:
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[3]);
			break;
		}
		return repConfig;
	}

	public ReportConfig createSICLIR002(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 42:
			repConfig.getParams().put(ReportParams.BANCO_ADQUIRENTE, args[2]);
			repConfig.getParams().put(ReportParams.MARCA, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[4]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[5]);
			break;
		}
		return repConfig;
	}

	public ReportConfig createSICLIRI0050(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 44:
			repConfig.getParams().put(ReportParams.BANCO, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
			break;
		}
		return repConfig;
	}

	public ReportConfig createSICLIRI0060(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 45:
			repConfig.getParams().put(ReportParams.BANCO, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
			break;
		}
		return repConfig;
	}

	public ReportConfig createSICLIRI0020(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 46:
			repConfig.getParams().put(ReportParams.BANCO, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
			break;
		}
		return repConfig;
	}

	public ReportConfig createSICLIRI0130(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 47:
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[3]);
			break;
		}
		return repConfig;
	}

	public ReportConfig createSICLIRI320(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 48:
			repConfig.getParams().put(ReportParams.LIQUIDACION, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
			break;
		}
		return repConfig;
	}
	
	public ReportConfig createSICLIRD0050(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 49:
			repConfig.getParams().put(ReportParams.BANCO, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
			break;
		}
		return repConfig;
	}

	public ReportConfig createSICLIRD0060(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 50:
			repConfig.getParams().put(ReportParams.BANCO, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
			break;
		}
		return repConfig;
	}

	public ReportConfig createSICLIRD0020(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 51:
			repConfig.getParams().put(ReportParams.BANCO, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
			break;
		}
		return repConfig;
	}

	public ReportConfig createSICLIRD0130(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 52:
			repConfig.getParams().put(ReportParams.BANCO, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
			break;
		}
		return repConfig;
	}

	public ReportConfig createSICLICE0300(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 53:
			repConfig.getParams().put(ReportParams.BANCO_ADQUIRENTE, args[2]);
			repConfig.getParams().put(ReportParams.BANCO_EMISOR, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[4]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[5]);
			break;
		case 54:
		case 55:
		case 56:
		case 57:
		case 58:
		case 59:
		case 60:
		case 61:
		case 62:
		case 63:
		case 64:
			repConfig.getParams().put(ReportParams.BANCO_ADQUIRENTE, args[2]);
			repConfig.getParams().put(ReportParams.BANCO_EMISOR, args[3]);
			repConfig.getParams().put(ReportParams.FUENTE, args[4]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[5]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[6]);
			break;
		}
		return repConfig;
	}

	public ReportConfig createSICLICA0170(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 65:
			repConfig.getParams().put(ReportParams.BANCO_ADQUIRENTE, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
			break;
		}
		return repConfig;
	}

	public ReportConfig createSICLICE0170(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 66:
			repConfig.getParams().put(ReportParams.BANCO_EMISOR, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
			break;
		}
		return repConfig;
	}

	public ReportConfig createSICMIR0420(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 73:
			repConfig.getParams().put(ReportParams.BANCOADQ, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
			break;
		}
		return repConfig;
	}

	public ReportConfig createSICMOR0210(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 77:
			repConfig.getParams().put(ReportParams.TIPO_RECHAZO, args[2]);
			repConfig.getParams().put(ReportParams.BANCOADQ, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[4]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[5]);
			break;
		}
		return repConfig;
	}
	
	public ReportConfig createSICLIR00280(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 78:
			repConfig.getParams().put(ReportParams.BANCO, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
			break;
		}
		return repConfig;
	}

	public ReportConfig createSICMOR0305H(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 85:
		case 86:
		case 87:
		case 88:
		case 89:
			repConfig.getParams().put(ReportParams.BANCOADQ, args[2]);
			repConfig.getParams().put(ReportParams.BANCOEMI, args[3]);
			repConfig.getParams().put(ReportParams.TIPO_TRANS, args[4]);
			repConfig.getParams().put(ReportParams.NATCON, args[5]);
			repConfig.getParams().put(ReportParams.LIQUIDACION, args[6]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[7]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[8]);
			break;
		}
		return repConfig;
	}

	public ReportConfig createSICMIR0054(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 90:
		case 91:
		case 92:
			repConfig.getParams().put(ReportParams.BANCOEMI, args[2]);
			repConfig.getParams().put(ReportParams.ARCHIVO, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[4]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[5]);
			break;
		}
		return repConfig;
	}

	public ReportConfig createSICLIR0110(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 93:
			repConfig.getParams().put(ReportParams.BANCOEMI, args[2]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[4]);
			break;
		}
		return repConfig;
	}

	public ReportConfig createSICMOR0305(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 94:
		case 95:
		case 96:
		case 97:
			repConfig.getParams().put(ReportParams.BANCOADQ, args[2]);
			repConfig.getParams().put(ReportParams.BANCOEMI, args[3]);
			repConfig.getParams().put(ReportParams.TIPO_TRANS, args[4]);
			repConfig.getParams().put(ReportParams.LIQUIDACION, args[5]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[6]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[7]);
			break;
		}
		return repConfig;
	}

	public ReportConfig createSICMOR0340(String[] args) {
		ReportConfig repConfig = new ReportConfig();
		repConfig.setReportName(this.reportName);
		repConfig.setPdfName(args[1]);
		switch (numReport) {
		case 110:
			repConfig.getParams().put(ReportParams.BANCOEMI, args[2]);
			repConfig.getParams().put(ReportParams.BANCOADQ, args[3]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_INI, args[4]);
			repConfig.getParams().put(ReportParams.RANGO_FECHA_FIN, args[5]);
			break;
		}
		return repConfig;
	}

}
