package com.prosa.dao;

public class ClicCashDAO {

	public static String enmascara(String cadena) {
		String sal = "";
		if (cadena != null && !cadena.equalsIgnoreCase("")) {
			for (int x = 0; x < cadena.length(); x++) {
				if (!(cadena.charAt(x) == ','))
					sal += "*";
				else
					sal += ",";
			}
		}
		return sal;
	}

}
