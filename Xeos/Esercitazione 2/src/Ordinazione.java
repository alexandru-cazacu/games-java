
public class Ordinazione {
	private String customerName;
	private Portata[] portate;
	private int[] quant;
	
	private int count = 0;
	
	public static final int MAX_PORTATE = 100;
	
	public Ordinazione (String customerName) {
		this.customerName = customerName;
		portate = new Portata[MAX_PORTATE];
		quant = new int[MAX_PORTATE];
	}
	
	public void aggiungiPortata(Portata p, int q) {
		portate[count] = p;
		quant[count] = q;
		
		count++;
	}
	
	public double conto() {
		int sum = 0;
		for (int i = 0; i < count; i++) {
			sum += portate[i].getPrezzo() * quant[i];
		}
		
		return sum;
	}
	
	public double contoBevande() {
		int sum = 0;
		for (int i = 0; i < count; i++) {
			sum += portate[i].isBevanda() ? portate[i].getPrezzo() * quant[i] : 0;
		}
		
		return sum;
	}
	
	public int numeroTotalePortate() {
		int sum = 0;
		for (int i = 0; i < count; i++) {
			sum += quant[i];
		}
		
		return sum;
	}
	
	public int portateOrdinate() {
		return count;
	}
}