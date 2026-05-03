import java.io.Serializable;
import java.util.EnumSet;

enum SamolotType {Regionalny, Sredniodystansowy, Dlugodystansowy, Samolot}
public class Samolot implements IRegionalny, ISredniodystansowy, IDlugodystansowy, Serializable {
    private String nazwa;
    private String producent;
    private int liczbaMiejsc;
    private double zasiegKilometrow;

    //regionalny
    private boolean czyWymagaPasaAsfaltowego;
    //sredniodystansowy
    private int liczbaKlasPokladowych;
    private double zuzyciePaliwaNa100Km;
    //dlugodystansowy
    private int liczbaPokladow;
    private int maksymalnaIloscGodzinLotu;
    //dyskryminator
    private EnumSet<SamolotType> rodzajSamolotu;

    private Samolot(String nazwa, String producent, int liczbaMiejsc, double zasiegKilometrow, EnumSet<SamolotType> rodzajSamolotu) {
        if(nazwa == null || nazwa.isBlank()) throw new IllegalArgumentException("Nazwa nie może być blank albo null.");
        if(producent == null || producent.isBlank()) throw new IllegalArgumentException("Producent nie może być blank albo null.");
        if(liczbaMiejsc<=0) throw new IllegalArgumentException("Liczba miejsc nie może być równa 0 bądź też mniejsza.");
        if(zasiegKilometrow<=0) throw new IllegalArgumentException("Zasięg kilometrów nie może być równy 0 bądź też mniejszy.");
        if(rodzajSamolotu==null) throw new IllegalArgumentException("Rodzaj samolotu nie może być pusty.");
        this.nazwa = nazwa;
        this.producent = producent;
        this.liczbaMiejsc = liczbaMiejsc;
        this.zasiegKilometrow = zasiegKilometrow;
        this.rodzajSamolotu = rodzajSamolotu;
    }

    public static Samolot createRegionalny(String nazwa, String producent,
                                           int liczbaMiejsc, double zasieg, boolean czyWymagaPasaAsflatowego) {
        Samolot s = new Samolot(nazwa, producent, liczbaMiejsc, zasieg,
                EnumSet.of(SamolotType.Samolot, SamolotType.Regionalny));
        s.czyWymagaPasaAsfaltowego = czyWymagaPasaAsflatowego;
        Repozytorium.getInstance().dodajSamolot(s);
        return s;
    }

    public static Samolot createSredniodystansowy(String nazwa, String producent,
                                                  int liczbaMiejsc, double zasieg, int liczbaKlasPokladowych, double zuzyciePaliwaNa100Km) {
        if(liczbaKlasPokladowych<=0) throw new IllegalArgumentException("Liczba klas pokladowych nie moze byc równa 0 albo mniejsza od niego.");
        if(zuzyciePaliwaNa100Km<=0) throw new IllegalArgumentException("Zużycie paliwa na 100km nie moze byc równe 0 albo mniejsze od niego.");
        Samolot s = new Samolot(nazwa, producent, liczbaMiejsc, zasieg,
                EnumSet.of(SamolotType.Samolot, SamolotType.Sredniodystansowy));
        s.liczbaKlasPokladowych = liczbaKlasPokladowych;
        s.zuzyciePaliwaNa100Km = zuzyciePaliwaNa100Km;
        Repozytorium.getInstance().dodajSamolot(s);
        return s;
    }

    public static Samolot createDlugodystansowy(String nazwa, String producent,
                                                  int liczbaMiejsc, double zasieg, int liczbaPokladow, int maksymalnaIloscGodzinLotu) {
        if(liczbaPokladow<=0) throw new IllegalArgumentException("Liczba pokladow nie moze byc rowna 0 albo mniejsza od niego.");
        if(maksymalnaIloscGodzinLotu<=0) throw new IllegalArgumentException("Maksymalna ilosc godzin lotu nie moze byc rowna 0 albo mniejsza od niego.");
        Samolot s = new Samolot(nazwa, producent, liczbaMiejsc, zasieg,
                EnumSet.of(SamolotType.Samolot, SamolotType.Dlugodystansowy));
        s.liczbaPokladow = liczbaPokladow;
        s.maksymalnaIloscGodzinLotu = maksymalnaIloscGodzinLotu;
        Repozytorium.getInstance().dodajSamolot(s);
        return s;
    }


