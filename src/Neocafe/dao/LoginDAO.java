package Neocafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Neocafe.connection.ConnectionManager;
import Neocafe.model.Login;

public class LoginDAO {
	static Connection currentCon = null;
	static ResultSet rsstaff = null, rscust = null; 
	static PreparedStatement psstaff = null, pscust = null;
	static Statement stmt=null;
	static int staffId, custId;
	static String username, password ;

	public boolean checkUser(String username,String password) 
	{
		boolean st =false;
		try {

			//creating connection with the database
			currentCon = ConnectionManager.getConnection();
			PreparedStatement psstaff = currentCon.prepareStatement("select * from staff where staffuser=? and staffpass=?");

			psstaff.setString(1, username);
			psstaff.setString(2, password);
			ResultSet rsstaff =psstaff.executeQuery();
			st = rsstaff.next();
			if(st == false) {

				System.out.println("tak jumpa staff");
				PreparedStatement pscust = currentCon.prepareStatement("select * from customer where custuser=? and custpass=?");

				pscust.setString(1, username);
				pscust.setString(2, password);
				ResultSet rscust =pscust.executeQuery();
				st = rscust.next();
			}

		}
		catch(Exception e) {
			System.out.println("failed: An Exception has occurred! " + e);
		}
		return st;                 
	}  

	public Login getLoginType (String uname, String password) {
		Login userinfo = new Login();

		try {
			currentCon = ConnectionManager.getConnection();
			PreparedStatement psstaff = currentCon.prepareStatement("select * from staff where staffuser=? and staffpass=?");

			psstaff.setString(1, uname);
			psstaff.setString(2, password);
			ResultSet rsstaff = psstaff.executeQuery();

			if (rsstaff.next() == true) {
				userinfo.setTypeuser("takestaff");
				userinfo.setId(rsstaff.getInt("staffid"));
				System.out.println("jom kite ambik id staff");
			}
			
			else if(rsstaff.next() == false) {
				PreparedStatement pscust = currentCon.prepareStatement("select * from customer where custuser=? and custpass=?");

				pscust.setString(1, uname);
				pscust.setString(2, password);
				ResultSet rscust = pscust.executeQuery();
				System.out.println("jom kite ambik id customer");

				if (rscust.next() == true) {
					userinfo.setTypeuser("takecustomer");
					userinfo.setId(rscust.getInt("custid"));
				}
			}
			
		} catch (SQLException e) {
			System.out.println("failed: An Exception has occurred! " + e);
		}
		return userinfo;
	}

	
}
