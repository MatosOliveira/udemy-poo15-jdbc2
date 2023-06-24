/**
 * 
 */
package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DBException;
import db.Database;

/**
 * Classe para atualizacao dos dados
 * 
 * @author Matos
 *
 */
public class DatabaseProgram4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Connection conn = null;
		Statement ps = null;

		try {
			conn = Database.getConnection();
			conn.setAutoCommit(false);

			ps = conn.createStatement();
			
			int rowsAffected = ps.executeUpdate("UPDATE seller SET BaseSalary = 3000.0 WHERE DepartmentId = 1");
			
			int rowsAffected2 = ps.executeUpdate("UPDATE seller SET BaseSalary = 3500.0 WHERE DepartmentId = 2");

			conn.commit();
			
			System.out.println("Done! Rows affected: " + rowsAffected);
			System.out.println("Done! Rows affected: " + rowsAffected2);

			
		} catch (SQLException e) {
			try {
				conn.rollback();
				throw new DBException("Transaction rolled back! Caused by: " + e.getMessage());
				
			} catch (SQLException e1) {
				throw new DBException("Error trying to rollback! Caused by: " + e1.getMessage());
			}
			
		} finally {
			Database.closeStatement(ps);
			Database.closeConnection();
		}

	}

}
