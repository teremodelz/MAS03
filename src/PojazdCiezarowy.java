import java.util.EnumSet;

public class PojazdCiezarowy extends Pojazd{
    private double dopuszczalnaMasaCalkowita;
    private PojazdCiezarowy(String model, String marka,
                            double dopuszczalnaMasaCalkowita, NapedType typNapedu) {
        super(model, marka, typNapedu);
        if(dopuszczalnaMasaCalkowita <= 0) throw new IllegalArgumentException("Dopuszczalna masa całkowita nie może być równa 0 bądź mniejsza.");
        this.dopuszczalnaMasaCalkowita = dopuszczalnaMasaCalkowita;
    }

    public static PojazdCiezarowy createSpalinowy(String model, String marka,
                                                  double dopuszczalnaMasaCalkowita, double pojemnoscSilnika) {
        if(pojemnoscSilnika <= 0) throw new IllegalArgumentException("Pojemność silnika nie może być równa 0 bądź mniejsza.");
        PojazdCiezarowy p = new PojazdCiezarowy(model, marka, dopuszczalnaMasaCalkowita,
                NapedType.Spalinowy);
        p.setPojemnoscSilnika(pojemnoscSilnika);
        Repozytorium.getInstance().dodajPojazd(p);
        return p;
    }

    public static PojazdCiezarowy createElektryczny(String model, String marka,
                                                    double dopuszczalnaMasaCalkowita, double pojemnoscBaterii) {
        if(pojemnoscBaterii <= 0) throw new IllegalArgumentException("Pojemność baterii nie może być równa 0 bądź mniejsza.");
        PojazdCiezarowy p = new PojazdCiezarowy(model, marka, dopuszczalnaMasaCalkowita,
                NapedType.Elektryczny);
        p.setPojemnoscBaterii(pojemnoscBaterii);
        Repozytorium.getInstance().dodajPojazd(p);
        return p;
    }
    public double getDopuszczalnaMasaCalkowita() { return dopuszczalnaMasaCalkowita; }
    public void setDopuszczalnaMasaCalkowita(double dopuszczalnaMasaCalkowita) {
        if(dopuszczalnaMasaCalkowita <= 0) throw new IllegalArgumentException("Dopuszczalna masa całkowita nie może być równa 0 bądź mniejsza.");
        this.dopuszczalnaMasaCalkowita = dopuszczalnaMasaCalkowita;
    }
}
