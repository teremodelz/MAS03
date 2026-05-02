import java.util.EnumSet;

enum SprawaType {Sadowa, Aktywna, Zawieszona, Zakonczona}
public class SprawaSadowa implements IAktywna, IZawieszona, IZakonczona {
    private String sygnatura;
    private String opisZarzutow;
    //aktywna
    private String sedziaProwadzacy;
    //zawieszona
    private String powodZawieszenia;
    //zakończona
    private String wynikSprawy;
    private EnumSet<SprawaType> rodzajSprawy;

    private SprawaSadowa(String sygnatura, String opisZarzutow, EnumSet<SprawaType> rodzajSprawy) {
        if(sygnatura == null || sygnatura.isBlank()) throw new IllegalArgumentException("Sygnatura nie może być blank albo null.");
        if(opisZarzutow == null || opisZarzutow.isBlank()) throw new IllegalArgumentException("Nazwa nie może być blank albo null.");
        if(rodzajSprawy==null) throw new IllegalArgumentException("Rodzaj samolotu nie może być pusty.");
        this.sygnatura = sygnatura;
        this.opisZarzutow = opisZarzutow;
        this.rodzajSprawy = rodzajSprawy;
    }
    public static SprawaSadowa createAktywna(String sygnatura, String opisZarzutow, String sedziaProwadzacy) {
        if(sedziaProwadzacy == null || sedziaProwadzacy.isBlank()) throw new IllegalArgumentException("Sędzia prowadzący nie może być blank albo null.");
        SprawaSadowa s = new SprawaSadowa(sygnatura, opisZarzutow,
                EnumSet.of(SprawaType.Sadowa, SprawaType.Aktywna));
        s.sedziaProwadzacy = sedziaProwadzacy;
        return s;
    }

    public static SprawaSadowa createZawieszona(String sygnatura, String opisZarzutow, String powodZawieszenia) {
        if(powodZawieszenia == null || powodZawieszenia.isBlank()) throw new IllegalArgumentException("Powód zawieszenia nie może być blank albo null.");
        SprawaSadowa s = new SprawaSadowa(sygnatura, opisZarzutow,
                EnumSet.of(SprawaType.Sadowa, SprawaType.Zawieszona));
        s.powodZawieszenia = powodZawieszenia;
        return s;
    }

    public static SprawaSadowa createZakonczona(String sygnatura, String opisZarzutow, String wynikSprawy) {
        if(wynikSprawy == null || wynikSprawy.isBlank()) throw new IllegalArgumentException("Wynik sprawy nie może być blank albo null.");
        SprawaSadowa s = new SprawaSadowa(sygnatura, opisZarzutow,
                EnumSet.of(SprawaType.Sadowa, SprawaType.Zakonczona));
        s.wynikSprawy = wynikSprawy;
        return s;
    }

    @Override
    public String getSedziaProwadzacy() throws Exception {
        if(rodzajSprawy.contains(SprawaType.Aktywna))
            return sedziaProwadzacy;
        throw new Exception("Sprawa nie jest aktywna!");
    }

    @Override
    public void setSedziaProwadzacy(String sedziaProwadzacy) throws Exception {
        if(rodzajSprawy.contains(SprawaType.Aktywna))
            this.sedziaProwadzacy = sedziaProwadzacy;
        else
            throw new Exception("Sprawa nie jest aktywna!");
    }

    @Override
    public String getPowodZawieszenia() throws Exception {
        if(rodzajSprawy.contains(SprawaType.Zawieszona))
            return powodZawieszenia;
        throw new Exception("Sprawa nie jest zawieszona!");
    }

    @Override
    public void setPowodZawieszenia(String powodZawieszenia) throws Exception {
        if(rodzajSprawy.contains(SprawaType.Zawieszona))
            this.powodZawieszenia = powodZawieszenia;
        else
            throw new Exception("Sprawa nie jest zawieszona!");
    }

    @Override
    public String getWynikSprawy() throws Exception {
        if(rodzajSprawy.contains(SprawaType.Zakonczona))
            return wynikSprawy;
        throw new Exception("Sprawa nie jest zakończona!");
    }

    @Override
    public void setWynikSprawy(String wynikSprawy) throws Exception {
        if(rodzajSprawy.contains(SprawaType.Zakonczona))
            this.wynikSprawy = wynikSprawy;
        else
            throw new Exception("Sprawa nie jest zakończona!");
    }

    @Override
    public String pobierzStatus() {
        if(rodzajSprawy.contains(SprawaType.Aktywna))
            return "Sprawa aktywna. Sędzia prowadzący: " + sedziaProwadzacy;
        if(rodzajSprawy.contains(SprawaType.Zawieszona))
            return "Sprawa zawieszona. Powód: " + powodZawieszenia;
        if(rodzajSprawy.contains(SprawaType.Zakonczona))
            return "Sprawa zakończona. Wynik: " + wynikSprawy;
        return "Status nieznany.";
    }

    public void zmienNaAktywna(String sedziaProwadzacy) {
        if(rodzajSprawy.contains(SprawaType.Aktywna)) {
            System.out.println("Sprawa jest już aktywna!");
            return;
        }
        if(sedziaProwadzacy == null || sedziaProwadzacy.isBlank())
            throw new IllegalArgumentException("Sędzia prowadzący nie może być blank albo null.");

        this.sedziaProwadzacy = sedziaProwadzacy;
        rodzajSprawy.add(SprawaType.Aktywna);

        this.powodZawieszenia = null;
        rodzajSprawy.remove(SprawaType.Zawieszona);

        this.wynikSprawy = null;
        rodzajSprawy.remove(SprawaType.Zakonczona);
    }

    public void zmienNaZawieszona(String powodZawieszenia) {
        if(rodzajSprawy.contains(SprawaType.Zawieszona)) {
            System.out.println("Sprawa jest już zawieszona!");
            return;
        }
        if(powodZawieszenia == null || powodZawieszenia.isBlank())
            throw new IllegalArgumentException("Powód zawieszenia nie może być blank albo null.");

        this.powodZawieszenia = powodZawieszenia;
        rodzajSprawy.add(SprawaType.Zawieszona);

        this.sedziaProwadzacy = null;
        rodzajSprawy.remove(SprawaType.Aktywna);

        this.wynikSprawy = null;
        rodzajSprawy.remove(SprawaType.Zakonczona);
    }

    public void zmienNaZakonczona(String wynikSprawy) {
        if(rodzajSprawy.contains(SprawaType.Zakonczona)) {
            System.out.println("Sprawa jest już zakończona!");
            return;
        }
        if(wynikSprawy == null || wynikSprawy.isBlank())
            throw new IllegalArgumentException("Wynik sprawy nie może być blank albo null.");

        this.wynikSprawy = wynikSprawy;
        rodzajSprawy.add(SprawaType.Zakonczona);

        this.sedziaProwadzacy = null;
        rodzajSprawy.remove(SprawaType.Aktywna);

        this.powodZawieszenia = null;
        rodzajSprawy.remove(SprawaType.Zawieszona);
    }

}
