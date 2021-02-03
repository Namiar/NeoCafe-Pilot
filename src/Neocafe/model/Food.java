package Neocafe.model;

public class Food extends Menu {
	
	private String fooddesc;

	public Food() {
		super();
	}

	public Food(int menuid, String menuname, float menuprice, String fooddesc) {
		super(menuid, menuname, menuprice);
		this.fooddesc = fooddesc;
	}
	
	public void setFood(String menuname, float menuprice, String fooddesc) {
		super.setMenuname(menuname);
		super.setMenuprice(menuprice);
		this.fooddesc = fooddesc;
	}

	public Food(String fooddesc) {
		super();
		this.fooddesc = fooddesc;
	}

	public String getFooddesc() {
		return fooddesc;
	}

	public void setFooddesc(String fooddesc) {
		this.fooddesc = fooddesc;
	}
}
