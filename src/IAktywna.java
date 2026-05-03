
interface IAktywna {
    String getSedziaProwadzacy() throws Exception;
    void setSedziaProwadzacy(String sedziaProwadzacy) throws Exception;
    String pobierzStatus() throws Exception;
}

interface IZawieszona {
    String getPowodZawieszenia() throws Exception;
    void setPowodZawieszenia(String powodZawieszenia) throws Exception;
    String pobierzStatus() throws Exception;
}

interface IZakonczona {
    String getWynikSprawy() throws Exception;
    void setWynikSprawy(String wynikSprawy) throws Exception;
    String pobierzStatus() throws Exception;
}