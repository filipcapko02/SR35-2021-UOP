package biblioteka_paket;

public class Zanr {

	private int ID;
	private String oznaka;
	private String opis;
	
	public Zanr() {
		this.oznaka = "";
		this.opis = "";
	}

	public Zanr(int ID, String oznaka, String opis) {
		this.ID = ID;
		this.oznaka = oznaka;
		this.opis = opis;
	}

	public Zanr(Zanr original) {
		this.oznaka = original.oznaka;
		this.opis = original.opis;
	}


	@Override
	public String toString() {
		return "Zanr [oznaka=" + oznaka + ", opis=" + opis + "]";
	}

	public String getOznaka() {
		return oznaka;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}
}
