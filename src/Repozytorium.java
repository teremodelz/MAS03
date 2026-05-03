import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Repozytorium implements Serializable {
    private static final String PLIK = "obiekty.ser";
    private static Repozytorium instancja;

    private List<Zawodnik> zawodnicy = new ArrayList<>();
    private List<Samolot> samoloty = new ArrayList<>();
    private List<Pojazd> pojazdy = new ArrayList<>();
    private List<Urzadzenie> urzadzenia = new ArrayList<>();
    private List<SprawaSadowa> sprawy = new ArrayList<>();

    private Repozytorium() {}

    public static Repozytorium getInstance() {
        if (instancja == null) {
            instancja = new Repozytorium();
        }
        return instancja;
    }

    public void dodajZawodnika(Zawodnik z) { zawodnicy.add(z); }
    public void dodajSamolot(Samolot s) { samoloty.add(s); }
    public void dodajPojazd(Pojazd p) { pojazdy.add(p); }
    public void dodajUrzadzenie(Urzadzenie u) { urzadzenia.add(u); }
    public void dodajSprawa(SprawaSadowa s) { sprawy.add(s); }

    public void usunZawodnika(Zawodnik z) { zawodnicy.remove(z); }
    public void usunSamolot(Samolot s) { samoloty.remove(s); }
    public void usunPojazd(Pojazd p) { pojazdy.remove(p); }
    public void usunUrzadzenie(Urzadzenie u) { urzadzenia.remove(u); }
    public void usunSprawa(SprawaSadowa s) { sprawy.remove(s); }

    public List<Zawodnik> getZawodnicy() { return zawodnicy; }
    public List<Samolot> getSamoloty() { return samoloty; }
    public List<Pojazd> getPojazdy() { return pojazdy; }
    public List<Urzadzenie> getUrzadzenia() { return urzadzenia; }
    public List<SprawaSadowa> getSprawy() { return sprawy; }


    public void zapisz() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PLIK))) {
            oos.writeObject(this);
            System.out.println("Zapisano do pliku: " + PLIK);
        }
    }

    public static void wczytaj() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PLIK))) {
            instancja = (Repozytorium) ois.readObject();
            System.out.println("Wczytano z pliku: " + PLIK);
        }
    }

    protected Object readResolve() {
        instancja = this;
        return instancja;
    }
}