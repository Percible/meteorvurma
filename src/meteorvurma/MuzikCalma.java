package meteorvurma;

public class MuzikCalma {

    private final Muzik LazerSesi;
    private final Muzik OyunIciSes;

    public MuzikCalma() {

        LazerSesi = new Sesler();
        OyunIciSes = new Sesler();
    }

    public void LazerSesiCal() {

        LazerSesi.LazerSesi();
    }
    
    public void OyunIciSesCal(){
        
        OyunIciSes.OyunIciSes();
        
    }

}
