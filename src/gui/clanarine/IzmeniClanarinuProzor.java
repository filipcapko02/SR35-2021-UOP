package gui.clanarine;

import biblioteka_paket.Clanarina;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IzmeniClanarinuProzor extends JFrame {

    private JLabel lblNaziv = new JLabel("Naziv");
    private JLabel lblCena = new JLabel("Cena");
    private JTextField txtNaziv;
    private JTextField txtCena;
    private JButton btnPromeni = new JButton("Promeni");
    private JButton btnCancel = new JButton("Cancel");

    private Clanarina clanarina;
    private ClanarineProzor clanarineProzor;

    public IzmeniClanarinuProzor(Clanarina clanarina, ClanarineProzor clanarineProzor) {
        this.clanarina = clanarina;
        this.clanarineProzor = clanarineProzor;
        setTitle("Clanarina " + clanarina.getID());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
        pack();
    }

    private void initGUI() {
        txtNaziv = new JTextField(clanarina.getNaziv(), 20);
        txtCena = new JTextField(String.valueOf(clanarina.getCena()), 20);


        MigLayout mig = new MigLayout("wrap 2", "[]5[]", "[]10[]");
        setLayout(mig);

        add(lblNaziv);
        add(txtNaziv);
        add(lblCena);
        add(txtCena);
        add(btnPromeni);
        add(btnCancel);

        getRootPane().setDefaultButton(btnPromeni);
    }

    private void initActions() {
        btnPromeni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtNaziv.getText().equals("") || txtCena.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Niste uneli sve podatke.", "Greska", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                clanarina.setNaziv(txtNaziv.getText());
                clanarina.setCena(Double.parseDouble(txtCena.getText()));
                clanarineProzor.updateTable();
                IzmeniClanarinuProzor.this.dispose();
                IzmeniClanarinuProzor.this.setVisible(false);
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IzmeniClanarinuProzor.this.dispose();
                IzmeniClanarinuProzor.this.setVisible(false);
            }
        });
    }
}
