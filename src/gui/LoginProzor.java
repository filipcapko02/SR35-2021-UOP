package gui;

import biblioteka.Biblioteka;
import biblioteka_paket.Zaposleni;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginProzor extends JFrame {

    private JLabel lblGreeting = new JLabel("Dobrodošli. Molimo da se prijavite.");
    private JLabel lblUsername = new JLabel("Korisničko ime");
    private JTextField txtKorisnickoIme = new JTextField(20);
    private JLabel lblPassword = new JLabel("Šifra");
    private JPasswordField pfPassword = new JPasswordField(20);
    private JButton btnOk = new JButton("OK");
    private JButton btnRegistracija = new JButton("Registracija");
    private JButton btnCancel = new JButton("Cancel");

    private Biblioteka biblioteka;

    public LoginProzor(Biblioteka biblioteka) {
        this.biblioteka = biblioteka;
        setTitle("Prijava");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
        pack();
    }

    public void initGUI() {
        MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[][]10[]");
        setLayout(mig);

        add(lblGreeting, "span 2");
        add(lblUsername);
        add(txtKorisnickoIme);
        add(lblPassword);
        add(pfPassword);
        add(new JLabel());
        add(btnOk, "split 3");
        add(btnRegistracija);
        add(btnCancel);


        txtKorisnickoIme.setText("Munjov02");
        pfPassword.setText("123");
        getRootPane().setDefaultButton(btnOk);
    }

    public void initActions() {
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginProzor.this.dispose();
                LoginProzor.this.setVisible(false);
            }
        });

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String korisnikoIme = txtKorisnickoIme.getText().trim();
                String sifra = new String(pfPassword.getPassword()).trim();

                if(korisnikoIme.equals("") || sifra.equals("")) {
                    JOptionPane.showMessageDialog(null, "Niste uneli sve podatke za prijavu.", "Greska", JOptionPane.WARNING_MESSAGE);
                } else {
                    Zaposleni prijavljeni = biblioteka.login(korisnikoIme, sifra);
                    if(prijavljeni == null) {
                        JOptionPane.showMessageDialog(null, "Pogrešni login podaci.", "Greška", JOptionPane.WARNING_MESSAGE);
                    } else {
                        LoginProzor.this.dispose();
                        LoginProzor.this.setVisible(false);
                        GlavniProzor gp = new GlavniProzor(biblioteka, prijavljeni);
                        gp.setVisible(true);
                    }
                }
            }
        });

    }


}
