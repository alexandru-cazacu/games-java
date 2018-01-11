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

import java.util.Random;

/**
 * Classe che rappresenta la distribuzione di cibo
 * @author Alessandro Bugatti
 */

public class Food {
    /**
     * Matrice del cibo
     */
    private boolean food[][];
    /**
     * Larghezza della matrice
     */
    private int width;
    /**
     * Altezza della matrice
     */
    private int height;
    Random random;
    
    /**
     * @param w Larghezza della matrice
     * @param h Altezza della matrice
     */
    public Food(int w, int h)
    {
        width = w;
        height = h;
        food = new boolean[w][h];
        random = new Random();
    }
    
    /**
     * Distribuisce il cibo secondo una distribuzione
     * quadrata
     * @param l lato del quadrato della distribuzione   
     * @param q quantità di cibo da distribuire
     */
    public void squareDistribution(int l, int q)
    {
        int randx = random.nextInt(width - l);
        int randy = random.nextInt(height - l);
        for (int i = 0; i < q; i++)
            food[random.nextInt(l) + randx][random.nextInt(l) + randy] = true;
    }
    
    /**
     * Controlla se c'è cibo in posizione x,y
     * @param x Coordinata x da controllare
     * @param y Coordinata y da controllare
     * @return True se c'è cibo in x,y, false altrimenti
     */
    public boolean isFood(int x, int y)
    {
        return food[x][y];
    }

    /**
     * Mangia il cibo in posizione x,y
     * @param x Coordinata x 
     * @param y Coordinata y 
     */
    public void eatFood(int x, int y)
    {
        food[x][y] = false;
        food[x+1][y] = false;
        food[x][y+1] = false;
        food[x+1][y+1] = false;
    }
    
    /**
     * @return Larghezza
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return Altezza
     */
    public int getHeight() {
        return height;
    }

}
