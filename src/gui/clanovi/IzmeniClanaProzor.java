package gui.clanovi;

import biblioteka_paket.Clan;
import biblioteka_paket.enums.TipClanarine;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IzmeniClanaProzor extends JFrame {

    private JLabel lblIme = new JLabel("Ime");
    private JLabel lblPrezime = new JLabel("Prezime");
    private JLabel lblJmbg = new JLabel("JMBG");
    private JLabel lblAdresa = new JLabel("Adresa");
    private JLabel lblBrojClanskeKarte = new JLabel("Br clanske karte");
    private JLabel lblTipClanarine = new JLabel("Tip clanarine");
    private JLabel lblDatumPoslednjeUplate = new JLabel("Datum poslednje uplate");
    private JLabel lblBrojMeseci = new JLabel("Broj meseci");
    private JTextField txtIme;
    private JTextField txtPrezime;
    private JTextField txtJmbg;
    private JTextField txtAdresa;
    private JTextField txtBrojClanskeKarte;
    private JTextField txtTipClanarine;
    private JTextField txtDatumPoslednjeUplate;
    private JTextField txtBrojMeseci;
    private JButton btnPromeni = new JButton("Promeni");
    private JButton btnCancel = new JButton("Cancel");

    private Clan clan;
    private ClanoviProzor clanoviProzor;

    public IzmeniClanaProzor(Clan clan, ClanoviProzor clanoviProzor) {
        this.clan = clan;
        this.clanoviProzor = clanoviProzor;
        setTitle("Clan " + clan.getID());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300, 300);
        initGUI();
        initActions();
        pack();
    }

    private void initGUI() {
        txtIme = new JTextField(clan.getIme(), 20);
        txtPrezime = new JTextField(clan.getPrezime(), 20);
        txtAdresa = new JTextField(clan.getAdresa(), 20);
        txtJmbg = new JTextField(clan.getJmbg(), 20);
        txtBrojClanskeKarte = new JTextField(String.valueOf(clan.getBrojClanskeKarte()), 20);
        txtTipClanarine = new JTextField(clan.getTipClanarine().toString(), 20);
        txtDatumPoslednjeUplate = new JTextField(clan.getDatumPoslednjeUplate(), 20);
        txtBrojMeseci = new JTextField(String.valueOf(clan.getBrojMeseci()), 20);


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
        add(lblBrojClanskeKarte);
        add(txtBrojClanskeKarte);
        add(lblTipClanarine);
        add(txtTipClanarine);
        add(lblDatumPoslednjeUplate);
        add(txtDatumPoslednjeUplate);
        add(lblBrojMeseci);
        add(txtBrojMeseci);
        add(btnPromeni);
        add(btnCancel);

        getRootPane().setDefaultButton(btnPromeni);
    }

    private void initActions() {
        btnPromeni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clan.setIme(txtIme.getText());
                clan.setPrezime(txtPrezime.getText());
                clan.setAdresa(txtAdresa.getText());
                clan.setBrojClanskeKarte(Integer.parseInt(txtBrojClanskeKarte.getText()));
                clan.setBrojMeseci(Integer.parseInt(txtBrojMeseci.getText()));
                clan.setDatumPoslednjeUplate(txtDatumPoslednjeUplate.getText());
                clan.setJmbg(txtJmbg.getText());
                clan.setTipClanarine(TipClanarine.valueOf(txtTipClanarine.getText()));
                clanoviProzor.updateTable();
                IzmeniClanaProzor.this.dispose();
                IzmeniClanaProzor.this.setVisible(false);
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IzmeniClanaProzor.this.dispose();
                IzmeniClanaProzor.this.setVisible(false);
            }
        });
    }

}
