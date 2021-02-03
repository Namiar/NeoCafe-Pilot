package Neocafe.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Neocafe.dao.CustomerDAO;
import Neocafe.model.Customer;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO daoCustomer;
	String forward="";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        daoCustomer = new CustomerDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("viewcustomer")) {
			String id = request.getParameter("id");
			Customer cus = daoCustomer.getCustomerById(id);
			request.setAttribute("cus", cus);
			
			forward = "cust_profile.jsp";
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("register")) {
			String custname = request.getParameter("Name");
			String custuser = request.getParameter("Username");
			String custemail = request.getParameter("Email");
			String custpass = request.getParameter("Password");
			
			Customer customer = new Customer(custname, custpass, custemail, custuser);				
			
			customer = daoCustomer.getCustomer(customer);
		
			if(!customer.isValid()){			
				System.out.println("inserting customer");
	        	daoCustomer.add(customer);
	        	forward= "login.jsp?action=login";
	        	RequestDispatcher view = request.getRequestDispatcher(forward);
	            view.forward(request, response);
	        }
		}
	}

}
