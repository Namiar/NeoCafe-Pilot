package Neocafe.model;

public class Staff {
	private int staffid;
	private String staffname;
	private String staffpass;
	private String staffuser;
	public boolean valid;
	
	public Staff() {
		super();
	}
	
	public Staff(String staffname, String staffpass, String staffuser) {
		super();
		this.staffname = staffname;
		this.staffpass = staffpass;
		this.staffuser = staffuser;
	}

	public int getStaffid() {
		return staffid;
	}
	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}
	public String getStaffname() {
		return staffname;
	}
	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}
	public String getStaffpass() {
		return staffpass;
	}
	public void setStaffpass(String staffpass) {
		this.staffpass = staffpass;
	}
	
	public String getStaffuser() {
		return staffuser;
	}

	public void setStaffuser(String staffuser) {
		this.staffuser = staffuser;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
}
