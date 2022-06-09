package biblioteka_paket;

import biblioteka_paket.enums.Pol;
import biblioteka_paket.enums.TipClanarine;

public class Clan extends Osoba {

	private int brojClanskeKarte;
	private TipClanarine tipClanarine;
	private String datumPoslednjeUplate;
	private int brojMeseci;
	private boolean active;
	
	public Clan() {
		this.ID = 0;
		this.ime = "";
		this.prezime = "";
		this.jmbg = "";
		this.adresa = "";
	}

	public Clan(int ID, Pol pol, String ime, String prezime, String jmbg, String adresa, int brojClanskeKarte, TipClanarine tipClanarine, String datumPoslednjeUplate, int brojMeseci, boolean active) {
		super(ID, pol, ime, prezime, jmbg, adresa);
		this.brojClanskeKarte = brojClanskeKarte;
		this.tipClanarine = tipClanarine;
		this.datumPoslednjeUplate = datumPoslednjeUplate;
		this.brojMeseci = brojMeseci;
		this.active = active;
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

	public TipClanarine getTipClanarine() {
		return tipClanarine;
	}

	public void setTipClanarine(TipClanarine tipClanarine) {
		this.tipClanarine = tipClanarine;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
		return "Clan{" +
				", ID=" + ID +
				", pol=" + pol +
				", ime='" + ime + '\'' +
				", prezime='" + prezime + '\'' +
				", jmbg='" + jmbg + '\'' +
				", adresa='" + adresa + '\'' +
				"brojClanskeKarte=" + brojClanskeKarte +
				", tipClanarine=" + tipClanarine +
				", datumPoslednjeUplate='" + datumPoslednjeUplate + '\'' +
				", brojMeseci=" + brojMeseci +
				", active=" + active +
				'}';
	}
}
