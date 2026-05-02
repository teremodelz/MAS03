public interface IRegionalny {
    boolean isCzyWymagaPasaAsfaltowego() throws Exception;
    void setCzyWymagaPasaAsfaltowego(boolean value) throws Exception;
    void wystartuj() throws Exception;
}

public interface ISredniodystansowy {
    int getLiczbaKlasPokladowych() throws Exception;
    void setLiczbaKlasPokladowych(int value) throws Exception;
    double getZuzyciePaliwaNa100Km() throws Exception;
    void setZuzyciePaliwaNa100Km(double value) throws Exception;
    void wystartuj() throws Exception;
}

public interface IDlugodystansowy {
    int getLiczbaPokladow() throws Exception;
    void setLiczbaPokladow(int value) throws Exception;
    int getMaksymalnaIloscGodzinLotu() throws Exception;
    void setMaksymalnaIloscGodzinLotu(int value) throws Exception;
    void wystartuj() throws Exception;
}