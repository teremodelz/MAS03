import java.io.Serializable;
import java.util.EnumSet;

enum NapedType { Spalinowy, Elektryczny }
public abstract class Pojazd implements Serializable {
    private String model;
    private String marka;
    // spalinowy
    private double pojemnoscSilnika;
    //elektryczny
    private double pojemnoscBaterii;
    private NapedType typNapedu;
    protected Pojazd(String model, String marka, NapedType typNapedu) {
        if(model == null || model.isBlank()) throw new IllegalArgumentException("Model nie może być blank albo null.");
        if(marka == null || marka.isBlank()) throw new IllegalArgumentException("Marka nie może być blank albo null.");
        if(typNapedu == null) throw new IllegalArgumentException("Typ napędu nie może być pusty.");
        this.model = model;
        this.marka = marka;
        this.typNapedu = typNapedu;
    }

    public void setPojemnoscSilnika(double pojemnoscSilnika) {
        if(typNapedu != NapedType.Spalinowy)
            throw new IllegalArgumentException("Pojazd nie jest spalinowy!");
        if(pojemnoscSilnika <= 0)
            throw new IllegalArgumentException("Pojemność silnika nie może być równa 0 bądź mniejsza.");
        this.pojemnoscSilnika = pojemnoscSilnika;
    }

    public void setPojemnoscBaterii(double pojemnoscBaterii) {
        if(typNapedu != NapedType.Elektryczny)
            throw new IllegalArgumentException("Pojazd nie jest elektryczny!");
        if(pojemnoscBaterii <= 0)
            throw new IllegalArgumentException("Pojemność baterii nie może być równa 0 bądź mniejsza.");
        this.pojemnoscBaterii = pojemnoscBaterii;
    }

    public double getPojemnoscSilnika() throws Exception {
        if(typNapedu != NapedType.Spalinowy)
            throw new Exception("Pojazd nie jest spalinowy!");
        return pojemnoscSilnika;
    }

    public double getPojemnoscBaterii() throws Exception {
        if(typNapedu != NapedType.Elektryczny)
            throw new Exception("Pojazd nie jest elektryczny!");
        return pojemnoscBaterii;
    }

    public NapedType getTypNapedu() { return typNapedu; }
    public String getModel() { return model; }
    public String getMarka() { return marka; }

    public void usun() {
        Repozytorium.getInstance().usunPojazd(this);
    }

}
