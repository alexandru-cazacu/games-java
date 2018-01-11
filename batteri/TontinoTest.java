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
import java.util.Random;

/**
 * Classe d'esempio per la gara
 * @author Alessandro Bugatti &lt; alessandro.bugatti@gmail.com &gt;
 */

public class TontinoTest extends Batterio{
    private int VIEW = 5;
    private int WIDTH = 1024;
    private int HEIGHT = 700;
    int flag = 0;
    
    public TontinoTest(int x, int y, Color c, Food f){
        super(x,y,c,f);
    }
    
    private boolean isFood()
    {
        for (int i=x-VIEW; i<x+VIEW; i++)
        for (int j=y-VIEW; j<y+VIEW; j++)
            if (ControllaCibo(i, j))
                return true;
        return false;
    }
    
    private void spostadaiMargini()
    {
        if(x<=VIEW) x += VIEW;
        if(x>WIDTH-VIEW) x -= VIEW;
        if(y<=VIEW) y += VIEW;
        if(y>HEIGHT-VIEW) y -= VIEW;
    }
    
    @Override
    protected void Sposta(){
        spostadaiMargini();
        
        if(isFood()){
        for (int i=x-VIEW; i<x+VIEW; i++)
        for (int j=y-VIEW; j<y+VIEW; j++){
            if (ControllaCibo(i, j)){
                x=i;
                y=j;
                return;
            }
        }
        }
        else{
        if(flag == 0)
            x += 1;
        if (flag == 1)
            x -= 1;
        if(x+VIEW > WIDTH-VIEW) 
            flag = 1;
        if(x-VIEW < VIEW)
            flag = 0;
        
        }
               
    }
    
    @Override
    public Batterio Clona(){
       return new TontinoTest(x,y,colore,food); 
    }
    
    @Override
    public String toString(){
        return "TontinoTest";
    }
}
