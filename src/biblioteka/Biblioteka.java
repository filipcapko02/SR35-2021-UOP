package biblioteka;

import biblioteka_paket.*;
import biblioteka_paket.enums.Jezik;
import biblioteka_paket.enums.Pol;
import biblioteka_paket.enums.Povez;

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
	private ArrayList<Clanarina> clanarine;
	private ArrayList<PrimerakKnjige> primerciKnjiga;
	private ArrayList<Iznajmljivanje> iznajmljivanja;

	public Biblioteka() {
		this.clanovi = new ArrayList<Clan>();
		this.knjige = new ArrayList<Knjiga>();
		this.zaposleni = new ArrayList<Zaposleni>();
		this.zanrovi = new ArrayList<Zanr>();
		this.clanarine = new ArrayList<>();
		this.primerciKnjiga = new ArrayList<>();
		this.iznajmljivanja = new ArrayList<>();
	}

	public void ucitajClanarine(String filename) {
		try {
			File file = new File("src/fajlovi/" + filename);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				Clanarina clanarina = new Clanarina(Integer.parseInt(split[0]), split[1], Double.parseDouble(split[2]));
				clanarine.add(clanarina);
			}

			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ucitajZanrove(String filename) {
		try {
			File file = new File("src/fajlovi/" + filename);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				Zanr zanr = new Zanr(Integer.parseInt(split[0]), split[1], split[2]);
				zanrovi.add(zanr);
			}

			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
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
				String korisnickaSifra = split[7];
				int plata = Integer.parseInt(split[8]);
				String uloga = split[9];
				Zaposleni zaposleni;
				if (uloga.equals("Administrator")) {
					zaposleni = new Administrator(id, pol, ime, prezime, jmbg, adresa, korisnickoIme, korisnickaSifra, plata, false);
				} else {
					zaposleni = new Bibliotekar(id, pol, ime, prezime, jmbg, adresa, korisnickoIme, korisnickaSifra, plata, false);
				}
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
				if (split[1].equals("MUSKO")) {
					pol = Pol.MUSKO;
				} else {
					pol = Pol.ZENSKO;
				}
				String ime = split[2];
				String prezime = split[3];
				String jmbg = split[4];
				String adresa = split[5];
				int brojClanskeKarte = Integer.parseInt(split[6]);
				Clanarina clanarina = nadjiClanarinu(split[7]);
				String datumUplate = split[8];
				int brojMeseci = Integer.parseInt(split[9]);
				boolean active = split[10].equals("active");


				Clan clan = new Clan(id, pol, ime, prezime, jmbg, adresa, brojClanskeKarte, clanarina, datumUplate, brojMeseci, active);
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

				Knjiga knjiga = new Knjiga(id, naslov, imePisca, imePisca, prezimePisca, datumObjave, jezik, opis, zanr);
				this.knjige.add(knjiga);
			}

			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ucitajPrimerke(String filename) {
		try {
			File file = new File("src/fajlovi/" + filename);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				int id = Integer.parseInt(split[0]);
				Knjiga knjiga = nadjiKnjigu(Integer.parseInt(split[1]));
				int brojStrana = Integer.parseInt(split[2]);
				Povez povez = Povez.valueOf(split[3]);
				String godinaStampanja = split[4];
				Jezik jezik = Jezik.valueOf(split[5]);
				boolean iznajmljena = Boolean.parseBoolean(split[6]);

				PrimerakKnjige primerakKnjige = new PrimerakKnjige(id, knjiga, brojStrana, povez, godinaStampanja, jezik, iznajmljena);
				this.primerciKnjiga.add(primerakKnjige);
			}

			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ucitajIznajmljivanja(String filename) {
		try {
			File file = new File("src/fajlovi/" + filename);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				int id = Integer.parseInt(split[0]);
				Zaposleni zaposleni = nadjiZaposlenog(split[1]);
				Clan clan = nadjiClana(Integer.parseInt(split[2]));
				String datumIznajmljivanja = split[3];
				String datumVracanja = split[4];
				PrimerakKnjige primerakKnjige = nadjiPrimerakKnjige(Integer.parseInt(split[5]));

				Iznajmljivanje iznajmljivanje = new Iznajmljivanje(id, zaposleni, clan, datumIznajmljivanja, datumVracanja, primerakKnjige);
				this.iznajmljivanja.add(iznajmljivanje);
			}

			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void snimiClanarine(String filename) {
		File file = new File("src/fajlovi/" + filename);
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for (Clanarina clanarina: clanarine) {
				sadrzaj += clanarina.getID() + "|" + clanarina.getNaziv() + "|" + clanarina.getCena() + "\n";
			}
			writer.write(sadrzaj);
			writer.close();
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
						+ "|" + zaposleni.getKorisnickoIme() + "|" + zaposleni.getKorisnickaSifra() + "|"
						+ zaposleni.getPlata() + "|" + zaposleni.getClass().getSimpleName() + "\n";
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
						+ "|" + clan.getBrojClanskeKarte() + "|" + clan.getClanarina().getNaziv() + "|"
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
						+ "|" + knjiga.getOpis() + "|" + knjiga.getZanr().getOznaka() + "|"
						+ knjiga.getZanr().getOpis() + "\n";
			}
			writer.write(sadrzaj);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void snimiPrimerke(String filename) {
		File file = new File("src/fajlovi/" + filename);
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for (PrimerakKnjige knjiga: primerciKnjiga) {
				sadrzaj += knjiga.getID() + "|" + knjiga.getKnjiga().getID() + "|" + knjiga.getBrojStrana() + "|"
						+ knjiga.getPovez() + "|" + knjiga.getGodinaStampanja() + "|" + knjiga.getJezik()
						+ "|" + knjiga.isIznajmljena() + "\n";
			}
			writer.write(sadrzaj);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void snimiIznajmljivanja(String filename) {
		File file = new File("src/fajlovi/" + filename);
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for (Iznajmljivanje iznajmljivanje: iznajmljivanja) {
				sadrzaj += iznajmljivanje.getID() + "|" + iznajmljivanje.getZaposleni().getKorisnickoIme() + "|"
						+ iznajmljivanje.getClan().getID() + "|" + iznajmljivanje.getDatumIznajmljivanja() + "|"
						+ iznajmljivanje.getDatumVracanja() + "|"
						+ iznajmljivanje.getPrimerakKnjige().getID() + "\n";
			}
			writer.write(sadrzaj);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void snimiZanrove(String filename) {
		File file = new File("src/fajlovi/" + filename);
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for (Zanr zanr: zanrovi) {
				sadrzaj += zanr.getID() + "|" + zanr.getOznaka() + "|"
						+ zanr.getOpis() + "\n";
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

	public void obrisiZanr(Zanr zanr) {
		this.zanrovi.remove(zanr);
	}

	public Clanarina nadjiClanarinu(String naziv) {
		for (Clanarina clanarina: clanarine) {
			if (clanarina.getNaziv().equals(naziv)) {
				return clanarina;
			}
		}
		return null;
	}


	public boolean dodajZaposlenog(Zaposleni zaposlen) {
		System.out.println(zaposlen);
		if (!this.zaposleni.contains(zaposlen)) {
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

	public boolean dodajZanr(Zanr zanr) {
		if (!this.zanrovi.contains(zanr)) {
			this.zanrovi.add(zanr);
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

	public boolean dodajPrimerakKnjige(PrimerakKnjige primerakKnjige) {
		if (!this.primerciKnjiga.contains(primerakKnjige)) {
			this.primerciKnjiga.add(primerakKnjige);
			return true;
		}
		return false;
	}

	public boolean dodajIznajmljivanje(Iznajmljivanje iznajmljivanje) {
		if (!this.iznajmljivanja.contains(iznajmljivanje)) {
			this.iznajmljivanja.add(iznajmljivanje);
			return true;
		}
		return false;
	}

	public void obrisiIznajmljivanje(Iznajmljivanje iznajmljivanje) {
		this.iznajmljivanja.remove(iznajmljivanje);
	}

	public void obrisiKnjigu(Knjiga knjiga) {
		this.knjige.remove(knjiga);
	}

	public void obrisiPrimerakKnjige(PrimerakKnjige primerakKnjige) {
		this.primerciKnjiga.remove(primerakKnjige);
	}

	public Knjiga nadjiKnjigu(int id) {
		for (Knjiga knjiga: knjige) {
			if (knjiga.getID() == id) {
				return knjiga;
			}
		}
		return null;
	}

	public PrimerakKnjige nadjiPrimerakKnjige(int id) {
		for (PrimerakKnjige knjiga: primerciKnjiga) {
			if (knjiga.getID() == id) {
				return knjiga;
			}
		}
		return null;
	}

	public Iznajmljivanje nadjiIznajmljivanje(int id) {
		for (Iznajmljivanje iznajmljivanje: iznajmljivanja) {
			if (iznajmljivanje.getID() == id) {
				return iznajmljivanje;
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

	public ArrayList<Zaposleni> getAdmini() {
		ArrayList<Zaposleni> admini = new ArrayList<>();
		for (Zaposleni zaposleni: zaposleni) {
			if (zaposleni instanceof Administrator) {
				admini.add(zaposleni);
			}
		}
		return admini;
	}

	public ArrayList<Zaposleni> getBibliotekari() {
		ArrayList<Zaposleni> bibliotekari = new ArrayList<>();
		for (Zaposleni zaposleni: zaposleni) {
			if (zaposleni instanceof Bibliotekar) {
				bibliotekari.add(zaposleni);
			}
		}
		return bibliotekari;
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

	public ArrayList<Clanarina> getClanarine() {
		return clanarine;
	}

	public void setClanarine(ArrayList<Clanarina> clanarine) {
		this.clanarine = clanarine;
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

	public ArrayList<PrimerakKnjige> getPrimerciKnjiga() {
		return primerciKnjiga;
	}

	public void setPrimerciKnjiga(ArrayList<PrimerakKnjige> primerciKnjiga) {
		this.primerciKnjiga = primerciKnjiga;
	}

	public ArrayList<Iznajmljivanje> getIznajmljivanja() {
		return iznajmljivanja;
	}

	public void setIznajmljivanja(ArrayList<Iznajmljivanje> iznajmljivanja) {
		this.iznajmljivanja = iznajmljivanja;
	}
}
