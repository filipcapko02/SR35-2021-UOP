package gui.iznajmljivanja;

import biblioteka_paket.Clan;
import biblioteka_paket.Iznajmljivanje;
import biblioteka_paket.PrimerakKnjige;
import biblioteka_paket.Zaposleni;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DodajIznajmljivanjeProzor extends JFrame {

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
    private JList<PrimerakKnjige> listPrimerci;
    private JButton btnDodaj = new JButton("Dodaj");
    private JButton btnCancel = new JButton("Cancel");

    private IznajmljivanjaProzor iznajmljivanjaProzor;

    public DodajIznajmljivanjeProzor(IznajmljivanjaProzor iznajmljivanjaProzor) {
        this.iznajmljivanjaProzor = iznajmljivanjaProzor;
        setTitle("Dodaj");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
        pack();
    }

    private void initGUI() {
        txtDatumIznajmljivanja = new JTextField("", 20);
        txtDatumVracanja = new JTextField("", 20);
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
        //cbPrimerci = new JComboBox<>(primerci);

        // Lista svih primeraka
        listPrimerci = new JList<>(primerci);
        JScrollPane scrollPane = new JScrollPane(listPrimerci);


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
        add(scrollPane);
        add(btnDodaj);
        add(btnCancel);

        getRootPane().setDefaultButton(btnCancel);
    }

    private void initActions() {
        btnDodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtDatumIznajmljivanja.getText().equals("") || txtDatumVracanja.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Niste uneli sve podatke.", "Greska", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                List<PrimerakKnjige> selected = listPrimerci.getSelectedValuesList();
                for (int i = 0; i < selected.size(); i++) {
                    Iznajmljivanje iznajmljivanje = new Iznajmljivanje();
                    iznajmljivanje.setID(iznajmljivanjaProzor.getBiblioteka().nadjiSlobodanId());
                    iznajmljivanje.setZaposleni((Zaposleni) cbZaposleni.getSelectedItem());
                    iznajmljivanje.setClan((Clan) cbClanovi.getSelectedItem());
                    iznajmljivanje.setDatumIznajmljivanja(txtDatumIznajmljivanja.getText());
                    iznajmljivanje.setDatumVracanja(txtDatumVracanja.getText());
                    iznajmljivanje.setPrimerakKnjige(selected.get(i));
                    iznajmljivanjaProzor.getBiblioteka().dodajIznajmljivanje(iznajmljivanje);
                }
                DodajIznajmljivanjeProzor.this.dispose();
                DodajIznajmljivanjeProzor.this.setVisible(false);
                iznajmljivanjaProzor.updateTable();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DodajIznajmljivanjeProzor.this.dispose();
                DodajIznajmljivanjeProzor.this.setVisible(false);
            }
        });
    }
}
