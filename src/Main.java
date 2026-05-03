public class Main {
    public static void main(String[] args) throws Exception {

        // ---- ZAWODNICY ----
        Pilkarz lewandowski = new Pilkarz("Robert", "Lewandowski", 35, 9, "FC Barcelona");
        Pilkarz mbappe = new Pilkarz("Kylian", "Mbappe", 25, 7, "Real Madryt");
        Plywak peaty = new Plywak("Adam", "Peaty", 29, StylPlywacki.ZABKA);
        Tenisista alcaraz = new Tenisista("Carlos", "Alcaraz", 21, 3);

        // ---- SAMOLOTY ----
        Samolot cessna = Samolot.createRegionalny("Cessna 172", "Cessna", 4, 1289, false);
        Samolot boeing737 = Samolot.createSredniodystansowy("Boeing 737", "Boeing", 180, 5765, 3, 2600);
        Samolot boeing777 = Samolot.createDlugodystansowy("Boeing 777", "Boeing", 396, 13650, 2, 17);

        // ---- POJAZDY ----
        PojazdOsobowy golf = PojazdOsobowy.createSpalinowy("Golf", "Volkswagen", 5, 1.6);
        PojazdOsobowy tesla = PojazdOsobowy.createElektryczny("Model 3", "Tesla", 5, 75);
        PojazdCiezarowy actros = PojazdCiezarowy.createSpalinowy("Actros", "Mercedes", 24000, 12.0);

        // ---- URZADZENIA ----
        Drukarka drukarka = new Drukarka("LaserJet", "HP", 85.0, true);
        Skaner skaner = new Skaner("CanoScan", "Canon", 1200);
        Kopiarka kopiarka = new Kopiarka("WorkCentre", "Xerox", 600, 70.0, false);

        // ---- SPRAWY SADOWE ----
        SprawaSadowa sprawa1 = SprawaSadowa.createAktywna("XII K 45/24", "Kradzież z włamaniem", "Jan Kowalski");
        SprawaSadowa sprawa2 = SprawaSadowa.createZawieszona("III C 12/23", "Spór o własność", "Brak świadków");
        SprawaSadowa sprawa3 = SprawaSadowa.createZakonczona("V GC 8/22", "Sprawa gospodarcza", "Ugoda stron");

        // ---- WYPISANIE WSZYSTKICH ----
        System.out.println("=== ZAWODNICY ===");
        Repozytorium.getInstance().getZawodnicy()
                .forEach(z -> System.out.println(z.trenuj()));

        System.out.println("\n=== SAMOLOTY ===");
        Repozytorium.getInstance().getSamoloty()
                .forEach(s -> {
                    try { s.wystartuj(); }
                    catch (Exception e) { e.printStackTrace(); }
                });

        System.out.println("\n=== POJAZDY ===");
        Repozytorium.getInstance().getPojazdy()
                .forEach(p -> System.out.println(p.getMarka() + " " + p.getModel() + " - " + p.getTypNapedu()));

        System.out.println("\n=== URZADZENIA ===");
        Repozytorium.getInstance().getUrzadzenia()
                .forEach(u -> System.out.println(u.getInfo()));

        System.out.println("\n=== SPRAWY SADOWE ===");
        Repozytorium.getInstance().getSprawy()
                .forEach(s -> System.out.println(s.pobierzStatus()));

        // ---- USUWANIE ----
        System.out.println("\n=== USUWANIE ===");
        lewandowski.usun();
        System.out.println("Usunieto: Lewandowski");
        cessna.usun();
        System.out.println("Usunieto: Cessna");
        golf.usun();
        System.out.println("Usunieto: Golf");
        sprawa2.usun();
        System.out.println("Usunieto: sprawa III C 12/23");

        // ---- WYPISANIE PO USUNIECIU ----
        System.out.println("\n=== ZAWODNICY PO USUNIECIU ===");
        Repozytorium.getInstance().getZawodnicy()
                .forEach(z -> System.out.println(z.trenuj()));

        System.out.println("\n=== POJAZDY PO USUNIECIU ===");
        Repozytorium.getInstance().getPojazdy()
                .forEach(p -> System.out.println(p.getMarka() + " " + p.getModel()));

        System.out.println("\n=== SPRAWY PO USUNIECIU ===");
        Repozytorium.getInstance().getSprawy()
                .forEach(s -> System.out.println(s.pobierzStatus()));

        // ---- ZAPIS ----
        Repozytorium.getInstance().zapisz();
        System.out.println("\nZapisano wszystko do pliku obiekty.ser");
    }
}