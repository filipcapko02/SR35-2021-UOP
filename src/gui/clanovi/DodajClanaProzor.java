package gui.clanovi;

import biblioteka_paket.Clan;
import biblioteka_paket.Clanarina;
import biblioteka_paket.enums.Pol;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodajClanaProzor extends JFrame {

    private JLabel lblId = new JLabel("ID");
    private JLabel lblPol = new JLabel("Pol");
    private JLabel lblIme = new JLabel("Ime");
    private JLabel lblPrezime = new JLabel("Prezime");
    private JLabel lblJmbg = new JLabel("JMBG");
    private JLabel lblAdresa = new JLabel("Adresa");
    private JLabel lblBrojClanskeKarte = new JLabel("Br clanske karte");
    private JLabel lblTipClanarine = new JLabel("Tip clanarine");
    private JLabel lblDatumPoslednjeUplate = new JLabel("Datum poslednje uplate");
    private JLabel lblBrojMeseci = new JLabel("Broj meseci");
    private JTextField txtId;
    private JTextField txtPol;
    private JTextField txtIme;
    private JTextField txtPrezime;
    private JTextField txtJmbg;
    private JTextField txtAdresa;
    private JTextField txtBrojClanskeKarte;
    private JComboBox<Clanarina> cbClanarine;
    private JTextField txtDatumPoslednjeUplate;
    private JTextField txtBrojMeseci;
    private JButton btnDodaj = new JButton("Dodaj");
    private JButton btnCancel = new JButton("Cancel");

    private ClanoviProzor clanoviProzor;

    public DodajClanaProzor(ClanoviProzor clanoviProzor) {
        this.clanoviProzor = clanoviProzor;
        setTitle("Dodaj clana");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
        pack();
    }

    private void initGUI() {
        txtId = new JTextField("", 20);
        txtPol = new JTextField("", 20);
        txtIme = new JTextField("", 20);
        txtPrezime = new JTextField("", 20);
        txtAdresa = new JTextField("", 20);
        txtJmbg = new JTextField("", 20);
        txtBrojClanskeKarte = new JTextField("", 20);
        Clanarina[] clanarine = new Clanarina[clanoviProzor.getBiblioteka().getClanarine().size()];
        for (int i = 0; i < clanoviProzor.getBiblioteka().getClanarine().size(); i++) {
            clanarine[i] = clanoviProzor.getBiblioteka().getClanarine().get(i);
        }
        cbClanarine = new JComboBox<>(clanarine);
        txtDatumPoslednjeUplate = new JTextField("", 20);
        txtBrojMeseci = new JTextField("", 20);


        MigLayout mig = new MigLayout("wrap 2", "[]5[]", "[]10[][]10[]10[]10[]10[]10[]");
        setLayout(mig);

        add(lblId);
        add(txtId);
        add(lblPol);
        add(txtPol);
        add(lblIme);
        add(txtIme);
        add(lblPrezime);
        add(txtPrezime);
        add(lblJmbg);
        add(txtJmbg);
        add(lblAdresa);
        add(txtAdresa);
        add(lblBrojClanskeKarte);
        add(txtBrojClanskeKarte);
        add(lblTipClanarine);
        add(cbClanarine);
        add(lblDatumPoslednjeUplate);
        add(txtDatumPoslednjeUplate);
        add(lblBrojMeseci);
        add(txtBrojMeseci);
        add(btnDodaj);
        add(btnCancel);

        getRootPane().setDefaultButton(btnDodaj);
    }

    private void initActions() {
        btnDodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtId.getText().equals("") || txtIme.getText().equals("") || txtPrezime.getText().equals("") || txtAdresa.getText().equals("")
                        || txtBrojClanskeKarte.getText().equals("") || txtBrojMeseci.getText().equals("") || txtDatumPoslednjeUplate.getText().equals("")
                        || txtJmbg.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Niste uneli sve podatke.", "Greska", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                Clan clan = new Clan(Integer.parseInt(txtId.getText()), Pol.valueOf(txtPol.getText()), txtIme.getText(), txtPrezime.getText(),
                        txtJmbg.getText(), txtAdresa.getText(), Integer.parseInt(txtBrojClanskeKarte.getText()), (Clanarina) cbClanarine.getSelectedItem(),
                        txtDatumPoslednjeUplate.getText(), Integer.parseInt(txtBrojMeseci.getText()), true);
                boolean result = clanoviProzor.getBiblioteka().dodajClana(clan);
                if (!result) {
                    JOptionPane.showMessageDialog(null, "Clan sa tim id-jem vec postoji."
                            , "Greska", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                clanoviProzor.updateTable();
                DodajClanaProzor.this.dispose();
                DodajClanaProzor.this.setVisible(false);
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DodajClanaProzor.this.dispose();
                DodajClanaProzor.this.setVisible(false);
            }
        });
    }

}
