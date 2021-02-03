package Neocafe.model;

public class Customer {
	private int custid;
	private String custname;
	private String custpass;
	private String custemail;
	private String custuser;
	private boolean valid;
	
	public Customer() {
		super();
	}
	
	public Customer(String custname, String custpass, String custemail, String custuser) {
		super();
		this.custname = custname;
		this.custpass = custpass;
		this.custemail = custemail;
		this.custuser = custuser;
	}

	public int getCustid() {
		return custid;
	}
	public void setCustid(int cusid) {
		this.custid = cusid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getCustpass() {
		return custpass;
	}
	public void setCustpass(String custpass) {
		this.custpass = custpass;
	}
	public String getCustemail() {
		return custemail;
	}
	public void setCustemail(String custemail) {
		this.custemail = custemail;
	}
	
	public String getCustuser() {
		return custuser;
	}

	public void setCustuser(String custuser) {
		this.custuser = custuser;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
}
