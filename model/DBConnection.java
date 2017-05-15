package model;

import java.sql.*;

public class DBConnection {
	private String	driverName	= "com.mysql.jdbc.Driver";
	private String	url		= "jdbc:mysql://localhost:3306/";
	private String	database	= "imaima";
	private String	username	= "root";
	private String	password	= "1234";
	public Connection getConnection() {
		try {
            System.out.println(database);
			Connection con = DriverManager
					.getConnection(url + database, username, password);
			System.out.println("DBConnection::Connection SUCCESS");
			return con;
		} catch (Exception ex) {
			System.out.println("Exception Caught::Unable to connect to " + url + database);
                        ex.printStackTrace();
		}
		return null;
	}
        
        public ResultSet executeQuery(String s){
            
            try{
                Statement statement = getConnection().createStatement();
                ResultSet rs = statement.executeQuery(s);
                return rs;
            }catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }
        public void updateQuery(String s){
            try{
                Statement statement = getConnection().createStatement();
                statement.executeUpdate(s);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
}