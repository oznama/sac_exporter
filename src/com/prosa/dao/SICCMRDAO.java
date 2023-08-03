package com.prosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.prosa.jasper.beans.CriteriosObj;
import com.prosa.jasper.beans.SICCMRObj;

public class SICCMRDAO {

	private static final Logger logger = Logger.getLogger(SICCMRDAO.class);

	public SICCMRDAO() {
	}

	private Connection obtieneConexion() {
		return ConnectionManager.conexionOCI();
	}

	private void cierraConexion(Connection conexion) {
		try {
			if (conexion != null) {
				conexion.close();
			}
		} catch (SQLException ex) {
			logger.error("Error al cerrar conexion, " + ex.toString());
			logger.error(ex);
		}
	}

	public String descripcionesListaMarcas(String[] lista) {
		String valor = "";
		if (lista != null) {
			for (int i = 0; i < lista.length; i++) {
				if (i == 0) {
					valor = nombreMarca(lista[i]);
				} else {
					valor = valor + "," + nombreMarca(lista[i]);
				}
			}
		}
		return valor;
	}

	public String nombreMarca(String clave) {
		Connection conexion = null;
		PreparedStatement pStmt = null;
		ResultSet rDatos = null;
		String sSQL = "";
		String valor = "";

		sSQL = "SELECT TRIM(descripcion) From PMADMIN.PRSA_MARCA Where marca LIKE ?";
		try {
			conexion = obtieneConexion();

			pStmt = conexion.prepareStatement(sSQL);
			pStmt.setString(1, clave);
			rDatos = pStmt.executeQuery();

			while (rDatos.next()) {
				valor = rDatos.getString(1);
			}
			pStmt.close();
			rDatos.close();
		} catch (SQLException e) {
			logger.error(" Error al obtener NombreMarca:" + clave);
		} finally {
			ConnectionManager.close(rDatos);
			ConnectionManager.close(pStmt);
			cierraConexion(conexion);
		}

		return valor;
	}

	public String descripcionesListaCamaras(String[] lista) {
		String valor = "";
		if (lista != null) {
			for (int i = 0; i < lista.length; i++) {
				if (i == 0) {
					valor = nombreCamara(lista[i]);
				} else {
					valor = valor + "," + nombreCamara(lista[i]);
				}
			}
		}
		return valor;
	}

	public String nombreCamara(String clave) {
		Connection conexion = null;
		PreparedStatement pStmt = null;
		ResultSet rDatos = null;
		String sSQL = "";
		String valor = "";

		sSQL = "SELECT TRIM(descripcion) From PMADMIN.PRSA_CAMARA Where camara LIKE ?";
		try {
			conexion = obtieneConexion();

			pStmt = conexion.prepareStatement(sSQL);
			pStmt.setString(1, clave);
			rDatos = pStmt.executeQuery();

			while (rDatos.next()) {
				valor = rDatos.getString(1);
			}
			pStmt.close();
			rDatos.close();
		} catch (SQLException e) {
			logger.error(" Error al obtener NombreCamara:" + clave);
		} finally {
			ConnectionManager.close(rDatos);
			ConnectionManager.close(pStmt);
			cierraConexion(conexion);
		}

		return valor;
	}

