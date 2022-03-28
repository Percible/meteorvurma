package meteorvurma;

import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public class LazerHareket extends FrameHareket {

    Timer timer;
    Lazer lazer;

    private final static LazerHareket lHareket = new LazerHareket();

    private LazerHareket() {// SİNGLETON İÇİN PRİVATE KURUCU METHODUM BURADA 

    }

    public static LazerHareket getInstance() {// BURADA GETINSTANCE METHODUNU OLUŞTURDUM HOCAM
        return lHareket;
    }

    @Override
    public void oynatma() {//Burada lazerin hareketini yapıoruz space tusuna basilirsa lazer burada uzay aracindan cikisini gerceklestiriyor.

        timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {

                Iterator<Lazer> itr = GrafikSinifi.lazerler.iterator();

                try {
                    while (itr.hasNext()) {
                        Lazer lazer = itr.next();
                        if (GrafikSinifi.lazerKontrol == true) {
                            lazer.setAtesY(lazer.getAtesY() - GrafikSinifi.lazerAzalanY);
                            if (lazer.getAtesY() < 0) {//LAZERIN Y KOORDINATI 0 DAN KUCUK OLURSA LAZER SILINIYOR.
                                itr.remove();

                            }
                            if (GrafikSinifi.astreoidCarpmaKucuk == true) {//eger lazer meteora carparsa lazer siliniyor.
                                itr.remove();
                                GrafikSinifi.astreoidCarpmaKucuk = false;
                                Runtime.getRuntime().gc();
                                
                            }

                        }
                    }

                } catch (Exception e) {
                    System.out.println("Hata");
                }

            }
        }, 0, 15);

    }
}
