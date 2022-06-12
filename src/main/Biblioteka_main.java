package main;

import biblioteka.Biblioteka;
import biblioteka_paket.*;
import biblioteka_paket.enums.Jezik;
import biblioteka_paket.enums.Pol;
import gui.LoginProzor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Biblioteka_main {

	public static final String ZANROVI_FAJL = "Zanrovi.txt";
	public static final String CLANARINE_FAJL = "Clanarine.txt";
	public static final String CLANOVI_FAJL = "Clanovi.txt";
	public static final String KNJIGE_FAJL = "Knjige.txt";
	public static final String PRIMERCI_FAJL = "Primerci.txt";
	public static final String ZAPOSLENI_FAJL = "Zaposleni.txt";
	public static final String IZNAJMLJIVANJA_FAJL = "Iznajmljivanja.txt";
	
	
	public static void main(String[] args) {

		Biblioteka biblioteka = new Biblioteka();
		biblioteka.ucitajZanrove(ZANROVI_FAJL);
		biblioteka.ucitajClanarine(CLANARINE_FAJL);
		biblioteka.ucitajZaposlene(ZAPOSLENI_FAJL);
		biblioteka.ucitajClanove(CLANOVI_FAJL);
		biblioteka.ucitajKnjige(KNJIGE_FAJL);
		biblioteka.ucitajPrimerke(PRIMERCI_FAJL);
		biblioteka.ucitajIznajmljivanja(IZNAJMLJIVANJA_FAJL);

		System.out.println("PODACI UCITANI IZ DATOTEKA");
		
		System.out.println("Dodavanje test podataka...");
		Knjiga testKnjiga = new Knjiga(003, "Test Knjiga", "Test Knjiga Original",
				"TestIme", "TestPrezime", "2021", Jezik.SRPSKI, "TestOpis",
				biblioteka.getZanrovi().get(0));
		biblioteka.dodajKnjigu(testKnjiga);


		LoginProzor lp = new LoginProzor(biblioteka);
		lp.setVisible(true);


	}
}