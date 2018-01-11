/**
 * Classe Predator per la gara
 *
 * @author Barensfeld Antonio
 * @author Cazacu Alexandru
 * @author Piva Lorenzo
 * @lastupdate 04/04/2017
 */
package batteri;

import java.awt.Color;

public class Predator extends Batterio {

    private int closeDistMinScan = 1;
    private int closeDistMaxScan = 3;
    private int midDist = 100;
    private int midSteps = 5;

    /*
    Classe di ausilio che contiene true e le coordinate del cibo,
    false -1 -1 altrimenti
     */
    public class Vector2 {

        boolean isFood;
        int xCord;
        int yCord;

        public Vector2(int x, int y, boolean isFood) {
            this.xCord = x;
            this.yCord = y;
            this.isFood = isFood;
        }
    }

    public Predator(int x, int y, Color c, Food f) {
        super(x, y, c, f);
    }

    @Override
    protected void Sposta() {

        Vector2 v;

        /*
        Scan a breve distanza. Cerca sul perimetro di un quadrato con lato
        crescente, per mangiare prima il cibo più vicino
         */
        for (int i = closeDistMinScan; i <= closeDistMaxScan; i++) {
            v = getFoodSquare(x, y, i);
            if (v.isFood) {
                x = v.xCord;
                y = v.yCord;
                return;
            }
        }

        /*
        Scan a media distanza, cerca su una distanza maggiore a discapito della
        precisione. Combinato con il movimento casuale produce un risultato
        soddisfacente
         */
        v = getFoodLine(midDist, midSteps);
        if (v.isFood) {
            x = v.xCord;
            y = v.yCord;
            return;
        }

        /*
        Movimento casuale, da solo è poco utile, ma combinato con lo scan a
        media distanza, anche esso casuale, produce un risultato più
        utile
         */
        int dx = (int) (Math.random() * 3) - 1;
        int dy = (int) (Math.random() * 3) - 1;
        if (x + dx >= 0 && x + dx < food.getWidth()) {
            x += dx;
        }
        if (y + dy >= 0 && y + dy < food.getHeight()) {
            y += dy;

        }
    }

    /**
     * Sansione sul perimetro di un quadrato dato il centro e la distanza dei
     * lati da esso
     *
     * @param xOrigin Origine x
     * @param yOrigin Origine Y
     * @param distance dall'origine
     * @return Vector2(x, y, true) se c'è cibo, Vector2(-1, -1, false)
     * altrimenti
     */
    Vector2 getFoodSquare(int xOrigin, int yOrigin, int distance) {
        for (int yy = yOrigin - distance; yy <= yOrigin + distance; yy++) {
            for (int xx = xOrigin - distance; xx <= xOrigin + distance; xx++) {
                if (xx >= 0 && xx < food.getWidth() && yy >= 0 && yy < food.getHeight()) {
                    if (yy == yOrigin - distance || yy == yOrigin + distance
                            || xx == xOrigin - distance || xx == xOrigin + distance) {
                        if (food.isFood(xx, yy)) {
                            return new Vector2(xx, yy, true);
                        }
                    }
                }
            }
        }
        return new Vector2(-1, -1, false);
    }

    /**
     * Sansione sul perimetro di un quadrato dato il centro e la distanza dei
     * lati da esso
     *
     * @param xOrigin Origine x
     * @param yOrigin Origine Y
     * @param distance dall'origine
     * @return Vector2(x, y, true) se c'è cibo, Vector2(-1, -1, false)
     * altrimenti
     */
    Vector2 getFoodSquare2(int xOrigin, int yOrigin, int distance) {
        for (int yy = yOrigin - distance; yy <= yOrigin + distance; yy++) {
            for (int xx = xOrigin - distance; xx <= xOrigin + distance; xx++) {
                if (xx >= 0 && xx < food.getWidth() && yy >= 0 && yy < food.getHeight()) {
                    if (food.isFood(xx, yy)) {
                        return new Vector2(xx, yy, true);
                    }

                }
            }
        }
        return new Vector2(-1, -1, false);
    }

    /**
     * Scansione verticale e orizzontale per x volte ongi n pixel
     *
     * @param distance Distanza dello scan
     * @param offset Distanza fra ogni scan
     * @return Vector2(x, y, true; se c'è cibo Vector2(-1, -1, false) altrimenti
     */
    Vector2 getFoodLine(int distance, int offset) {
        // Allontanamento progressivo dal batterio
        for (int n = 1; n < distance; n += offset) {
            // Se il punto dello scan è valido
            if (x - n >= 0 && x + n < food.getWidth() && y - n >= 0 && y + n < food.getHeight()) {
                // Controllo le 4 direzioni e ritorno se c'è cibo
                if (food.isFood(x + n, y)) {
                    return new Vector2(x + n, y, true);
                } else if (food.isFood(x - n, y)) {
                    return new Vector2(x - n, y, true);
                }
                if (food.isFood(x, y + n)) {
                    return new Vector2(x, y + n, true);
                } else if (food.isFood(x, y - n)) {
                    return new Vector2(x, y - n, true);
                }
            }
        }
        // Non c'è cibo nelle zone scansionate
        return new Vector2(-1, -1, false);
    }

    @Override
    public Batterio Clona() {
        return new Predator(x, y, colore, food);
    }

    @Override
    public String toString() {
        return "Predator";
    }

}
