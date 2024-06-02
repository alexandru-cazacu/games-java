
public class Main {

	public static void main(String[] args) {
		Portata p1 = new Portata("antipasto", 8.5f, false);
		Portata p2 = new Portata("matriciana", 12.5f, false);
		Portata p3 = new Portata("bistecca", 25, false);
		Portata p4 = new Portata("insalata", 3, false);
		Portata p5 = new Portata("negramaro", 15.5f, true);
		Portata p6 = new Portata("acqua", 2.5f, true);
		
		Ordinazione o = new Ordinazione("luca");
		o.aggiungiPortata(p1, 3);
		o.aggiungiPortata(p2, 4);
		o.aggiungiPortata(p3, 3);
		o.aggiungiPortata(p4, 1);
		o.aggiungiPortata(p5, 3);
		o.aggiungiPortata(p6, 2);
		
		System.out.println("Conto:			" + o.conto());
		System.out.println("Conto bevande:	" + o.contoBevande());
		System.out.println("Portate:		" + o.portateOrdinate());
		System.out.println("Totale portate:	" + o.numeroTotalePortate());
		
		p1.setPrezzo(10);
		p2.setPrezzo(10);
		p3.setPrezzo(10);
		p4.setPrezzo(10);
		p5.setPrezzo(10);
		p6.setPrezzo(10);
		
		System.out.println("\nConto:			" + o.conto());
		System.out.println("Conto bevande:	" + o.contoBevande());
		System.out.println("Portate:		" + o.portateOrdinate());
		System.out.println("Totale portate:	" + o.numeroTotalePortate());
		
		int[][] mat1 = {{8, 2, -1, 0}, {7, 8, 0, 12}, {0, 0, 8, 8}};
		int[][] mat2 = {{-1, 3, -10, 2}, {3, 4, 13, 1}, {-2, 0, -4, 2}};
		int[][] mat3 = Eserc2.somma(mat1, mat2);
		System.out.println("Risultato corretto: ");
		System.out.println("7 5 -11 2");
		System.out.println("10 12 13 13");
		System.out.println("-2 0 4 10\n");
		
		System.out.println("Risultato trovato: ");
		for (int y = 0; y < mat3.length; y++) {
			for (int x = 0; x < mat3[0].length; x++) {
				System.out.print(mat3[y][x] + " ");
			}
			System.out.println();
		}
	}

}
