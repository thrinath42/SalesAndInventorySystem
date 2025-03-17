package com.SalesAndInventorySystem.Generic.DataBaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection con;
	public void getConnection() throws SQLException {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		con = DriverManager.getConnection("");
	}
	
	public ResultSet excuteSelectQuery(String query) throws SQLException {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		con=DriverManager.getConnection("");
		Statement stat = con.createStatement();
		ResultSet result = stat.executeQuery(query);
		return result;
		
	}
	
	public void closeDbConnection() throws SQLException {
		try {
		con.close();
		}catch (Exception e) {
		}
	}
}
