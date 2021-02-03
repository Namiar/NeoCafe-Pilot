package Neocafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import Neocafe.connection.ConnectionManager;
import Neocafe.model.OrderMenu;

/**
 * Servlet implementation class OrderMenuDAO
 */
@WebServlet("/OrderMenuDAO")
public class OrderMenuDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;

	public void addOrderMenu(String foodid, int qty, int custid) {

		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("insert into ordermenu (quantity, menuid, custid) values(?,?,?)");

			ps.setInt(1, qty );
			ps.setInt(2, Integer.parseInt(foodid));
			ps.setInt(3, custid);
			ps.executeUpdate();

			System.out.println("foodid is " + foodid);

		}

		catch (Exception ex) {
			System.out.println("failed: An Exception has occurred! " + ex);
		}

		finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
				}
				ps = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;

			}
		}
	}

	public List<OrderMenu> getAllOrderMenubyStatus(int custid) {
		List<OrderMenu> semuamenu = new ArrayList<OrderMenu>();

		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();

			String q = "select * from ordermenu o join menu f on o.menuid = f.menuid where status='pending' and custid = " + custid;
			System.out.println(q);
			ResultSet rs = stmt.executeQuery(q);

			while (rs.next()) {
				OrderMenu om = new OrderMenu();

				om.setQtyid(rs.getInt("qtyid"));
				om.setQuantity(rs.getInt("quantity"));
				om.setStatus(rs.getString("status"));
				om.setOrderid(rs.getInt("orderid"));
				om.setMenuid(rs.getInt("menuid"));
				om.setCustid(rs.getInt("custid"));
				om.setMenuprice(rs.getFloat("menuprice"));
				om.setMenuname(rs.getString("menuname"));
				System.out.println("muncul"+rs.getInt("menuid"));
				semuamenu.add(om);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return semuamenu;
	}

	public void updateAllOrderMenu(int custid, int orderid) {

		String searchQuery = "UPDATE ordermenu SET status='on delivery', orderid = " + orderid + " WHERE status='pending' and custid= " + custid ;
		System.out.println(searchQuery);

		try {

			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);

		} catch (SQLException e) {
			System.out.println("failed: An Exception has occurred! " + e);
		}

	}

	public void deleteOrderMenu(int qtyid)
	{
		String searchQuery = "delete from ordermenu where qtyid=" + qtyid;

		System.out.println(searchQuery);

		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<OrderMenu> getAllOrderMustDelivered(int orderid, int custid) {
		List<OrderMenu> semuaoM = new ArrayList<OrderMenu>();
		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from ordermenu o join menu m on o.menuid = m.menuid where orderid = ? and status = 'on delivery' and custid = ?");

			ps.setInt(1,  orderid);
			ps.setInt(2, custid);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				OrderMenu oM = new OrderMenu();
				oM.setMenuid(rs.getInt("menuid"));
				System.out.println("hehe"+rs.getInt("menuid"));
				oM.setMenuname(rs.getString("menuname"));
				oM.setMenuprice(rs.getFloat("menuprice"));
				oM.setStatus(rs.getString("status"));
				oM.setQuantity(rs.getInt("quantity"));

				semuaoM.add(oM);
			}
		} catch (SQLException e) {
			System.out.println("failed: An Exception has occurred! " + e);
		}
		return semuaoM;
	}

	public List<OrderMenu> getAllOrderMenuPaid(int orderid, int custid) {
		List<OrderMenu> semuamenu = new ArrayList<OrderMenu>();

		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();

			String q = "select * from ordermenu o join menu m on o.menuid = m.menuid where orderid = " + orderid + " and custid = " + custid;
			System.out.println(q);
			ResultSet rs = stmt.executeQuery(q);

			while (rs.next()) {
				OrderMenu om = new OrderMenu();

				om.setQtyid(rs.getInt("qtyid"));
				om.setQuantity(rs.getInt("quantity"));
				om.setStatus(rs.getString("status"));
				om.setOrderid(rs.getInt("orderid"));
				om.setMenuid(rs.getInt("menuid"));
				om.setCustid(rs.getInt("custid"));
				om.setMenuprice(rs.getFloat("menuprice"));

				om.setMenuname(rs.getString("menuname"));
				System.out.println("muncul"+rs.getString("menuname"));
				semuamenu.add(om);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return semuamenu;
	}
	
	public List<OrderMenu> getAllOrderMenubyCustid(int orderid) {
		List<OrderMenu> semuamenu = new ArrayList<OrderMenu>();

		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();

			String q = "select * from ordermenu o join menu f on o.menuid = f.menuid where orderid = " + orderid;
			System.out.println(q);
			ResultSet rs = stmt.executeQuery(q);

			while (rs.next()) {
				OrderMenu om = new OrderMenu();

				om.setQtyid(rs.getInt("qtyid"));
				om.setQuantity(rs.getInt("quantity"));
				om.setStatus(rs.getString("status"));
				om.setOrderid(rs.getInt("orderid"));
				om.setMenuid(rs.getInt("menuid"));
				om.setCustid(rs.getInt("custid"));
				om.setMenuprice(rs.getFloat("menuprice"));
				om.setMenuname(rs.getString("menuname"));
				System.out.println("muncul"+rs.getInt("menuid"));
				semuamenu.add(om);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return semuamenu;
	}

	public void updateDeliveryStatus(int orderid) {

		String searchQuery = "UPDATE ordermenu SET status='completed' WHERE orderid = " + orderid;
		System.out.println(searchQuery);

		try {

			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);

		} catch (SQLException e) {
			System.out.println("failed: An Exception has occurred! " + e);
		}

	}
}


