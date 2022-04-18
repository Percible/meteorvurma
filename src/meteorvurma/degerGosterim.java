package meteorvurma;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class degerGosterim extends JFrame implements ActionListener {

    oyunIciDegerler skor = new oyunIciDegerler(GrafikSinifi.Skor, GrafikSinifi.para);
    static String skorGosterim;

    static JLabel l1;
    static JLabel l2;
    static JButton buton = new JButton();
    static JButton buton1 = new JButton();
    static JButton buton2 = new JButton();
    Toolkit t = Toolkit.getDefaultToolkit();
    Image i = t.getImage("resim\\kurukafa.png");

    public degerGosterim(int puan, int oyunparasi) {
        puan = skor.getSkor();
        oyunparasi = skor.getPara();

        l1 = new JLabel();
        l2 = new JLabel();
        l1.setText("<html><body>Skorunuz :" + puan + "<br>Paranız : " + oyunparasi + "$$" + "</body></html><br><br>");
        l2.setText("<html><body>1 Can Ekle  : <br>10 Can Ekle : </body></html>");

        l1.setBounds(60, 10, 500, 100);
        l1.setFont(new Font("arial", Font.BOLD, 30));
        l1.setForeground(Color.white);
        l1.setOpaque(true);
        l1.setBackground(Color.black);
        l2.setBounds(30, 30, 500, 500);
        l2.setFont(new Font("arial", Font.BOLD, 30));
        l2.setForeground(Color.white);
        l2.setOpaque(true);
        l2.setBackground(Color.black);
        buton.setBounds(140, 400, 80, 30);
        buton.setText("Tamam");
        buton.addActionListener(this);
        buton1.setBounds(250, 250, 80, 30);
        buton1.setText("Ekle");
        buton1.addActionListener(this);
        buton2.setBounds(250, 280, 80, 30);
        buton2.setText("Ekle");
        buton2.addActionListener(this);

        add(l1);
        add(l2);
        add(buton1);
        add(buton);
        add(buton2);
        setTitle("SKOR");
        setBackground(Color.black);
        getContentPane().setBackground(Color.BLACK);
        setIconImage(i);
        setLayout(null);
        setSize(400, 800);
        setVisible(false);
        setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

    }

    public static int degerGoster(oyunIciDegerler degerler, int message) {

        degerGosterim sg = new degerGosterim(degerler.getSkor(), degerler.getPara());

        sg.setVisible(true);
        return message;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buton) {
            dispose();
        }
        if (e.getSource() == buton1) {
            //skor.setSaglik(GrafikSinifi.Saglik+1);
            //skor.setPara(GrafikSinifi.para-1);

            if (GrafikSinifi.para > 0) {
                GrafikSinifi.Saglik = GrafikSinifi.Saglik + 1;
                GrafikSinifi.para = GrafikSinifi.para - 1;
            }

        }
        if (e.getSource() == buton2) {

            if (GrafikSinifi.para > 9) {

                GrafikSinifi.Saglik = GrafikSinifi.Saglik + 10;
                GrafikSinifi.para = GrafikSinifi.para - 10;
            }

            //skor.setSaglik(GrafikSinifi.Saglik+10);
            //skor.setPara(GrafikSinifi.para-10);
        }

    }
}
