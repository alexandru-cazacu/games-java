/*
  Copyright (C) 2013 Alessandro Bugatti (alessandro.bugatti@istruzione.it)

  This program is free software; you can redistribute it and/or
  modify it under the terms of the GNU General Public License
  as published by the Free Software Foundation; either version 2
  of the License, or (at your option) any later version.

  This program is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  GNU General Public License for more details.

  You should have received a copy of the GNU General Public License
  along with this program; if not, write to the Free Software
  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
*/

package batteri;

import java.awt.Color;

/**
 * Classe astratta genitore della gerarchia dei batteri.
 * Ogni tipo diverso di batterio eredita da questa classe
 * @author Alessandro Bugatti
 */
abstract public class Batterio {
    final private int DELTA;
    final static int MAX_LIFE = 1500;
    final static int MAX_HEALTH = 600;
    final static int CICLO_RIPRODUTTIVO = 500;
    final static int BUONA_SALUTE = 200;
    /**
     * Contiene la durata massima del batterio
     */
    private int eta;
    /**
     * Contiene la "salute" del batterio.
     * Arrivata a zero il batterio muore
     */
    protected int salute;
    /**
     * Flag che indica se il batterio è maturo per
     * la duplicazione o no
     */
    private int duplica;
    /**
    * Posizione x del batterio nello schermo
    */
    protected int x;
    /**
    * Posizione y del batterio nello schermo
    */
    protected int y;
    /**
     * Riferimento al cibo
     */
    protected Food food;
    /**
     * Colore tipo del batterio
     */
    protected Color colore;

    public Batterio(int x, int y, Color c, Food f) {
        this.DELTA = 100;
        this.x = x;
	this.y = y;
	colore=c;
	eta=(int)(Math.random()*MAX_LIFE)+500;
	salute=(int)(Math.random()*MAX_HEALTH)+200;
	duplica=CICLO_RIPRODUTTIVO+(int)(Math.random()*100);
        food = f;
    }
    /**
     * Sposta il batterio nel terreno. Deve essere ridefinita nelle classi
     * ereditate per dar loro un comportamento diverso
     */
    abstract protected void Sposta();
    /**
     *\brief Controlla se c'è del cibo nella posizione occupata dal batterio
     */
    protected final boolean ControllaCibo(){
        return food.isFood(getX(), getY());
    }
    /**
     * brief Controlla se c'è del cibo nella posizione x,y
     * @param X Posizione x dove cercare il cibo
     * @param Y Posizione y dove cercare il cibo
     */
    protected final boolean ControllaCibo(int X, int Y){
        return food.isFood(X, Y);
    }
    /**
     * Se nella posizione occupata dal batterio c'è del cibo lo mangia
     * e incrementa la sua salute di DELTA
     */
    private final void Mangia(){
            if (ControllaCibo())
            {
                food.eatFood(x, y);
                salute+=DELTA;
            }
    }
    /**
     * Controlla se un batterio è fecondo
     */
    public final boolean Fecondo(){
        if ((duplica == 0) && (salute > BUONA_SALUTE))
		{
			duplica = BUONA_SALUTE;
			return true;
		}
	return false;
    }
    /**
     * Controlla se un batterio è morto o perchè
     * troppo vecchio o perchè non ha abbastanza salute
     */
    public final boolean Morto(){
        if ((salute<1) || (eta < 1)) return true;
        else return false;
    }
    /**
     * Esegue le mosse del batterio
     */
    final public void Run()
    {
        if (Morto()) return ;
        int xprec = getX();
        int yprec = getY();
    	/*Calcolo le nuove coordinate del batterio*/
	Sposta();
	/*Mangia l'eventuale cibo*/
	Mangia();
	/*Faccio invecchiare il batterio*/
	eta--;
	/*Diminuisce la sua salute
	in funzione dello spostamento effettuato secondo una
	metrica Manhattan*/
	int sforzo = Math.abs(getX()-xprec) + Math.abs(getY()-yprec);
	salute-=sforzo;
	/*Diminuisce il tempo per la riproduzione,
          solo se si è mosso, altrimenti no*/
	if (duplica>0 && sforzo!=0) duplica--;
    }
    /**
     * Clona il batterio in senso biologico
     * @return Un nuovo baterio creato con la stessa posizione
     * di quello originale
     */
    abstract public Batterio Clona();
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @return the colore
     */
    final public Color getColore() {
        return colore;
    }
    /**
     * Metodo che va sovrascritta per produrre il nome della classe
     * @return La stringa con il nome del batterio
     */
    @Override
    abstract public String toString();
}
