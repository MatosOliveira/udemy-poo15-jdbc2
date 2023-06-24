/**
 * 
 */
package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.Database;

/**
 * Classe para insercao dos dados
 * 
 * @author Matos
 *
 */
public class DatabaseProgram2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = Database.getConnection();

			ps = conn.prepareStatement("INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)");
			
			ps.setString(1, "Carl Purple");
			ps.setString(2, "carl@gmail.com");
			ps.setDate(3, new java.sql.Date(sdf.parse("24/05/1985").getTime()));
			ps.setDouble(4, 3000.0);
			ps.setInt(5, 4);

			int rowsAffected = ps.executeUpdate();

			System.out.println("Done! Rows affected: " + rowsAffected);


		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ParseException e) {
			e.printStackTrace();

		} finally {
			Database.closeStatement(ps);
			Database.closeConnection();
		}

	}

}
