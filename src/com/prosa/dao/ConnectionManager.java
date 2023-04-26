package com.prosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.CallableStatement;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.prosa.main.Properties;

import oracle.jdbc.pool.OracleDataSource;

public class ConnectionManager {
	
	private static Logger logger = Logger.getLogger(ConnectionManager.class);
	
	private static final String DB_URL = "jdbc:oracle:thin:@%s:%s:%s";

	public static DataSource conexionDS() {
		OracleDataSource ds = null;
        try {
        	ds = new OracleDataSource();
        	ds.setURL(String.format(DB_URL, Properties.DB_HOST, Properties.DB_PORT, Properties.DB_NAME));
        	ds.setUser(Properties.DB_USER);
        	ds.setPassword(Properties.DB_PSWD);
        } catch (SQLException ne){
        	logger.error(ne);
        }
        return ds;
    }

	public static int executeUpdate(Statement stmt, String query) throws SQLException {
		return stmt.executeUpdate(query);
	}
	public static CallableStatement PrepararSP(String sqlQuery, Connection con) throws SQLException {
        CallableStatement cstmt = con.prepareCall("{CALL ".concat(sqlQuery).concat("}"));
        return cstmt;
    }

	public static ResultSet executeThisQuery(Statement stmt, String query) throws SQLException {
		return stmt.executeQuery(query);
	}
	
	public static int executeThisUpdate(Statement stmt, String query) throws SQLException {
		return stmt.executeUpdate(query);
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				logger.debug("\n\nCLOSE RESULT SET...\n\n");
			}
		} catch (SQLException esql) {
			logger.error("ERROR AL CERRAR CONNECTION: " + esql.getMessage() + " \n\n");
			esql.printStackTrace();
		}
	}

	public static void close(PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.close();
				logger.debug("\n\nCLOSE PREPARED STATEMENT...\n\n");
			}
		} catch (SQLException esql) {
			logger.error("ERROR AL CERRAR CONNECTION: " + esql.getMessage() +" \n\n");
			logger.error(esql);
		}
	}

	public static void close(Statement st) {
		try {
			if (st != null) {
				st.close();
				logger.debug("\n\nCLOSE STATEMENT...\n\n");
			}
		} catch (SQLException esql) {
			logger.error("ERROR AL CERRAR CONNECTION: " + esql.getMessage() + "\n\n");
			logger.error(esql);
		}
	}


	public static void close(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
				logger.debug("\n\nCLOSE CONNECTION...\n\n");
			}
		} catch (SQLException esql) {
			logger.error("ERROR AL CERRAR CONNECTION: " + esql.getMessage() + "\n\n");
			logger.error(esql);
		}
	}

}