	public List<SICCMRObj> consultarSICCMR0077(CriteriosObj criterios) {
		SICCMRObj objeto = new SICCMRObj();
		List<SICCMRObj> lista = null;

		Connection conexion = null;
		PreparedStatement pStmt = null;
		ResultSet rDatos = null;

		try {
			conexion = obtieneConexion();

			String sSQL = "SELECT ENTIDAD, TRIM(C.DESCRIPCION), TTR_NUMERO, SUM(IMPORTE) " + "FROM (" +

					"SELECT B.ENT_NUMERO_PROSA_ADQ, C.ENTIDAD_PADRE ENTIDAD, B.TTR_NUMERO TTR_NUMERO, \n"
					+ "SUM(DECODE(TTR_NUMERO, 20, (NVL(TOTAL_IMPORTE, 0) - NVL(IMPORTE_COMISION_INTERCAMB, 0) - NVL(IVA_COMISION_INTERCAMB, 0)), \n"
					+ "                   21, (NVL(TOTAL_IMPORTE, 0) - NVL(IMPORTE_COMISION_INTERCAMB, 0) - NVL(IVA_COMISION_INTERCAMB, 0)) , \n"
					+ "                   16, (NVL(TOTAL_IMPORTE, 0) - NVL(IMPORTE_COMISION_INTERCAMB, 0) - NVL(IVA_COMISION_INTERCAMB, 0)) , \n"
					+ "                   19, (NVL(TOTAL_IMPORTE, 0) - NVL(IMPORTE_COMISION_INTERCAMB, 0) - NVL(IVA_COMISION_INTERCAMB, 0)) , \n"
					+ "                       (NVL(TOTAL_IMPORTE, 0) - NVL(IMPORTE_COMISION_INTERCAMB, 0) - NVL(IVA_COMISION_INTERCAMB, 0))* -1 )) AS IMPORTE \n"
					+ "FROM PMADMIN.PRSA_MARCA_POSICIONES B, PMADMIN.PRSA_ENTIDADES C "
					+ "WHERE FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY') - 1 AND TO_DATE(?, 'DD/MM/YYYY') - 1 "
					+ "AND B.CAMARA_EMI IN (" + criterios.getCamaraAdq() + ") " + "AND B.MARCA IN ("
					+ criterios.getMarca() + ") " + "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ " +

					/* "AND C.NUMERO_PROSA NOT IN (94,95,96,97,98) " + */
					"AND C.NUMERO_PROSA NOT IN (" + "                             SELECT ent.NUMERO_PROSA \n"
					+ "                               FROM pmadmin.PRSA_ENTIDADES ent \n"
					+ "                                   ,pmadmin.PRSA_CAMARA    cam \n"
					+ "                               WHERE cam.CAMARA = ent.CAMARA \n"
					+ "                                 AND cam.ACTIVO = 'S' \n"
					+ "                                 AND cam.CAMARA <> 1 \n"
					+ "                                 AND ent.GCO_NUMERO = 3 \n"
					+ "                               UNION ALL \n" + "                              SELECT 94 \n"
					+ "                                FROM DUAL\n" + "                               UNION ALL \n"
					+ "                              SELECT 98 \n" + "                                FROM DUAL \n"
					+ "                          ) " +

					/* "AND B.TLI_NUMERO IN (3) " + */

					"AND B.TLI_NUMERO IN \n" + "    (SELECT cl.SALIENTE \n"
					+ "       FROM PMADMIN.PRSA_CAMARA_LIQ cl\n " + "      WHERE cl.CAMARA = B.CAMARA_EMI\n "
					+ "        AND cl.SALIENTE IS NOT NULL\n " + "    )\n " +

					"AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) \n" + "AND (   B.TTR_NUMERO IN (1,21,20,9) \n"
					+ "     OR B.TTR_NUMERO IN (315, 316, 317, 318, 319) \n" + "    ) \n" + "GROUP \n"
					+ "   BY B.ENT_NUMERO_PROSA_ADQ \n" + "     ,C.ENTIDAD_PADRE \n" + "     ,B.TTR_NUMERO \n"
					+ "     ,NVL(STTR_NUMERO, 0) \n" +

					"UNION ALL " + "SELECT B.ENT_NUMERO_PROSA_ADQ, C.ENTIDAD_PADRE ENTIDAD, B.TTR_NUMERO TTR_NUMERO, "
					+ "(CASE WHEN TTR_NUMERO IN (11) AND trim(NOMBRE_ARCHIVO) <> 'CZDCS035' THEN abs(TOTAL_IMPORTE) "
					+ "      ELSE -TOTAL_IMPORTE  " + "END) IMPORTE \n"
					+ "FROM PMADMIN.PRSA_MARCA_POSICIONES B, PMADMIN.PRSA_ENTIDADES C "
					+ "WHERE FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY') - 1 AND TO_DATE(?, 'DD/MM/YYYY') - 1 "
					+ "AND B.CAMARA_EMI IN (" + criterios.getCamaraAdq() + ") " + "AND B.MARCA IN ("
					+ criterios.getMarca() + ") " + "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ " +

					/* "AND C.NUMERO_PROSA NOT IN (94,95,96,97,98) " + */
					"AND C.NUMERO_PROSA NOT IN (" +
					/* "AND B.ENT_NUMERO_PROSA_EMI NOT IN (" + */
					"                             SELECT ent.NUMERO_PROSA \n"
					+ "                               FROM pmadmin.PRSA_ENTIDADES ent \n"
					+ "                                   ,pmadmin.PRSA_CAMARA    cam \n"
					+ "                               WHERE cam.CAMARA = ent.CAMARA \n"
					+ "                                 AND cam.ACTIVO = 'S' \n"
					+ "                                 AND cam.CAMARA <> 1 \n"
					+ "                                 AND ent.GCO_NUMERO = 3 \n"
					+ "                               UNION ALL \n" + "                              SELECT 94 \n"
					+ "                                FROM DUAL\n" + "                               UNION ALL \n"
					+ "                              SELECT 98 \n" + "                                FROM DUAL \n"
					+ "                          ) " +

					/* "AND B.TLI_NUMERO IN (3) " + */

					"AND B.TLI_NUMERO IN \n" + "    (SELECT cl.SALIENTE \n"
					+ "       FROM PMADMIN.PRSA_CAMARA_LIQ cl\n " + "      WHERE cl.CAMARA = B.CAMARA_EMI\n "
					+ "        AND cl.SALIENTE IS NOT NULL\n " + "    )\n " +

					"AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) " + "AND (TTR_NUMERO = 11 AND STTR_NUMERO = 112) "
					+ "AND NOMBRE_ARCHIVO NOT IN ('MISC (A FAVOR)','MISC (EN CONTRA)','CZDCS030') " +

					"UNION ALL " + "SELECT B.ENT_NUMERO_PROSA_EMI, C.ENTIDAD_PADRE ENTIDAD, B.TTR_NUMERO TTR_NUMERO, "
					+ "(CASE WHEN TTR_NUMERO IN (16) THEN (NVL(TOTAL_IMPORTE, 0) - NVL(IMPORTE_COMISION_INTERCAMB, 0) - NVL(IVA_COMISION_INTERCAMB, 0)) "
					+ "ELSE (NVL(TOTAL_IMPORTE, 0) - NVL(IMPORTE_COMISION_INTERCAMB, 0) - NVL(IVA_COMISION_INTERCAMB, 0))* -1 "
					+ "END) IMPORTE \n" + "FROM PMADMIN.PRSA_MARCA_POSICIONES B, PMADMIN.PRSA_ENTIDADES C "
					+ "WHERE FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY') - 1 AND TO_DATE(?, 'DD/MM/YYYY') - 1 "
					+ "AND B.CAMARA_ADQ IN (" + criterios.getCamaraAdq() + ") " + "AND B.MARCA IN ("
					+ criterios.getMarca() + ") " + "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI " +
					/* "AND C.NUMERO_PROSA NOT IN (94,95,96,97,98) " + */

					"AND C.NUMERO_PROSA NOT IN (" +
					/* "AND B.ENT_NUMERO_PROSA_ADQ NOT IN (" + */
					"                             SELECT ent.NUMERO_PROSA \n"
					+ "                               FROM pmadmin.PRSA_ENTIDADES ent \n"
					+ "                                   ,pmadmin.PRSA_CAMARA    cam \n"
					+ "                               WHERE cam.CAMARA = ent.CAMARA \n"
					+ "                                 AND cam.ACTIVO = 'S' \n"
					+ "                                 AND cam.CAMARA <> 1 \n"
					+ "                                 AND ent.GCO_NUMERO = 3 \n"
					+ "                               UNION ALL \n" + "                              SELECT 94 \n"
					+ "                                FROM DUAL\n" + "                               UNION ALL \n"
					+ "                              SELECT 98 \n" + "                                FROM DUAL \n"
					+ "                          ) " +

					/* "AND B.TLI_NUMERO IN (3) " + */

					"AND B.TLI_NUMERO IN \n" + "    (SELECT cl.SALIENTE \n"
					+ "       FROM PMADMIN.PRSA_CAMARA_LIQ cl\n " + "      WHERE cl.CAMARA = B.CAMARA_ADQ\n "
					+ "        AND cl.SALIENTE IS NOT NULL\n " + "    )\n " +

					"AND NVL(STTR_NUMERO,0) NOT IN (120,281,321,322) AND B.TTR_NUMERO IN (15,16,17,18,19) " +

					"UNION ALL " + "SELECT B.ENT_NUMERO_PROSA_EMI, "
					+ "CASE WHEN D.ENTIDAD_PADRE IN (95,96,97) THEN C.ENTIDAD_PADRE " + "     ELSE D.ENTIDAD_PADRE "
					+ "END ENTIDAD, "
					+ "10 TTR_NUMERO, (CASE WHEN TTR_NUMERO IN (10) AND trim(NOMBRE_ARCHIVO) =  'CZDCS025_112_A' THEN TOTAL_IMPORTE "
					+ "                     WHEN TTR_NUMERO IN (11) AND trim(NOMBRE_ARCHIVO) <> 'CZDCS035' THEN abs(TOTAL_IMPORTE) "
					+ "                     WHEN TTR_NUMERO IN (10) AND trim(NOMBRE_ARCHIVO) <> 'CZDCS025_112_A' THEN abs(TOTAL_IMPORTE) * -1 "
					+ "                     ELSE -TOTAL_IMPORTE  " + "               END) IMPORTE  \n"
					+ "FROM PMADMIN.PRSA_MARCA_POSICIONES B, PMADMIN.PRSA_ENTIDADES C, PMADMIN.PRSA_ENTIDADES D  "
					+ "WHERE FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY') - 1 AND TO_DATE(?, 'DD/MM/YYYY') - 1  "
					+ "AND (B.CAMARA_EMI IN (" + criterios.getCamaraAdq() + ") OR B.CAMARA_ADQ IN ("
					+ criterios.getCamaraAdq() + ") ) " + "AND B.MARCA IN (" + criterios.getMarca() + ")  "
					+ "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ  " + "AND D.NUMERO_PROSA = B.ENT_NUMERO_PROSA_EMI " +
					/* "AND B.TLI_NUMERO IN (3) " + */

					/*
					 * "AND B.TLI_NUMERO IN \n" + "    (SELECT cl.SALIENTE \n" +
					 * "       FROM PMADMIN.PRSA_CAMARA_LIQ cl\n " +
					 * "      WHERE cl.SALIENTE IS NOT NULL\n " + "    )\n " +
					 */

					"AND TTR_NUMERO in (10,11) "
					+ "AND trim(NOMBRE_ARCHIVO) not in ('MISC (A FAVOR)','MISC (EN CONTRA)','CZDCS030') " +

					"UNION ALL \n" + "SELECT B.ENT_NUMERO_PROSA_EMI, C.ENTIDAD_PADRE ENTIDAD, 101 TTR_NUMERO, \n"
					+ "DECODE(TTR_NUMERO, 20, (NVL(TOTAL_IMPORTE, 0) - NVL(IMPORTE_COMISION_INTERCAMB, 0) - NVL(IVA_COMISION_INTERCAMB, 0)) , \n"
					+ "                   21, (NVL(TOTAL_IMPORTE, 0) - NVL(IMPORTE_COMISION_INTERCAMB, 0) - NVL(IVA_COMISION_INTERCAMB, 0)) , \n"
					+ "                   16, (NVL(TOTAL_IMPORTE, 0) - NVL(IMPORTE_COMISION_INTERCAMB, 0) - NVL(IVA_COMISION_INTERCAMB, 0)) , \n"
					+ "                   19, (NVL(TOTAL_IMPORTE, 0) - NVL(IMPORTE_COMISION_INTERCAMB, 0) - NVL(IVA_COMISION_INTERCAMB, 0)) , \n"
					+ "                       (  CASE \n"
					+ "                            WHEN STTR_NUMERO IN (120, 322) THEN NVL (TOTAL_IMPORTE, 0) \n"
					+ "                            ELSE NVL (TOTAL_IMPORTE, 0) *-1 \n"
					+ "                          END \n"
					+ "                                             - NVL(IMPORTE_COMISION_INTERCAMB, 0) - NVL(IVA_COMISION_INTERCAMB, 0)) * -1) IMPORTE \n"
					+ "FROM PMADMIN.PRSA_MARCA_POSICIONES B, PMADMIN.PRSA_ENTIDADES C \n"
					+ "WHERE FECHA_PROCESO BETWEEN TO_DATE(?, 'DD/MM/YYYY') - 1 AND TO_DATE(?, 'DD/MM/YYYY') - 1 \n"
					+ "AND B.CAMARA_EMI IN (" + criterios.getCamaraAdq() + ") \n" + "AND B.MARCA IN ("
					+ criterios.getMarca() + ") " + "AND C.NUMERO_PROSA = B.ENT_NUMERO_PROSA_ADQ " +
					/* "AND C.NUMERO_PROSA NOT IN (94,95,96,97,98) " + */

					"AND C.NUMERO_PROSA NOT IN (" +
					/* "AND B.ENT_NUMERO_PROSA_ADQ NOT IN (" + */
					"                             SELECT ent.NUMERO_PROSA \n"
					+ "                               FROM pmadmin.PRSA_ENTIDADES ent \n"
					+ "                                   ,pmadmin.PRSA_CAMARA    cam \n"
					+ "                               WHERE cam.CAMARA = ent.CAMARA \n"
					+ "                                 AND cam.ACTIVO = 'S' \n"
					+ "                                 AND cam.CAMARA <> 1 \n"
					+ "                                 AND ent.GCO_NUMERO = 3 \n"
					+ "                               UNION ALL \n" + "                              SELECT 94 \n"
					+ "                                FROM DUAL\n" + "                               UNION ALL \n"
					+ "                              SELECT 98 \n" + "                                FROM DUAL \n"
					+ "                          ) \n" +

					/* "AND B.TLI_NUMERO IN (2,3) " + */

					"AND (    (     TTR_NUMERO IN (1, 9, 15, 17, 18) \n"
					+ "           AND (    (     B.TLI_NUMERO IN (SELECT cl.SALIENTE \n"
					+ "                                             FROM PMADMIN.PRSA_CAMARA_LIQ cl \n"
					+ "                                            WHERE cl.SALIENTE IS NOT NULL \n"
					+ "                                          ) \n"
					+ "                      AND STTR_NUMERO IN (120, 322)\n" + "                    ) \n"
					+ "                 OR (     B.TLI_NUMERO IN (SELECT cl.ENTRANTE \n"
					+ "                                             FROM PMADMIN.PRSA_CAMARA_LIQ cl \n"
					+ "                                            WHERE cl.ENTRANTE IS NOT NULL\n"
					+ "                                          ) \n"
					+ "                      AND STTR_NUMERO IN (281, 321) \n" + "                    ) \n"
					+ "               ) \n" + "         ) \n" + "      OR (     TTR_NUMERO IN (20, 21, 16, 19) \n"
					+ "           AND (    (     B.TLI_NUMERO IN (SELECT cl.SALIENTE \n"
					+ "                                            FROM PMADMIN.PRSA_CAMARA_LIQ cl \n"
					+ "                                           WHERE cl.SALIENTE IS NOT NULL \n"
					+ "                                          ) \n"
					+ "                      AND STTR_NUMERO IN (281, 321) \n" + "                    ) \n"
					+ "                 OR (     B.TLI_NUMERO IN (SELECT cl.ENTRANTE \n"
					+ "                                             FROM PMADMIN.PRSA_CAMARA_LIQ cl \n"
					+ "                                            WHERE cl.ENTRANTE IS NOT NULL \n"
					+ "                                          ) \n"
					+ "                      AND STTR_NUMERO IN (120, 322) \n" + "                    ) \n"
					+ "               ) \n" + "         ) \n" + "    ) \n" +

					/*
					 * "AND B.TLI_NUMERO IN \n" + "    (SELECT cl.SALIENTE \n" +
					 * "       FROM PMADMIN.PRSA_CAMARA_LIQ cl\n " +
					 * "      WHERE cl.SALIENTE IS NOT NULL\n " + "      UNION \n" +
					 * "        ALL SELECT ce.ENTRANTE \n" +
					 * "       FROM PMADMIN.PRSA_CAMARA_LIQ ce\n " +
					 * "      WHERE ce.ENTRANTE IS NOT NULL\n " + "    )\n " +
					 * 
					 * 
					 * "AND ( (TTR_NUMERO IN (1,9,15,17,18) AND STTR_NUMERO IN (120,322)) OR (TTR_NUMERO IN (20,21,16,19) AND STTR_NUMERO IN (281,321)) ) \n"
					 * +
					 */

					") A, PMADMIN.PRSA_ENTIDADES C \n" + "WHERE C.NUMERO_PROSA = A.ENTIDAD \n"
					+ "GROUP BY ENTIDAD, TRIM(C.DESCRIPCION), TTR_NUMERO \n";

			logger.debug("Reporte SICCMR0077:" + sSQL
					.replaceAll(criterios.getMarca(),
							ClicCashDAO.enmascara(criterios.getMarca()).replaceAll(criterios.getBancoEmi(),
									ClicCashDAO.enmascara(criterios.getBancoEmi())))
					.replaceAll(criterios.getCamaraAdq(), ClicCashDAO.enmascara(criterios.getCamaraAdq())));

			pStmt = conexion.prepareStatement(sSQL);
			pStmt.setString(1, criterios.getIni());
			pStmt.setString(2, criterios.getFin());
			pStmt.setString(3, criterios.getIni());
			pStmt.setString(4, criterios.getFin());
			pStmt.setString(5, criterios.getIni());
			pStmt.setString(6, criterios.getFin());
			pStmt.setString(7, criterios.getIni());
			pStmt.setString(8, criterios.getFin());
			pStmt.setString(9, criterios.getIni());
			pStmt.setString(10, criterios.getFin());
			rDatos = pStmt.executeQuery();
			lista = new ArrayList<>();

			while (rDatos.next()) {
				objeto = new SICCMRObj();
				objeto.setEntidad(Integer.valueOf(rDatos.getString(1)));
				objeto.setNombreBanco(rDatos.getString(2));
				if ("1".compareTo(rDatos.getString(3)) == 0) {
					objeto.setTtr(1);
					objeto.setTtrDs("Ventas");
					objeto.setImporte(Double.valueOf(rDatos.getString(4)));
				} else if ("21".compareTo(rDatos.getString(3)) == 0) {
					objeto.setTtr(2);
					objeto.setTtrDs("Devoluciones");
					objeto.setImporte(Double.valueOf(rDatos.getString(4)));
				} else if ("20".compareTo(rDatos.getString(3)) == 0) {
					objeto.setTtr(3);
					objeto.setTtrDs("Pagos");
					objeto.setImporte(Double.valueOf(rDatos.getString(4)));
				} else if ("11".compareTo(rDatos.getString(3)) == 0) {
					objeto.setTtr(4);
					objeto.setTtrDs("Miscel\u00e1neos");
					objeto.setImporte(Double.valueOf(rDatos.getString(4)));
				} else if ("9".compareTo(rDatos.getString(3)) == 0) {
					objeto.setTtr(6);
					objeto.setTtrDs("Representaciones");
					objeto.setImporte(Double.valueOf(rDatos.getString(4)));
				} else if ("10".compareTo(rDatos.getString(3)) == 0) {
					objeto.setTtr(4);
					objeto.setTtrDs("Miscel\u00e1neos");
					objeto.setImporte(Double.valueOf(rDatos.getString(4)));
				} else if ("15".compareTo(rDatos.getString(3)) == 0) {
					objeto.setTtr(5);
					objeto.setTtrDs("1er Contracargo");
					objeto.setImporte(Double.valueOf(rDatos.getString(4)));
				} else if ("16".compareTo(rDatos.getString(3)) == 0) {
					objeto.setTtr(5);
					objeto.setTtrDs("1er Contracargo");
					objeto.setImporte(Double.valueOf(rDatos.getString(4)));
				} else if ("17".compareTo(rDatos.getString(3)) == 0) {
					objeto.setTtr(5);
					objeto.setTtrDs("1er Contracargo");
					objeto.setImporte(Double.valueOf(rDatos.getString(4)));
				} else if ("18".compareTo(rDatos.getString(3)) == 0) {
					objeto.setTtr(7);
					objeto.setTtrDs("2do Contracargo");
					objeto.setImporte(Double.valueOf(rDatos.getString(4)));
				} else if ("19".compareTo(rDatos.getString(3)) == 0) {
					objeto.setTtr(7);
					objeto.setTtrDs("2do Contracargo");
					objeto.setImporte(Double.valueOf(rDatos.getString(4)));
				} else if ("101".compareTo(rDatos.getString(3)) == 0) {
					objeto.setTtr(8);
					objeto.setTtrDs("Rechazos de Sintaxis");
					objeto.setImporte(Double.valueOf(rDatos.getString(4)));
				} else if ("315".compareTo(rDatos.getString(3)) == 0 || "316".compareTo(rDatos.getString(3)) == 0
						|| "317".compareTo(rDatos.getString(3)) == 0 || "318".compareTo(rDatos.getString(3)) == 0
						|| "319".compareTo(rDatos.getString(3)) == 0) {
					objeto.setTtr(9);
					objeto.setTtrDs("Rechazos Sintaxis");
					objeto.setImporte(Double.valueOf(rDatos.getString(4)));

				}

				lista.add(objeto);
			}
			rDatos.close();
		} catch (SQLException e) {
			logger.error("Error al consultar SICCMR0077");
			lista = new ArrayList<>();
		} finally {
			ConnectionManager.close(rDatos);
			ConnectionManager.close(pStmt);
			cierraConexion(conexion);
		}
		return lista;
	}

}
