package gui.zanrovi;

import biblioteka_paket.Zanr;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodajZanrProzor extends JFrame {

    private JLabel lblId = new JLabel("ID");
    private JLabel lblOznaka = new JLabel("Oznaka");
    private JLabel lblOpis = new JLabel("Opis");
    private JTextField txtId;
    private JTextField txtOznaka;
    private JTextField txtOpis;
    private JButton btnDodaj = new JButton("Dodaj");
    private JButton btnCancel = new JButton("Cancel");

    private ZanroviProzor zanroviProzor;

    public DodajZanrProzor(ZanroviProzor zanroviProzor) {
        this.zanroviProzor = zanroviProzor;
        setTitle("Dodaj");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
        pack();
    }

    private void initGUI() {
        txtId = new JTextField("", 20);
        txtOznaka = new JTextField("", 20);
        txtOpis = new JTextField("", 20);


        MigLayout mig = new MigLayout("wrap 2", "[]5[]", "[]5[]5[]");
        setLayout(mig);

        add(lblId);
        add(txtId);
        add(lblOznaka);
        add(txtOznaka);
        add(lblOpis);
        add(txtOpis);
        add(btnDodaj);
        add(btnCancel);

        getRootPane().setDefaultButton(btnDodaj);
    }

    private void initActions() {
        btnDodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtId.getText().equals("") || txtOznaka.getText().equals("") || txtOpis.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Niste uneli sve podatke.", "Greska", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                Zanr zanr = new Zanr();
                zanr.setID(Integer.parseInt(txtId.getText()));
                zanr.setOznaka(txtOznaka.getText());
                zanr.setOpis(txtOpis.getText());
                boolean result = zanroviProzor.getBiblioteka().dodajZanr(zanr);
                if (!result) {
                    JOptionPane.showMessageDialog(null, "Zanr sa tim id-jem vec postoji."
                            , "Greska", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                zanroviProzor.updateTable();
                DodajZanrProzor.this.dispose();
                DodajZanrProzor.this.setVisible(false);
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DodajZanrProzor.this.dispose();
                DodajZanrProzor.this.setVisible(false);
            }
        });
    }

}
