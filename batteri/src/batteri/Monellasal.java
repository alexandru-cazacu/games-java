/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package batteri;

import java.awt.Color;
import java.util.Random;

/**
 * 
 * @author Stefano Lecchi <feno14899@gmail.com>
 */
public class Monellasal extends Batterio 
{
    private Random random;
    private final int bordo = 5;
    private int raggioSpirale;
    private int eatingCycle;
    
    private static boolean isEating;
    
    private boolean quadranteA, quadranteB, quadranteC, quadranteD;
    private boolean inizializzazione;
    private boolean onFood;
    
    private static Food food;
    
    public Monellasal(int x, int y, Color c, Food f)
    {
        super(x,y,c,f);
        
        this.food = f;
        this.raggioSpirale = this.food.getWidth() / 2 - this.bordo;
        this.eatingCycle = 10;
        
        this.quadranteA = false;
        this.quadranteB = false;
        this.quadranteC = false;
        this.quadranteD = false;
        
        this.inizializzazione = true;
        this.onFood = false;
        
        this.isEating = false;
        this.random = new Random();
    }
   
    
    /*public int ricercaLaterale()
    {
        int xSearch = this.search;
        int ySearch = this.search;
        
        if(y < this.search)
            ySearch = 0;
        
        if(y > this.food.getHeight() - this.search)
            ySearch = this.food.getHeight() - this.search;
        
        for(int i = 0; i < ySearch; i++)
        {
            if(this.food.isFood(x, ySearch + i))
        }
        
        return -1;
    }*/
    
    private void SpostaRicerca()
    {
        if(this.inizializzazione)
        {
            //quadrante a
            if(x <= this.food.getWidth() / 2 && y <= this.food.getHeight() / 2)
            {
                this.quadranteA = true;
            }
            //quadrante c
            else if(x <= this.food.getWidth() / 2 && y >= this.food.getHeight() / 2)
            {
                this.quadranteC = true;
            }
            //quadrante b
            else if(x >= this.food.getWidth() / 2 && y <= this.food.getHeight() / 2)
            {
                this.quadranteB = true;
            }
            //quadrante d
            else
            {
                this.quadranteD = true;
            }
            
            this.inizializzazione = false;
        }
        
        if(this.quadranteA)
        {
            if(y < this.food.getHeight() - this.bordo)
            {
                y ++;
                this.raggioSpirale --;
            }
          
            if(this.raggioSpirale == 0 || y == this.food.getHeight() - bordo)
            {
                this.raggioSpirale = this.food.getWidth() / 2 - this.bordo;
                
                this.quadranteA = false;
                this.quadranteC = true;
            }
        }
        else if(this.quadranteC)
        {
            if(x < this.food.getWidth() - this.bordo)
            {
                x ++;
                this.raggioSpirale --;
            }
            
            
            if(this.raggioSpirale == 0 || x == this.food.getWidth() - bordo)
            {
                this.raggioSpirale = this.food.getWidth() / 2 - this.bordo;
                
                this.quadranteC = false;
                this.quadranteD = true;
            }
        }
        else if(this.quadranteD)
        {
            if(y > this.bordo)
            {
                y --;
                this.raggioSpirale --;
            }
            
            if(this.raggioSpirale == 0 || y == this.bordo)
            {
                this.raggioSpirale = this.food.getWidth() / 2 - this.bordo;
                
                this.quadranteD = false;
                this.quadranteB = true;
            }
        }
        else
        {
            if(x > this.bordo)
            {
                x --;
                this.raggioSpirale --;
            }
            
            if(this.raggioSpirale == 0 || x == this.bordo)
            {
                this.raggioSpirale = this.food.getWidth() / 2 - this.bordo;
                
                this.quadranteB = false;
                this.quadranteA = true;
                
            }
        }
    }
    
    private void randomWalker()
    {
        switch(random.nextInt(4))
            {
                //Sposto destra
                case 0:
                    if(x < this.food.getWidth() - this.bordo)
                    {
                        x ++;
                        break;
                    }
                //sposto alto
                case 1:
                    if(y > this.bordo)
                    {
                        y --;
                        break;
                    }
                //sposto sinistra
                case 2:
                    if(x > this.bordo)
                    {
                        x --;
                        break;
                    }
                case 3:
                    if(y < this.food.getHeight() - this.bordo)
                    {
                        y ++;
                        break;
                    }

            }
        
    }
    
    @Override
    protected void Sposta()
    {   
        //controllo sulle coordinate per non generare eccezioni
        if( (x > this.bordo || x < this.food.getWidth() - this.bordo) && (y > this.bordo || y < this.food.getHeight() - this.bordo) )
        {
            //controllo quadrante A
            if(this.quadranteA && this.food.isFood(x, y + 1) && y < this.food.getHeight() - this.bordo && x > this.bordo)
            {
                this.onFood = true;
            }
            //controllo quadrante B
            else if(this.quadranteB && this.food.isFood(x - 1, y) && y < this.food.getHeight() - this.bordo && x < this.food.getWidth() - this.bordo)
            {
                this.onFood = true;
            }
            //controllo quadrante C
            else if(this.quadranteC && this.food.isFood(x + 1, y) && x < this.food.getWidth() - this.bordo && y < this.food.getHeight() - this.bordo)
            {
                this.onFood = true;
            }
            //controllo quadrante D
            else if(this.quadranteD && this.food.isFood(x, y - 1) && x < this.food.getWidth() - this.bordo && y < this.food.getHeight() - this.bordo)
            {
                this.onFood = true;
            }
        }
        
        
        if(this.onFood)
        {
            randomWalker();
            
            this.eatingCycle --;
            
            if(this.eatingCycle == 0)
            {
                this.eatingCycle = 10;
                this.onFood = false;
            }
        }
        else
            SpostaRicerca();
    }
    
    @Override
    public Batterio Clona()
    {
       return new Monellasal(x,y,colore,food); 
    }
    
    @Override
    public String toString()
    {
        return "Monellasal";
    }

}
