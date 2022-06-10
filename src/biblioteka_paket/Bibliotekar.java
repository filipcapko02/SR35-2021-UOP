package biblioteka_paket;

import biblioteka_paket.enums.Pol;

public class Bibliotekar extends Zaposleni {


    public Bibliotekar(int ID, Pol pol, String ime, String prezime, String jmbg, String adresa, String korisnickoIme, String korisnickaSifra, int plata, boolean obrisan) {
        super(ID, pol, ime, prezime, jmbg, adresa, korisnickoIme, korisnickaSifra, plata, obrisan);
    }
}