    public static Samolot createRegionalnoSredniodystansowy(String nazwa, String producent,
                                                            int liczbaMiejsc, double zasieg,
                                                            boolean czyWymagaPasa,
                                                            int liczbaKlasPokladowych, double zuzyciePaliwaNa100Km) {

        if(liczbaKlasPokladowych <= 0) throw new IllegalArgumentException("Liczba klas pokladowych nie moze byc równa 0 albo mniejsza od niego.");
        if(zuzyciePaliwaNa100Km <= 0) throw new IllegalArgumentException("Zużycie paliwa na 100km nie moze byc równe 0 albo mniejsze od niego.");

        Samolot s = new Samolot(nazwa, producent, liczbaMiejsc, zasieg,
                EnumSet.of(SamolotType.Samolot,
                        SamolotType.Regionalny,
                        SamolotType.Sredniodystansowy));
        s.czyWymagaPasaAsfaltowego = czyWymagaPasa;
        s.liczbaKlasPokladowych = liczbaKlasPokladowych;
        s.zuzyciePaliwaNa100Km = zuzyciePaliwaNa100Km;
        Repozytorium.getInstance().dodajSamolot(s);
        return s;
    }


    public static Samolot createRegionalnoDlugodystansowy(String nazwa, String producent,
                                                          int liczbaMiejsc, double zasieg,
                                                          boolean czyWymagaPasa,
                                                          int liczbaPokladow, int maksymalnaIloscGodzinLotu) {

        if(liczbaPokladow <= 0) throw new IllegalArgumentException("Liczba pokladow nie moze byc rowna 0 albo mniejsza od niego.");
        if(maksymalnaIloscGodzinLotu <= 0) throw new IllegalArgumentException("Maksymalna ilosc godzin lotu nie moze byc rowna 0 albo mniejsza od niego.");

        Samolot s = new Samolot(nazwa, producent, liczbaMiejsc, zasieg,
                EnumSet.of(SamolotType.Samolot,
                        SamolotType.Regionalny,
                        SamolotType.Dlugodystansowy));
        s.czyWymagaPasaAsfaltowego = czyWymagaPasa;
        s.liczbaPokladow = liczbaPokladow;
        s.maksymalnaIloscGodzinLotu = maksymalnaIloscGodzinLotu;
        Repozytorium.getInstance().dodajSamolot(s);
        return s;
    }


    public static Samolot createRegionalnoSrednioDlugodystansowy(String nazwa, String producent,
                                                                 int liczbaMiejsc, double zasieg,
                                                                 boolean czyWymagaPasa,
                                                                 int liczbaKlasPokladowych, double zuzyciePaliwaNa100Km,
                                                                 int liczbaPokladow, int maksymalnaIloscGodzinLotu) {

        if(liczbaKlasPokladowych <= 0) throw new IllegalArgumentException("Liczba klas pokladowych nie moze byc równa 0 albo mniejsza od niego.");
        if(zuzyciePaliwaNa100Km <= 0) throw new IllegalArgumentException("Zużycie paliwa na 100km nie moze byc równe 0 albo mniejsze od niego.");
        if(liczbaPokladow <= 0) throw new IllegalArgumentException("Liczba pokladow nie moze byc rowna 0 albo mniejsza od niego.");
        if(maksymalnaIloscGodzinLotu <= 0) throw new IllegalArgumentException("Maksymalna ilosc godzin lotu nie moze byc rowna 0 albo mniejsza od niego.");

        Samolot s = new Samolot(nazwa, producent, liczbaMiejsc, zasieg,
                EnumSet.of(SamolotType.Samolot,
                        SamolotType.Regionalny,
                        SamolotType.Sredniodystansowy,
                        SamolotType.Dlugodystansowy));
        s.czyWymagaPasaAsfaltowego = czyWymagaPasa;
        s.liczbaKlasPokladowych = liczbaKlasPokladowych;
        s.zuzyciePaliwaNa100Km = zuzyciePaliwaNa100Km;
        s.liczbaPokladow = liczbaPokladow;
        s.maksymalnaIloscGodzinLotu = maksymalnaIloscGodzinLotu;
        Repozytorium.getInstance().dodajSamolot(s);
        return s;
    }

    public static Samolot createSrednioDlugodystansowy(String nazwa, String producent,
                                                       int liczbaMiejsc, double zasieg,
                                                       int liczbaKlasPokladowych, double zuzyciePaliwaNa100Km,
                                                       int liczbaPokladow, int maksymalnaIloscGodzinLotu) {

        if(liczbaKlasPokladowych <= 0) throw new IllegalArgumentException("Liczba klas pokladowych nie moze byc równa 0 albo mniejsza od niego.");
        if(zuzyciePaliwaNa100Km <= 0) throw new IllegalArgumentException("Zużycie paliwa na 100km nie moze byc równe 0 albo mniejsze od niego.");
        if(liczbaPokladow <= 0) throw new IllegalArgumentException("Liczba pokladow nie moze byc rowna 0 albo mniejsza od niego.");
        if(maksymalnaIloscGodzinLotu <= 0) throw new IllegalArgumentException("Maksymalna ilosc godzin lotu nie moze byc rowna 0 albo mniejsza od niego.");

        Samolot s = new Samolot(nazwa, producent, liczbaMiejsc, zasieg,
                EnumSet.of(SamolotType.Samolot,
                        SamolotType.Sredniodystansowy,
                        SamolotType.Dlugodystansowy));
        s.liczbaKlasPokladowych = liczbaKlasPokladowych;
        s.zuzyciePaliwaNa100Km = zuzyciePaliwaNa100Km;
        s.liczbaPokladow = liczbaPokladow;
        s.maksymalnaIloscGodzinLotu = maksymalnaIloscGodzinLotu;
        Repozytorium.getInstance().dodajSamolot(s);
        return s;
    }


