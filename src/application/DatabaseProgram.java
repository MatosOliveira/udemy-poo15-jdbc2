/**
 * 
 */
package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.Database;

/**
 * @author Matos
 *
 */
public class DatabaseProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = Database.getConnection();
			
			st = conn.createStatement();
			rs = st.executeQuery("select * from department");
			
			while(rs.next()) {
				System.out.println(rs.getInt("Id") + ", " + rs.getString("name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.closeResultSet(rs);
			Database.closeStatement(st);
			Database.closeConnection();
		}

	}

}
