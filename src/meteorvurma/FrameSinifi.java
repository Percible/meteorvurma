package meteorvurma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameSinifi extends JFrame {

    GrafikSinifi grafikSinifi;
    static int setGenislik = 600;
    static int setYukseklik = 500;
    JFrame frame = new JFrame();

    private static final FrameSinifi fSinifi = new FrameSinifi();

    private FrameSinifi() {// SİNGLETON İÇİN PRİVATE KURUCU METHODUM BURADA 

    }

    public static FrameSinifi getInstance() {// BURADA GETINSTANCE METHODUNU OLUŞTURDUM HOCAM
        return fSinifi;
    }

    public void oynatma() {

        GrafikSinifi graf = new GrafikSinifi();
        AracHareket h = new AracHareket();

        //BURADA EKRANIMIN BOYU GENISLIGI, BASLIK, GORUNURLUGU GIBI OLALYLARI GERCEKLESTIRDIM HOCAM.
        frame.add(h);
        frame.add(graf);
        frame.setTitle("Meteor Vurma");
        frame.setSize(setGenislik, setYukseklik);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

    }

}
