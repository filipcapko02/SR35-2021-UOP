package biblioteka;

import biblioteka_paket.Clan;
import biblioteka_paket.Knjiga;
import biblioteka_paket.Zanr;
import biblioteka_paket.Zaposleni;
import biblioteka_paket.enums.Jezik;
import biblioteka_paket.enums.Pol;
import biblioteka_paket.enums.TipClanarine;

import java.io.*;
import java.util.ArrayList;

public class Biblioteka {
	
	private String naziv;
	private String adresa;
	private String telefon;
	private String radnoVreme;
	private ArrayList<Zaposleni> zaposleni;
	private ArrayList<Knjiga> knjige;
	private ArrayList<Clan> clanovi;
	private ArrayList<Zanr> zanrovi;

	public Biblioteka() {
		this.clanovi = new ArrayList<Clan>();
		this.knjige = new ArrayList<Knjiga>();
		this.zaposleni = new ArrayList<Zaposleni>();
		this.zanrovi = new ArrayList<Zanr>();
	}


	public void ucitajZaposlene(String filename) {
		try {
			File file = new File("src/fajlovi/" + filename);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				int id = Integer.parseInt(split[0]);
				Pol pol;
				if (split[1].equals("Musko")) {
					pol = Pol.MUSKO;
				} else {
					pol = Pol.ZENSKO;
				}
				String ime = split[2];
				String prezime = split[3];
				String jmbg = split[4];
				String adresa = split[5];
				String korisnickoIme = split[6];
				String korisnickaSifra = "123";
				int plata = Integer.parseInt(split[7]);
				Zaposleni zaposleni = new Zaposleni(id, pol, ime, prezime, jmbg, adresa, korisnickoIme, korisnickaSifra, plata, false);
				this.zaposleni.add(zaposleni);
			}

			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ucitajClanove(String filename) {
		try {
			File file = new File("src/fajlovi/" + filename);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				int id = Integer.parseInt(split[0]);
				Pol pol;
				if (split[1].equals("Musko")) {
					pol = Pol.MUSKO;
				} else {
					pol = Pol.ZENSKO;
				}
				String ime = split[2];
				String prezime = split[3];
				String jmbg = split[4];
				String adresa = split[5];
				int brojClanskeKarte = Integer.parseInt(split[6]);
				TipClanarine tipClanarine = null;
				if (split[7].equals("ostali")) {
					tipClanarine = TipClanarine.OSTALI;
				}
				String datumUplate = split[8];
				int brojMeseci = Integer.parseInt(split[9]);
				boolean active = split[10].equals("Aktivan");

				Clan clan = new Clan(id, pol, ime, prezime, jmbg, adresa, brojClanskeKarte ,tipClanarine, datumUplate, brojMeseci, active);
				this.clanovi.add(clan);
			}

			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ucitajKnjige(String filename) {
		try {
			File file = new File("src/fajlovi/" + filename);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				int id = Integer.parseInt(split[0]);
				String naslov = split[1];
				String imePisca = split[2];
				String prezimePisca = split[3];
				String datumObjave = split[4];
				Jezik jezik = Jezik.valueOf(split[5]);
				String opis = split[6];
				Zanr zanr = nadjiZanr(split[7]);
				if (zanr == null) {
					zanr = new Zanr(split[7], split[8]);
					this.zanrovi.add(zanr);
				}

				Knjiga knjiga = new Knjiga(id, naslov, imePisca, imePisca, prezimePisca, datumObjave, jezik, opis, zanr);
				this.knjige.add(knjiga);
			}

			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void snimiZaposlene(String filename) {
		File file = new File("src/fajlovi/" + filename);
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for (Zaposleni zaposleni: zaposleni) {
				sadrzaj += zaposleni.getID() + "|" + zaposleni.getPol() + "|" + zaposleni.getIme() + "|"
						+ zaposleni.getPrezime() + "|" + zaposleni.getJmbg() + "|" + zaposleni.getAdresa()
						+ "|" + zaposleni.getPlata() + "\n";
			}
			writer.write(sadrzaj);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void snimiClanove(String filename) {
		File file = new File("src/fajlovi/" + filename);
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for (Clan clan: clanovi) {
				sadrzaj += clan.getID() + "|" + clan.getPol() + "|" + clan.getIme() + "|"
						+ clan.getPrezime() + "|" + clan.getJmbg() + "|" + clan.getAdresa()
						+ "|" + clan.getBrojClanskeKarte() + "|" + clan.getTipClanarine() + "|"
						+ clan.getDatumPoslednjeUplate() + "|" + clan.getBrojMeseci()
						+ "|" + clan.isAktivan() + "\n";
			}
			writer.write(sadrzaj);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void snimiKnjige(String filename) {
		File file = new File("src/fajlovi/" + filename);
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for (Knjiga knjiga: knjige) {
				sadrzaj += knjiga.getID() + "|" + knjiga.getNaslovKnjige() + "|" + knjiga.getImePisca() + "|"
						+ knjiga.getPrezimePisca() + "|" + knjiga.getGodinaObjave() + "|" + knjiga.getJezik()
						+ "|" + knjiga.getOpis() + "|" + knjiga.getZanr() + "|"
						+ knjiga.getZanr().getOpis() + "\n";
			}
			writer.write(sadrzaj);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public Zanr nadjiZanr(String oznaka) {
		for (Zanr zanr: zanrovi) {
			if (zanr.getOznaka().equals(oznaka)) {
				return zanr;
			}
		}
		return null;
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

	public ArrayList<Zanr> getZanrovi() {
		return zanrovi;
	}

	public void setZanrovi(ArrayList<Zanr> zanrovi) {
		this.zanrovi = zanrovi;
	}
}
