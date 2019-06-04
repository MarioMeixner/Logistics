import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class Dron {

    private String serioveCislo;
    private TypDronu typDronu;
    private int nosnost, rychlost, dobaLetu, dobaNabijania, pocetPrepZas;
    private double pocetNalHod;
    private Datum datum;
    private boolean jeDostupny;
    private int aktualneNabitie;
    private Queue<Objednavka> objednavky;

    public Dron(String serioveCislo, int typ) {
        this.serioveCislo = serioveCislo;
        if (typ == 1) {
            this.typDronu = TypDronu.typI;
            this.nosnost = 2;
            this.rychlost = 80;
            this.dobaLetu = 40;
            this.dobaNabijania = 3;
        } else if (typ == 2) {
            this.typDronu = TypDronu.typII;
            this.nosnost = 5;
            this.rychlost = 40;
            this.dobaLetu = 60;
            this.dobaNabijania = 5;
        } else {
            System.out.println("Nespravny typ!");
        }
        this.pocetNalHod = 0;
        this.pocetPrepZas = 0;
        this.jeDostupny = true;
        this.aktualneNabitie = 100;
        this.objednavky = new LinkedList<Objednavka>();
    }

    public String getTypString() {
        String typ;
        if (this.typDronu == TypDronu.typI)
            typ = "I";
        else
            typ = "II";
        return typ;
    }

    public int getRychlost() { return this.rychlost; }

    public int getDobaLetu() { return this.dobaLetu; }

    public int getNosnost() { return this.nosnost; }

    public double getPocetNalHod() {
        return this.pocetNalHod;
    }

    public int getPocetPrepZas() {
        return this.pocetPrepZas;
    }

    public boolean getDostupnost() { return this.jeDostupny; }

    public int getAktualneNabitie() { return this.aktualneNabitie; }

    public Objednavka getObjednavka() { return this.objednavky.peek(); }

    public Objednavka remObjednavka() { return this.objednavky.poll(); }

    public void setDatum(Datum datum) {
        this.datum = datum;
    }

    public void setDostupnost(boolean hodnota) { this.jeDostupny = hodnota; }

    public void setPocetNalHod(double hodnota) { this.pocetNalHod += hodnota; }

    public void pridajPocetPrepZas() { this.pocetPrepZas++; }

    public String getDatum() {
        return this.datum.toString();
    }

    public void addObjednavka(Objednavka o) {
        this.objednavky.add(o);
    }
}
