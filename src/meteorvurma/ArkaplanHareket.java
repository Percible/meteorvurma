package meteorvurma;

import java.util.TimerTask;
import java.util.Timer;

public class ArkaplanHareket extends FrameHareket{

    Timer hareket;
    
    private static final ArkaplanHareket arkaplanHareket = new ArkaplanHareket();
    
    private ArkaplanHareket() {// SİNGLETON İÇİN PRİVATE KURUCU METHODUM BURADA 
    }
    
    public static ArkaplanHareket getInstance() {// BURADA GETINSTANCE METHODUNU OLUŞTURDUM HOCAM
        return arkaplanHareket;
    }
    @Override
    public void oynatma() {

        hareket = new Timer();

        hareket.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {//BURADA ARKA PLANIN KENDINI TEKRAR ETMESINI SAGLADIM VE ARKAPLANIN HAREKET ETMESINI. SUREKLI OLARAK ASAGIYA DOGRU ILERLIYOR VE 0 A GELDIGINDE TEKRAR YUKARI SPAWN OLUYOR.

                if (GrafikSinifi.arkaplanY1 < 495) {
                    GrafikSinifi.arkaplanY1 += 2;
                } else {
                    GrafikSinifi.arkaplanY1 = -500;

                }
                if (GrafikSinifi.arkaplanY2 < 495) {
                    GrafikSinifi.arkaplanY2 += 2;
                } else {
                    GrafikSinifi.arkaplanY2 = -500;

                }

            }
        }, 0, GrafikSinifi.arkaplanHiz);

    }

}
