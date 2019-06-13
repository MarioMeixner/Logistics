public class Miesto {
    private String nazov;
    private double vzdialenost;

    public Miesto(String nazov, double vzdialenost) {
        this.nazov = nazov;
        this.vzdialenost = vzdialenost;
    }

    public String getNazov() { return this.nazov; }

    public double getVzdialenost() { return this.vzdialenost; }
}
