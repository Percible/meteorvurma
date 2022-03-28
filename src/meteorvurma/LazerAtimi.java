package meteorvurma;

import java.util.Timer;
import java.util.TimerTask;

public class LazerAtimi {

    Timer lz;
    private final static LazerAtimi la = new LazerAtimi();

    private LazerAtimi() {// SİNGLETON İÇİN PRİVATE KURUCU METHODUM BURADA 

    }

    public static LazerAtimi getInstance() {// BURADA GETINSTANCE METHODUNU OLUŞTURDUM HOCAM
        return la;
    }

    public void oynatma() {

        lz = new Timer();

        lz.schedule(new TimerTask() {
            @Override
            public void run() {//BURADA LAZERI BELLI BIR SANIYE ICINDE ATMAK ICIN SAYAC EKLEDIM HER YARIM SANIYEDE BIR SAYAC 2 ARTIYOR. 10 OLURSA TEKRAR ATABILIYORSUNUZ HOCAM.

                AracHareket.sayac = AracHareket.sayac + 2;

            }

        }, 0, 500);

    }

}
