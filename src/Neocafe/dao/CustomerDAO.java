package Neocafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Neocafe.model.Customer;
import Neocafe.connection.ConnectionManager;

public class CustomerDAO {
	
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static int custid;
	static String custname, custemail, custpass, custuser;

	public Customer getCustomer(Customer customer) {
		custuser = customer.getCustuser();

        String searchQuery = "select * from customer where custuser='" + custuser + "'";

        try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
            
            System.out.println(searchQuery);

            // if customer exists set the isValid variable to true
            if (more) {
                customer.setValid(true);
           	}
           
            else if (!more) {            	
            	customer.setValid(false);
            }
           
        }

        catch (Exception ex) {
            System.out.println("Register failed: An Exception has occurred! " + ex);
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

        return customer;
	}

	public void add(Customer customer) {
        custname = customer.getCustname();
        custemail = customer.getCustemail();
        custpass = customer.getCustpass();
        custuser = customer.getCustuser();
       
    	try {
    		currentCon = ConnectionManager.getConnection();
    		ps=currentCon.prepareStatement("insert into customer (custname, custpass, custemail,custuser)values(?,?,?,?)");
    		
    		ps.setString(1,custname);
    		ps.setString(3,custemail);
    		ps.setString(2,custpass);
    		ps.setString(4,custuser);
    		ps.executeUpdate();
    		
    		System.out.println("Customer name is " + custname);
			System.out.println("Email is " + custemail);
    		System.out.println("Password is " + custpass);
    		System.out.println("CustUser is " + custuser);
            
    	}

    	catch (Exception ex) {
    		System.out.println("addcustomer failed: An Exception has occurred! " + ex);
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
	
	public Customer getCustomerById(String id) {

		Customer cus = new Customer();

		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from customer where custid=?");

			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
		        cus.setCustid(rs.getInt("custid"));	          
	            cus.setCustname(rs.getString("custname"));
	            cus.setCustpass(rs.getString("custpass"));
	            cus.setCustemail(rs.getString("custemail"));
	            cus.setCustuser(rs.getString("custuser"));
	            
			}
		} catch (SQLException e) {
			System.out.println("failed: An Exception has occurred! " + e);
		}
		return cus;
	}

}
