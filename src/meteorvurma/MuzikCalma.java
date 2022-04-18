package meteorvurma;

public class MuzikCalma {

    private Muzik LazerSesi;
    private Muzik OyunIciSes;
    private Muzik OyunIciSesiDur;
    
    private final static MuzikCalma mCalma = new MuzikCalma();
    
    MuzikCalma() {// SİNGLETON İÇİN PRİVATE KURUCU METHODUM BURADA 
        LazerSesi = new Sesler();
        OyunIciSes = new Sesler();
        OyunIciSesiDur = new Sesler();
    }
    
    public static MuzikCalma getInstance() {// BURADA GETINSTANCE METHODUNU OLUŞTURDUM HOCAM
        return mCalma;
    }

    

    public void LazerSesiCal() {

        LazerSesi.LazerSesi();
    }
    
    public void OyunIciSesCal(){
        
        
        OyunIciSes.OyunIciSes();
        
    }
    
    public void OyunIciSesiDurdurma(){
        
        OyunIciSesiDur.OyunIciSesDurdur();
        
    }

}
