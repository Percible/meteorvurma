package meteorvurma;

import jaco.mp3.player.MP3Player;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.chrono.ThaiBuddhistEra;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicOptionPaneUI;

public class GrafikSinifi extends JPanel implements ActionListener, Muzik {

    private static final long serialVersionUID = 1L;

    public Rectangle oyna = new Rectangle(125, 150, 100, 50);
    public Rectangle cikis = new Rectangle(125, 250, 100, 50);
    public Rectangle hakkimda = new Rectangle(325, 150, 180, 50);
    public Rectangle kural = new Rectangle(100, 380, 180, 50);
    public Rectangle cikis1 = new Rectangle(460, 380, 100, 50);
    public Rectangle cikis2 = new Rectangle(460, 380, 100, 50);

    static BufferedImage arka1;
    static BufferedImage arka2;
    static BufferedImage arac;
    static BufferedImage meteor;
    static BufferedImage patlamaDizi[] = new BufferedImage[26];
    static BufferedImage lazer;
    static BufferedImage ates1;
    static BufferedImage ates2;

    static ArrayList<Lazer> lazerler = new ArrayList<Lazer>();

    static int arkaplanY1 = 0;
    static int arkaplanY2 = -500;
    static int arkaplanHiz = 15;
    static int aracX = 250;
    static int aracY = 350;
    static int meteorX[] = new int[6];
    static int meteorY[] = new int[6];
    static int meteorHiz[] = new int[6];
    static int patlamaSuresi = 0;
    static int harcananLazer = 0;
    static int lazerAzalanY = 8;
    static int geciciX = 0;
    static int geciciY = 0;
    static int carpmaDegeri = 0;
    static int saglik = 100;

    public static boolean ileri = false, geri = false, saga = false, sola = false;
    public static boolean resett = false;
    public static boolean oyunkontrol;
    public static boolean cik = false;
    public static boolean hakkimdaButon = false;
    public static boolean kurallar = false;
    public static boolean patlamaKontrol = false;
    public static boolean lazerKontrol = false;
    public static boolean lazerAtimi = false;
    static boolean astreoidCarpmaKucuk = false;
    static boolean saglikKontrol = false;

    private static final String s = "Music\\laser.mp3";
    private static final String l = "Music\\oyun.mp3";
    MP3Player mp3player = new MP3Player(new File(s));
    MP3Player mp3 = new MP3Player(new File(l));

    JButton b1 = new JButton();
    JButton b2 = new JButton();
    JButton b3 = new JButton();
    JButton b4 = new JButton();
    JButton b5 = new JButton();
    JButton b6 = new JButton();
    

    public GrafikSinifi() {
        

        try {//Burada butonlari tanittim hocam.
            b1.setBounds(125, 150, 100, 50);
            b1.setText("OYNA");
            b2.setBounds(125, 250, 100, 50);
            b2.setText("ÇIKIŞ");
            b3.setBounds(325, 150, 180, 50);
            b3.setText("HAKKIMDA");
            b4.setBounds(460, 380, 100, 50);
            b4.setText("Geri");
            b5.setBounds(460, 380, 100, 50);
            b5.setText("Geri");
            b6.setBounds(100, 380, 180, 50);
            b1.addActionListener(this);
            b2.addActionListener(this);
            b3.addActionListener(this);
            b4.addActionListener(this);
            b5.addActionListener(this);
            b6.addActionListener(this);

            //BURADA RESİMLERİ DOSYADAN CEKTIM
            arka1 = ImageIO.read(new File("resim\\indir.png"));
            arka2 = ImageIO.read(new File("resim\\indir.png"));
            arac = ImageIO.read(new File("resim\\arac.png"));
            meteor = ImageIO.read(new File("resim\\meteor.png"));
            lazer = ImageIO.read(new File("resim\\Lazer.png"));

            //BURADA PATLAMA EFEKTİ VAR
            for (int i = 0; i < 26; i++) {
                patlamaDizi[i] = ImageIO.read(new File("resim\\pat" + (i + 1) + ".png"));
            }

        } catch (IOException e) {

        }

    }

