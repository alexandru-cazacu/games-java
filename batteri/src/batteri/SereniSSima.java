/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batteri;

import java.awt.Color;
import java.util.LinkedList;

/**
 *
 * @author Abate Simone, Facchini Omar, Mattanza Michael
 */

public class SereniSSima extends Batterio{
    private static LinkedList<cordlist> venetoloc = new LinkedList<>();
    private int flag;
    private static int conta=1;
    public SereniSSima(int x, int y, Color c, Food f) {
        super(x, y, c, f);
        flag=0;
    }

    @Override
    protected void Sposta() {
        for(int i=1;i<100 && flag==0;i++)
            if(circontr2(i*3)){
                venetoloc.addFirst(new cordlist(x,y));
                flag=1;
            }
        if(venetoloc.isEmpty()==false && conta%100==0)
            venetoloc.clear();
        if(flag==0 && venetoloc.isEmpty()==false && salute-(Math.abs(x-venetoloc.getFirst().xf)+Math.abs(y-venetoloc.getFirst().yf))>0){
            x=venetoloc.getFirst().xf;
            y=venetoloc.getFirst().yf;
            conta++;
        }
        else if(flag==0){
            int dx = (int)(Math.random()*3) - 1;
            int dy = (int)(Math.random()*3) - 1;
            if (x+dx >= 0 && x+dx<food.getWidth())
                x += dx; 
            if (y+dy >= 0 && y+dy<food.getHeight())
                y += dy;
        }
        flag=0;
    }

    @Override
    public Batterio Clona() {
        return new SereniSSima(x, y, colore, food);
    }
    
    private boolean circontr2(int molt){
        if (x+molt<food.getWidth())
            if(ControllaCibo(molt+x,y) && salute-molt > 0 ){
                x+=molt;
                return true;
            }
        if(x-molt>0)
            if (ControllaCibo(x-molt,y) && salute-molt > 0){
                x-=molt;
                return true;
            }
        if(y+molt<food.getHeight())
            if (ControllaCibo(x,y+molt) && salute-molt > 0 ){
                y+=molt;
                return true;
            }
        if(y-molt>0)
            if (ControllaCibo(x,y-molt) && salute-molt > 0){
                y-=molt;
                return true;
            }
        if(x+molt<food.getWidth() && y+molt<food.getHeight())
            if (ControllaCibo(x+molt,y+molt) && salute-molt > 0 ){
                x+=molt;
                y+=molt;
                return true;
            }
        if(x-molt>0 && y+molt<food.getHeight())
            if (ControllaCibo(x-molt,y+molt) && salute-molt > 0 ){
                x-=molt;
                y+=molt;
                return true;
            }
        if(x+molt<food.getWidth() && y-molt>0)
            if (ControllaCibo(x+molt,y-molt) && salute-molt > 0 ){
                x+=molt;
                y-=molt;
                return true;
            }
        if(x-molt>0 && y-molt>0)
            if (ControllaCibo(x-molt,y-molt) && salute-molt > 0 ){
                x-=molt;
                y-=molt;
                return true;
            }
        return false;
    }
    
    @Override
    public String toString() {
        return "SereniSSima";
    }
//---------------------------------------------------------------------------------
    public class cordlist{
        private int xf,yf,numveneti;
        
        public cordlist(int xf, int yf){
            this.xf=xf;
            this.yf=yf;
            numveneti=0;
        }
    } 
}


