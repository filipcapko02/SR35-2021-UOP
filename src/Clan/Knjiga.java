package Clan;

import java.util.ArrayList;

public abstract class Knjiga {
	
	protected int ID;
	protected String naslovKnjige;
	protected String imePisca;
	protected String prezimePisca;
	protected String godinaObjave;
	protected Jezik jezik;
	protected String opis;
	protected Zanr zanr;
	
	public Knjiga() {
		this.ID = 0;
		this.naslovKnjige = "";
		this.imePisca = "";
		this.prezimePisca = "";
		this.godinaObjave = "";
		this.opis = ""; 
		
	}
	public Knjiga(int ID,  String naslovKnjige ,
			String imePisca,
			String prezimePisca, String godinaObjave,
			Jezik jezik,String opis,Zanr zanr) {
		super();
		this.ID = ID;
		this.naslovKnjige = naslovKnjige;
		this.imePisca = imePisca;
		this.prezimePisca = prezimePisca;
		this.godinaObjave = godinaObjave;
		this.jezik = jezik;
		this.opis = opis;
		this.zanr = zanr;
	}
	public Knjiga(Knjiga original) {
		this.ID = original.ID;
		this.naslovKnjige = original.naslovKnjige;
		this.imePisca = original.imePisca;
		this.prezimePisca = original.prezimePisca;
		this.godinaObjave = original.godinaObjave;
		this.jezik = original.jezik;
		this.opis = original.opis;
		this.zanr = original.zanr;
		
	}
	@Override
	public String toString() {
		return "Knjiga [ID=" + ID + ", naslovKnjige=" + naslovKnjige + ", imePisca=" + imePisca + ", prezimePisca="
				+ prezimePisca + ", godinaObjave=" + godinaObjave + ", jezik=" + jezik + ", opis=" + opis + ", zanr="
				+ zanr + "]";
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNaslovKnjige() {
		return naslovKnjige;
	}
	public void setNaslovKnjige(String naslovKnjige) {
		this.naslovKnjige = naslovKnjige;
	}
	public String getImePisca() {
		return imePisca;
	}
	public void setImePisca(String imePisca) {
		this.imePisca = imePisca;
	}
	public String getPrezimePisca() {
		return prezimePisca;
	}
	public void setPrezimePisca(String prezimePisca) {
		this.prezimePisca = prezimePisca;
	}
	public String getGodinaObjave() {
		return godinaObjave;
	}
	public void setGodinaObjave(String godinaObjave) {
		this.godinaObjave = godinaObjave;
	}
	public Jezik getJezik() {
		return jezik;
	}
	public void setJezik(Jezik jezik) {
		this.jezik = jezik;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public Zanr getZanr() {
		return zanr;
	}
	public void setZanr(Zanr zanr) {
		this.zanr = zanr;
	}
	
}
