package biblioteka_paket;

import java.util.ArrayList;

public class Iznajmljivanje {

    private int ID;
    private Zaposleni zaposleni;
    private Clan clan;
    private String datumIznajmljivanja;
    private String datumVracanja;
    private ArrayList<PrimerakKnjige> primerci;


    public Iznajmljivanje() {

    }

    public Iznajmljivanje(int ID, Zaposleni zaposleni, Clan clan, String datumIznajmljivanja, String datumVracanja, ArrayList<PrimerakKnjige> primerci) {
        this.ID = ID;
        this.zaposleni = zaposleni;
        this.clan = clan;
        this.datumIznajmljivanja = datumIznajmljivanja;
        this.datumVracanja = datumVracanja;
        this.primerci = primerci;
    }

    @Override
    public String toString() {
        return "Iznajmljivanje{" +
                "ID=" + ID +
                ", zaposleni=" + zaposleni +
                ", clan=" + clan +
                ", datumIznajmljivanja='" + datumIznajmljivanja + '\'' +
                ", datumVracanja='" + datumVracanja + '\'' +
                ", primerci=" + primerci +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public String getDatumIznajmljivanja() {
        return datumIznajmljivanja;
    }

    public void setDatumIznajmljivanja(String datumIznajmljivanja) {
        this.datumIznajmljivanja = datumIznajmljivanja;
    }

    public String getDatumVracanja() {
        return datumVracanja;
    }

    public void setDatumVracanja(String datumVracanja) {
        this.datumVracanja = datumVracanja;
    }

    public ArrayList<PrimerakKnjige> getPrimerci() {
        return primerci;
    }

    public void setPrimerci(ArrayList<PrimerakKnjige> primerci) {
        this.primerci = primerci;
    }
}
