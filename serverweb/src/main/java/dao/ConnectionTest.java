package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {

	public static void main(String[] args) {
		String url="jdbc:mysql://127.0.0.1:3306/jdbc?serverTimezone=UTC";
		//String url2="jdbc:oracle:thin:@127.0.0.1:1521:xe"; //오라클
		String user="exam";
		String password="exam";
		StringBuffer sql=new StringBuffer();
		try {
			//1.드라이버로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버로딩성공!!");
			//2.DB서버에 접속하기
			Connection con= DriverManager.getConnection(url,user,password);
			System.out.println("커넥션성공!!"+con);
			/*
			 * Statement stmt=con.createStatement();
			 * System.out.println("Statement객체: "+stmt);
			 * 
			 * int result= stmt.executeUpdate(sql.toString());
			 * System.out.println(result+"개 행 삭제성공!!");
			 */
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버로딩실패!!");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
