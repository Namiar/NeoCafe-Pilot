package Neocafe.controller;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Neocafe.dao.MenuDAO;
import Neocafe.dao.OrderMenuDAO;
import Neocafe.model.Drink;
import Neocafe.model.Food;
import Neocafe.model.Menu;

/**
 * Servlet implementation class StaffController
 */
@WebServlet("/MenuController")
public class MenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuDAO daoMenu;
	private OrderMenuDAO daoOrderMenu;
	String forward="";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuController() {
		super();
		daoMenu = new MenuDAO();
		daoOrderMenu = new OrderMenuDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("listMenu")) {

			request.setAttribute("semuafood", daoMenu.getAllFood());
			request.setAttribute("semuadrink", daoMenu.getAllDrink());
			DecimalFormat pf = new DecimalFormat("0.00");
			request.setAttribute("pf", pf); 
			forward = "admin_menu.jsp";

		}else if (action.equalsIgnoreCase("nologinlistMenu")) {

			request.setAttribute("semuafood", daoMenu.getAllFood());
			request.setAttribute("semuadrink", daoMenu.getAllDrink());
			DecimalFormat pf = new DecimalFormat("0.00");
			request.setAttribute("pf", pf); 
			forward = "recipe.jsp";

		}else if (action.equalsIgnoreCase("nologinindex")) {

			request.setAttribute("semuafood", daoMenu.getAllFood());
			request.setAttribute("semuadrink", daoMenu.getAllDrink());
			DecimalFormat pf = new DecimalFormat("0.00");
			request.setAttribute("pf", pf); 
			forward = "index.jsp";

		}else if (action.equalsIgnoreCase("listMenuCust")) {
			String id = request.getParameter("id");
			
			DecimalFormat pf = new DecimalFormat("0.00");
			request.setAttribute("pf", pf);
			
			request.setAttribute("semuafood", daoMenu.getAllFood());
			request.setAttribute("semuadrink", daoMenu.getAllDrink());
			request.setAttribute("semuamenu2", daoOrderMenu.getAllOrderMenubyStatus(Integer.parseInt(id)));
			forward = "cust_menu.jsp";

		} else if (action.equalsIgnoreCase("readyupdate")) {
			String mid= ""+request.getParameter("id");

			System.out.println("find menuid = "+mid);
			Menu men = new Menu();
			men = daoMenu.getMenuById(mid);
			request.setAttribute("men", men);
			
			DecimalFormat pf = new DecimalFormat("0.00");
			request.setAttribute("pf", pf); 
			
			forward = "admin_editmenu.jsp";

		} else if (action.equalsIgnoreCase("delMenu")) {

			String menuid = request.getParameter("id");
			String type = request.getParameter("type");
			
//			daoMenu.deleteMenu(menuid);
			if (type.equalsIgnoreCase("food")) {
				daoMenu.deleteFood(menuid);
			}
			
			if (type.equalsIgnoreCase("drink")) {
				daoMenu.deleteDrink(menuid);
			}
			
			forward = "admin_menu.jsp";
			DecimalFormat pf = new DecimalFormat("0.00");
			request.setAttribute("pf", pf); 
			request.setAttribute("semuafood", daoMenu.getAllFood());
			request.setAttribute("semuadrink", daoMenu.getAllDrink());
			
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("addmenu")) {

			int id = Integer.parseInt(request.getParameter("id"));
			String menuname = request.getParameter("n");
			float menuprice = Float.parseFloat(request.getParameter("p"));
			String fooddesc = request.getParameter("d");
			String typedrink = request.getParameter("t");
			Menu addmenu = new Menu(menuname, menuprice,id);
			daoMenu.addNewMenu(addmenu, id);
			
			Menu namkay = new Menu();
			namkay = daoMenu.getMenuByName(menuname);
			int findmid = namkay.getMenuid();
			
			if(!fooddesc.isEmpty()) {
				Food food = new Food();
				food.setFood(menuname, menuprice, fooddesc);
				daoMenu.addNewFood(food,findmid);
			} else if (!typedrink.isEmpty()){
				Drink drink = new Drink();
				drink.setDrink(menuname, menuprice, typedrink);
				daoMenu.addNewDrink(drink, findmid);
			}
			
			DecimalFormat pf = new DecimalFormat("0.00");
			request.setAttribute("pf", pf); 
			request.setAttribute("semuafood", daoMenu.getAllFood());
			request.setAttribute("semuadrink", daoMenu.getAllDrink());
			System.out.println("add menu item");
			forward = "admin_menu.jsp";
			
		} else if (action.equalsIgnoreCase("editmenu")) {

			String id = request.getParameter("id");
			float foodprice = Float.parseFloat(request.getParameter("p"));

			daoMenu.updateMenu(id, foodprice);
			
			DecimalFormat pf = new DecimalFormat("0.00");
			request.setAttribute("pf", pf); 
			System.out.println("update menu");
			request.setAttribute("semuafood", daoMenu.getAllFood());
			request.setAttribute("semuadrink", daoMenu.getAllDrink());
			forward = "admin_menu.jsp";	
			
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
}
