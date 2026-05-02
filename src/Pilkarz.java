public class Pilkarz extends Zawodnik {
    private int numerKoszulki;
    private String klub;

    public Pilkarz(String imie, String nazwisko, int wiek, int numerKoszulki, String klub){
        super(imie, nazwisko, wiek);
        if(numerKoszulki<0) throw new IllegalArgumentException("Numer koszulki nie może być mniejszy od zera.");
        if(klub == null || klub.isBlank()) throw new IllegalArgumentException("Klub nie może być blank albo null.");
        this.numerKoszulki = numerKoszulki;
        this.klub = klub;
    }

    @Override
    public String trenuj() {
        return "Piłkarz "+super.getImie()+" "+super.getNazwisko()+" o numerze koszulki "+numerKoszulki
                +" z klubu " + klub +" rozpoczął trening.";
    }

    public int getNumerKoszulki() {
        return numerKoszulki;
    }

    public String getKlub() {
        return klub;
    }

    public void setNumerKoszulki(int numerKoszulki) {
        if(numerKoszulki<0) throw new IllegalArgumentException("Zły argument w metodzie setNumerKoszulki. Numer koszulki nie może być mniejszy od zera.");
        this.numerKoszulki = numerKoszulki;
    }

    public void setKlub(String klub) {
        if(klub==null || klub.isBlank()) throw new IllegalArgumentException("Zły argument w metodzie setKlub. Klub nie może być blank albo null.");
        this.klub = klub;
    }

}
