import java.io.Serializable;

public class Kopiarka extends Skaner implements IDrukarka {
    private double poziomTuszu;
    private boolean czyKolor;

    public Kopiarka(String nazwa, String producent,
                    double maksymalnaRozdzielczosc,
                    double poziomTuszu, boolean czyKolor) {
        super(nazwa, producent, maksymalnaRozdzielczosc);
        if(poziomTuszu < 0) throw new IllegalArgumentException("Poziom tuszu nie może być mniejszy od 0.");
        this.poziomTuszu = poziomTuszu;
        this.czyKolor = czyKolor;
    }

    @Override
    public double getPoziomTuszu() throws Exception { return poziomTuszu; }

    @Override
    public void setPoziomTuszu(double poziomTuszu) throws Exception {
        if(poziomTuszu < 0) throw new IllegalArgumentException("Poziom tuszu nie może być mniejszy od 0.");
        this.poziomTuszu = poziomTuszu;
    }

    @Override
    public boolean isCzyKolor() throws Exception { return czyKolor; }

    @Override
    public void setCzyKolor(boolean czyKolor) throws Exception { this.czyKolor = czyKolor; }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Poziom tuszu: " + poziomTuszu + ", Kolor: " + czyKolor;
    }
}