package D1;

import java.util.ArrayList;
import java.util.List;

class Getraenk {
    private String name;
    private double preis;

    public Getraenk(String name, double preis) {
        this.name = name;
        this.preis = preis;
    }

    public String getName() {
        return name;
    }

    public double getPreis() {
        return preis;
    }
}

class Kunde {
    private String name;
    private Getraenk bestellung;

    public Kunde(String name) {
        this.name = name;
    }

    public String bestelle(Getraenk getraenk) {
        this.bestellung = getraenk;
        return name + " bestellt " + getraenk.getName() + ".";
    }

    public Getraenk getBestellung() {
        return bestellung;
    }

    public String getName() {
        return name;
    }
}

class Barista {
    private String name;

    public Barista(String name) {
        this.name = name;
    }

    public String bereiteZu(Getraenk getraenk) {
        return name + " bereitet " + getraenk.getName() + " zu.";
    }
}

class Cafe {
    private String name;
    private double umsatz;
    private Barista barista;
    private List<Kunde> kunden;

    public Cafe(String name) {
        this.name = name;
        this.umsatz = 0;
        this.kunden = new ArrayList<>();
    }

    public void setBarista(Barista barista) {
        this.barista = barista;
    }

    public void betrete(Kunde kunde) {
        kunden.add(kunde);
    }

    public void bestellungAufnehmen(Kunde kunde, Getraenk getraenk) {
        if (kunden.contains(kunde) && barista != null) {
            System.out.println(kunde.bestelle(getraenk));
            System.out.println(barista.bereiteZu(getraenk));
            umsatz += getraenk.getPreis();
        }
    }

    public double getUmsatz() {
        return umsatz;
    }
}

public class Main {
    public static void main(String[] args) {
        Cafe cafe = new Cafe("Café Aroma");
        Barista barista = new Barista("Lina");
        cafe.setBarista(barista);

        Kunde kunde1 = new Kunde("Mia");
        Kunde kunde2 = new Kunde("Jonas");
        cafe.betrete(kunde1);
        cafe.betrete(kunde2);

        Getraenk latte = new Getraenk("Latte Macchiato", 5.5);
        Getraenk espresso = new Getraenk("Espresso", 3.0);

        cafe.bestellungAufnehmen(kunde1, latte);
        cafe.bestellungAufnehmen(kunde2, espresso);

        System.out.println("Tagesumsatz: " + cafe.getUmsatz() + " CHF");
    }
}
