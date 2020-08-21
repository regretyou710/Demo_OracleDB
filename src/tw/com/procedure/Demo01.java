package tw.com.procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class Demo01 {

	public static void main(String[] args) {
		String sql = "{CALL orcl_proc(?,?,?)}";
		try (Connection conn = DBFactory.getOracleDBConnection();
				// 建立CallableStatement物件
				CallableStatement cstmt = conn.prepareCall(sql);) {

			cstmt.setInt(1, 70);// 指派第1個IN參數
			cstmt.setInt(2, 80);// 指派第2個IN參數
			cstmt.registerOutParameter(2, Types.INTEGER);// 設置第2個OUT參數
			cstmt.registerOutParameter(3, Types.INTEGER);// 設置第3個OUT參數
			cstmt.execute();
			System.out.println("IN OUT的輸出: " + cstmt.getInt(2));// 取得第2個OUT參數資料
			System.out.println("OUT的輸出: " + cstmt.getInt(3));// 取得第3個OUT參數資料

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
