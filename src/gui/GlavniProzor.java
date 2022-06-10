package gui;

import biblioteka.Biblioteka;
import biblioteka_paket.Administrator;
import biblioteka_paket.Zaposleni;
import gui.clanovi.ClanoviProzor;
import gui.knjige.KnjigeProzor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GlavniProzor extends JFrame {

    private JMenuBar mainMenu = new JMenuBar();
    private JMenu korisniciMenu = new JMenu("Korisnici");
    private JMenu knjigeMenu = new JMenu("Knjige");
    private JMenu bibliotekaMenu = new JMenu("Biblioteka");
    private JMenuItem administratoriItem = new JMenuItem("Administratori");
    private JMenuItem bibliotekariItem = new JMenuItem("Bibliotekari");
    private JMenuItem clanoviItem = new JMenuItem("Clanovi");
    private JMenuItem clanarineItem = new JMenuItem("Tipovi clanarine");
    private JMenuItem knjigeItem = new JMenuItem("Knjige");
    private JMenuItem zanroviItem = new JMenuItem("Zanrovi");
    private JMenuItem primerciItem = new JMenuItem("Primerci knjiga");
    private JMenuItem iznajmiljivanjaItem = new JMenuItem("Iznajmljivanja");

    private Biblioteka biblioteka;
    private Zaposleni prijavljeniKorisnik;

    public GlavniProzor(Biblioteka biblioteka, Zaposleni prijavljeniKorisnik) {
        this.biblioteka = biblioteka;
        this.prijavljeniKorisnik = prijavljeniKorisnik;
        setTitle("Zaposleni: " + prijavljeniKorisnik.getKorisnickoIme());
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initMenu();
        initActions();
    }

    private void initMenu() {
        setJMenuBar(mainMenu);
        mainMenu.add(bibliotekaMenu);
        mainMenu.add(korisniciMenu);
        mainMenu.add(knjigeMenu);
        if (prijavljeniKorisnik instanceof Administrator) {
            korisniciMenu.add(administratoriItem);
            korisniciMenu.add(bibliotekariItem);
        }
        korisniciMenu.add(clanoviItem);
        korisniciMenu.add(clanarineItem);
        knjigeMenu.add(knjigeItem);
        knjigeMenu.add(zanroviItem);
        knjigeMenu.add(primerciItem);
        knjigeMenu.add(iznajmiljivanjaItem);
    }

    private void initActions() {
        knjigeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KnjigeProzor kp = new KnjigeProzor(biblioteka);
                kp.setVisible(true);
            }
        });

        clanoviItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClanoviProzor cp = new ClanoviProzor(biblioteka);
                cp.setVisible(true);
            }
        });
    }


}
