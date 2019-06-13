import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Sklad {
    private String nazov;
    private ArrayList<Dron> drony;
    private Vozidlo vozidlo;
    private Queue<Objednavka> objednavky;
    private ArrayList<Objednavka> zasielky;

    public Sklad(String nazov) {
        this.nazov = nazov;
        this.drony = new ArrayList<>();
        this.vozidlo = null;
        this.objednavky = new LinkedList<>();
        this.zasielky = new ArrayList<>();
    }

    public String getNazov() {
        return this.nazov;
    }

    public void pridajDron(Dron d) {
        this.drony.add(d);
    }

    public ArrayList<Dron> getDrony() { return this.drony; }

    public void setVozidlo(Vozidlo v) { this.vozidlo = v; }

    public Vozidlo getVozidlo() { return this.vozidlo; }

    public void vypisDrony() {
        if (!this.drony.isEmpty()) {
            for (Dron d : this.drony) {
                System.out.println("Datum pridania: " + d.getDatum() + " typ: " + d.getTypString() + " pocet nalietanych hodin " + d.getPocetNalHod() + " pocet prepravenych zasielok: " + d.getPocetPrepZas());
            }
        } else {
            System.out.println("Zoznam dronov je prazdny!");
        }
    }

    public void pridajObjednavku(Objednavka o) {
        this.objednavky.add(o);
    }

    public Objednavka getObjednavku() {
        return this.objednavky.peek();
    }

    public Objednavka remObjednavku() {
        return this.objednavky.poll();
    }

    public void pridajZasielku(Objednavka o) {
        this.zasielky.add(o);
    }

    public boolean maZasielky() {
        if (!this.zasielky.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void nalozVozidlo() {
        double hmotnost = 0;
        int pocetZasielok = 0;

        for (Iterator<Objednavka> iterator = this.zasielky.iterator(); iterator.hasNext();) {
            Objednavka o = iterator.next();
            this.vozidlo.pridajZasielku(o);
            hmotnost = o.getHmotnost();
            pocetZasielok++;
            iterator.remove();
        }
        System.out.println("Vozidlo bolo nalozene. \nCelkova hmotnost nalozenych zasielok: " + hmotnost + "\nPocet nalozenych zasielok: " + pocetZasielok);
    }
}
