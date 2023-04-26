package com.prosa.jasper.beans;

import java.io.Serializable;

public class CriteriosObj implements Serializable {

private static final long serialVersionUID = 5389479861620520900L;

	public CriteriosObj() {
	}

	private String owner = "";

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	private String ini = "";

	public String getIni() {
		return this.ini;
	}

	public void setIni(String ini) {
		this.ini = ini;
	}

	private String fin = "";

	public String getFin() {
		return this.fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	private String banco = "";

	public String getBanco() {
		return this.banco;
	}

	public void setBanco(String[] banco) {
		this.banco = listaCadenas(banco);
	}

	private String bancoEmi = "";

	public String getBancoEmi() {
		return this.bancoEmi;
	}

	public void setBancoEmi(String[] bancoEmi) {
		this.bancoEmi = listaCadenas(bancoEmi);
	}

	private String bancoAdq = "";

	public String getBancoAdq() {
		return this.bancoAdq;
	}

	public void setBancoAdq(String[] bancoAdq) {
		this.bancoAdq = listaCadenas(bancoAdq);
	}

	private String camaraEmi = "";

	public String getCamaraEmi() {
		return this.camaraEmi;
	}

	public void setCamaraEmi(String[] camaraEmi) {
		this.camaraEmi = listaNumeros(camaraEmi);
	}

	private String camaraAdq = "";

	public String getCamaraAdq() {
		return this.camaraAdq;
	}

	public void setCamaraAdq(String[] camaraAdq) {
		this.camaraAdq = listaNumeros(camaraAdq);
	}

	private String marca = "";

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String[] marca) {
		this.marca = listaNumeros(marca);
	}

	private String listaCadenas(String[] lista) {
		String valor = "";
		if (lista != null) {
			for (int i = 0; i < lista.length; i++) {
				if (i == 0) {
					valor = "'" + lista[i] + "'";
				} else {
					valor = valor + ",'" + lista[i] + "'";
				}
			}
		}
		return valor;
	}

	private String listaNumeros(String[] lista) {
		String valor = "";
		if (lista != null) {
			for (int i = 0; i < lista.length; i++) {
				if (i == 0) {
					valor = lista[i];
				} else {
					valor = valor + "," + lista[i];
				}
			}
		}
		return valor;
	}
}
