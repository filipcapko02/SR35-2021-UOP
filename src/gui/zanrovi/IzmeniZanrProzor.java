package gui.zanrovi;

import biblioteka_paket.Clanarina;
import biblioteka_paket.Zanr;
import gui.clanarine.ClanarineProzor;
import gui.clanarine.IzmeniClanarinuProzor;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IzmeniZanrProzor extends JFrame {

    private JLabel lblOznaka = new JLabel("Oznaka");
    private JLabel lblOpis = new JLabel("Opis");
    private JTextField txtOznaka;
    private JTextField txtOpis;
    private JButton btnPromeni = new JButton("Promeni");
    private JButton btnCancel = new JButton("Cancel");

    private Zanr zanr;
    private ZanroviProzor zanroviProzor;

    public IzmeniZanrProzor(Zanr zanr, ZanroviProzor zanroviProzor) {
        this.zanr = zanr;
        this.zanroviProzor = zanroviProzor;
        setTitle("Zanr " + zanr.getID());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
        pack();
    }

    private void initGUI() {
        txtOznaka = new JTextField(zanr.getOznaka(), 20);
        txtOpis = new JTextField(String.valueOf(zanr.getOpis()), 20);


        MigLayout mig = new MigLayout("wrap 2", "[]5[]", "[]10[]");
        setLayout(mig);

        add(lblOznaka);
        add(txtOznaka);
        add(lblOpis);
        add(txtOpis);
        add(btnPromeni);
        add(btnCancel);

        getRootPane().setDefaultButton(btnPromeni);
    }

    private void initActions() {
        btnPromeni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtOznaka.getText().equals("") || txtOpis.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Niste uneli sve podatke.", "Greska", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                zanr.setOznaka(txtOznaka.getText());
                zanr.setOpis(txtOpis.getText());
                zanroviProzor.updateTable();
                IzmeniZanrProzor.this.dispose();
                IzmeniZanrProzor.this.setVisible(false);
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IzmeniZanrProzor.this.dispose();
                IzmeniZanrProzor.this.setVisible(false);
            }
        });
    }
}
