package gui.knjige;

import biblioteka_paket.Clanarina;
import biblioteka_paket.Knjiga;
import biblioteka_paket.Zanr;
import biblioteka_paket.enums.Jezik;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DodajKnjiguProzor extends JFrame {

    private JLabel lblId = new JLabel("ID");
    private JLabel lblNaslov = new JLabel("Naslov knjige");
    private JLabel lblImePisca = new JLabel("Ime pisca");
    private JLabel lblPrezimePisca = new JLabel("Prezime pisca");
    private JLabel lblGodina = new JLabel("Godina objave");
    private JLabel lblJezik = new JLabel("Jezik");
    private JLabel lblOpis = new JLabel("Opis");
    private JLabel lblZanr = new JLabel("Zanr");
    private JTextField txtId;
    private JTextField txtNaslov;
    private JTextField txtIme;
    private JTextField txtPrezime;
    private JTextField txtGodina;
    private JTextField txtJezik;
    private JTextField txtOpis;
    private JComboBox<Zanr> cbZanrovi;
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
        txtId = new JTextField("", 20);
        txtNaslov = new JTextField("", 20);
        txtIme = new JTextField("", 20);
        txtPrezime = new JTextField("", 20);
        txtGodina = new JTextField("", 20);
        txtJezik = new JTextField("", 20);
        txtOpis = new JTextField("", 20);
        Zanr[] zanrovi = new Zanr[knjigeProzor.getBiblioteka().getZanrovi().size()];
        for (int i = 0; i < knjigeProzor.getBiblioteka().getZanrovi().size(); i++) {
            zanrovi[i] = knjigeProzor.getBiblioteka().getZanrovi().get(i);
        }
        cbZanrovi = new JComboBox<>(zanrovi);

        MigLayout mig = new MigLayout("wrap 2", "[]5[]", "[]10[][]10[]10[]10[]10[]");
        setLayout(mig);

        add(lblId);
        add(txtId);
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
        add(cbZanrovi);
        add(btnDodaj);
        add(btnCancel);

        getRootPane().setDefaultButton(btnCancel);
    }

    private void initActions() {
        btnDodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtId.getText().equals("") || txtIme.getText().equals("") || txtPrezime.getText().equals("") || txtNaslov.getText().equals("")
                        || txtGodina.getText().equals("") || txtOpis.getText().equals("") || txtJezik.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Niste uneli sve podatke.", "Greska", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                Knjiga knjiga = new Knjiga();
                knjiga.setID(Integer.parseInt(txtId.getText()));
                knjiga.setNaslovKnjige(txtNaslov.getText());
                knjiga.setImePisca(txtIme.getText());
                knjiga.setPrezimePisca(txtPrezime.getText());
                knjiga.setGodinaObjave(txtGodina.getText());
                knjiga.setOpis(txtOpis.getText());
                knjiga.setJezik(Jezik.valueOf(txtJezik.getText()));
                knjiga.setZanr((Zanr) cbZanrovi.getSelectedItem());
                boolean result = knjigeProzor.getBiblioteka().dodajKnjigu(knjiga);
                if (!result) {
                    JOptionPane.showMessageDialog(null, "Zaposleni sa tim id-jem vec postoji."
                            , "Greska", JOptionPane.WARNING_MESSAGE);
                    return;
                }
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
