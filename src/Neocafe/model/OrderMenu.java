package Neocafe.model;

public class OrderMenu {
	private int qtyid;
	private int quantity;
	private String status;
	private int orderid;
	private int menuid;
	private int custid;
	private float menuprice;
	private String menuname;
	
	public OrderMenu() {
		super();
	}
	public OrderMenu(int qtyid, int quantity, String status, int orderid, int menuid, int custid) {
		super();
		this.qtyid = qtyid;
		this.quantity = quantity;
		this.status = status;
		this.orderid = orderid;
		this.menuid = menuid;
		this.custid = custid;
	}
	public int getQtyid() {
		return qtyid;
	}
	public void setQtyid(int qtyid) {
		this.qtyid = qtyid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public float getMenuprice() {
		return menuprice;
	}
	public void setMenuprice(float menuprice) {
		this.menuprice = menuprice;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
}
