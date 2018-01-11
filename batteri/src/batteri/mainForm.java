/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package batteri;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.Timer;

/**
 *
 * @author Alessandro Bugatti 2015
 */
public class mainForm extends javax.swing.JFrame {

    /**
     * Creates new form mainForm
     */
    public mainForm() {
        initComponents();
        running = false;
        food = new Food(1024, 700);
        inizializzaBatteri();
        terrain = new Terrain(food, batteri, jPanelTerrain.getBackground(), numeroBatteri);
        this.jPanelTerrain.add(terrain);
        values = new javax.swing.JLabel[10];
        for (int i = 0; i < nomiBatteri.size(); i++) {
            values[i] = new javax.swing.JLabel(nomiBatteri.get(i)
                    + " " + numeroBatteri.get(nomiBatteri.get(i)));
            values[i].setForeground(coloreBatteri.get(nomiBatteri.get(i)));
            this.jPanelResult.add(values[i]);
        }
        javax.swing.JButton btnStart = new javax.swing.JButton("Start");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerUpdateSimulation.start();
                timerUpdateResult.start();
                timerUpdateFood.start();
            }
        }
        );
        this.jPanelResult.add(btnStart);
        javax.swing.JButton btnStop = new javax.swing.JButton("Stop");
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerUpdateSimulation.stop();
                timerUpdateResult.stop();
                timerUpdateFood.stop();
            }
        }
        );
        this.jPanelResult.add(btnStop);
        pack();
        //Timer per l'aggiornamento della simulazione
        ActionListener taskUpdateSimulation;
        taskUpdateSimulation = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Lo scopo di running è evitare che riparta un ciclo
                // di ridisegno del campo gara mentre ne è già in corso uno
                if (running) {
                    return;
                }
                running = true;
                terrain.repaint();
                running = false;
            }

        };
        timerUpdateSimulation = new Timer(100, taskUpdateSimulation);
        //timer.setInitialDelay(2000);        
        //timerUpdateSimulation.setRepeats(true);

        //Timer per l'aggiunta di cibo
        ActionListener taskUpdateFood;
        taskUpdateFood = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                terrain.toggleFood();
            }

        };
        timerUpdateFood = new Timer(1000, taskUpdateFood);
        //timer.setInitialDelay(2000);        
        timerUpdateFood.setRepeats(true);
        //timerUpdateFood.start();

        //Timer per l'aggiornamento del pannello dei dati
        ActionListener taskUpdateResult;
        taskUpdateResult = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < nomiBatteri.size(); i++) {
                    values[i].setText(nomiBatteri.get(i)
                            + " " + numeroBatteri.get(nomiBatteri.get(i)));
                }
            }

        };
        timerUpdateResult = new Timer(1000, taskUpdateResult);
        //timer.setInitialDelay(2000);        
        //timerUpdateResult.setRepeats(true);
        //timerUpdateResult.start();
    }

    /**
     * Inizializza la lista dei batteri
     */
    private void inizializzaBatteri() {
        batteri = new LinkedList<>();
        Random r = new Random();
        numeroBatteri = new HashMap<>();
        coloreBatteri = new HashMap<>();
        nomiBatteri = new ArrayList<>();
        /*Codice da replicare per ogni tipo di batterio aggiunto*/
 /*INIZIO*/
//        for (int i = 0; i < 100; i++)
//            batteri.add(new TontinoMigliore(r.nextInt(food.getWidth()),
//                                r.nextInt(food.getHeight()),
//                                Color.gray,food));
//        numeroBatteri.put("TontinoMigliore", 100);
//        coloreBatteri.put("TontinoMigliore", Color.gray);
//        nomiBatteri.add("TontinoMigliore");
        /*FINE TONTINO*/
        for (int i = 0; i < 100; i++) {
            batteri.add(new Tontone(r.nextInt(food.getWidth()),
                    r.nextInt(food.getHeight()),
                    Color.red, food));
        }
        numeroBatteri.put("Tontone", 100);
        coloreBatteri.put("Tontone", Color.red);
        nomiBatteri.add("Tontone");

        for (int i = 0; i < 100; i++) {
            batteri.add(new Tontino(r.nextInt(food.getWidth()),
                    r.nextInt(food.getHeight()),
                    Color.blue, food));
        }
        numeroBatteri.put("Tontino", 100);
        coloreBatteri.put("Tontino", Color.blue);
        nomiBatteri.add("Tontino");

        for (int i = 0; i < 100; i++) {
            batteri.add(new Predator(r.nextInt(food.getWidth()),
                    r.nextInt(food.getHeight()),
                    Color.gray, food));
        }
        numeroBatteri.put("Predator", 100);
        coloreBatteri.put("Predator", Color.gray);
        nomiBatteri.add("Predator");

        for (int i = 0; i < 100; i++) {
            batteri.add(new SLAYER(r.nextInt(food.getWidth()),
                    r.nextInt(food.getHeight()),
                    Color.black, food));
        }
        numeroBatteri.put("SLAYER", 100);
        coloreBatteri.put("SLAYER", Color.black);
        nomiBatteri.add("SLAYER");

        for (int i = 0; i < 100; i++) {
            batteri.add(new SereniSSima(r.nextInt(food.getWidth()),
                    r.nextInt(food.getHeight()),
                    Color.white, food));
        }
        numeroBatteri.put("SereniSSima", 100);
        coloreBatteri.put("SereniSSima", Color.white);
        nomiBatteri.add("SereniSSima");

        for (int i = 0; i < 100; i++) {
            batteri.add(new Ripetenti(r.nextInt(food.getWidth()),
                    r.nextInt(food.getHeight()),
                    Color.white, food));
        }
        numeroBatteri.put("Ripetenti", 100);
        coloreBatteri.put("Ripetenti", Color.white);
        nomiBatteri.add("Ripetenti");

//        for (int i = 0; i < 100; i++)
//            batteri.add(new Ripetenti(r.nextInt(food.getWidth()),
//                                r.nextInt(food.getHeight()),
//                                Color.cyan,food));
//        numeroBatteri.put("Ripetenti", 100);
//        coloreBatteri.put("Ripetenti", Color.cyan);
//        nomiBatteri.add("Ripetenti");
//        
//        for (int i = 0; i < 100; i++)
//            batteri.add(new GLADIATHOR(r.nextInt(food.getWidth()),
//                                r.nextInt(food.getHeight()),
//                                Color.MAGENTA,food));
//        numeroBatteri.put("GLADIATHOR", 100);
//        coloreBatteri.put("GLADIATHOR", Color.MAGENTA);
//        nomiBatteri.add("GLADIATHOR");
//        
//        for (int i = 0; i < 100; i++)
//            batteri.add(new Monellasal(r.nextInt(food.getWidth()),
//                                r.nextInt(food.getHeight()),
//                                Color.WHITE,food));
//        numeroBatteri.put("Monellasal", 100);
//        coloreBatteri.put("Monellasal", Color.WHITE);
//        nomiBatteri.add("Monellasal");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.1111111
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelResult = new javax.swing.JPanel();
        jPanelTerrain = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bacteria");
        setResizable(false);

        jPanelResult.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelResult.setMinimumSize(new java.awt.Dimension(150, 100));
        jPanelResult.setLayout(new javax.swing.BoxLayout(jPanelResult, javax.swing.BoxLayout.Y_AXIS));
        getContentPane().add(jPanelResult, java.awt.BorderLayout.LINE_END);

        jPanelTerrain.setBackground(new java.awt.Color(0, 0, 0));
        jPanelTerrain.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanelTerrain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelResult;
    private javax.swing.JPanel jPanelTerrain;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JLabel values[];
    private Terrain terrain;
    private javax.swing.Timer timerUpdateSimulation;
    private javax.swing.Timer timerUpdateFood;
    private javax.swing.Timer timerUpdateResult;
    private LinkedList<Batterio> batteri;
    private Food food;
    private boolean running;
    private HashMap<String, Integer> numeroBatteri;
    private HashMap<String, Color> coloreBatteri;
    private ArrayList<String> nomiBatteri;

}
