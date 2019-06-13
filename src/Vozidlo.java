import java.util.ArrayList;
import java.util.Iterator;

public class Vozidlo {

    private final String spz;
    private final double nosnost;
    private final double naklady;
    private double aktualnaNosnost;
    private ArrayList<Objednavka> zasielky;
    private double celkoveNaklady;

    public Vozidlo(String spz, double nosnost, double naklady) {
        this.spz = spz;
        this.nosnost = nosnost * 1000;
        this.naklady = naklady;
        this.aktualnaNosnost = 0;
        this.zasielky = new ArrayList<>();
        this.celkoveNaklady = 0;
    }

    public String getSpz() {
        return this.spz;
    }

    public double getNosnost() {
        return this.nosnost;
    }

    public double getNaklady() {
        return this.naklady;
    }

    public double getAktualnaNosnost() { return this.aktualnaNosnost; }

    public void setAktualnaNosnost(double hodnota) { this.aktualnaNosnost = hodnota; }

    public void nalozVozidlo(ArrayList<Objednavka> zasielky) { this.zasielky = zasielky; }

    public void pridajZasielku(Objednavka o) {
        this.zasielky.add(o);
    }

    public ArrayList<Objednavka> getZasielky() {
        return this.zasielky;
    }

    public void setCelkoveNaklady(double hodnota) {
        this.celkoveNaklady += hodnota;
    }

    public double getCelkoveNaklady() { return this.celkoveNaklady; }

    public void vylozVozidlo() {
        int size = this.zasielky.size();
        for (int index = size-1; index >= 0; index--) {
            this.zasielky.remove(index);
        }
    }
}
