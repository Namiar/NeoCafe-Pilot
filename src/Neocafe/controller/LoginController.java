package Neocafe.controller;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Neocafe.dao.CustomerDAO;
import Neocafe.dao.LoginDAO;
import Neocafe.dao.MenuDAO;
import Neocafe.dao.StaffDAO;
import Neocafe.model.Customer;
import Neocafe.model.Login;
import Neocafe.model.Staff;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDAO daoLogin;
	private StaffDAO daoStaff;
	private CustomerDAO daoCustomer;
	private MenuDAO daoMenu;
	String forward="";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		daoLogin = new LoginDAO();
		daoStaff = new StaffDAO();
		daoCustomer = new CustomerDAO();
		daoMenu = new MenuDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("logout")) {
			HttpSession session=request.getSession();  
            session.invalidate(); 
        	
            request.setAttribute("semuafood", daoMenu.getAllFood());
			request.setAttribute("semuadrink", daoMenu.getAllDrink());
			DecimalFormat pf = new DecimalFormat("0.00");
			request.setAttribute("pf", pf);
            
			System.out.println("Successfully logout");
			forward = "index.jsp";
        }
    	RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("login")) {
			String username = request.getParameter("Username");
			String password = request.getParameter("Password");

			if(daoLogin.checkUser(username, password))
			{	
				Login userinfo = daoLogin.getLoginType(username, password);
				HttpSession session = request.getSession();

				session.setAttribute("userinfo", userinfo);
				
				String loginid= ""+userinfo.getId();
				Customer cus = new Customer();
				Staff sta = new Staff();
				
				if (userinfo.getTypeuser().equalsIgnoreCase("takestaff")==true) {
					
					
					sta = daoStaff.getStaffById(loginid);
					request.setAttribute("sta", sta);
					session.setAttribute("staffid", sta.getStaffid());
					session.setAttribute("stafffullname", sta.getStaffname());
					session.setAttribute("staffusername", sta.getStaffuser());
					System.out.println(sta.getStaffname());
					
					request.setAttribute("semuafood", daoMenu.getAllFood());
					request.setAttribute("semuadrink", daoMenu.getAllDrink());
					DecimalFormat pf = new DecimalFormat("0.00");
					request.setAttribute("pf", pf); 
		            
		            forward = "admin_menu.jsp";
				} 
				if (userinfo.getTypeuser().equalsIgnoreCase("takecustomer")==true)
				{
					
					cus = daoCustomer.getCustomerById(loginid);
					request.setAttribute("cus", cus);
					session.setAttribute("custid", cus.getCustid());
					session.setAttribute("custfullname", cus.getCustname());
					session.setAttribute("custusername", cus.getCustuser());
					System.out.println(cus.getCustname());
					forward = "cust_profile.jsp";
				}
				
				RequestDispatcher view = request.getRequestDispatcher(forward);
				view.forward(request, response);

			}
			else
			{
				System.out.println("Username or Password incorrect");
				RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
				rs.include(request, response);
			}
		}
	}

}
