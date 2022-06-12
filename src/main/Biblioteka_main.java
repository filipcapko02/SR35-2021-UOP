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

	private static final String ZANROVI_FAJL = "Zanrovi.txt";
	private static final String CLANARINE_FAJL = "Clanarine.txt";
	private static final String CLANOVI_FAJL = "Clanovi.txt";
	private static final String KNJIGE_FAJL = "Knjige.txt";
	private static final String PRIMERCI_FAJL = "Primerci.txt";
	private static final String ZAPOSLENI_FAJL = "Zaposleni.txt";
	private static final String IZNAJMLJIVANJA_FAJL = "Iznajmljivanja.txt";
	
	
	public static void main(String[] args) {

		Biblioteka biblioteka = new Biblioteka();
		biblioteka.ucitajZanrove(ZANROVI_FAJL);
		biblioteka.ucitajClanarine(CLANARINE_FAJL);
		biblioteka.ucitajZaposlene(ZAPOSLENI_FAJL);
		biblioteka.ucitajClanove(CLANOVI_FAJL);
		biblioteka.ucitajKnjige(KNJIGE_FAJL);
		biblioteka.ucitajPrimerke(PRIMERCI_FAJL);
		biblioteka.ucitajIznajmljivanja(IZNAJMLJIVANJA_FAJL);

		System.out.println("PODACI UCITANI IZ DATOTEKA:");
		System.out.println("----------------------------------------------");
		ispisiSvePodatke(biblioteka);
		System.out.println("----------------------------------------------");
		
		System.out.println("Dodavanje test podataka...");
		Knjiga testKnjiga = new Knjiga(003, "Test Knjiga", "Test Knjiga Original",
				"TestIme", "TestPrezime", "2021", Jezik.SRPSKI, "TestOpis",
				biblioteka.getZanrovi().get(0));
		biblioteka.dodajKnjigu(testKnjiga);


		
		System.out.println("Snimanje dodanih podataka...");
		biblioteka.snimiClanarine(CLANARINE_FAJL);
		biblioteka.snimiKnjige(KNJIGE_FAJL);
		biblioteka.snimiZaposlene(ZAPOSLENI_FAJL);
		biblioteka.snimiClanove(CLANOVI_FAJL);


		LoginProzor lp = new LoginProzor(biblioteka);
		lp.setVisible(true);


	}
	
	public static void ispisiSvePodatke(Biblioteka biblioteka) {
		for(Knjiga knjiga : biblioteka.getKnjige()) {
			System.out.println(knjiga + "\n");
		}
		
		for(Clan clan : biblioteka.getClanovi()) {
			System.out.println(clan + "\n");
		}

		for(Zaposleni zaposleni : biblioteka.getZaposleni()) {
			System.out.println(zaposleni + "\n");
		}

		for (PrimerakKnjige primerakKnjige: biblioteka.getPrimerciKnjiga()) {
			System.out.println(primerakKnjige + "\n");
		}

		for (Iznajmljivanje iznajmljivanje: biblioteka.getIznajmljivanja()) {
			System.out.println(iznajmljivanje + "\n");
		}
	}
}