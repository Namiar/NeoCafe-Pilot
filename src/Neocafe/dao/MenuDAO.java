package Neocafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Neocafe.connection.ConnectionManager;
import Neocafe.model.Drink;
import Neocafe.model.Food;
import Neocafe.model.Menu;

public class MenuDAO {
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static int menuid;
	static String foodname,fooddesc, dt;
	static float foodprice;

	public Menu getMenuById(String mid) {

		Menu findmenu = new Menu();
		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from menu where menuid=?");

			ps.setString(1, mid);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				findmenu.setMenuid(rs.getInt("menuid"));	          
				findmenu.setMenuname(rs.getString("menuname"));
				findmenu.setMenuprice(rs.getFloat("menuprice"));

			}
		} catch (SQLException e) {
			System.out.println("failed: An Exception has occurred! " + e);
		}
		return findmenu;
	}

	public Menu getMenuByName(String mename) {

		Menu findmenu = new Menu();

		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from menu where menuname=?");

			ps.setString(1, mename);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				findmenu.setMenuid(rs.getInt("menuid"));	          
				findmenu.setMenuname(rs.getString("menuname"));
				findmenu.setMenuprice(rs.getFloat("menuprice"));

			}

		} catch (SQLException e) {
			System.out.println("failed: An Exception has occurred! " + e);
		}
		return findmenu;
	}

	public Food getFoodById(String mid) {

		Food food = new Food();
		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from menu m join food f on m.menuid = f.menuid where m.menuid=?");

			ps.setString(1, mid);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				food.setMenuid(rs.getInt("menuid"));	          
				food.setMenuname(rs.getString("menuname"));
				food.setFooddesc(rs.getString("fooddesc"));
				food.setMenuprice(rs.getFloat("menuprice"));

			}
		} catch (SQLException e) {
			System.out.println("failed: An Exception has occurred! " + e);
		}
		return food;
	}

	public Drink getDrinkById(String mid) {

		Drink drink = new Drink();
		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from menu m join drink d on m.menuid = d.menuid where m.menuid=?");

			ps.setString(1, mid);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				drink.setMenuid(rs.getInt("menuid"));	          
				drink.setMenuname(rs.getString("menuname"));
				drink.setDrinktype(rs.getString("drinktype"));
				drink.setMenuprice(rs.getFloat("menuprice"));

			}
		} catch (SQLException e) {
			System.out.println("failed: An Exception has occurred! " + e);
		}
		return drink;
	}

	public Menu getMenu(Menu menuitem) {
		menuid = menuitem.getMenuid();

		String searchQuery = "select * from menu where foodid='" + menuid + "'";

		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			System.out.println(searchQuery);
			System.out.println("gonna catch id");

			// if menuitem exists set the isValid variable to true
			if (more) {
				menuitem.setValid(true);
			}

			else if (!more) {            	
				menuitem.setValid(false);
			}

		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}

		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}

		return menuitem;
	}

	public void addNewMenu(Menu menuitem, int id) {

		foodname = menuitem.getMenuname();
		foodprice = menuitem.getMenuprice();

		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("insert into menu (menuname, menuprice, staffid)values(?,?,?)");

			ps.setString(1,foodname);
			ps.setFloat(2,foodprice);
			ps.setInt(3, id);
			ps.executeUpdate();

			System.out.println("foodie name is " + foodname);
			System.out.println("foodie price is " + foodprice);
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

	public void addNewFood(Food menuitem, int id) {

		fooddesc = menuitem.getFooddesc();

		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("insert into food (menuid, fooddesc)values(?,?)");

			ps.setInt(1,id);
			ps.setString(2, fooddesc);
			ps.executeUpdate();

			System.out.println("foodie description is " + fooddesc);

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

	public void addNewDrink(Drink menuitem, int id) {

		dt = menuitem.getDrinktype();

		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("insert into drink (menuid, drinktype)values(?,?)");

			ps.setInt(1,id);
			ps.setString(2, dt);
			ps.executeUpdate();

			System.out.println("drinkie type is " + dt);

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

	public List<Food> getAllFood() {
		List<Food> semuamenu = new ArrayList<Food>();

		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();

			String q = "select * from menu m join food f on m.menuid = f.menuid order by menuname";
			ResultSet rs = stmt.executeQuery(q);

			while (rs.next()) {
				Food food = new Food();

				food.setMenuid(rs.getInt("menuid"));	          
				food.setMenuname(rs.getString("menuname"));
				food.setFooddesc(rs.getString("fooddesc"));
				food.setMenuprice(rs.getFloat("menuprice"));
				semuamenu.add(food);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return semuamenu;
	}

	public List<Drink> getAllDrink() {
		List<Drink> semuamenu = new ArrayList<Drink>();

		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();

			String q = "select * from menu m join drink d on m.menuid = d.menuid order by menuname";
			ResultSet rs = stmt.executeQuery(q);

			while (rs.next()) {
				Drink drink = new Drink();

				drink.setMenuid(rs.getInt("menuid"));	          
				drink.setMenuname(rs.getString("menuname"));
				drink.setDrinktype(rs.getString("drinktype"));
				drink.setMenuprice(rs.getFloat("menuprice"));
				semuamenu.add(drink);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return semuamenu;
	}

	public void updateMenu(String id, float foodprice) {
		int mid = Integer.parseInt(id);
		System.out.println("i get you, " + mid);

		String searchQuery = "UPDATE menu SET menuprice='" + foodprice + "'  WHERE menuid = '" + mid + "'";

		try {

			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);

		} catch (SQLException e) {
			System.out.println("failed: An Exception has occurred! " + e);
		}

	}

	public void deleteMenu(String menuid22) {

		int menuid2 = Integer.parseInt(menuid22);
		String searchQuery = "delete from menu where menuid='" + menuid2 + "'";
		System.out.println(searchQuery);

		try {

			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteFood(String menuid22) {

		int menuid2 = Integer.parseInt(menuid22);
		String searchQuery = "delete from food where menuid= '" +menuid2+"'";
		String searchQuery2 = "delete from menu where menuid='" + menuid2 + "'";
		System.out.println(searchQuery);
		System.out.println(searchQuery2);
		
		try {

			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);
			stmt.executeUpdate(searchQuery2);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void deleteDrink(String menuid22) {

		int menuid2 = Integer.parseInt(menuid22);
		String searchQuery = "delete from drink where menuid= '" +menuid2+"'";
		String searchQuery2 = "delete from menu where menuid='" + menuid2 + "'";
		System.out.println(searchQuery);
		System.out.println(searchQuery2);

		try {

			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);
			stmt.executeUpdate(searchQuery2);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public List<Menu> getAllOrderCust() {
		List<Menu> menuitem = new ArrayList<Menu>();

		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();

			String q = "select * from customer c join orderlist o on (c.custid = o.custid) join payment p on (p.orderid = o.orderid)";
			ResultSet rs = stmt.executeQuery(q);

			while (rs.next()) {
				Menu mee = new Menu();

				mee.setCustname(rs.getString("custname"));
				mee.setCustid(rs.getInt("custid"));
				mee.setOrderid(rs.getInt("orderid"));
				mee.setStatus(rs.getString("status"));
				mee.setPaymentamount(rs.getFloat("paymentamount"));
				System.out.println("get ordercust row");
				menuitem.add(mee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menuitem;
	}
}
