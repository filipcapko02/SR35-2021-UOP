package gui.zaposleni;

import biblioteka_paket.Clan;
import biblioteka_paket.Zaposleni;
import gui.clanovi.ClanoviProzor;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IzmeniZaposlenogProzor extends JFrame {

    private JLabel lblIme = new JLabel("Ime");
    private JLabel lblPrezime = new JLabel("Prezime");
    private JLabel lblJmbg = new JLabel("JMBG");
    private JLabel lblAdresa = new JLabel("Adresa");
    private JLabel lblKorisnickoIme = new JLabel("Korisnicko ime");
    private JLabel lblKorisnickaSifra = new JLabel("Korisnicka sifra");
    private JLabel lblPlata = new JLabel("Plata");
    private JTextField txtIme;
    private JTextField txtPrezime;
    private JTextField txtJmbg;
    private JTextField txtAdresa;
    private JTextField txtKorisnickoIme;
    private JTextField txtKorisnickaSifra;
    private JTextField txtPlata;
    private JButton btnPromeni = new JButton("Promeni");
    private JButton btnCancel = new JButton("Cancel");

    private Zaposleni zaposleni;
    private ZaposleniProzor zaposleniProzor;

    public IzmeniZaposlenogProzor(Zaposleni zaposleni, ZaposleniProzor zaposleniProzor) {
        this.zaposleni = zaposleni;
        this.zaposleniProzor = zaposleniProzor;
        setTitle("Zaposleni " + zaposleni.getID());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
        pack();
    }

    private void initGUI() {
        txtIme = new JTextField(zaposleni.getIme(), 20);
        txtPrezime = new JTextField(zaposleni.getPrezime(), 20);
        txtAdresa = new JTextField(zaposleni.getAdresa(), 20);
        txtJmbg = new JTextField(zaposleni.getJmbg(), 20);
        txtKorisnickoIme = new JTextField(zaposleni.getKorisnickoIme(), 20);
        txtKorisnickaSifra = new JTextField(zaposleni.getKorisnickaSifra(), 20);
        txtPlata = new JTextField(String.valueOf(zaposleni.getPlata()), 20);


        MigLayout mig = new MigLayout("wrap 2", "[]5[]", "[]10[][]10[]10[]10[]10[]10[]");
        setLayout(mig);

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
        add(btnPromeni);
        add(btnCancel);

        getRootPane().setDefaultButton(btnPromeni);
    }

    private void initActions() {
        btnPromeni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zaposleni.setIme(txtIme.getText());
                zaposleni.setPrezime(txtPrezime.getText());
                zaposleni.setJmbg(txtJmbg.getText());
                zaposleni.setAdresa(txtAdresa.getText());
                zaposleni.setKorisnickaSifra(txtKorisnickaSifra.getText());
                zaposleni.setKorisnickoIme(txtKorisnickoIme.getText());
                zaposleni.setPlata(Integer.parseInt(txtPlata.getText()));
                zaposleniProzor.updateTable();
                IzmeniZaposlenogProzor.this.dispose();
                IzmeniZaposlenogProzor.this.setVisible(false);
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IzmeniZaposlenogProzor.this.dispose();
                IzmeniZaposlenogProzor.this.setVisible(false);
            }
        });
    }
}
