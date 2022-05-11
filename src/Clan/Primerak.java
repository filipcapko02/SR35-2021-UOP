package Clan;

public class Primerak {
	
	protected int ID;
	protected  String brojStrana;
	protected Povez povez;
	protected String godinaStampanja;
	protected Jezik jezik;
	protected Iznajmljena iznajmljena;
	
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

	public Iznajmljena getIznajmljena() {
		return iznajmljena;
	}

	public void setIznajmljena(Iznajmljena iznajmljena) {
		this.iznajmljena = iznajmljena;
	}

	public Primerak() {
		this.ID = 0;
		this.brojStrana = "";
		this.godinaStampanja = "";
	}
	
	public Primerak(int ID, String brojStrana ,
			Povez povez,
			String godinaStampanja, Jezik jezik,
			Iznajmljena iznajmljena) {
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

	public Primerak(Primerak original) {
		this.ID = original.ID;
		this.brojStrana = original.brojStrana;
		this.povez = original.povez;
		this.godinaStampanja = original.godinaStampanja;
		this.jezik = original.jezik;
		this.iznajmljena = original.iznajmljena;
		
	}
}
