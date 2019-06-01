public class Objednavka {

    private double hmotnost;
    private Miesto miesto_o;
    private Miesto miesto_p;

    public Objednavka(double hmotnost, Miesto miesto_o, Miesto miesto_p) {
        this.hmotnost = hmotnost;
        this.miesto_o = miesto_o;
        this.miesto_p = miesto_p;
    }

    public double getHmotnost() {
        return this.hmotnost;
    }

    public Miesto getMiesto_o() {
        return this.miesto_o;
    }

    public Miesto getMiesto_p() {
        return this.miesto_p;
    }
}
