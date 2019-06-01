public class Datum {

    private int den;
    private int mesiac;
    private int rok;

    public Datum(int den, int mesiac, int rok) {

        this.den = den;
        this.mesiac = mesiac;
        this.rok = rok;
    }

    public int getDen() {
        return this.den;
    }

    public int getMesiac() {
        return this.mesiac;
    }

    public int getRok() {
        return this.rok;
    }

    public void krok() {
        if (this.mesiac == 1 || this.mesiac == 3 || this.mesiac == 5 || this.mesiac == 7 ||
                this.mesiac == 8 || this.mesiac == 10 || this.mesiac == 12) {
            if (this.den == 31) {
                if (this.mesiac == 12) {
                    this.rok++;
                    this.mesiac = 1;
                    this.den = 1;
                } else {
                    this.mesiac++;
                    this.den = 1;
                }
            } else
                this.den++;
        } else if (this.mesiac == 4 || this.mesiac == 6 || this.mesiac == 9 || this.mesiac == 11) {
            if (this.den == 30) {
                this.mesiac++;
                this.den = 1;
            } else
                this.den++;
        } else {
            if (this.den == 28) {
                this.mesiac++;
                this.den = 1;
            } else
                this.den++;
        }
    }

    @Override
    public String toString() {
        return this.den + "/" + this.mesiac + "/" + this.rok;
    }
}
