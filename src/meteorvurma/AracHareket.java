package meteorvurma;

import jaco.mp3.player.MP3Player;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Timer;
import java.util.stream.DoubleStream;

import javax.swing.JPanel;
import static meteorvurma.Sesler.sesKontrol;

public class AracHareket extends JPanel implements KeyListener {

    Timer timer;
                int sayma =0;
                MuzikCalma mCal = new MuzikCalma();
                


    public static int sayac = 10;
    GrafikSinifi sarki = new GrafikSinifi();

    public AracHareket() {
        addKeyListener(this);
        setFocusable(true);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //BURADA BELLI TUSLARA BASILDIGINDA BAZI BOOLEAN DEGERLERI AKTIF EDIYOR VE ARACI KONTROL EDEBILIRSINIZ HOCAM.
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            GrafikSinifi.ileri = true;

        }

        if (e.getKeyCode() == KeyEvent.VK_S) {
            GrafikSinifi.geri = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            GrafikSinifi.saga = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            GrafikSinifi.sola = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);

        }
        if (e.getKeyCode() == KeyEvent.VK_M) {
            GrafikSinifi.resett = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_P) {
            GrafikSinifi.oyunkontrol = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {//BURASI ONEMLI HOCAM BURADA HER 2 SANIYEDE BIR LAZER ATMAYA HAZIR OLUYOR.

            if (sayac > 9) {
                try {
                    GrafikSinifi.lazerler.add(new Lazer(GrafikSinifi.aracX + 35, GrafikSinifi.aracY + 20));//BURADA SPACE TUSUNA BASILDIGINDA LAZELER ADLI ARRAYLISTDE YENI BIR LAZER OLUSTURUYOR
                    //OLUSTURULAN LAZER ARACIN KOORDINATLARINDAN CIKIYOR.
                    GrafikSinifi.harcananLazer++;
                    GrafikSinifi.lazerKontrol = true;
                    mCal.LazerSesiCal();
                    sayac = 0;
                } catch (Exception e1) {

                }
            }

        }
        
        if (e.getKeyCode() == KeyEvent.VK_P) {
            
            sayma++;
            sesKontrol = false;
            if (sayma>0) {
                MuzikCalma.getInstance().OyunIciSesCal();

            }
            
        }

        if (e.getKeyCode() == KeyEvent.VK_O) {
            sayma=0;
            
            if(sayma == 0){
                
                MuzikCalma.getInstance().OyunIciSesiDurdurma();

            }
            
            
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            GrafikSinifi.ileri = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            GrafikSinifi.geri = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            GrafikSinifi.saga = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            GrafikSinifi.sola = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_M) {
            GrafikSinifi.resett = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_M) {
            GrafikSinifi.oyunkontrol = false;
        }

    }

    /* @Override
    public void mouseClicked(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (mx >=125 && mx <=225) {
            if (my >= 250 && my <= 300) {
                System.exit(0);
            }
        }
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        
        if (mx >=125 && mx <=225) {
            if (my >= 150 && my <= 200) {
                grafikSinifi.oyunkontrol=true;
            }
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}
