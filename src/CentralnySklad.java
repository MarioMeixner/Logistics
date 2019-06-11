import java.util.ArrayList;

public class CentralnySklad extends Sklad {

    private ArrayList<Vozidlo> vozidla;
    private ArrayList<Objednavka> zasielky;

    public CentralnySklad(String nazov) {
        super(nazov);
        this.vozidla = new ArrayList<>();
        this.zasielky = new ArrayList<>();
    }

    public void pridajVozidlo(Vozidlo v) {
        this.vozidla.add(v);
    }

    public void vypisVozidla() {
        if (!this.vozidla.isEmpty()) {
            for (Vozidlo v : this.vozidla) {
                System.out.println("SPZ: " + v.getSpz() + " nosnost: " + v.getNosnost() + " naklady: " + v.getNaklady());
            }
        } else {
            System.out.println("Zoznam je prazdny.");
        }
    }

    public void pridajZasielku(Objednavka o) {
        this.zasielky.add(o);
    }

    public void vylozVozidla() {
        for (Vozidlo v : this.vozidla) {
            if (!v.getZasielky().isEmpty()) {
                this.zasielky.addAll(v.getZasielky());
            }
        }
    }
}
