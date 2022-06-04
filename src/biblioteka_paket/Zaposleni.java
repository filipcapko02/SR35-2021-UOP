package biblioteka_paket;

import java.util.Objects;

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
