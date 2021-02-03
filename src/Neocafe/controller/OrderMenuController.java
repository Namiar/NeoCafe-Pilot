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
import Neocafe.dao.OrderListDAO;
import Neocafe.dao.OrderMenuDAO;

/**
 * Servlet implementation class OrderMenuController
 */
@WebServlet("/OrderMenuController")
public class OrderMenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuDAO daoMenu;
	private OrderMenuDAO daoOrderMenu;
	private OrderListDAO daoOrderList;
	String forward="";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderMenuController() {
        super();
        daoMenu = new MenuDAO();
        daoOrderList = new OrderListDAO();
        daoOrderMenu = new OrderMenuDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("deleteordermenu")) {
			int qtyid = Integer.parseInt(request.getParameter("qtyid"));
			String id = request.getParameter("id");
			
			daoOrderMenu.deleteOrderMenu(qtyid);
			
			DecimalFormat priceFormatter = new DecimalFormat("0.00");
			request.setAttribute("pf", priceFormatter);
			
			request.setAttribute("semuamenu2", daoOrderMenu.getAllOrderMenubyStatus(Integer.parseInt(id)));
			request.setAttribute("semuafood", daoMenu.getAllFood());
			request.setAttribute("semuadrink", daoMenu.getAllDrink());
			forward = "cust_menu.jsp";	
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		}
		

		else if (action.equalsIgnoreCase("vieworder")) {
			int id = Integer.parseInt(request.getParameter("id"));
			int orderid = Integer.parseInt(request.getParameter("orderid"));
			
			DecimalFormat priceFormatter = new DecimalFormat("0.00");
			request.setAttribute("priceFormatter", priceFormatter);
			
			request.setAttribute("order", daoOrderList.getOrderbyOrderid(orderid));
			request.setAttribute("semuaorder2", daoOrderMenu.getAllOrderMenuPaid(orderid,id));
			
			forward = "cust_vieworder.jsp";	
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("addtocart")) {
			
			String id = request.getParameter("id");
			String foodid = request.getParameter("order");
			System.out.println(foodid);
			int qty = Integer.parseInt(request.getParameter("quantity"));
			
			System.out.println("phase 2");
			daoOrderMenu.addOrderMenu(foodid, qty, Integer.parseInt(id));
			
			DecimalFormat priceFormatter = new DecimalFormat("0.00");
			request.setAttribute("pf", priceFormatter);
			
			request.setAttribute("semuamenu2", daoOrderMenu.getAllOrderMenubyStatus(Integer.parseInt(id)));
			request.setAttribute("semuafood", daoMenu.getAllFood());
			request.setAttribute("semuadrink", daoMenu.getAllDrink());
			forward = "cust_menu.jsp";	
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
	}
		
	}

}
