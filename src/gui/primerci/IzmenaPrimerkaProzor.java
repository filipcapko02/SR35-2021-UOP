package gui.primerci;

import biblioteka_paket.Knjiga;
import biblioteka_paket.PrimerakKnjige;
import biblioteka_paket.enums.Jezik;
import biblioteka_paket.enums.Povez;
import gui.knjige.IzmenaKnjigeProzor;
import gui.knjige.KnjigeProzor;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IzmenaPrimerkaProzor extends JFrame {

    private JLabel lblKnjiga = new JLabel("Knjiga");
    private JLabel lblBrojStrana = new JLabel("Broj strana");
    private JLabel lblPovez = new JLabel("Povez");
    private JLabel lblGodinaStampanja = new JLabel("Godina stampanja");
    private JLabel lblJezik = new JLabel("Jezik");
    private JLabel lblIznajmljena = new JLabel("Iznajmljena");
    private JComboBox<Knjiga> cbKnjige;
    private JTextField txtBrojStrana;
    private JTextField txtGodinaStampanja;
    private JComboBox<Povez> cbPovezi;
    private JComboBox<Jezik> cbJezici;
    private JComboBox<String> cbIznajmljena;
    private JButton btnPromeni = new JButton("Promeni");
    private JButton btnCancel = new JButton("Cancel");

    private PrimerakKnjige primerakKnjige;
    private PrimerciProzor primerciProzor;

    public IzmenaPrimerkaProzor(PrimerakKnjige primerakKnjige, PrimerciProzor primerciProzor) {
        this.primerakKnjige = primerakKnjige;
        this.primerciProzor = primerciProzor;
        setTitle("Primerak " + primerakKnjige.getID());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
        pack();
    }

    private void initGUI() {
        txtBrojStrana = new JTextField(String.valueOf(primerakKnjige.getBrojStrana()), 20);
        txtGodinaStampanja = new JTextField(primerakKnjige.getGodinaStampanja(), 20);
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
        add(btnPromeni);
        add(btnCancel);

        getRootPane().setDefaultButton(btnPromeni);
    }

    private void initActions() {
        btnPromeni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                primerakKnjige.setKnjiga((Knjiga) cbKnjige.getSelectedItem());
                primerakKnjige.setBrojStrana(Integer.parseInt(txtBrojStrana.getText()));
                primerakKnjige.setGodinaStampanja(txtGodinaStampanja.getText());
                primerakKnjige.setJezik((Jezik) cbJezici.getSelectedItem());
                primerakKnjige.setPovez((Povez) cbPovezi.getSelectedItem());
                boolean iznajmljena = cbIznajmljena.getSelectedItem().equals("DA");
                primerakKnjige.setIznajmljena(iznajmljena);
                IzmenaPrimerkaProzor.this.dispose();
                IzmenaPrimerkaProzor.this.setVisible(false);
                primerciProzor.updateTable();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IzmenaPrimerkaProzor.this.dispose();
                IzmenaPrimerkaProzor.this.setVisible(false);
            }
        });
    }
}
