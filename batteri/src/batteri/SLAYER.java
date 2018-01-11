/* 

@author: Andrea Mazzoletti

 */
package batteri;

import java.awt.Color;

public class SLAYER extends Batterio {

    public SLAYER(int x, int y, Color c, Food f) {
        super(x, y, c, f);
    }
    private final int n = 5;
    private final int n2 = 15;
    private final int n3 = 20;
    private int flag = 0;
    private int flagint = 0;

    public void pattuglia() {
        if (flag == 0) {                     //flag 0
            if (flagint >= 20) {
                flag += 1;
                flagint = 0;
            }
            if (x - 1 >= 0 && x - 1 < food.getWidth()) {
                this.x -= 1;
            }
            flagint++;

        }
        if (flag == 1) {                     //flag 1
            if (flagint >= 20) {
                flag += 1;
                flagint = 0;
            }
            if (y + 1 >= 0 && y + 1 < food.getHeight()) {
                this.y += 1;
            }
            flagint++;

        }
        if (flag == 2) {                     // flag 2
            if (flagint >= 20) {
                flag += 1;
                flagint = 0;
            }
            if (x + 1 >= 0 && x + 1 < food.getWidth()) {
                this.x += 1;
            }
            flagint++;
        }
        if (flag == 3) {                      //flag 3
            if (flagint >= 20) {
                flag = 0;
                flagint = 0;
            }
            if (y - 1 >= 0 && y - 1 < food.getHeight()) {
                this.y -= 1;
            }
            flagint++;

        }

    }

    public void spostaVicino() {
        if (x + n >= 0 && x + n < food.getWidth() && (y + n >= 0 && y + n < food.getHeight())) {
            if (ControllaCibo(this.x + n, this.y + n) == true) {
                this.x += n;
                this.y += n;
            }
        }
        if (x - n >= 0 && x - n < food.getWidth() && (y - n >= 0 && y - n < food.getHeight())) {
            if (ControllaCibo(this.x - n, this.y - n) == true) {
                this.x -= n;
                this.y -= n;
            }
        }
        if (x + n >= 0 && x + n < food.getWidth() && (y - n >= 0 && y - n < food.getHeight())) {
            if (ControllaCibo(this.x + n, this.y - n) == true) {
                this.x += n;
                this.y -= n;
            }
        }
        if (x - n >= 0 && x - n < food.getWidth() && (y + n >= 0 && y + n < food.getHeight())) {
            if (ControllaCibo(this.x - n, this.y + n) == true) {
                this.x -= n;
                this.y += n;
            }
        }
    }

    public void spostaLontano() {
        if (x + n2 >= 0 && x + n2 < food.getWidth() && (y + n2 >= 0 && y + n2 < food.getHeight())) {
            if (ControllaCibo(this.x + n2, this.y + n2) == true) {
                this.x += n2;
                this.y += n2;
            }
        }
        if (x - n2 >= 0 && x - n2 < food.getWidth() && (y - n2 >= 0 && y - n2 < food.getHeight())) {
            if (ControllaCibo(this.x - n2, this.y - n2) == true) {
                this.x -= n2;
                this.y -= n2;
            }
        }
        if (x + n2 >= 0 && x + n2 < food.getWidth() && (y - n2 >= 0 && y - n2 < food.getHeight())) {
            if (ControllaCibo(this.x + n2, this.y - n2) == true) {
                this.x += n2;
                this.y -= n2;
            }
        }
        if (x - n2 >= 0 && x - n2 < food.getWidth() && (y + n2 >= 0 && y + n2 < food.getHeight())) {
            if (ControllaCibo(this.x - n2, this.y + n2) == true) {
                this.x -= n2;
                this.y += n2;
            }
        }

    }

    public void spostaUno() {
        if (x + 1 >= 0 && x + 1 < food.getWidth() && (y + 1 >= 0 && y + 1 < food.getHeight())) {
            if (ControllaCibo(this.x + 1, this.y + 1) == true) {
                this.x += 1;
                this.y += 1;
            }
        }
        if (x - 1 >= 0 && x - 1 < food.getWidth() && (y - 1 >= 0 && y - 1 < food.getHeight())) {
            if (ControllaCibo(this.x - 1, this.y - 1) == true) {
                this.x -= 1;
                this.y -= 1;
            }
        }
        if (x + 1 >= 0 && x + 1 < food.getWidth() && (y - 1 >= 0 && y - 1 < food.getHeight())) {
            if (ControllaCibo(this.x + 1, this.y - 1) == true) {
                this.x += 1;
                this.y -= 1;
            }
        }
        if (x - 1 >= 0 && x - 1 < food.getWidth() && (y + 1 >= 0 && y + 1 < food.getHeight())) {
            if (ControllaCibo(this.x - 1, this.y + 1) == true) {
                this.x -= 1;
                this.y += 1;
            }
        }
    }

    public void spostaOrizzontale() {
        if (x + n2 >= 0 && x + n2 < food.getWidth()) {
            if (ControllaCibo(this.x + n2, this.y) == true) {
                this.x += n2;
            }
        }
        if (x - n2 >= 0 && x - n2 < food.getWidth()) {
            if (ControllaCibo(this.x - n2, this.y) == true) {
                this.x -= n2;
            }
        }
    }

    public void spostaVerticale() {
        if (y + n2 >= 0 && y + n2 < food.getHeight()) {
            if (ControllaCibo(this.x, this.y + n2) == true) {
                this.y += n2;
            }
        }
        if (y - n2 >= 0 && y - n2 < food.getHeight()) {
            if (ControllaCibo(this.x, this.y - n2) == true) {
                this.y -= n2;
            }
        }
    }

    @Override
    protected void Sposta() {
        if (ControllaCibo() == false) {
            pattuglia();
        }
        spostaUno();
        spostaOrizzontale();
        spostaVerticale();
        spostaVicino();
        spostaLontano();
    }

    @Override
    public Batterio Clona() {
        return new SLAYER(x, y, colore, food);
    }

    @Override
    public String toString() {
        return "SLAYER";
    }
}
