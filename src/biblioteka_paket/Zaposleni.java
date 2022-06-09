package biblioteka_paket;

import biblioteka_paket.enums.Pol;

public class Zaposleni extends Osoba {

	protected String korisnickoIme;
	protected String korisnickaSifra;
	protected int plata;
	private boolean obrisan;
	
	
	public Zaposleni() {
		this.korisnickoIme = "";
		this.korisnickaSifra = "";
		this.plata = 0;
		this.obrisan = false;
	}
	
	public Zaposleni(String korisnickoIme, String korisnickaSifra, int plata) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.korisnickaSifra = korisnickaSifra;
		this.plata = plata;
	}

	public Zaposleni(int ID, Pol pol, String ime, String prezime, String jmbg, String adresa, String korisnickoIme, String korisnickaSifra, int plata, boolean obrisan) {
		super(ID, pol, ime, prezime, jmbg, adresa);
		this.korisnickoIme = korisnickoIme;
		this.korisnickaSifra = korisnickaSifra;
		this.plata = plata;
		this.obrisan = obrisan;
	}

	@Override
	public String toString() {
		return "Zaposleni{" +
				"ID=" + ID +
				", pol=" + pol +
				", ime='" + ime + '\'' +
				", prezime='" + prezime + '\'' +
				", jmbg='" + jmbg + '\'' +
				", adresa='" + adresa + '\'' +
				", korisnickoIme='" + korisnickoIme + '\'' +
				", korisnickaSifra='" + korisnickaSifra + '\'' +
				", plata=" + plata +
				", obrisan=" + obrisan +
				'}';
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getKorisnickaSifra() {
		return korisnickaSifra;
	}

	public void setKorisnickaSifra(String korisnickaSifra) {
		this.korisnickaSifra = korisnickaSifra;
	}

	public int getPlata() {
		return plata;
	}

	public void setPlata(int plata) {
		this.plata = plata;
	}

	public boolean isObrisan() {
		return obrisan;
	}
}
