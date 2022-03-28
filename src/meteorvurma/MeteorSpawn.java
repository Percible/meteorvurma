package meteorvurma;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MeteorSpawn extends FrameHareket{

    int sayac = 0;
    Timer meteor;
    
    private final static MeteorSpawn mSpawn = new MeteorSpawn();
    
    private MeteorSpawn() {// SİNGLETON İÇİN PRİVATE KURUCU METHODUM BURADA 
    }
    
    public static MeteorSpawn getInstance() {// BURADA GETINSTANCE METHODUNU OLUŞTURDUM HOCAM
        return mSpawn;
    }

    @Override
    public void oynatma() {

        // BURADA OLUSTURDUGUM METEOR RESIMLERINI YAN YANA DIZMEK ICIN BIR METHOD OLUSTURDUM.
        for (int i = 0; i < 6; i++) {
            GrafikSinifi.meteorX[i] = 10 + sayac;
            GrafikSinifi.meteorY[i] = -100 + sayac;
            sayac = sayac + 100;

        }

        meteor = new Timer();
        meteor.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                
                

                //BURADA OYUN HER BASLADIGINDA METEORLARA RANDOM BIR HIZ VERIYORUM.
                Random r = new Random();
                GrafikSinifi.meteorHiz[0] = r.nextInt(10);
                GrafikSinifi.meteorHiz[1] = r.nextInt(10);
                GrafikSinifi.meteorHiz[2] = r.nextInt(10);
                GrafikSinifi.meteorHiz[3] = r.nextInt(10);
                GrafikSinifi.meteorHiz[4] = r.nextInt(10);
                GrafikSinifi.meteorHiz[5] = r.nextInt(10);

                //BU DONGUDE METEORLARIN ASAGIYA DOGRU KAYMASINI SAGLADIM HOCAM.
                for (int i = 0; i < 6; i++) {
                    GrafikSinifi.meteorY[i] += GrafikSinifi.meteorHiz[i];

                    if (GrafikSinifi.meteorY[i] > 550) {
                        GrafikSinifi.meteorY[i] = -50;
                    }
                }
            }
        }, 0, 10);

    }

}
