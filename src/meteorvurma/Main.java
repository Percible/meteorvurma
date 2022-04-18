package meteorvurma;

public class Main {

    public static void main(String[] args) {

        //  BURADA SİNGLETON İÇİN ÇAGIRDIGIM METHODLAR VAR HOCAM
        //  KURUCU METHODUN PRİVATE OLMASI LAZIM HOCAM. BU SAYEDE NEW ILE YENİ NESNE OLUSMASINI ENGELLIYORUZ.

        FrameSinifi.getInstance().oynatma();
        ArkaplanHareket.getInstance().oynatma();
        AracHiz.getInstance().oynatma();
        MeteorSpawn.getInstance().oynatma();
        MeteorCarpma.getInstance().oynatma();
        PatlamaOynatma.getInstance().oynatma();
        LazerHareket.getInstance().oynatma();
        LazerMeteorCarpisma.getInstance().oynatma();
        LazerAtimi.getInstance().oynatma();
        MuzikCalma.getInstance().LazerSesiCal();
        
        

    }
}
