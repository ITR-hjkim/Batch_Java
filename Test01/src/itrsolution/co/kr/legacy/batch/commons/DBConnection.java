package itrsolution.co.kr.legacy.batch.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
//	private static DBConnection _instance = null;

	private DBConnection() {
	}

//	private static DBConnection getInstance() {
//		if (_instance == null) {
//			_instance = new DBConnection();
//		}
//
//		return _instance;
//	}

	private static Connection getConnForOracle(String url, String user, String password) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException");
		} catch (SQLException e) {
			System.out.println("SQLException");
		} catch (Exception e) {
			System.out.println("Exception");
		}

		return conn;
	}

	public static Connection getConnMainDB() {
		try {
			// DB정보 외부 파일로 별도 관리 할 것!
			String url = "jdbc:oracle:thin:@192.168.0.203:1521:xe";
			String user = "gownd";
			String password = "gownd";
			return getConnForOracle(url, user, password);
		} catch (Exception e) {
			System.out.println("Exception");
			return null;
		}
	}
}
