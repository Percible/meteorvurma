package meteorvurma;

import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author welco
 */
public class LazerMeteorCarpisma extends FrameHareket {

    Timer timer;
    Lazer lazer;
    private final static LazerMeteorCarpisma lmCarpisma = new LazerMeteorCarpisma();

    private LazerMeteorCarpisma() {// SİNGLETON İÇİN PRİVATE KURUCU METHODUM BURADA 

    }

    public static LazerMeteorCarpisma getInstance() {// BURADA GETINSTANCE METHODUNU OLUŞTURDUM HOCAM
        return lmCarpisma;
    }

    @Override
    public void oynatma() {

        timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {

                Iterator<Lazer> it = GrafikSinifi.lazerler.iterator();

                while (it.hasNext()) {
                    Lazer lazer = it.next();
                    for (int i = 0; i < 6; i++) {

                        try {
                            if (lazer.getAtesX() >= GrafikSinifi.meteorX[i] - 30 && lazer.getAtesX() <= GrafikSinifi.meteorX[i] + 40//Lazer buradaki koordinatlarin icine girerse carpmis oluyor
                                    && lazer.getAtesY() >= GrafikSinifi.meteorY[i] - 30 && lazer.getAtesY() <= GrafikSinifi.meteorY[i] + 30) {
                                GrafikSinifi.carpmaDegeri++;
                                GrafikSinifi.astreoidCarpmaKucuk = true;//burada bu degeri true yapip lazer hareket sinifina yönlendirdim.

                                GrafikSinifi.meteorY[i] = -100;

                                if (GrafikSinifi.astreoidCarpmaKucuk == true) {
                                    GrafikSinifi.saglik = GrafikSinifi.saglik + 10;
                                }

                            }
                        } catch (Exception e) {

                        }

                    }

                }

            }
        }, 0, 15);

    }
}
