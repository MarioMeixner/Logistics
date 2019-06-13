public class Objednavka {

    private double hmotnost;
    private Miesto miesto_x;
    private Miesto miesto_y;

    public Objednavka(double hmotnost, Miesto miesto_x, Miesto miesto_y) {
        this.hmotnost = hmotnost;
        this.miesto_x = miesto_x;
        this.miesto_y = miesto_y;
    }

    public double getHmotnost() { return this.hmotnost; }

    public Miesto getMiesto_x() { return this.miesto_x; }

    public Miesto getMiesto_y() {
        return this.miesto_y;
    }
}
