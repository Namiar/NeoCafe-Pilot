package Neocafe.model;

import java.util.List;

public class Menu {
	private int menuid;
	private String menuname;
	private float menuprice;
	private int staffid;
	public boolean valid;
	private List<Menu> menulist;
	private String custname;
	private int custid;
	private int orderid;
	private String status;
	private float paymentamount;
	
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Menu(String menuname, float menuprice, int staffid) {
		super();
		this.menuname = menuname;
		this.menuprice = menuprice;
		this.staffid = staffid;
	}
	
	public Menu(int menuid, String menuname, float menuprice) {
		super();
		this.menuid = menuid;
		this.menuname = menuname;
		this.menuprice = menuprice;
	}

	public int getMenuid() {
		return menuid;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public float getMenuprice() {
		return menuprice;
	}

	public void setMenuprice(float menuprice) {
		this.menuprice = menuprice;
	}

	public int getStaffid() {
		return staffid;
	}

	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}
	
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public List<Menu> getMenulist() {
		return menulist;
	}

	public void setMenulist(List<Menu> menulist) {
		this.menulist = menulist;
	}
	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getPaymentamount() {
		return paymentamount;
	}

	public void setPaymentamount(float paymentamount) {
		this.paymentamount = paymentamount;
	}
}
