package gui.iznajmljivanja;

import biblioteka_paket.*;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IzmeniIzmajmljivanjeProzor extends JFrame {

    private JLabel lblZaposleni = new JLabel("Zaposleni");
    private JLabel lblClan = new JLabel("Clan");
    private JLabel lblDatumIznajmljivanja = new JLabel("Datum iznajmljivanja");
    private JLabel lblDatumVracanja = new JLabel("Datum vracanja");
    private JLabel lblPrimerakKnjige = new JLabel("Primerak");
    private JTextField txtDatumIznajmljivanja;
    private JTextField txtDatumVracanja;
    private JComboBox<Zaposleni> cbZaposleni;
    private JComboBox<Clan> cbClanovi;
    private JComboBox<PrimerakKnjige> cbPrimerci;
    private JButton btnPromeni = new JButton("Promeni");
    private JButton btnCancel = new JButton("Cancel");

    private Iznajmljivanje iznajmljivanje;
    private IznajmljivanjaProzor iznajmljivanjaProzor;

    public IzmeniIzmajmljivanjeProzor(Iznajmljivanje iznajmljivanje, IznajmljivanjaProzor iznajmljivanjaProzor) {
        this.iznajmljivanje = iznajmljivanje;
        this.iznajmljivanjaProzor = iznajmljivanjaProzor;
        setTitle("Najam " + iznajmljivanje.getID());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
        pack();
    }

    private void initGUI() {
        txtDatumIznajmljivanja = new JTextField(iznajmljivanje.getDatumIznajmljivanja(), 20);
        txtDatumVracanja = new JTextField(iznajmljivanje.getDatumVracanja(), 20);
        Zaposleni[] zaposleni = new Zaposleni[iznajmljivanjaProzor.getBiblioteka().getZaposleni().size()];
        for (int i = 0; i < iznajmljivanjaProzor.getBiblioteka().getZaposleni().size(); i++) {
            zaposleni[i] = iznajmljivanjaProzor.getBiblioteka().getZaposleni().get(i);
        }
        cbZaposleni = new JComboBox<>(zaposleni);
        Clan[] clanovi = new Clan[iznajmljivanjaProzor.getBiblioteka().getClanovi().size()];
        for (int i = 0; i < iznajmljivanjaProzor.getBiblioteka().getClanovi().size(); i++) {
            clanovi[i] = iznajmljivanjaProzor.getBiblioteka().getClanovi().get(i);
        }
        cbClanovi = new JComboBox<>(clanovi);
        PrimerakKnjige[] primerci = new PrimerakKnjige[iznajmljivanjaProzor.getBiblioteka().getPrimerciKnjiga().size()];
        for (int i = 0; i < iznajmljivanjaProzor.getBiblioteka().getPrimerciKnjiga().size(); i++) {
            primerci[i] = iznajmljivanjaProzor.getBiblioteka().getPrimerciKnjiga().get(i);
        }
        cbPrimerci = new JComboBox<>(primerci);

        MigLayout mig = new MigLayout("wrap 2", "[]5[]", "[]10[][]10[]10[]10[]10[]");
        setLayout(mig);

        add(lblZaposleni);
        add(cbZaposleni);
        add(lblClan);
        add(cbClanovi);
        add(lblDatumIznajmljivanja);
        add(txtDatumIznajmljivanja);
        add(lblDatumVracanja);
        add(txtDatumVracanja);
        add(lblPrimerakKnjige);
        add(cbPrimerci);
        add(btnPromeni);
        add(btnCancel);

        getRootPane().setDefaultButton(btnCancel);
    }

    private void initActions() {
        btnPromeni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtDatumIznajmljivanja.getText().equals("") || txtDatumVracanja.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Niste uneli sve podatke.", "Greska", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                iznajmljivanje.setZaposleni((Zaposleni) cbZaposleni.getSelectedItem());
                iznajmljivanje.setClan((Clan) cbClanovi.getSelectedItem());
                iznajmljivanje.setDatumIznajmljivanja(txtDatumIznajmljivanja.getText());
                iznajmljivanje.setDatumVracanja(txtDatumVracanja.getText());
                iznajmljivanje.setPrimerakKnjige((PrimerakKnjige) cbPrimerci.getSelectedItem());
                IzmeniIzmajmljivanjeProzor.this.dispose();
                IzmeniIzmajmljivanjeProzor.this.setVisible(false);
                iznajmljivanjaProzor.updateTable();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IzmeniIzmajmljivanjeProzor.this.dispose();
                IzmeniIzmajmljivanjeProzor.this.setVisible(false);
            }
        });
    }
}
