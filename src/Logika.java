import java.util.*;

class Logika {

    private Scanner sc;
    private Sklad[] sklady;
    private CentralnySklad centralnySklad;
    private Datum datum;
    private int cas;

    Logika() {
        this.sc = new Scanner(System.in);
        this.centralnySklad = new CentralnySklad("ZA");
        this.sklady = new Sklad[25];

        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Prague"));
        cal.setTime(new Date());
        this.datum = new Datum(cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH), cal.get(Calendar.YEAR));
        this.cas = 7;

        this.vytvorSietPrekladisk();
    }

    private void krokCas() {
        if (this.cas == 23) {
            this.cas = 7;
            this.datum.krok();
        } else
            this.cas++;
    }

    private String getCas() {
        return this.cas + ":00";
    }

    private void vytvorSietPrekladisk() {
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

    void start() {
        int volba;
        boolean loop = true;

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
                    "=  6. Naplanuj let        =\n" +
                    "=  7. Krok den            =\n" +
                    "=  8. Krok cas            =\n" +
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
                    vyzdvihnutieZasielky();
                    break;
                case 7:
                    this.datum.krok();
                    break;
                case 8:
                    krokCas();
                    break;
                default:
                    break;
            }
        } while(loop);
    }

    private void pridanieVozidla() {
        String spz, region;
        double nosnost, naklady;

        System.out.println("Zadaj spz: ");
        spz = this.sc.next();
        System.out.println("Zadaj nosnost: ");
        nosnost = this.sc.nextDouble();
        System.out.println("Zadaj naklady: ");
        naklady = this.sc.nextDouble();
        System.out.println("Zadaj trasu: \nCielovy region: ");
        region = this.sc.next();

        Vozidlo v = new Vozidlo(spz, nosnost, naklady);
        this.centralnySklad.pridajVozidlo(v);
        System.out.println("Vozidlo bolo pridane.");

        for (Sklad s : this.sklady) {
            if (s.getNazov().equals(region)) {
                s.setVozidlo(v);
            }
        }
    }

    private void vypisVozidiel() {
        this.centralnySklad.vypisVozidla();
    }

    private void pridanieDronu() {
        String serioveCislo, nazovSkladu;
        int typ;
        boolean najdeny = false;

        System.out.println("Zadaj nazov skladu: ");
        nazovSkladu = this.sc.next();

        for (Sklad sklad : this.sklady) {
            if (sklad.getNazov().equals(nazovSkladu)) {
                najdeny = true;
                System.out.println("Zadaj seriove cislo: ");
                serioveCislo = this.sc.next();
                System.out.println("Zadaj typ: ");
                typ = this.sc.nextInt();
                Dron d = new Dron(serioveCislo, typ);
                d.setDatum(this.datum);
                sklad.pridajDron(d);
                System.out.println("Dron bol pridany do zoznamu.");
            }
        }
        if (!najdeny)
            System.out.println("Nespravny nazov skladu!");
    }

    private void vypisDronov() {
        String nazovSkladu;
        boolean najdeny = false;

        System.out.println("Zadaj nazov skladu: ");
        nazovSkladu = this.sc.next();

        for (Sklad sklad : this.sklady) {
            if (sklad.getNazov().equals(nazovSkladu)) {
                najdeny = true;
                sklad.vypisDrony();
            }
        }
        if (!najdeny)
            System.out.println("Nespravny nazov skladu!");
    }

    private void vytvorObjednavku() {
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
        Sklad sklad = null;

        for (Sklad s : this.sklady) {
            if (s.getNazov().equals(region_x)) {
                sklad = s;
                for (Dron d : s.getDrony()) {
                    if ((vzdialenost_x / d.getRychlost()) + this.cas <= 22 &&
                            ((double)d.getDobaLetu() / 60) * d.getRychlost() >= vzdialenost_x &&
                            d.getNosnost() >= hmotnostZasielky &&
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
                    if (((double)d.getDobaLetu() / 60) * d.getRychlost() >= vzdialenost_y &&
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
            sklad.pridajObjednavku(objednavka);
            System.out.println("Objednavka bola prijata.");
        } else
            System.out.println("Objednavka bola zamietnuta.");
    }

    private void vyzdvihnutieZasielky() {
        ArrayList<Dron> vhodneDronyT1 = new ArrayList<>();
        ArrayList<Dron> vhodneDronyT2 = new ArrayList<>();
        ArrayList<Dron> obsadeneDrony = new ArrayList<>();
        Dron vhodnyDron = null;
        double hodina;
        int volba;

        for (Sklad s : this.sklady) {
            if (!s.getDrony().isEmpty()) {
                for (Dron d : s.getDrony()) {
                    //vyhladanie vhodneho dronu na prenasku zasielky
                    if (((double)d.getDobaLetu() / 60) * d.getRychlost() >= s.getObjednavku().getMiesto_o().getVzdialenost() &&
                            d.getNosnost() >= s.getObjednavku().getHmotnost()) {
                        if (d.getDostupnost()) {
                            if (d.getTypString().equals("I")) {
                                vhodneDronyT1.add(d);
                            } else {
                                vhodneDronyT2.add(d);
                            }
                        } else {
                            obsadeneDrony.add(d);
                        }
                    }
                }
                if (!obsadeneDrony.isEmpty() && vhodneDronyT1.isEmpty() && vhodneDronyT2.isEmpty()) {
                    vhodnyDron = obsadeneDrony.get(0);
                    for (Dron d : obsadeneDrony) {
                        if (vhodnyDron.getObjednavka().getMiesto_o().getVzdialenost() / vhodnyDron.getRychlost() > d.getObjednavka().getMiesto_o().getVzdialenost() / d.getRychlost()) {
                            vhodnyDron = d;
                        }
                    }
                    hodina = vhodnyDron.getObjednavka().getMiesto_o().getVzdialenost() / vhodnyDron.getRychlost();
                    if (hodina > 1) {
                        System.out.println("Vsetky drony su obsadene. \nNajblizsie vyzdvihnutie zasielky sa predpoklada o " + hodina + " hodin.");
                        System.out.println("1. Zrusit objednavku.");
                        System.out.println("2. Pokracovat");
                        volba = this.sc.nextInt();
                        switch (volba) {
                            case 1:
                                //vymazanie objednavky z frontu v sklade
                                s.remObjednavku();
                                System.out.println("Objednavka bola zrusena.");
                                break;
                            case 2:
                                //priradenie zasielky vhodnemu dronu a vymazanie z frontu objednavok v sklade
                                vyzdvihniZasielku(vhodnyDron, s);
                                break;
                            default:
                                System.out.println("Nespravna volba.");
                                break;
                        }
                    } else {
                        //priradenie zasielky vhodnemu dronu a vymazanie z frontu objednavok v sklade
                        vyzdvihniZasielku(vhodnyDron, s);
                    }
                } else {
                    porovnaj(vhodneDronyT1.isEmpty() ? vhodneDronyT2 : vhodneDronyT1);
                    if (!vhodneDronyT1.isEmpty()) {
                        //priradenie zasielky vhodnemu dronu a vymazanie z frontu objednavok v sklade
                        vyzdvihniZasielku(vhodneDronyT1.get(0), s);
                        System.out.println("Success T1");
                    } else {
                        //priradenie zasielky vhodnemu dronu a vymazanie z frontu objednavok v sklade
                        vyzdvihniZasielku(vhodneDronyT2.get(0), s);
                        System.out.println("Success T2");
                    }
                }
            }
            //prevzatie objednavky dronom do skladu
            for (Dron d : s.getDrony()) {
                while (d.getObjednavka() != null) {
                    s.pridajZasielku(d.remObjednavka());
                    d.setDostupnost(true);
                    System.out.println("Zasielky boli dorucene do skladu.");
                }
            }
        }
    }

    private void vyzdvihniZasielku(Dron d, Sklad s) {
        double hodina = d.getObjednavka().getMiesto_o().getVzdialenost() / d.getRychlost();
        d.addObjednavka(s.remObjednavku());
        d.setPocetNalHod(hodina);
        d.pridajPocetPrepZas();
        d.setDostupnost(false);
    }

    private void porovnaj(ArrayList<Dron> list) {
        list.sort((d1, d2) -> {
            Integer i1 = d1.getAktualneNabitie();
            Integer i2 = d2.getAktualneNabitie();
            return i2.compareTo(i1);
        });
    }
}