    //BURADA KI FONSKIYONDA OYUNU SIFIRLAMA YAPTIM "M" TUSUNA BASARSAK OYUN SIFIRLANIYOR.
    public void reset() {
        if (resett == true) {
            //g.setColor(new Color(230,0,10));
            //g.fillRect(0, 0,frameSinifi.setGenislik , frameSinifi.setYukseklik);
            int sayac = 0;
            arkaplanY1 = 0;
            arkaplanY2 = -500;
            aracX = 250;
            aracY = 350;

            for (int i = 0; i < 6; i++) {
                GrafikSinifi.meteorX[i] = 10 + sayac;
                GrafikSinifi.meteorY[i] = -100 + sayac;
                sayac = sayac + 100;

            }
        }
    }

    @Override
    public void LazerSesi() {//BURASI MUZIK ICIN YAPTIM DAHA SONRA PROJEYE EKLEYECEGIM DENEME OLARAK YAPTIM.

        mp3player.play();
        

    }
    
    @Override
    public void OyunIciSes() {
        mp3.play();
           }

    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y, int w, int h) {
        return super.imageUpdate(img, infoflags, x, y, w, h);
    }

    // BURADA EKRANA CIZDIRDIGIM RESIMLER VAR
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        
        if (oyunkontrol == false) {//EGER OYUN KONTROL SIFIR ISE BASLAMA EKRANINA GELIYOR ZATEN OYUN BU EKRAN ILE BASLIYOR.

            this.add(b1);
            this.add(b2);
            this.add(b3);

            Font font = new Font("Arial", Font.BOLD, 50);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, FrameSinifi.setGenislik, FrameSinifi.setYukseklik);
            //setBackground(Color.BLACK);
            g.setFont(font);

            g.setColor(Color.white);
            g.drawString("UZAY OYUNU", 125, 100);

            Font oyn = new Font("arial", Font.BOLD, 30);
            g.setFont(oyn);
            g.drawString("OYNA", oyna.x + 5, oyna.y + 35);
            Font cks = new Font("arial", Font.BOLD, 30);
            g.setFont(cks);
            g.drawString("CIKIŞ", cikis.x + 5, cikis.y + 35);
            Font hkkm = new Font("arial", Font.BOLD, 30);
            g.setFont(hkkm);
            g.drawString("HAKKIMDA", hakkimda.x + 5, hakkimda.y + 35);

            g2d.draw(oyna);
            g2d.draw(cikis);
            g2d.draw(hakkimda);
            remove(b6);

            repaint();

            //EGER HAKKIMDA BUTONUNA BASARSANIZ ISMIM VE NUMARAM GOZUKUR.
            if (hakkimdaButon == true) {
                this.add(b4);
                this.add(b6);
                Font hak1 = new Font("arial", Font.BOLD, 50);
                Font hak2 = new Font("arial", Font.BOLD, 30);
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, FrameSinifi.setGenislik, FrameSinifi.setYukseklik);

                g.setFont(hak1);
                g.setColor(Color.white);
                g.drawString("HAKKIMDA", 150, 100);
                g.setFont(hak2);
                g.setColor(Color.white);
                g.drawString("Levent BUĞDAYCI", 50, 200);
                g.drawString("02175076054", 50, 250);
                g.drawString("GERİ", cikis1.x + 10, cikis1.y + 35);
                g.drawString("KURALLAR", kural.x + 5, kural.y + 35);
                g2d.draw(cikis1);
                g2d.draw(kural);
                remove(b1);
                remove(b2);
                remove(b3);
                remove(b5);

                // HAKKIMDA KISMININ ICINDE KURALLARI KOYDUM CUNKU ILK EKRANA KOYDUGUMDA BUTONLAR CALISMIYORDU DUZELTEMEDIM BURAYA ALDIM.
                if (kurallar == true) {
                    this.add(b5);
                    Font kur1 = new Font("arial", Font.BOLD, 50);
                    Font kur2 = new Font("arial", Font.BOLD, 30);
                    g.setColor(Color.black);
                    g.fillRect(0, 0, FrameSinifi.setGenislik, FrameSinifi.setYukseklik);

                    g.setFont(kur1);
                    g.setColor(Color.WHITE);
                    g.drawString("TUŞLAR", 180, 100);
                    g.setFont(kur2);

                    g.setColor(Color.WHITE);
                    g.drawString("GERİ", cikis2.x + 10, cikis2.y + 35);
                    g2d.draw(cikis2);
                    remove(b1);
                    remove(b2);
                    remove(b3);
                    remove(b4);

                }
            }

        } 
        // BURADA OYNA BUTONUNA BASILDIGINDA OYUN ICERIGI GOSTERILIYOR
        else {

            g.drawImage(arka1, 0, arkaplanY1, 600, 500, null);
            g.drawImage(arka2, 0, arkaplanY2, 600, 500, null);
            g.drawImage(arac, aracX, aracY, 60, 50, null);

            //METEOR RESIMLERINI DIZIYE EKLEDIM EKRANA BASMAK ICIN
            for (int i = 0; i < 6; i++) {
                g.drawImage(meteor, meteorX[i], meteorY[i], 40, 30, null);

            }

            // BURADA PATLAMA GERCEKLESMESINI SAGLAYACAK RESIMLERI DIZIYE ATTIM.
            if (patlamaKontrol == true) {
                for (int i = 0; i < 26; i++) {

                    if (patlamaSuresi == i) {
                        g.drawImage(patlamaDizi[i], aracX - 20, aracY - 30, 120, 100, null);
                    }

                }
            }

            // BURADA ARRAY LIST KULLANMAK ZORUNDA KALDIM HOCAM COK ARASTIRDIM AMA DIZI ILE YAPAMADIM ARRAYLISTIN OZEELLIKLERI ISIME YARADI
            // AMA ARRAYLIST DE TAM ISIME YARAMADI LAZER ATMAK ICIN SPACE TUSUNA COK BASILDIGINDA "LISTEDE KUYRUK BOS" HATASI VERIYORDU 
            //BU YUZDEN OYUNA LAZER ATMA SINIRI GETIRDIM HER 2 SANIYEDE BIR LAZER ATILIYOR. SIMDILIK HATA VERMEDI
            
                for (Lazer lazer : GrafikSinifi.lazerler) {
                    try {
                        g.drawImage(GrafikSinifi.lazer, lazer.getAtesX(), lazer.getAtesY(), 20, 40, null);
                    } 
                    catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            

            //if(saglik <10){
            //  g.setColor(Color.BLACK);
            //g.fillRect(0, 0, FrameSinifi.setGenislik, FrameSinifi.setYukseklik);
            //}
            //BURADA SAGLIK KISMINI YAZDIM HOCAM BUNU DAHA YENI YAPTIM GAME OVER KISMINI YAPAMADIM.
            g.setColor(Color.BLUE);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Saglik : " + GrafikSinifi.saglik, 5, 30);

            remove(b1);
            remove(b2);
            remove(b3);
            remove(b4);
            remove(b5);
            remove(b6);

            reset();

            repaint();
        }

    }
    

    //BURADA BUTONLARA BASILDIGINDA GERCEKLESMESI GEREKEN OZELLIKLERI EKLEDIM.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            oyunkontrol = true;
            System.out.println("Buton testi");

        }
        if (e.getSource() == b2) {
            System.exit(0);
        }
        if (e.getSource() == b3) {
            hakkimdaButon = true;
        }
        if (e.getSource() == b4) {
            hakkimdaButon = false;
            remove(b4);
        }
        if (e.getSource() == b6) {
            kurallar = true;

        }
        if (e.getSource() == b5) {
            kurallar = false;

        }

    }

    

}
