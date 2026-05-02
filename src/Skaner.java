public class Skaner extends Urzadzenie {
    private double maksymalnaRozdzielczosc;

    public Skaner(String nazwa, String producent, double maksymalnaRozdzielczosc) {
        super(nazwa, producent);
        if(maksymalnaRozdzielczosc <= 0) throw new IllegalArgumentException("Maksymalna rozdzielczość nie może być równa 0 albo mniejsza od niego.");
        this.maksymalnaRozdzielczosc = maksymalnaRozdzielczosc;
    }

    public double getMaksymalnaRozdzielczosc() { return maksymalnaRozdzielczosc; }

    public void setMaksymalnaRozdzielczosc(double maksymalnaRozdzielczosc) {
        if(maksymalnaRozdzielczosc <= 0) throw new IllegalArgumentException("Maksymalna rozdzielczość nie może być równa 0 albo mniejsza od niego.");
        this.maksymalnaRozdzielczosc = maksymalnaRozdzielczosc;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Maksymalna rozdzielczość: " + maksymalnaRozdzielczosc;
    }
}