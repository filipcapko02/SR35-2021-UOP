package Clan;

public abstract class Biblioteka {
	
	protected String nazivB;
	protected String adresaB;
	protected int telefonB;
	
	public Biblioteka() {
		this.nazivB = "";
		this.adresaB = "";
		this.telefonB = 0;
	}
	public Biblioteka(String nazivB, String adresaB ,
			int telefonB
			) {
		super();
		this.nazivB = nazivB;
		this.adresaB = adresaB;
		this.telefonB = telefonB;
	}
	@Override
	public String toString() {
		return "Biblioteka [nazivB=" + nazivB + ", adresaB=" + adresaB + ", telefonB=" + telefonB + "]";
	}
	public String getNazivB() {
		return nazivB;
	}
	public void setNazivB(String nazivB) {
		this.nazivB = nazivB;
	}
	public String getAdresaB() {
		return adresaB;
	}
	public void setAdresaB(String adresaB) {
		this.adresaB = adresaB;
	}
	public int getTelefonB() {
		return telefonB;
	}
	public void setTelefonB(int telefonB) {
		this.telefonB = telefonB;
	}
	public Biblioteka(Biblioteka original) {
		this.nazivB = original.nazivB;
		this.adresaB = original.adresaB;
		this.telefonB = original.telefonB;
	}
}
