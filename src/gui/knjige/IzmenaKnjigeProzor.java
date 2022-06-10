package gui.knjige;

import biblioteka_paket.Knjiga;
import biblioteka_paket.Zanr;
import biblioteka_paket.enums.Jezik;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IzmenaKnjigeProzor extends JFrame {

    private JLabel lblNaslov = new JLabel("Naslov knjige");
    private JLabel lblImePisca = new JLabel("Ime pisca");
    private JLabel lblPrezimePisca = new JLabel("Prezime pisca");
    private JLabel lblGodina = new JLabel("Godina objave");
    private JLabel lblJezik = new JLabel("Jezik");
    private JLabel lblOpis = new JLabel("Opis");
    private JLabel lblZanr = new JLabel("Zanr");
    private JTextField txtNaslov;
    private JTextField txtIme;
    private JTextField txtPrezime;
    private JTextField txtGodina;
    private JTextField txtJezik;
    private JTextField txtOpis;
    private JTextField txtZanr;
    private JButton btnPromeni = new JButton("Promeni");
    private JButton btnCancel = new JButton("Cancel");

    private Knjiga knjiga;
    private KnjigeProzor knjigeProzor;

    public IzmenaKnjigeProzor(Knjiga knjiga, KnjigeProzor knjigeProzor) {
        this.knjiga = knjiga;
        this.knjigeProzor = knjigeProzor;
        setTitle("Knjiga " + knjiga.getID());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300, 300);
        initGUI();
        initActions();
        pack();
    }

    private void initGUI() {
        txtNaslov = new JTextField(knjiga.getNaslovKnjige(), 20);
        txtIme = new JTextField(knjiga.getImePisca(), 20);
        txtPrezime = new JTextField(knjiga.getPrezimePisca(), 20);
        txtGodina = new JTextField(knjiga.getGodinaObjave(), 20);
        txtJezik = new JTextField(knjiga.getJezik().toString(), 20);
        txtOpis = new JTextField(knjiga.getOpis(), 20);
        txtZanr = new JTextField(knjiga.getZanr().getOznaka(), 20);


        MigLayout mig = new MigLayout("wrap 2", "[]5[]", "[]10[][]10[]10[]10[]10[]");
        setLayout(mig);

        add(lblNaslov);
        add(txtNaslov);
        add(lblImePisca);
        add(txtIme);
        add(lblPrezimePisca);
        add(txtPrezime);
        add(lblGodina);
        add(txtGodina);
        add(lblOpis);
        add(txtOpis);
        add(lblZanr);
        add(txtZanr);
        add(btnPromeni);
        add(btnCancel);

        getRootPane().setDefaultButton(btnCancel);
    }

    private void initActions() {
        btnPromeni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                knjiga.setNaslovKnjige(txtNaslov.getText());
                knjiga.setImePisca(txtIme.getText());
                knjiga.setPrezimePisca(txtPrezime.getText());
                knjiga.setGodinaObjave(txtGodina.getText());
                knjiga.setOpis(txtOpis.getText());
                knjiga.setJezik(Jezik.valueOf(txtJezik.getText()));
                knjiga.setZanr(new Zanr("zanr", "opisZanra"));
                IzmenaKnjigeProzor.this.dispose();
                IzmenaKnjigeProzor.this.setVisible(false);
                knjigeProzor.updateTable();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IzmenaKnjigeProzor.this.dispose();
                IzmenaKnjigeProzor.this.setVisible(false);
            }
        });
    }
}
