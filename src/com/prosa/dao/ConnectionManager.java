package com.prosa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class ConnectionManager {
	
	private static final Logger logger = Logger.getLogger(ConnectionManager.class);
	
	private static final String DB_URL_OCI = "jdbc:oracle:oci8:/@PMTU";
	
	public static Connection conexionOCI() {
		logger.debug("Creating OCI connection...");
		Connection conn = null;
		try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            logger.debug("STARTING DRIVER LOADED " );
            conn=DriverManager.getConnection(DB_URL_OCI);
            logger.debug("END DRIVER LOADED " );
        } catch (ClassNotFoundException ex) {
        	logger.error("Class driver not found!");
        } catch (SQLException ex) {
        	logger.error("SQL Exception!");
        }
           
       return conn;
	}
	
	public static void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				logger.debug("\n\nCLOSE RESULT SET...\n\n");
			}
		} catch (SQLException esql) {
			logger.error("ERROR AL CERRAR CONNECTION");
		}
	}

	public static void close(PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.close();
				logger.debug("\n\nCLOSE PREPARED STATEMENT...\n\n");
			}
		} catch (SQLException esql) {
			logger.error("ERROR AL CERRAR CONNECTION");
		}
	}

	public static void close(Statement st) {
		try {
			if (st != null) {
				st.close();
				logger.debug("\n\nCLOSE STATEMENT...\n\n");
			}
		} catch (SQLException esql) {
			logger.error("ERROR AL CERRAR CONNECTION");
		}
	}


	public static void close(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
				logger.debug("\n\nCLOSE CONNECTION...\n\n");
			}
		} catch (SQLException esql) {
			logger.error("ERROR AL CERRAR CONNECTION");
		}
	}

}
