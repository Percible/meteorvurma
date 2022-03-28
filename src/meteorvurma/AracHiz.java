package meteorvurma;

import java.util.Timer;
import java.util.TimerTask;

public class AracHiz extends FrameHareket {

    private static final AracHiz aHız = new AracHiz();
    Timer hiz;
    private final int aracinHizi = 5;

    private AracHiz() {// SİNGLETON İÇİN PRİVATE KURUCU METHODUM BURADA 
    }

    public static AracHiz getInstance() {// BURADA GETINSTANCE METHODUNU OLUŞTURDUM HOCAM
        return aHız;
    }

    @Override
    public void oynatma() {

        hiz = new Timer();

        hiz.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {//BURADA ARAC EKRAN DISINA CIKMASIN DIYE YAZDIGIM KODLAR VAR VEBELIRLI TUSLARA BASILDIGINDA ARACIN HANGI YONE GITMESINI , NEKDAR HIZDA GITMESINI BURADAN KONTROL EDIYORUM
                if (GrafikSinifi.ileri == true && GrafikSinifi.aracY > 0) {
                    GrafikSinifi.aracY -= aracinHizi;

                } else if (GrafikSinifi.geri == true && GrafikSinifi.aracY < 400) {
                    GrafikSinifi.aracY += aracinHizi;
                } else if (GrafikSinifi.saga == true && GrafikSinifi.aracX < 520) {
                    GrafikSinifi.aracX += aracinHizi;
                } else if (GrafikSinifi.sola == true && GrafikSinifi.aracX > 10) {
                    GrafikSinifi.aracX -= aracinHizi;
                }

            }
        }, 0, 15);
    }

}
