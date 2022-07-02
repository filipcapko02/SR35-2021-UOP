package gui.iznajmljivanja;

import biblioteka_paket.*;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
    private JList<PrimerakKnjige> listPrimerci;
    private JComboBox<PrimerakKnjige> cbPrimerci;
    private JButton btnPromeni = new JButton("Promeni");
    private JButton btnCancel = new JButton("Cancel");
    private JButton btnObrisi = new JButton("Obrisi");
    private JButton btnDodaj = new JButton("Dodaj");

    // Cuvamo originalne primerke, ukoliko odustanemo od promene (Cancel)
    private ArrayList<PrimerakKnjige> primerciOriginal;

    private Iznajmljivanje iznajmljivanje;
    private IznajmljivanjaProzor iznajmljivanjaProzor;

    public IzmeniIzmajmljivanjeProzor(Iznajmljivanje iznajmljivanje, IznajmljivanjaProzor iznajmljivanjaProzor) {
        this.iznajmljivanje = iznajmljivanje;
        this.iznajmljivanjaProzor = iznajmljivanjaProzor;
        primerciOriginal = (ArrayList<PrimerakKnjige>) iznajmljivanje.getPrimerci().clone();
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

        // Lista svih primeraka koji su iznajmljeni
        listPrimerci = new JList<>();
        DefaultListModel<PrimerakKnjige> model = new DefaultListModel<>();
        model.addAll(iznajmljivanje.getPrimerci());
        listPrimerci.setModel(model);
        JScrollPane scrollPane = new JScrollPane(listPrimerci);

        PrimerakKnjige[] primerci = new PrimerakKnjige[iznajmljivanjaProzor.getBiblioteka().getClanovi().size()];
        for (int i = 0; i < iznajmljivanjaProzor.getBiblioteka().getClanovi().size(); i++) {
            primerci[i] = iznajmljivanjaProzor.getBiblioteka().getPrimerciKnjiga().get(i);
        }
        cbPrimerci = new JComboBox<>(primerci);


        MigLayout mig = new MigLayout("wrap 2", "[]5[]", "[]10[]10[]10[]10[]10[]20[]");
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
        add(new JLabel());
        add(cbPrimerci, "split 3");
        add(btnDodaj);
        add(btnObrisi);
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
                IzmeniIzmajmljivanjeProzor.this.dispose();
                IzmeniIzmajmljivanjeProzor.this.setVisible(false);
                iznajmljivanjaProzor.updateTable();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iznajmljivanje.setPrimerci(primerciOriginal);
                IzmeniIzmajmljivanjeProzor.this.dispose();
                IzmeniIzmajmljivanjeProzor.this.setVisible(false);
            }
        });

        btnObrisi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<PrimerakKnjige> selected = listPrimerci.getSelectedValuesList();
                iznajmljivanje.getPrimerci().removeAll(selected);
                DefaultListModel<PrimerakKnjige> model = (DefaultListModel<PrimerakKnjige>) listPrimerci.getModel();
                int[] selectedIndices = listPrimerci.getSelectedIndices();
                for (int i: selectedIndices) {
                    model.remove(i);
                }
            }
        });

        btnDodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrimerakKnjige pk = (PrimerakKnjige) cbPrimerci.getSelectedItem();
                if (iznajmljivanje.getPrimerci().contains(pk)) {
                    JOptionPane.showMessageDialog(null, "Primerak je vec dodat.", "Greska", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                iznajmljivanje.getPrimerci().add(pk);
                DefaultListModel<PrimerakKnjige> model = (DefaultListModel<PrimerakKnjige>) listPrimerci.getModel();
                model.addElement(pk);
            }
        });
    }
}
