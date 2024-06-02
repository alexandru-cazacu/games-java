
public class Portata {
	private String desc;
	private double price;
	private boolean isDrink;
	
	public Portata (String desc, double price, boolean isDrink) {
		this.desc = desc;
		this.price = price;
		this.isDrink = isDrink;
	}
	
	public boolean isBevanda () {
		return isDrink;
	}
	
	public double getPrezzo () {
		return price;
	}
	
	public void setPrezzo (double newPrice) {
		price = newPrice;
	}
}
