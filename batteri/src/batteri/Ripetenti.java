/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batteri;

import java.awt.Color;

/**
 *
 * @author 70060344
 */
public class Ripetenti extends Batterio{
    private boolean flag=true;
    private int orientamento=1;
    private int dir;
    private int dirSpostamento;
    private int base, altezza;
    private boolean flagDirezione=true;
    public Ripetenti(int x, int y, Color c, Food f){
        super(x,y,c,f);
        dir=(int)(Math.random()*2);
        dirSpostamento=(int)(Math.random()*2);
        base=12;
        altezza=12;
    }
    @Override
    protected void Sposta(){
        int dx=1;
        int dy=1;
        if(dir==0){
            spostaOrizzontale(dx);
        }
        else
            spostaVerticale(dy);
            
    }
    private void spostaVerticale(int dY){
        if (y + dY >= 0 && y + dY < food.getHeight() && flag == true) {
            y += dY;
            ControlloDelCiboAlto();
                if (y + dY > food.getHeight() - 1) {
                    flag = false;
                }
        } else {
            y-= dY;
            ControlloDelCiboBasso();
            if (y - dY < 1) 
                flag = true;
                     
        }
    }
    private void spostaOrizzontale(int dX) {
        if (x + dX >= 0 && x + dX < food.getWidth() && flag == true) {
            x += dX;
            ControlloDelCiboSinistra();
            if (x + dX > food.getWidth() - 1) {
                flag = false;
            }
        } else {
            x -= dX;
            ControlloDelCiboDestra();
            if (x - dX < 1) {
                flag = true;
            }
        }
    }
    private void ControlloDelCiboDestra(){
        for(int i=this.x-(base/2); i<x+(base/2); i++){
            for(int j=this.y-(altezza/2); j<y+(altezza/2); j++){
                if((i>0 && i<food.getWidth()) && (j>0 && j<food.getHeight())){
                    if(this.ControllaCibo(i, j)==true){
                        this.x=i;
                        this.y=j;
                        //System.out.println(""+x+" "+y);
                        //food.eatFood(x, y);
                    }
                }
            }
        }
    }
    private void ControlloDelCiboSinistra(){
        for(int i=this.x+(base/2); i>x-(base/2); i--){
            for(int j=this.y+(altezza/2); j>y-(altezza/2); j--){
                if((i>0 && i<food.getWidth()) && (j>0 && j<food.getHeight())){
                    if(this.ControllaCibo(i, j)==true){
                        this.x=i;
                        this.y=j;
                        
                    }
                }
            }
        }
    }
    private void ControlloDelCiboAlto(){
        for(int i=this.y+(altezza/2); i>y-(altezza/2); i--){
            for(int j=this.x-(base/2); j<x+base/2; j++){
                if((j>0 && j<food.getWidth()) && (i>0 && i<food.getHeight())){
                    if(this.ControllaCibo(j, i)==true){
                        this.x=j;
                        this.y=i;
                        
                    }
                }
            }
        }
    }
    private void ControlloDelCiboBasso(){
        for(int i=this.y-(altezza/2); i<y+(altezza/2); i++){
            for(int j=this.x-(base/2); j<x+base/2; j++){
                if((j>0 && j<food.getWidth()) && (i>0 && i<food.getHeight())){
                    if(this.ControllaCibo(j, i)==true){
                        this.x=j;
                        this.y=i;
                        
                    }
                }
            }
        }
    }
    /*private true void controlloCibo(){
        
    }*/
    @Override
    public Batterio Clona(){
       return new Ripetenti(x,y,colore,food); 
    }
    
    @Override
    public String toString(){
        return "Ripetenti";
    }
}
