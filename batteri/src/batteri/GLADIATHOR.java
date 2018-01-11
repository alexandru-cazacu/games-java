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
 * Classe per la gara
 *
 * @author Bianchetti Michel;
 */
public class GLADIATHOR extends Batterio {

    private char direzione = ' ';
    private final int Range = 600;
    private int Xtemp[];
    private int Ytemp[];
    private int distanza[];
    private boolean controllo[];
    
    public GLADIATHOR(int x, int y, Color c, Food f) {
        super(x, y, c, f);
        Xtemp = new int [4];
        Ytemp = new int [4];
        distanza = new int [4];
        controllo = new boolean[4];
    }

    public void Inizializza()
    {
        for (int i = 0; i < 4; i++)
        {
            Xtemp[i] = x;
            Ytemp[i] = y;
            distanza[i] = 0;
            controllo[i] = false;
        }
    }
    
    public void ControllaDistanza()
    {
        while (!ControllaCibo(Xtemp[0], Ytemp[0]) && Ytemp[0] >= 2)
        {
            Ytemp[0]--;
            distanza[0]++;
            controllo[0] = ControllaCibo(Xtemp[0], Ytemp[0]);
        }
        if (!controllo[0])
            distanza[0] = 402;
        while (!ControllaCibo(Xtemp[1], Ytemp[1]) && Ytemp[1] <= food.getHeight() - 2)
        {
            Ytemp[1]++;
            distanza[1]++;
            controllo[1] = ControllaCibo(Xtemp[1], Ytemp[1]);
        }
        if (!controllo[1])
            distanza[1] = 402;
        while (!ControllaCibo(Xtemp[2], Ytemp[2]) && Xtemp[2] <= food.getWidth() - 2)
        {
            Xtemp[2]++;
            distanza[2]++;
            controllo[2] = ControllaCibo(Xtemp[2], Ytemp[2]);
        }
        if (!controllo[2])
            distanza[2] = 402;
        while (!ControllaCibo(Xtemp[3], Ytemp[3]) && Xtemp[3] >= 2)
        {
            Xtemp[3]--;
            distanza[3]++;
            controllo[3] = ControllaCibo(Xtemp[3], Ytemp[3]);
        }
        if (!controllo[3])
            distanza[3] = 402;
    }
    
    public void FissaDistanza()
    {
        if (distanza[0] < distanza[1] && distanza[0] < distanza[2] && distanza[0] < distanza[3] && distanza[0] < Range)
            direzione = 'N';
        else if (distanza[1] < distanza[2] && distanza[1] < distanza[3] && distanza[1] < Range)
            direzione = 'S';
        else if (distanza[2] < distanza[3] && distanza[2] < Range)
            direzione = 'E';
        else if (distanza[3] < Range)
            direzione = 'O';
        else direzione = ' ';
    }
    
    @Override
    public void Sposta() {
        int d;
        Inizializza();
        ControllaDistanza();
        FissaDistanza();
        if (distanza[0] < 10 || distanza[1] < 10 && distanza[2] < 10 || distanza[3] < 10)
        {
            d = (int) (Math.random()) + 5;
            for (int i = 0; i < 50; i++)
                for (int j = 0; j < 50; j++)
                    if (ControllaCibo(i, j)){
                        x = i;
                        y = j;
                    }      
        }
        else
        {
            d = (int) (Math.random()) + 1;
            for (int i = 0; i < 50; i++)
                for (int j = 0; j < 50; j++)
                    if (ControllaCibo(i, j)){
                        x = i;
                        y = j;
                    }  
        }
        switch (direzione) {
            case 'N': {
                if (y - d >= 1) {
                    y -= d;
                }
                break;
            }
            case 'S': {

                if (y + d < food.getHeight() - 1) {
                    y += (int) (Math.random() * 3);
                }
                break;
            }
            case 'E': {

                if (x + d < food.getWidth() - 1) {
                    x += (int) (Math.random() * 3);
                }
                break;
            }
            case 'O': {
                if (x - d >= 1) {
                    x -= (int) (Math.random() * 3);
                }
                break;
            }
        }
    }

    @Override
    public Batterio Clona() {
        return new GLADIATHOR(x, y, colore, food);
    }

    @Override
    public String toString() {
        return "GLADIATHOR";
    }
}
