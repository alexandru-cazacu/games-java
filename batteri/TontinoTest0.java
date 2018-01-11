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

public class TontinoTest0 extends Batterio{
    private int HEIGHT = 700;
    private int WIDTH = 1024;
    final static int VIEW = 10;
    int xdest;
    int ydest;
    int xtemp=0;
    int ytemp=0;
    int dx;
    int dy;
    int cont=3;
    int[][] cibo_trovato = new int [1000][2];
    int flag = 0;
    int tempo=0;
    
    
    
    public TontinoTest0(int x, int y, Color c    , Food f){
        super(x,y,c,f);
        cibo_trovato[0][0] = 500;
        cibo_trovato[0][1] = 350;
        cibo_trovato[1][0] = 200;
        cibo_trovato[1][1] = 100;
        cibo_trovato[2][0] = 800;
        cibo_trovato[2][1] = 500;
    }
    
    private void spostadaiMargini()
    {
        if(x<=VIEW) x += VIEW;
        if(x>WIDTH-VIEW) x -= VIEW;
        if(y<=VIEW) y += VIEW;
        if(y>HEIGHT-VIEW) y -= VIEW;
    }
    
    private void findFood()
    {
        for (int i=x-VIEW; i<x+VIEW; i++){
            for (int j=y-VIEW; j<y+VIEW; j++)
                if (ControllaCibo(i, j)){
                    cibo_trovato[cont+1][0] = i;
                    cibo_trovato[cont+1][1] = j;
                    cont++;
                    break;
                }  
            break;
        }
    }
    
    private void cercaCiboVicino()
    {
        xdest = cibo_trovato[0][0];
        ydest = cibo_trovato[0][1];
        for(int i=0; i<cont; i++)
            if((Math.abs(xdest-x))+(Math.abs(ydest-y)) >= 
                 (Math.abs(cibo_trovato[i][0]-x))+(Math.abs(cibo_trovato[i][1]-y))){
                xdest = cibo_trovato[i][0];
                ydest= cibo_trovato[i][1];
            }   
    }
    
    private void attendi()
    {
        if (flag == 1) return;
        if(tempo == 200) 
            flag = 1;
        tempo++;
    }
    
    @Override
    protected void Sposta(){
            
        spostadaiMargini();
        findFood();
        cercaCiboVicino();
        if(xdest>=x){
            x+=1;
            if(ydest>=y) 
                y += 1;
            else 
                y -= 1;
        }
        else {
            x-=1;
            if(ydest>=y) 
                y += 1;
            else 
                y -= 1;
        } 
        //if(x-VIEW > 0 && y-VIEW > 0 && x < WIDTH-VIEW && y < HEIGHT-VIEW){
//        for (int i=x-VIEW/2; i<x+VIEW/2; i++)
//            for (int j=y-VIEW/2; j<y+VIEW/2; j++){
//                if (ControllaCibo(i, j)){
//                    x=i;
//                    y=j;
//                    return;
//                }
//                    int dx = x-i;
//                    if (x+dx >= 0 && x+dx<food.getWidth() && dx > 0)
//                        x -= dx; 
//                    if (x+dx >= 0 && x+dx<food.getWidth() && dx < 0)
//                        x -= dx;
//                    int dy = y-i;
//                    if (y+dy >= 0 && y+dy<food.getHeight() && dy > 0)
//                        y -= dy;
//                    if (y+dy >= 0 && y+dy<food.getHeight() && dy < 0)
//                        y -= dy;
                    
//                    if(i-x >= 0) x += 1;
//                    if(i-x < 0) x-= 1;
//                    if(j-y >= 0) y += 1;
//                    if(j-y < 0) y -= 1;
//                    break;
//                }   
//                else {
//                    int dx = (int)(Math.random()*3) - 1;
//                    int dy = (int)(Math.random()*3) - 1;
//                    if (x+dx >= 0 && x+dx<food.getWidth())
//                        x += dx; 
//                    if (y+dy >= 0 && y+dy<food.getHeight())
//                        y += dy;
//                    return;
                    
//                }
//            }
        //}
        
        
        
        
    }
    
    @Override
    public Batterio Clona(){
       return new TontinoTest0(x,y,colore,food); 
    }
    
    @Override
    public String toString(){
        return "TontinoTest0";
    }
}
