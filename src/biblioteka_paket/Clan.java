package biblioteka_paket;

import biblioteka_paket.enums.Pol;

public class Clan extends Osoba {

	private int brojClanskeKarte;
	private Clanarina clanarina;
	private String datumPoslednjeUplate;
	private int brojMeseci;
	private boolean aktivan;
	
	public Clan() {
		this.ID = 0;
		this.ime = "";
		this.prezime = "";
		this.jmbg = "";
		this.adresa = "";
	}

	public Clan(int ID, Pol pol, String ime, String prezime, String jmbg, String adresa, int brojClanskeKarte, Clanarina clanarina, String datumPoslednjeUplate, int brojMeseci, boolean aktivan) {
		super(ID, pol, ime, prezime, jmbg, adresa);
		this.brojClanskeKarte = brojClanskeKarte;
		this.clanarina = clanarina;
		this.datumPoslednjeUplate = datumPoslednjeUplate;
		this.brojMeseci = brojMeseci;
		this.aktivan = aktivan;
	}
	
	public Clan(int ID, Pol pol ,
			String ime,
			String prezime, String jmbg,
			String adresa) {
		super();
		this.ID = ID;
		this.pol = pol;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.adresa = adresa;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Pol getPol() {
		return pol;
	}

	public void setPol(Pol pol) {
		this.pol = pol;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public int getBrojClanskeKarte() {
		return brojClanskeKarte;
	}

	public void setBrojClanskeKarte(int brojClanskeKarte) {
		this.brojClanskeKarte = brojClanskeKarte;
	}

	public Clanarina getClanarina() {
		return clanarina;
	}

	public void setClanarina(Clanarina clanarina) {
		this.clanarina = clanarina;
	}

	public String getDatumPoslednjeUplate() {
		return datumPoslednjeUplate;
	}

	public void setDatumPoslednjeUplate(String datumPoslednjeUplate) {
		this.datumPoslednjeUplate = datumPoslednjeUplate;
	}

	public int getBrojMeseci() {
		return brojMeseci;
	}

	public void setBrojMeseci(int brojMeseci) {
		this.brojMeseci = brojMeseci;
	}

	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}

	public Clan(Clan original) {
		this.ID = original.ID;
		this.pol = original.pol;
		this.ime = original.ime;
		this.prezime = original.prezime;
		this.jmbg = original.jmbg;
		this.adresa = original.adresa;
		
	}


	@Override
	public String toString() {
		return ime + " " + prezime;
	}
}
