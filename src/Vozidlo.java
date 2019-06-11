import java.util.ArrayList;

public class Vozidlo {

    private final String spz;
    private final double nosnost;
    private final double naklady;
    private double aktualnaNosnost;
    private ArrayList<Objednavka> zasielky;

    public Vozidlo(String spz, double nosnost, double naklady) {
        this.spz = spz;
        this.nosnost = nosnost * 1000;
        this.naklady = naklady;
        this.aktualnaNosnost = 0;
        this.zasielky = new ArrayList<>();
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
}
