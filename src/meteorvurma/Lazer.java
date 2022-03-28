
package meteorvurma;

public class Lazer {

    private int atesX;
    private int atesY;
    //BURADA LAZERIN X VE Y KOORDINATLARINI TUTTUM. KOORDINATLAR SUREKLI YENILENDIGI ICIN KAPSULLEME KULLANMA KARARI LADIM HOCAM.

    public Lazer(int atesX, int atesY) {
        super();
        this.atesX = atesX;
        this.atesY = atesY;
    }

    public int getAtesX() {
        return atesX;
    }

    public void setAtesX(int atesX) {
        this.atesX = atesX;
    }

    public int getAtesY() {
        return atesY;
    }

    public void setAtesY(int atesY) {
        this.atesY = atesY;
    }
    public Lazer(){
        
        
    }
}
