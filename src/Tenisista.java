public class Tenisista extends Zawodnik {
    private int rankingAtp;
    public Tenisista(String imie, String nazwisko, int wiek, int rankingAtp){
        super(imie, nazwisko, wiek);
        if(rankingAtp<=0) throw new IllegalArgumentException("Pozycja w rankingu atp nie może być mniejsza albo równa zero.");
        this.rankingAtp = rankingAtp;
    }

    @Override
    public String trenuj() {
        return "Tenisita"+super.getImie()+" "+super.getNazwisko()+" o pozycji w rankingu numer; "+rankingAtp+" rozpoczął trening.";
    }

    public int getRankingAtp() {
        return rankingAtp;
    }

    public void setRankingAtp(int rankingAtp) {
        if(rankingAtp<=0) throw new IllegalArgumentException("Zły argument w metodzie setRankingAtp. Pozycja w rankingu atp nie może być mniejsza albo równa zero.");
        this.rankingAtp = rankingAtp;
    }
}
