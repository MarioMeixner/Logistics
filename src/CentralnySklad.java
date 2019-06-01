import java.util.ArrayList;

public class CentralnySklad extends Sklad {

    private ArrayList<Vozidlo> vozidla;

    public CentralnySklad(String nazov) {
        super(nazov);
        this.vozidla = new ArrayList<>();
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
}
