package meteorvurma;

import java.util.Timer;
import java.util.TimerTask;

public class MeteorCarpma extends FrameHareket {

    Timer mtr;
    int sayac = 0;
    private final static MeteorCarpma mCarpma = new MeteorCarpma();

    private MeteorCarpma() {// SİNGLETON İÇİN PRİVATE KURUCU METHODUM BURADA 
    }

    public static MeteorCarpma getInstance() {// BURADA GETINSTANCE METHODUNU OLUŞTURDUM HOCAM
        return mCarpma;
    }

    
    //BURADA METEOR ILE ARAC CARPISTIGINDA OLUSACAK SEYLERI KODLADIM.
    @Override
    public void oynatma() {

        mtr = new Timer();

        mtr.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 6; i++) {
                        if (sayac == 0) {
                            //EGER ARACIN KOORDINATLARI METEORUN KOORDINATLARI ILE CAKISIRSA ARACDA PATLAMA EFEKTİ CIKIYOR VE METEORUN Y KOORDINATINI -150 YE ALIYORUM OYUN ICINDE SILINIYORMUS GIBI GOZUKUYOR.
                            if (GrafikSinifi.aracX >= GrafikSinifi.meteorX[i] - 40 && GrafikSinifi.aracX <= GrafikSinifi.meteorX[i] + 30
                                    && GrafikSinifi.aracY >= GrafikSinifi.meteorY[i] - 40 && GrafikSinifi.aracY <= GrafikSinifi.meteorY[i] + 30) {

                                GrafikSinifi.meteorY[i] = -150;

                                GrafikSinifi.patlamaKontrol = true;
                                
                                if (GrafikSinifi.patlamaKontrol == true) {
                                    GrafikSinifi.saglik =GrafikSinifi.saglik-10;
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, 10);

    }

}
