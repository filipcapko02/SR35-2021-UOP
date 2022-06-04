package main;

import biblioteka.Biblioteka;
import biblioteka_paket.Clan;
import biblioteka_paket.Knjiga;
import biblioteka_paket.Zanr;
import biblioteka_paket.Zaposleni;
import biblioteka_paket.enums.Jezik;
import biblioteka_paket.enums.Pol;

import java.util.ArrayList;

public class Biblioteka_main {

	private static final String CLANOVI_FAJL = "Clanovi.txt";
	private static final String KNJIGE_FAJL = "Knjige.txt";
	private static final String ZAPOSLENI_FAJL = "Zaposleni.txt";
	
	
	public static void main(String[] args) {

		Biblioteka biblioteka = new Biblioteka();
		biblioteka.ucitajZaposlene(ZAPOSLENI_FAJL);
		biblioteka.ucitajClanove(CLANOVI_FAJL);
		biblioteka.ucitajKnjige(KNJIGE_FAJL);

		System.out.println("PODACI UCITANI IZ DATOTEKA:");
		System.out.println("----------------------------------------------");
		ispisiSvePodatke(biblioteka);
		System.out.println("----------------------------------------------");
		
		System.out.println("Dodavanje test podataka...");
		Knjiga testKnjiga = new Knjiga(003, "Test Knjiga", "Test Knjiga Original",
				"TestIme", "TestPrezime", "2021", Jezik.SRPSKI, "TestOpis",
				new Zanr("Komedija", "OpisKomedije"));
		biblioteka.dodajKnjigu(testKnjiga);


		
		System.out.println("Snimanje dodanih podataka...");
		biblioteka.snimiKnjige(KNJIGE_FAJL);
		biblioteka.snimiZaposlene(ZAPOSLENI_FAJL);
		biblioteka.snimiClanove(CLANOVI_FAJL);
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
	}
}