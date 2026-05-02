public class Plywak extends Zawodnik {
    private StylPlywacki koronnyStyl;

    public Plywak(String imie, String nazwisko, int wiek, StylPlywacki koronnyStyl){
        super(imie, nazwisko, wiek);
        this.koronnyStyl = koronnyStyl;
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
        this.koronnyStyl = koronnyStyl;
    }
}
