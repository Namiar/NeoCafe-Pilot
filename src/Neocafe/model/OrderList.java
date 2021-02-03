package Neocafe.model;

import java.util.Date;

public class OrderList {
	private int orderid;
	private float ordertotal;
	private String payment_status;
	private Date orderdate;
	private int custid;
	private int staffid;
	private String custname;
	private String status;
	
	public OrderList() {
		super();
	}
	public OrderList(int orderid, float ordertotal, String payment_status, Date orderdate, int custid, int staffid) {
		super();
		this.orderid = orderid;
		this.ordertotal = ordertotal;
		this.payment_status = payment_status;
		this.orderdate = orderdate;
		this.custid = custid;
		this.staffid = staffid;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public float getOrdertotal() {
		return ordertotal;
	}
	public void setOrdertotal(float ordertotal) {
		this.ordertotal = ordertotal;
	}
	public String getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public int getStaffid() {
		return staffid;
	}
	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
