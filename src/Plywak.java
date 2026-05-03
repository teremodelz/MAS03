import java.io.Serializable;

public class Plywak extends Zawodnik {
    private StylPlywacki koronnyStyl;

    public Plywak(String imie, String nazwisko, int wiek, StylPlywacki koronnyStyl){
        super(imie, nazwisko, wiek);
        this.koronnyStyl = koronnyStyl;
        Repozytorium.getInstance().dodajZawodnika(this);
    }
    @Override
    public String trenuj() {
        return "Pływak "+super.getImie()+" "+super.getNazwisko()+" rozpoczął trening.";
    }

    public StylPlywacki getKoronnyStyl() {
        return koronnyStyl;
    }


    //walidacja enum poźniej
    public void setKoronnyStyl(StylPlywacki koronnyStyl) {
        if(koronnyStyl == null) throw new IllegalArgumentException("Koronny styl nie moze byc pusty.");
        this.koronnyStyl = koronnyStyl;
    }
}
