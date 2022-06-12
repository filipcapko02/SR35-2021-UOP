package gui.primerci;

import biblioteka_paket.Knjiga;
import biblioteka_paket.PrimerakKnjige;
import biblioteka_paket.enums.Jezik;
import biblioteka_paket.enums.Povez;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodajPrimerakProzor extends JFrame {

    private JLabel lblId = new JLabel("ID");
    private JLabel lblKnjiga = new JLabel("Knjiga");
    private JLabel lblBrojStrana = new JLabel("Broj strana");
    private JLabel lblPovez = new JLabel("Povez");
    private JLabel lblGodinaStampanja = new JLabel("Godina stampanja");
    private JLabel lblJezik = new JLabel("Jezik");
    private JLabel lblIznajmljena = new JLabel("Iznajmljena");
    private JTextField txtId;
    private JComboBox<Knjiga> cbKnjige;
    private JTextField txtBrojStrana;
    private JTextField txtGodinaStampanja;
    private JComboBox<Povez> cbPovezi;
    private JComboBox<Jezik> cbJezici;
    private JComboBox<String> cbIznajmljena;
    private JButton btnDodaj = new JButton("Dodaj");
    private JButton btnCancel = new JButton("Cancel");

    private PrimerciProzor primerciProzor;

    public DodajPrimerakProzor(PrimerciProzor primerciProzor) {
        this.primerciProzor = primerciProzor;
        setTitle("Dodaj");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
        pack();
    }

    private void initGUI() {
        txtId = new JTextField("", 20);
        txtBrojStrana = new JTextField("", 20);
        txtGodinaStampanja = new JTextField("", 20);
        Knjiga[] knjige = new Knjiga[primerciProzor.getBiblioteka().getKnjige().size()];
        for (int i = 0; i < primerciProzor.getBiblioteka().getKnjige().size(); i++) {
            knjige[i] = primerciProzor.getBiblioteka().getKnjige().get(i);
        }
        cbKnjige = new JComboBox<>(knjige);
        Povez[] povezi = new Povez[2];
        povezi[0] = Povez.MEK;
        povezi[1] = Povez.TVRD;
        cbPovezi = new JComboBox<>(povezi);
        Jezik[] jezici = new Jezik[Jezik.values().length];
        for (int i = 0; i < Jezik.values().length; i++) {
            jezici[i] = Jezik.values()[i];
        }
        cbJezici = new JComboBox<>(jezici);
        String[] res = new String[2];
        res[0] = "DA";
        res[1] = "NE";
        cbIznajmljena = new JComboBox<>(res);


        MigLayout mig = new MigLayout("wrap 2", "[]5[]", "[]10[][]10[]10[]10[]10[]");
        setLayout(mig);

        add(lblId);
        add(txtId);
        add(lblKnjiga);
        add(cbKnjige);
        add(lblBrojStrana);
        add(txtBrojStrana);
        add(lblPovez);
        add(cbPovezi);
        add(lblGodinaStampanja);
        add(txtGodinaStampanja);
        add(lblJezik);
        add(cbJezici);
        add(lblIznajmljena);
        add(cbIznajmljena);
        add(btnDodaj);
        add(btnCancel);

        getRootPane().setDefaultButton(btnDodaj);
    }

    private void initActions() {
        btnDodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtId.getText().equals("") || txtBrojStrana.getText().equals("") || txtGodinaStampanja.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Niste uneli sve podatke.", "Greska", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                PrimerakKnjige primerakKnjige = new PrimerakKnjige();
                primerakKnjige.setID(Integer.parseInt(txtId.getText()));
                primerakKnjige.setKnjiga((Knjiga) cbKnjige.getSelectedItem());
                primerakKnjige.setBrojStrana(Integer.parseInt(txtBrojStrana.getText()));
                primerakKnjige.setGodinaStampanja(txtGodinaStampanja.getText());
                primerakKnjige.setJezik((Jezik) cbJezici.getSelectedItem());
                primerakKnjige.setPovez((Povez) cbPovezi.getSelectedItem());
                boolean iznajmljena = cbIznajmljena.getSelectedItem().equals("DA");
                primerakKnjige.setIznajmljena(iznajmljena);
                primerciProzor.getBiblioteka().dodajPrimerakKnjige(primerakKnjige);
                DodajPrimerakProzor.this.dispose();
                DodajPrimerakProzor.this.setVisible(false);
                primerciProzor.updateTable();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DodajPrimerakProzor.this.dispose();
                DodajPrimerakProzor.this.setVisible(false);
            }
        });
    }
}
