package tw.com.procedure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBFactory {
	// 1.將屬性宣告成 private static
	private static Connection conn = null;

	// 2.將建構式宣告成 private
	private DBFactory() {

	}

	// 3.提供一個靜態方法取得連線物件
	public static Connection getOracleDBConnection() {

		try {
			if (conn == null || conn.isClosed()) {
				final String URL = "jdbc:oracle:thin:@192.168.10.101:1522:orcl12c";
				conn = DriverManager.getConnection(URL,"c##scott","tiger");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
