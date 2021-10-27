package demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {

	public static Connection getConnection() throws Exception,ClassNotFoundException{
		Connection con=null;
		try {
			String Driver="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/Hostel";
			String user="root";
			String password="";
			//register Driver
			Class.forName(Driver);
			//create connection
			con=DriverManager.getConnection(url,user,password);
			//close connection
		}catch(Exception e) {}
		return con;
	}

}
