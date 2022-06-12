package gui.clanarine;

import biblioteka_paket.Clanarina;
import biblioteka_paket.Knjiga;
import biblioteka_paket.Zanr;
import biblioteka_paket.enums.Jezik;
import gui.knjige.DodajKnjiguProzor;
import gui.knjige.KnjigeProzor;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodajClanarinuProzor extends JFrame {

    private JLabel lblId = new JLabel("ID");
    private JLabel lblNaziv = new JLabel("Naziv");
    private JLabel lblCena = new JLabel("Cena");
    private JTextField txtId;
    private JTextField txtNaziv;
    private JTextField txtCena;
    private JButton btnDodaj = new JButton("Dodaj");
    private JButton btnCancel = new JButton("Cancel");

    private ClanarineProzor clanarineProzor;

    public DodajClanarinuProzor(ClanarineProzor clanarineProzor) {
        this.clanarineProzor = clanarineProzor;
        setTitle("Dodaj");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
        pack();
    }

    private void initGUI() {
        txtId = new JTextField("", 20);
        txtNaziv = new JTextField("", 20);
        txtCena = new JTextField("", 20);


        MigLayout mig = new MigLayout("wrap 2", "[]5[]", "[]10[][]");
        setLayout(mig);

        add(lblId);
        add(txtId);
        add(lblNaziv);
        add(txtNaziv);
        add(lblCena);
        add(txtCena);
        add(btnDodaj);
        add(btnCancel);

        getRootPane().setDefaultButton(btnDodaj);
    }

    private void initActions() {
        btnDodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtId.getText().equals("") || txtNaziv.getText().equals("") || txtCena.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Niste uneli sve podatke.", "Greska", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                Clanarina clanarina = new Clanarina();
                clanarina.setID(Integer.parseInt(txtId.getText()));
                clanarina.setNaziv(txtNaziv.getText());
                clanarina.setCena(Double.parseDouble(txtCena.getText()));
                clanarineProzor.getBiblioteka().getClanarine().add(clanarina);
                clanarineProzor.updateTable();
                DodajClanarinuProzor.this.dispose();
                DodajClanarinuProzor.this.setVisible(false);
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DodajClanarinuProzor.this.dispose();
                DodajClanarinuProzor.this.setVisible(false);
            }
        });
    }
}
