public interface IDrukarka {
    double getPoziomTuszu() throws Exception;
    void setPoziomTuszu(double poziomTuszu) throws Exception;
    boolean isCzyKolor() throws Exception;
    void setCzyKolor(boolean czyKolor) throws Exception;
}