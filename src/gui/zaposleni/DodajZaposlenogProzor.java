package gui.zaposleni;

import biblioteka.Biblioteka;
import biblioteka_paket.Administrator;
import biblioteka_paket.Bibliotekar;
import biblioteka_paket.Zaposleni;
import biblioteka_paket.enums.Pol;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodajZaposlenogProzor extends JFrame {

    private JLabel lblId = new JLabel("ID");
    private JLabel lblPol = new JLabel("Pol");
    private JLabel lblIme = new JLabel("Ime");
    private JLabel lblPrezime = new JLabel("Prezime");
    private JLabel lblJmbg = new JLabel("JMBG");
    private JLabel lblAdresa = new JLabel("Adresa");
    private JLabel lblKorisnickoIme = new JLabel("Korisnicko ime");
    private JLabel lblKorisnickaSifra = new JLabel("Korisnicka sifra");
    private JLabel lblPlata = new JLabel("Plata");
    private JTextField txtId;
    private JComboBox<Pol> cbPol;
    private JTextField txtIme;
    private JTextField txtPrezime;
    private JTextField txtJmbg;
    private JTextField txtAdresa;
    private JTextField txtKorisnickoIme;
    private JTextField txtKorisnickaSifra;
    private JTextField txtPlata;
    private JButton btnDodaj = new JButton("Dodaj");
    private JButton btnCancel = new JButton("Cancel");

    private ZaposleniProzor zaposleniProzor;
    private Biblioteka biblioteka;

    public DodajZaposlenogProzor(ZaposleniProzor zaposleniProzor, Biblioteka biblioteka) {
        this.zaposleniProzor = zaposleniProzor;
        this.biblioteka = biblioteka;
        setTitle("Dodaj zaposlenog");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
        pack();
    }

    private void initGUI() {
        txtId = new JTextField("", 20);
        Pol[] polovi = new Pol[2];
        polovi[0] = Pol.MUSKO;
        polovi[1] = Pol.ZENSKO;
        cbPol = new JComboBox<>(polovi);
        txtIme = new JTextField("", 20);
        txtPrezime = new JTextField("", 20);
        txtAdresa = new JTextField("", 20);
        txtJmbg = new JTextField("", 20);
        txtKorisnickoIme = new JTextField("", 20);
        txtKorisnickaSifra = new JTextField("", 20);
        txtPlata = new JTextField("", 20);


        MigLayout mig = new MigLayout("wrap 2", "[]5[]", "[]10[][]10[]10[]10[]10[]10[]");
        setLayout(mig);

        add(lblId);
        add(txtId);
        add(lblPol);
        add(cbPol);
        add(lblIme);
        add(txtIme);
        add(lblPrezime);
        add(txtPrezime);
        add(lblJmbg);
        add(txtJmbg);
        add(lblAdresa);
        add(txtAdresa);
        add(lblKorisnickoIme);
        add(txtKorisnickoIme);
        add(lblKorisnickaSifra);
        add(txtKorisnickaSifra);
        add(lblPlata);
        add(txtPlata);
        add(btnDodaj);
        add(btnCancel);

        getRootPane().setDefaultButton(btnDodaj);
    }

    private void initActions() {
        btnDodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Zaposleni zaposleni;
                if (zaposleniProzor.getUloga().equals("administratori")) {
                    zaposleni = new Administrator();
                } else {
                    zaposleni = new Bibliotekar();
                }
                zaposleni.setID(Integer.parseInt(txtId.getText()));
                zaposleni.setPol((Pol) cbPol.getSelectedItem());
                zaposleni.setIme(txtIme.getText());
                zaposleni.setPrezime(txtPrezime.getText());
                zaposleni.setJmbg(txtJmbg.getText());
                zaposleni.setAdresa(txtAdresa.getText());
                zaposleni.setKorisnickaSifra(txtKorisnickaSifra.getText());
                zaposleni.setKorisnickoIme(txtKorisnickoIme.getText());
                zaposleni.setPlata(Integer.parseInt(txtPlata.getText()));
                zaposleniProzor.getBiblioteka().dodajZaposlenog(zaposleni);
                zaposleniProzor.updateTable();
                DodajZaposlenogProzor.this.dispose();
                DodajZaposlenogProzor.this.setVisible(false);
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DodajZaposlenogProzor.this.dispose();
                DodajZaposlenogProzor.this.setVisible(false);
            }
        });
    }
}
