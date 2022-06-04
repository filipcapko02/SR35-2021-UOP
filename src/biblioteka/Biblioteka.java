package biblioteka;

import biblioteka_paket.Clan;
import biblioteka_paket.Knjiga;
import biblioteka_paket.Zaposleni;

import java.util.ArrayList;

public class Biblioteka {
	
	private String naziv;
	private String adresa;
	private String telefon;
	private String radnoVreme;
	private ArrayList<Zaposleni> zaposleni;
	private ArrayList<Knjiga> knjige;
	private ArrayList<Clan> clanovi;

	public Biblioteka() {
		this.clanovi = new ArrayList<Clan>();
		this.knjige = new ArrayList<Knjiga>();
		this.zaposleni = new ArrayList<Zaposleni>();
	}





	public void ucitajZaposlene(String filename) {

	}

	public void ucitajClanove(String filename) {

	}

	public void ucitajKnjige(String filename) {

	}

	public void snimiZaposlene(String filename) {

	}

	public void snimiClanove(String filename) {

	}

	public void snimiKnjige(String filename) {

	}


	public boolean dodajZaposlenog(Zaposleni zaposlen) {
		if (this.zaposleni.contains(zaposlen)) {
			this.zaposleni.add(zaposlen);
			return true;
		}
		return false;
	}

	public void obrisiZaposlenog(Zaposleni zaposlen) {
		this.zaposleni.remove(zaposlen);
	}

	public Zaposleni nadjiZaposlenog(String korisnickoIme) {
		for (Zaposleni zaposlen: zaposleni) {
			if (zaposlen.getKorisnickoIme().equals(korisnickoIme)) {
				return zaposlen;
			}
		}
		return null;
	}

	public boolean dodajClana(Clan clan) {
		if (!this.clanovi.contains(clan)) {
			this.clanovi.add(clan);
			return true;
		}
		return false;
	}

	public void obrisiClana(Clan clan) {
		this.clanovi.remove(clan);
	}

	public Clan nadjiClana(int id) {
		for (Clan clan: clanovi) {
			if (clan.getID() == id) {
				return clan;
			}
		}
		return null;
	}

	public boolean dodajKnjigu(Knjiga knjiga) {
		if (!this.knjige.contains(knjiga)) {
			this.knjige.add(knjiga);
			return true;
		}
		return false;
	}

	public void obrisiKnjigu(Knjiga knjiga) {
		this.knjige.remove(knjiga);
	}

	public Knjiga nadjiKnjigu(int id) {
		for (Knjiga knjiga: knjige) {
			if (knjiga.getID() == id) {
				return knjiga;
			}
		}
		return null;
	}
	
	public Zaposleni login(String korisnickoIme,String korisnickaSifra) {
		for (Zaposleni zaposlen: zaposleni) {
			if(zaposlen.getKorisnickoIme().equalsIgnoreCase(korisnickoIme)
					&& zaposlen.getKorisnickaSifra().equals(korisnickaSifra)
					&& !zaposlen.isObrisan()) {
				return zaposlen;	
			}
		}
		return null;
	}

	public ArrayList<Zaposleni> getZaposleni(){
		return zaposleni;
	}
	
	public ArrayList<Knjiga> getKnjige(){
		return knjige;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getRadnoVreme() {
		return radnoVreme;
	}

	public void setRadnoVreme(String radnoVreme) {
		this.radnoVreme = radnoVreme;
	}

	public void setZaposleni(ArrayList<Zaposleni> zaposleni) {
		this.zaposleni = zaposleni;
	}

	public void setKnjige(ArrayList<Knjiga> knjige) {
		this.knjige = knjige;
	}

	public ArrayList<Clan> getClanovi() {
		return clanovi;
	}

	public void setClanovi(ArrayList<Clan> clanovi) {
		this.clanovi = clanovi;
	}
}
