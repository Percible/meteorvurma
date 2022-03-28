package meteorvurma;

import static meteorvurma.AracHareket.sayac;

public class Sesler implements Muzik {

    GrafikSinifi sarki = new GrafikSinifi();

    @Override
    public void LazerSesi() {

        if (sayac > 9) {

            sarki.LazerSesi();

        }

    }

    @Override
    public void OyunIciSes() {
        
        sarki.OyunIciSes();
    }

}
