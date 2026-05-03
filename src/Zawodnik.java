import java.io.Serializable;

public abstract class Zawodnik implements Serializable {
    private String imie;
    private String nazwisko;
    private int wiek;
    public abstract String trenuj();
    public Zawodnik(String imie, String nazwisko, int wiek) {
        if(imie==null || imie.isBlank()) throw new IllegalArgumentException("Imie nie może być blank albo null.");
        if(nazwisko==null || nazwisko.isBlank()) throw new IllegalArgumentException("Nazwisko nie może być blank albo null.");
        if(wiek<0) throw new IllegalArgumentException("Wiek nie może być mniejszy od zera.");
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    public void setImie(String imie) {
        if(imie==null || imie.isBlank()) throw new IllegalArgumentException("Zły argument w metodzie setImie. Imie nie może być blank albo null.");
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        if(nazwisko==null || nazwisko.isBlank()) throw new IllegalArgumentException("Zły argument w metodzie setNazwisko. Nazwisko nie może być blank albo null.");
        this.nazwisko = nazwisko;
    }

    public void setWiek(int wiek) {
        if(wiek<0) throw new IllegalArgumentException("Zły argument w metodzie setWiek. Wiek nie może być mniejszy od zera.");
        this.wiek = wiek;
    }

    public void usun() {
        Repozytorium.getInstance().usunZawodnika(this);
    }
}
