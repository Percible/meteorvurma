/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meteorvurma;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author welco
 */
public class PatlamaOynatma extends FrameHareket{

    Timer pat;
    int sayac = 0;
    private static final PatlamaOynatma patlatma = new PatlamaOynatma();

    private PatlamaOynatma() {// SİNGLETON İÇİN PRİVATE KURUCU METHODUM BURADA 

    }

    public static PatlamaOynatma getInstance() {// BURADA GETINSTANCE METHODUNU OLUŞTURDUM HOCAM
        return patlatma;
    }

    //BURADA METEOR VE ARAC BIRBIRINE CARPTIGINDA EKRANA PATLAMA EFEKTİ GELIYOR.
    @Override
    public void oynatma(){
        pat = new Timer();

        pat.schedule(new TimerTask() {
            @Override
            public void run() {

                if (GrafikSinifi.patlamaKontrol == true) {

                    if (sayac < 25) {//25 RESIMDEN OLUSUYOR HOCAM ARDI ARDINA FOTOGRAFLARI CAGIRDIGIM ZAMAN GIF GIBI GOZUKUYOR
                        GrafikSinifi.patlamaSuresi = sayac;
                        sayac++;
                    } else if (sayac == 25) {

                        GrafikSinifi.patlamaSuresi = 25;
                        sayac = 0;
                        GrafikSinifi.patlamaKontrol = false;
                    }

                }

            }
        }, 0, 30);
    }
}
