package meteorvurma;

public class oyunIciDegerler {

    private int skor;
    private int saglik;
    private int para;

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }

    public oyunIciDegerler(int skor, int para) {
        this.skor = skor;
        this.para = para;
    }
    
    public int getSaglik() {
        return saglik;
    }

    public void setSaglik(int saglik) {
        this.saglik = saglik;
    }
    
    public int getPara() {
        return para;
    }

    
    public void setPara(int para) {
        this.para = para;
    }

    public void degerGonderme(String message) {

        degerGosterim.degerGoster(this, skor);
        degerGosterim.degerGoster(this, saglik);
        degerGosterim.degerGoster(this, para);

    }

   
   

    

}
