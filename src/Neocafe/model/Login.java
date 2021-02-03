package Neocafe.model;

public class Login {
	private int id;
	private String typeuser;
	
	public Login() {
		super();
	}

	public Login(int id, String typeuser) {
		super();
		this.id = id;
		this.typeuser = typeuser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeuser() {
		return typeuser;
	}

	public void setTypeuser(String typeuser) {
		this.typeuser = typeuser;
	}
	
	
	
}
