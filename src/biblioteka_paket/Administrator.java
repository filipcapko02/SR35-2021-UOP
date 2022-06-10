package biblioteka_paket;


import biblioteka_paket.enums.Pol;

public class Administrator extends Zaposleni {


    public Administrator(int ID, Pol pol, String ime, String prezime, String jmbg, String adresa, String korisnickoIme, String korisnickaSifra, int plata, boolean obrisan) {
        super(ID, pol, ime, prezime, jmbg, adresa, korisnickoIme, korisnickaSifra, plata, obrisan);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}