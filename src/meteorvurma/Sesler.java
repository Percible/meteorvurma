package meteorvurma;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import static meteorvurma.AracHareket.sayac;

public class Sesler extends JPanel implements Muzik {

    GrafikSinifi sarki = new GrafikSinifi();

    static boolean sesKontrol;

    public Sesler() {

    }

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

    @Override
    public void OyunIciSesDurdur() {

        sarki.OyunIciSesDurdur();

    }

}
