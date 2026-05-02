public abstract class Urzadzenie {
    private String nazwa;
    private String producent;

    public Urzadzenie(String nazwa, String producent) {
        if(nazwa == null || nazwa.isBlank()) throw new IllegalArgumentException("Nazwa nie może być blank albo null.");
        if(producent == null || producent.isBlank()) throw new IllegalArgumentException("Producent nie może być blank albo null.");
        this.nazwa = nazwa;
        this.producent = producent;
    }

    public String getNazwa() { return nazwa; }
    public String getProducent() { return producent; }

    public void setNazwa(String nazwa) {
        if(nazwa == null || nazwa.isBlank()) throw new IllegalArgumentException("Nazwa nie może być blank albo null.");
        this.nazwa = nazwa;
    }

    public void setProducent(String producent) {
        if(producent == null || producent.isBlank()) throw new IllegalArgumentException("Producent nie może być blank albo null.");
        this.producent = producent;
    }

    public String getInfo() {
        return "Urządzenie: " + nazwa + ", Producent: " + producent;
    }
}