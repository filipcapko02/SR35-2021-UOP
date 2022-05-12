package Clan;

public class Clanarina {
	protected int ID;
	protected String naziv;
	protected double cena;
	
	
	public Clanarina() {
		this.ID = 0;
		this.naziv = "";
		this.cena = 0;
	}


	public Clanarina(int iD, String naziv, double cena) {
		super();
		this.ID = iD;
		this.naziv = naziv;
		this.cena = cena;
	}
	
	public Clanarina(Clanarina original) {
		this.ID = original.ID;
		this.naziv = original.naziv;
		this.cena = original.cena;
	}



	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public double getCena() {
		return cena;
	}


	public void setCena(double cena) {
		this.cena = cena;
	}
	

	@Override
	public String toString() {
		return "TipClanarine [ID=" + ID + ", naziv=" + naziv + ", cena=" + cena + "]";
	}

}
