import java.util.EnumSet;

public class PojazdOsobowy extends Pojazd{
    private int liczbaMiejsc;

    private PojazdOsobowy(String model, String marka,
                          int liczbaMiejsc, NapedType typNapedu) {
        super(model, marka, typNapedu);
        if(liczbaMiejsc <= 0) throw new IllegalArgumentException("Liczba miejsc nie może być równa 0 bądź mniejsza.");
        this.liczbaMiejsc = liczbaMiejsc;
    }

    public static PojazdOsobowy createSpalinowy(String model, String marka,
                                                int liczbaMiejsc, double pojemnoscSilnika) {
        if(pojemnoscSilnika <= 0) throw new IllegalArgumentException("Pojemność silnika nie może być równa 0 bądź mniejsza.");
        PojazdOsobowy p = new PojazdOsobowy(model, marka, liczbaMiejsc,
                NapedType.Spalinowy);
        p.setPojemnoscSilnika(pojemnoscSilnika);
        Repozytorium.getInstance().dodajPojazd(p);
        return p;
    }

    public static PojazdOsobowy createElektryczny(String model, String marka,
                                                  int liczbaMiejsc, double pojemnoscBaterii) {
        if(pojemnoscBaterii <= 0) throw new IllegalArgumentException("Pojemność baterii nie może być równa 0 bądź mniejsza.");
        PojazdOsobowy p = new PojazdOsobowy(model, marka, liczbaMiejsc,
                NapedType.Elektryczny);
        p.setPojemnoscBaterii(pojemnoscBaterii);
        Repozytorium.getInstance().dodajPojazd(p);
        return p;
    }
    public int getLiczbaMiejsc() { return liczbaMiejsc; }
    public void setLiczbaMiejsc(int liczbaMiejsc) {
        if(liczbaMiejsc <= 0) throw new IllegalArgumentException("Liczba miejsc nie może być równa 0 bądź mniejsza.");
        this.liczbaMiejsc = liczbaMiejsc;
    }
}
