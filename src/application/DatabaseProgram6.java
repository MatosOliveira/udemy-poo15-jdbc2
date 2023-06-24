/**
 * 
 */
package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DBIntegrityException;
import db.Database;

/**
 * Classe para atualizacao dos dados
 * 
 * @author Matos
 *
 */
public class DatabaseProgram6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = Database.getConnection();

			ps = conn.prepareStatement("DELETE FROM department "
					+ "WHERE (Id = ?) ");

			ps.setInt(1, 2);

			ps.executeUpdate();

			int rowsAffected = ps.executeUpdate();

			System.out.println("Done! Rows affected: " + rowsAffected);

		} catch (SQLException e) {
			throw new DBIntegrityException(e.getMessage());

		} finally {
			Database.closeStatement(ps);
			Database.closeConnection();
		}

	}

}