    @Override
    public boolean isCzyWymagaPasaAsfaltowego() throws Exception {
        if (rodzajSamolotu.contains(SamolotType.Regionalny))
            return czyWymagaPasaAsfaltowego;
        else
            throw new Exception("Samolot nie jest regionalny!");
    }

    @Override
    public void setCzyWymagaPasaAsfaltowego(boolean value) throws Exception {
        if (rodzajSamolotu.contains(SamolotType.Regionalny))
            this.czyWymagaPasaAsfaltowego = value;
        else
            throw new Exception("Samolot nie jest regionalny!");
    }

    @Override
    public int getLiczbaKlasPokladowych() throws Exception {
        if (rodzajSamolotu.contains(SamolotType.Sredniodystansowy))
            return liczbaKlasPokladowych;
        else
            throw new Exception("Samolot nie jest średniodystansowy!");
    }

    @Override
    public void setLiczbaKlasPokladowych(int liczbaKlasPokladowych) throws Exception {
        if (rodzajSamolotu.contains(SamolotType.Sredniodystansowy))
            this.liczbaKlasPokladowych = liczbaKlasPokladowych;
        else
            throw new Exception("Samolot nie jest średniodystansowy!");
    }

    @Override
    public double getZuzyciePaliwaNa100Km() throws Exception {
        if (rodzajSamolotu.contains(SamolotType.Sredniodystansowy))
            return zuzyciePaliwaNa100Km;
        else
            throw new Exception("Samolot nie jest średniodystansowy!");
    }

    @Override
    public void setZuzyciePaliwaNa100Km(double zuzyciePaliwaNa100Km) throws Exception {
        if (rodzajSamolotu.contains(SamolotType.Sredniodystansowy))
            this.zuzyciePaliwaNa100Km = zuzyciePaliwaNa100Km;
        else
            throw new Exception("Samolot nie jest średniodystansowy!");
    }

    @Override
    public int getLiczbaPokladow() throws Exception {
        if (rodzajSamolotu.contains(SamolotType.Dlugodystansowy))
            return liczbaPokladow;
        else
            throw new Exception("Samolot nie jest długodystansowy!");
    }

    @Override
    public void setLiczbaPokladow(int liczbaPokladow) throws Exception {
        if (rodzajSamolotu.contains(SamolotType.Dlugodystansowy))
            this.liczbaPokladow = liczbaPokladow;
        else
            throw new Exception("Samolot nie jest długodystansowy!");
    }

    @Override
    public int getMaksymalnaIloscGodzinLotu() throws Exception {
        if (rodzajSamolotu.contains(SamolotType.Dlugodystansowy))
            return maksymalnaIloscGodzinLotu;
        else
            throw new Exception("Samolot nie jest długodystansowy!");
    }

    @Override
    public void setMaksymalnaIloscGodzinLotu(int maksymalnaIloscGodzinLotu) throws Exception {
        if (rodzajSamolotu.contains(SamolotType.Dlugodystansowy))
            this.maksymalnaIloscGodzinLotu = maksymalnaIloscGodzinLotu;
        else
            throw new Exception("Samolot nie jest długodystansowy!");
    }
    @Override
    public void wystartuj() throws Exception {
        if (rodzajSamolotu.contains(SamolotType.Regionalny)) {
            if (czyWymagaPasaAsfaltowego) {
                System.out.println("Samolot regionalny startuje z pasa asfaltowego.");
            } else {
                System.out.println("Samolot regionalny startuje z pasa trawiastego.");
            }
        }
        if (rodzajSamolotu.contains(SamolotType.Sredniodystansowy)) {
            System.out.println("Samolot sredniodystansowy startuje. Liczba klas pokladowych: "
                    + liczbaKlasPokladowych + ". Zuzycie paliwa na 100km: " + zuzyciePaliwaNa100Km + "L.");
        }
        if (rodzajSamolotu.contains(SamolotType.Dlugodystansowy)) {
            System.out.println("Samolot dlugodystansowy startuje. Liczba pokladow: "
                    + liczbaPokladow + ". Maksymalna ilosc godzin lotu: " + maksymalnaIloscGodzinLotu + "h.");
        }
    }

    public void usun() {
        Repozytorium.getInstance().usunSamolot(this);
    }
}
