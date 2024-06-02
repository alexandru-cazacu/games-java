public class Prodotto {
	String codice;
	String desc;
	int quant;
	Prodotto prox;
	
	public Prodotto (String c, String d, int q) {
		codice = c;
		desc = d;
		quant = q;
		prox = null;
	}
}
