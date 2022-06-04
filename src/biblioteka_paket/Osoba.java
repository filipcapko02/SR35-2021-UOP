package biblioteka_paket;

import biblioteka_paket.enums.Pol;

import java.util.Objects;

public abstract class Osoba {
	
	protected int ID;
	protected Pol pol;
	protected String ime;
	protected String prezime;
	protected String jmbg;
	protected String adresa;
	
	
	public Osoba() {
		this.ID = 0;
		this.ime = "";
		this.prezime = "";
		this.jmbg = "";
		this.adresa = "";
	}
	
	public Osoba(int ID, Pol pol,
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

	public Osoba(Osoba original) {
		this.ID = original.ID;
		this.pol = original.pol;
		this.ime = original.ime;
		this.prezime = original.prezime;
		this.jmbg = original.jmbg;
		this.adresa = original.adresa;
		
	}
	@Override
	public String toString() {
		return "Osoba [ID=" + ID + ", pol=" + pol + ", ime=" + ime + ", prezime=" + prezime + ", JMBG=" + jmbg
				+ ", adresa=" + adresa + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Osoba osoba = (Osoba) o;
		return ID == osoba.ID;
	}
}
