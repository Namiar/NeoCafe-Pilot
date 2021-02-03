package Neocafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Neocafe.connection.ConnectionManager;
import Neocafe.model.Staff;

public class StaffDAO {
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static int staffId;
	static String username, password ;

	public Staff getStaffById(String loginid) {

		Staff sta = new Staff();

		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from staff where staffid=?");

			ps.setString(1, loginid);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				sta.setStaffid(rs.getInt("staffid"));	          
				sta.setStaffname(rs.getString("staffname"));
				sta.setStaffpass(rs.getString("staffpass"));
				sta.setStaffuser(rs.getString("staffuser"));

			}
		} catch (SQLException e) {
			System.out.println("failed: An Exception has occurred! " + e);
		}
		return sta;
	}
}
