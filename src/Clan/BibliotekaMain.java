package Clan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


import Clan.Aktivan;
import Clan.Biblioteka;
import Clan.Clan;
import Clan.Clanarina;
import Clan.Iznajmljena;
import Clan.Jezik;
import Clan.Knjiga;
import Clan.Nezaposlen;
import Clan.Pol;
import Clan.Povez;
import Clan.Primerak;
import Clan.Zanr;
import Clan.Zaposleni;

public class BibliotekaMain {
	private ArrayList<Clan> Clanovi;
	private ArrayList<Knjiga> Knjige;
	private ArrayList<Zaposleni> Zaposleni;
	
	
	public BibliotekaMain() {
		this.Clanovi = new ArrayList<Clan>();
		this.Knjige = new ArrayList<Knjiga>();
		this.Zaposleni = new ArrayList<Zaposleni>();
	}
	
	public ArrayList<Clan> getClanovi(){
		return Clanovi;
	}	
	public void dodajClana(Clan Clanovi) {
		this.Clanovi.add(Clanovi);
	}
	public void obrisiClana(Clan Clanovi) {
		this.Clanovi.remove(Clanovi);
	}
	public ArrayList<Knjiga> getKnjige() {
		return Knjige;
	}
		
	
	
}
