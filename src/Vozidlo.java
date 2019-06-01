public class Vozidlo {

    private final String spz;
    private final double nosnost;
    private final double naklady;
    private double aktualnaNosnost;

    public Vozidlo(String spz, double nosnost, double naklady) {
        this.spz = spz;
        this.nosnost = nosnost * 1000;
        this.naklady = naklady;
        this.aktualnaNosnost = 0;
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
}
