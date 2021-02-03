package Neocafe.model;

public class Drink extends Menu {
	
	private String drinktype;

	public Drink() {
		super();
	}

	public Drink(int menuid, String menuname, float menuprice, String drinktype) {
		super(menuid, menuname, menuprice);
		this.drinktype = drinktype;
	}
	
	public void setDrink(String menuname, float menuprice, String drinktype) {
		super.setMenuname(menuname);
		super.setMenuprice(menuprice);
		this.drinktype = drinktype;
	}
	
	public Drink(String drinktype) {
		super();
		this.drinktype = drinktype;
	}
	
	public String getDrinktype() {
		return drinktype;
	}

	public void setDrinktype(String drinktype) {
		this.drinktype = drinktype;
	}

}
