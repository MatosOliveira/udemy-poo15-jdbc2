/**
 * 
 */
package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.Database;

/**
 * Classe para atualizacao dos dados
 * 
 * @author Matos
 *
 */
public class DatabaseProgram3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = Database.getConnection();

			ps = conn.prepareStatement("UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ? "
					+ "WHERE (DepartmentId = ?) ");

			ps.setDouble(1, 200.0);
			ps.setInt(2, 2);

			ps.executeUpdate();

			int rowsAffected = ps.executeUpdate();

			System.out.println("Done! Rows affected: " + rowsAffected);

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			Database.closeStatement(ps);
			Database.closeConnection();
		}

	}

}
