package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author HWW
 *
 */
public class Dao {

	private static Connection conn;

	private static void createCon() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newsdb", "root", "123456");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn() {
		createCon();
		return conn;
	}
}
