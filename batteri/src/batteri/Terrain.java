package batteri;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 * Classe che rappresenta il terreno di gara
 * @author Alessandro Bugatti
 * @version 0.1
 */

public class Terrain extends JPanel {
    public Terrain(Food f, LinkedList<Batterio> l, Color s,HashMap<String,Integer> numeroBatteri) {
        food = f;
        batteri = l;
        sfondo = s;
        this.numeroBatteri = numeroBatteri; 
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1024,700);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(sfondo);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        LinkedList<Batterio> babies = new LinkedList<>();
        for(Iterator<Batterio> i = batteri.iterator();i.hasNext();){
            Batterio batterio = i.next();
            g.setColor(sfondo);
            g.fillRect(batterio.getX(), batterio.getY(), 2, 2);
            batterio.Run();
            if (batterio.Morto())
            {
                numeroBatteri.put(batterio.toString(), numeroBatteri.get(batterio.toString())-1);
                i.remove();
            }
            else if (batterio.Fecondo())
            {
                Batterio b = batterio.Clona();
                babies.add(b);
                numeroBatteri.put(batterio.toString(), numeroBatteri.get(batterio.toString())+1);
            }
            else{
                g.setColor(batterio.getColore());
                g.fillRect(batterio.getX(), batterio.getY(), 3, 3);
            }
        }
        batteri.addAll(babies);
        //Ridisegna il cibo a ogni ciclo
        {
            g.setColor(Color.GREEN);
            for (int i = 0; i < food.getWidth(); i++)
                for (int j = 0; j < food.getHeight(); j++)
                    if (food.isFood(i, j))
                        g.fillRect(i, j, 2, 2);
            
        }
    }  
    
    public void toggleFood()
    {
        food.squareDistribution(50, 500);
    }
        
    private Food food;
    private Color sfondo;
    LinkedList<Batterio> batteri;
    private HashMap<String,Integer> numeroBatteri;
}
