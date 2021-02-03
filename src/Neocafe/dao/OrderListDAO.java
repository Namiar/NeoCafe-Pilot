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

import Neocafe.model.OrderList;

/**
 * Servlet implementation class OrderListDAO
 */
@WebServlet("/OrderListDAO")
public class OrderListDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;

	public void addOrderList(float total, int custid) {

		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("insert into orderlist (ordertotal, custid) values(?, ?)");

			ps.setFloat(1,total);
			ps.setInt(2, custid);
			ps.executeUpdate();

			System.out.println("Total is " + total);

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

	public OrderList getOrderListbyCustid(float total, int custid) {
		OrderList oL = new OrderList();
		System.out.println(total);
		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from orderlist where payment_status='paid' and staffid is null and ordertotal = ? and custid=?");

			ps.setFloat(1, total);
			ps.setInt(2, custid);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				oL.setOrderid(rs.getInt("orderid"));
				System.out.println("hi"+rs.getFloat("ordertotal"));
				oL.setOrdertotal(rs.getFloat("ordertotal"));

				oL.setPayment_status(rs.getString("payment_status"));
				oL.setOrderdate(rs.getDate("orderdate"));
				oL.setCustid(rs.getInt("custid"));
				oL.setStaffid(rs.getInt("staffid"));

			}
		} catch (SQLException e) {
			System.out.println("failed: An Exception has occurred! " + e);
		}
		return oL;
	}

	public OrderList getOrderPaid(int custid) {
		OrderList oL = new OrderList();
		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select distinct l.* from orderlist l join ordermenu m on l.orderid = m.orderid where payment_status='paid' and status = 'on delivery' and l.custid = ?");

			ps.setInt(1, custid);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				oL.setOrderid(rs.getInt("orderid"));
				System.out.println("hi"+rs.getFloat("ordertotal"));
				oL.setOrdertotal(rs.getFloat("ordertotal"));
				oL.setPayment_status(rs.getString("payment_status"));
				oL.setOrderdate(rs.getDate("orderdate"));
				oL.setCustid(rs.getInt("custid"));
				oL.setStaffid(rs.getInt("staffid"));

			}
		} catch (SQLException e) {
			System.out.println("failed: An Exception has occurred! " + e);
		}
		return oL;
	}

	public List<OrderList> getAllOrderListCust(int custid) {
		List<OrderList> odlist = new ArrayList<OrderList>();
		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select distinct o.* from orderlist o join ordermenu m on o.orderid = m.orderid where status='on delivery' and o.custid=?");

			ps.setInt(1, custid);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				OrderList oL = new OrderList();

				oL.setOrderid(rs.getInt("orderid"));
				System.out.println("hi"+rs.getFloat("ordertotal"));
				oL.setOrdertotal(rs.getFloat("ordertotal"));
				oL.setPayment_status(rs.getString("payment_status"));
				oL.setOrderdate(rs.getDate("orderdate"));
				oL.setCustid(rs.getInt("custid"));
				oL.setStaffid(rs.getInt("staffid"));

				odlist.add(oL);
			}
		} catch (SQLException e) {
			System.out.println("failed: An Exception has occurred! " + e);
		}
		return odlist;
	}

	public OrderList getOrderbyOrderid(int orderid) {
		OrderList oL = new OrderList();
		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from orderlist where orderid = ?");

			ps.setInt(1, orderid);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				oL.setOrderid(rs.getInt("orderid"));
				System.out.println("hi"+rs.getFloat("ordertotal"));
				oL.setOrdertotal(rs.getFloat("ordertotal"));
				oL.setPayment_status(rs.getString("payment_status"));
				oL.setOrderdate(rs.getDate("orderdate"));
				oL.setCustid(rs.getInt("custid"));
				oL.setStaffid(rs.getInt("staffid"));

			}
		} catch (SQLException e) {
			System.out.println("failed: An Exception has occurred! " + e);
		}
		return oL;
	}
	
	public OrderList getAllOrderListbyCustid(int orderid) {
		OrderList oL = new OrderList();
		
		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from orderlist o join customer c on o.custid = c.custid where o.orderid = " + orderid);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				oL.setOrderid(rs.getInt("orderid"));
				System.out.println("hi"+rs.getFloat("ordertotal"));
				oL.setOrdertotal(rs.getFloat("ordertotal"));

				oL.setPayment_status(rs.getString("payment_status"));
				oL.setOrderdate(rs.getDate("orderdate"));
				oL.setCustname(rs.getString("custname"));
				oL.setStaffid(rs.getInt("staffid"));

			}
		} catch (SQLException e) {
			System.out.println("failed: An Exception has occurred! " + e);
		}
		return oL;
	}
	
	public List<OrderList> getAllOrderList() {
		List<OrderList> semuaorder = new ArrayList<OrderList>();

		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();

			String q = "select distinct o.orderid, orderdate, custname, payment_status, status\r\n"
					+ "from orderlist o \r\n"
					+ "join customer c on o.custid = c.custid \r\n"
					+ "join ordermenu om on o.orderid=om.orderid\r\n"
					+ "order by status desc, orderdate";
			ResultSet rs = stmt.executeQuery(q);

			while (rs.next()) {
				OrderList ol = new OrderList();

				ol.setOrderdate(rs.getDate("orderdate"));
				ol.setOrderid(rs.getInt("orderid"));
				//ol.setCustid(rs.getInt("o.custid"));
				ol.setCustname(rs.getString("custname"));
				ol.setPayment_status(rs.getString("payment_status"));
				ol.setStatus(rs.getString("status"));
				semuaorder.add(ol);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return semuaorder;
	}
	
	public void updateOrderListbyStaff(int staffid, int orderid) {

		String searchQuery = "UPDATE orderlist SET staffid="+ staffid +" WHERE orderid = " + orderid;
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


