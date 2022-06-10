package gui.knjige;

import biblioteka_paket.Knjiga;
import biblioteka_paket.Zanr;
import biblioteka_paket.enums.Jezik;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodajKnjiguProzor extends JFrame {

    private JLabel lblNaslov = new JLabel("Naslov knjige");
    private JLabel lblImePisca = new JLabel("Ime pisca");
    private JLabel lblPrezimePisca = new JLabel("Prezime pisca");
    private JLabel lblGodina = new JLabel("Godina objave");
    private JLabel lblJezik = new JLabel("Jezik");
    private JLabel lblOpis = new JLabel("Opis");
    private JLabel lblZanr = new JLabel("Zanr");
    private JTextField txtNaslov;
    private JTextField txtIme;
    private JTextField txtPrezime;
    private JTextField txtGodina;
    private JTextField txtJezik;
    private JTextField txtOpis;
    private JTextField txtZanr;
    private JButton btnDodaj = new JButton("Dodaj");
    private JButton btnCancel = new JButton("Cancel");

    private KnjigeProzor knjigeProzor;

    public DodajKnjiguProzor(KnjigeProzor knjigeProzor) {
        this.knjigeProzor = knjigeProzor;
        setTitle("Dodaj");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300, 300);
        initGUI();
        initActions();
        pack();
    }

    private void initGUI() {
        txtNaslov = new JTextField("", 20);
        txtIme = new JTextField("", 20);
        txtPrezime = new JTextField("", 20);
        txtGodina = new JTextField("", 20);
        txtJezik = new JTextField("", 20);
        txtOpis = new JTextField("", 20);
        txtZanr = new JTextField("", 20);


        MigLayout mig = new MigLayout("wrap 2", "[]5[]", "[]10[][]10[]10[]10[]10[]");
        setLayout(mig);

        add(lblNaslov);
        add(txtNaslov);
        add(lblImePisca);
        add(txtIme);
        add(lblPrezimePisca);
        add(txtPrezime);
        add(lblGodina);
        add(txtGodina);
        add(lblOpis);
        add(txtOpis);
        add(lblJezik);
        add(txtJezik);
        add(lblZanr);
        add(txtZanr);
        add(btnDodaj);
        add(btnCancel);

        getRootPane().setDefaultButton(btnCancel);
    }

    private void initActions() {
        btnDodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Knjiga knjiga = new Knjiga();
                knjiga.setNaslovKnjige(txtNaslov.getText());
                knjiga.setImePisca(txtIme.getText());
                knjiga.setPrezimePisca(txtPrezime.getText());
                knjiga.setGodinaObjave(txtGodina.getText());
                knjiga.setOpis(txtOpis.getText());
                knjiga.setJezik(Jezik.valueOf(txtJezik.getText()));
                knjiga.setZanr(new Zanr("zanr", "opisZanra"));
                knjiga.setID(1512);
                knjigeProzor.getBiblioteka().dodajKnjigu(knjiga);
                knjigeProzor.updateTable();
                DodajKnjiguProzor.this.dispose();
                DodajKnjiguProzor.this.setVisible(false);
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DodajKnjiguProzor.this.dispose();
                DodajKnjiguProzor.this.setVisible(false);
            }
        });
    }

}
