package biblioteka_paket;

import biblioteka_paket.enums.Jezik;
import biblioteka_paket.enums.Povez;

public class PrimerakKnjige {
	
	private int ID;
	private Knjiga knjiga;
	private String brojStrana;
	private Povez povez;
	private String godinaStampanja;
	private Jezik jezik;
	private boolean iznajmljena;
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getBrojStrana() {
		return brojStrana;
	}

	public void setBrojStrana(String brojStrana) {
		this.brojStrana = brojStrana;
	}

	public Povez getPovez() {
		return povez;
	}

	public void setPovez(Povez povez) {
		this.povez = povez;
	}

	public String getGodinaStampanja() {
		return godinaStampanja;
	}

	public void setGodinaStampanja(String godinaStampanja) {
		this.godinaStampanja = godinaStampanja;
	}

	public Jezik getJezik() {
		return jezik;
	}

	public void setJezik(Jezik jezik) {
		this.jezik = jezik;
	}

	public boolean isIznajmljena() {
		return iznajmljena;
	}

	public void setIznajmljena(boolean iznajmljena) {
		this.iznajmljena = iznajmljena;
	}

	public PrimerakKnjige() {
		this.ID = 0;
		this.brojStrana = "";
		this.godinaStampanja = "";
	}
	
	public PrimerakKnjige(int ID, String brojStrana ,
						  Povez povez,
						  String godinaStampanja, Jezik jezik,
						  boolean iznajmljena) {
		super();
		this.ID = ID;
		this.brojStrana = brojStrana;
		this.povez = povez;
		this.godinaStampanja = godinaStampanja;
		this.jezik = jezik;
		this.iznajmljena = iznajmljena;
	}
	@Override
	public String toString() {
		return "Primerak [ID=" + ID + ", brojStrana=" + brojStrana + ", povez=" + povez + ", godinaStampanja="
				+ godinaStampanja + ", jezik=" + jezik + ", iznajmljena=" + iznajmljena + "]";
	}

	public PrimerakKnjige(PrimerakKnjige original) {
		this.ID = original.ID;
		this.brojStrana = original.brojStrana;
		this.povez = original.povez;
		this.godinaStampanja = original.godinaStampanja;
		this.jezik = original.jezik;
		this.iznajmljena = original.iznajmljena;
		
	}
}
