import java.util.*;

public class Logika {

    private Scanner sc;
    private Sklad[] sklady;
    private CentralnySklad centralnySklad;
    private Datum datum;
    private int cas;
    private Queue<Objednavka> objednavky;

    public Logika() {
        this.sc = new Scanner(System.in);
        this.centralnySklad = new CentralnySklad("ZA");
        this.sklady = new Sklad[25];
        this.objednavky = new LinkedList<Objednavka>();

        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Prague"));
        cal.setTime(new Date());
        this.datum = new Datum(cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH), cal.get(Calendar.YEAR));
        this.cas = 7;

        this.vytvorSietPrekladisk();
    }

    public String krokCas() {
        if (this.cas == 23) {
            this.cas = 7;
            this.datum.krok();
        } else {
            this.cas++;
        }
        return this.cas + ":00";
    }

    public String getCas() {
        return this.cas + ":00";
    }

    public void vytvorSietPrekladisk() {
        this.sklady[0] = centralnySklad;
        LokalnePrekladisko BA = new LokalnePrekladisko("BA");
        this.sklady[1] = BA;
        LokalnePrekladisko MA = new LokalnePrekladisko("MA");
        this.sklady[2] = MA;
        LokalnePrekladisko TT = new LokalnePrekladisko("TT");
        this.sklady[3] = TT;


        LokalnePrekladisko KN = new LokalnePrekladisko("KN");
        this.sklady[4] = KN;
        LokalnePrekladisko LV = new LokalnePrekladisko("LV");
        this.sklady[5] = LV;
        LokalnePrekladisko NR = new LokalnePrekladisko("NR");
        this.sklady[6] = NR;
        LokalnePrekladisko TN = new LokalnePrekladisko("TN");
        this.sklady[7] = TN;
        LokalnePrekladisko PD = new LokalnePrekladisko("PD");
        this.sklady[8] = PD;

        LokalnePrekladisko CA = new LokalnePrekladisko("CA");
        this.sklady[9] = CA;
        LokalnePrekladisko NO = new LokalnePrekladisko("NO");
        this.sklady[10] = NO;
        LokalnePrekladisko MT = new LokalnePrekladisko("MT");
        this.sklady[11] = MT;
        LokalnePrekladisko LM = new LokalnePrekladisko("LM");
        this.sklady[12] = LM;

        LokalnePrekladisko BB = new LokalnePrekladisko("BB");
        this.sklady[13] = BB;
        LokalnePrekladisko ZV = new LokalnePrekladisko("ZV");
        this.sklady[14] = ZV;
        LokalnePrekladisko KA = new LokalnePrekladisko("KA");
        this.sklady[15] = KA;
        LokalnePrekladisko LC = new LokalnePrekladisko("LC");
        this.sklady[16] = LC;
        LokalnePrekladisko RA = new LokalnePrekladisko("RA");
        this.sklady[17] = RA;

        LokalnePrekladisko SN = new LokalnePrekladisko("SN");
        this.sklady[18] = SN;
        LokalnePrekladisko KE = new LokalnePrekladisko("KE");
        this.sklady[19] = KE;
        LokalnePrekladisko MI = new LokalnePrekladisko("MI");
        this.sklady[20] = MI;

        LokalnePrekladisko PP = new LokalnePrekladisko("PP");
        this.sklady[21] = PP;
        LokalnePrekladisko SL = new LokalnePrekladisko("SL");
        this.sklady[22] = SL;
        LokalnePrekladisko PO = new LokalnePrekladisko("PO");
        this.sklady[23] = PO;
        LokalnePrekladisko HE = new LokalnePrekladisko("HE");
        this.sklady[24] = HE;
    }

    public void start() {
        int volba;
        boolean loop = true;
        String nazovSkladu;

        do {
            System.out.println(this.datum.toString() + " " + this.getCas());
            System.out.print("=====Informacny system=====\n" +
                    "===========================\n" +
                    "=  0. Koniec              =\n" +
                    "=  1. Pridat vozidlo      =\n" +
                    "=  2. Vypisat vozidla     =\n" +
                    "=  3. Pridat dron         =\n" +
                    "=  4. Vypisat drony       =\n" +
                    "=  5. Vytvor objednavku   =\n" +
                    "=  6. Krok den            =\n" +
                    "=  7. Krok cas            =\n" +
                    "===========================\n" +
                    "=  Zadaj volbu:		      =\n");
            volba = this.sc.nextInt();
            switch (volba) {
                case 0:
                    loop = false;
                    break;
                case 1:
                    pridanieVozidla();
                    break;
                case 2:
                    vypisVozidiel();
                    break;
                case 3:
                    pridanieDronu();
                    break;
                case 4:
                    vypisDronov();
                    break;
                case 5:
                    vytvorObjednavku();
                    break;
                case 6:
                    this.datum.krok();
                    break;
                case 7:
                    krokCas();
                    break;
                default:
                    break;
            }
        } while(loop);
    }

    public void pridanieVozidla() {
        String spz;
        double nosnost, naklady;

        System.out.println("Zadaj spz: ");
        spz = this.sc.next();
        System.out.println("Zadaj nosnost: ");
        nosnost = this.sc.nextDouble();
        System.out.println("Zadaj naklady: ");
        naklady = this.sc.nextDouble();

        Vozidlo v = new Vozidlo(spz, nosnost, naklady);
        this.centralnySklad.pridajVozidlo(v);
        System.out.println("Vozidlo bolo pridane.");
    }

    public void vypisVozidiel() {
        this.centralnySklad.vypisVozidla();
    }

    public void pridanieDronu() {
        String serioveCislo, nazovSkladu;
        int typ;
        boolean najdeny = false;

        System.out.println("Zadaj nazov skladu: ");
        nazovSkladu = this.sc.next();

        for (int i = 0; i < this.sklady.length; i++) {
            if (this.sklady[i].getNazov().equals(nazovSkladu)) {
                najdeny = true;
                System.out.println("Zadaj seriove cislo: ");
                serioveCislo = this.sc.next();
                System.out.println("Zadaj typ: ");
                typ = this.sc.nextInt();
                Dron d = new Dron(serioveCislo, typ);
                d.setDatum(this.datum);
                this.sklady[i].pridajDron(d);
                System.out.println("Dron bol pridany do zoznamu.");
            }
        }
        if (!najdeny)
            System.out.println("Nespravny nazov skladu!");
    }

    public void vypisDronov() {
        String nazovSkladu;
        boolean najdeny = false;

        System.out.println("Zadaj nazov skladu: ");
        nazovSkladu = this.sc.next();

        for (int i = 0; i < this.sklady.length; i++) {
            if (this.sklady[i].getNazov().equals(nazovSkladu)) {
                najdeny = true;
                this.sklady[i].vypisDrony();
            }
        }
        if (!najdeny)
            System.out.println("Nespravny nazov skladu!");
    }

    public void vytvorObjednavku() {
        double hmotnostZasielky, vzdialenost_x, vzdialenost_y;
        String region_x, region_y;

        System.out.println("Zadaj hmostnost zasielky: ");
        hmotnostZasielky = this.sc.nextDouble();

        System.out.println("Zadaj region vyzdvihnutia zasielky: ");
        region_x = this.sc.next();
        System.out.println("Zadaj vzdialenost od lokalneho prekladiska: ");
        vzdialenost_x = this.sc.nextDouble();
        Miesto miesto_o = new Miesto(region_x, vzdialenost_x);

        System.out.println("Zadaj region dorucenia zasielky : ");
        region_y = this.sc.next();
        System.out.println("Zadaj vzdialenost od lokalneho prekladiska: ");
        vzdialenost_y = this.sc.nextDouble();
        Miesto miesto_p = new Miesto(region_y, vzdialenost_y);

        boolean zamietnuta_x = true;
        boolean zamietnuta_y = true;

        for (Sklad s : this.sklady) {
            if (s.getNazov().equals(region_x)) {
                for (Dron d : s.getDrony()) {
                    if ((vzdialenost_x / d.getRychlost()) + this.cas <= 22 &&
                            (d.getDobaLetu() / 60) * d.getRychlost() >= vzdialenost_x &&
                            d.getNosnost() >= hmotnostZasielky&&
                            s.getVozidlo().getAktualnaNosnost() + hmotnostZasielky <= s.getVozidlo().getNosnost()) {
                        zamietnuta_x = false;
                    } else {
                        zamietnuta_x = true;
                    }
                }
            }
        }

        for (Sklad s : this.sklady) {
            if (s.getNazov().equals(region_y)) {
                for (Dron d: s.getDrony()) {
                    if ((d.getDobaLetu() / 60) * d.getRychlost() >= vzdialenost_y &&
                            d.getNosnost() >= hmotnostZasielky) {
                        zamietnuta_y = false;
                    } else {
                        zamietnuta_y = true;
                    }
                }
            }
        }

        if (!zamietnuta_x && !zamietnuta_y) {
            Objednavka objednavka = new Objednavka(hmotnostZasielky, miesto_o, miesto_p);
            this.objednavky.add(objednavka);
            System.out.println("Objednavka bola prijata.");
        } else
            System.out.println("Objednavka bola zamietnuta.");
    }
}
