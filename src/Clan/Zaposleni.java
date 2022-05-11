package Clan;

public class Zaposleni extends Clan {

	protected String korisnickoIme;
	protected String korisnickaSifra;
	protected int plata;
	
	
	public Zaposleni() {
		this.korisnickoIme = "";
		this.korisnickaSifra = "";
		this.plata = 0;
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
	

}
