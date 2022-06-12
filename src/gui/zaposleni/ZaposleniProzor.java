package gui.zaposleni;

import biblioteka.Biblioteka;
import biblioteka_paket.Zaposleni;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZaposleniProzor extends JFrame {


    private JToolBar mainToolbar = new JToolBar();
    private JButton btnAdd = new JButton();
    private JButton btnEdit = new JButton();
    private JButton btnDelete = new JButton();

    private DefaultTableModel tableModel;
    private JTable zaposleniTabela;
    private String[] zaglavlja;

    private Biblioteka biblioteka;
    private String uloga;

    public ZaposleniProzor(Biblioteka biblioteka, String uloga) {
        this.biblioteka = biblioteka;
        this.uloga = uloga;
        setTitle("Zaposleni");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
    }

    private void initGUI() {
        ImageIcon addIcon = new ImageIcon(getClass().getResource("/slike/add.gif"));
        btnAdd.setIcon(addIcon);
        ImageIcon editIcon = new ImageIcon(getClass().getResource("/slike/edit.gif"));
        btnEdit.setIcon(editIcon);
        ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/slike/remove.gif"));
        btnDelete.setIcon(deleteIcon);

        mainToolbar.add(btnAdd);
        mainToolbar.add(btnEdit);
        mainToolbar.add(btnDelete);
        add(mainToolbar, BorderLayout.NORTH);

        zaglavlja = new String[] {"ID", "Ime", "Prezime", "Korisnicko ime", "Sifra", "JMBG", "Adresa", "Plata"};
        Object[][] sadrzaj = null;
        int size = 0;
        if (uloga.equals("administratori")) {
            sadrzaj = new Object[biblioteka.getAdmini().size()][zaglavlja.length];
            size = biblioteka.getAdmini().size();
        } else {
            sadrzaj = new Object[biblioteka.getBibliotekari().size()][zaglavlja.length];
            size = biblioteka.getBibliotekari().size();
        }
        for (int i = 0; i < size; i++) {
            Zaposleni zaposleni;
            if (uloga.equals("administratori")) {
                zaposleni = biblioteka.getAdmini().get(i);
            } else {
                zaposleni = biblioteka.getBibliotekari().get(i);
            }
            sadrzaj[i][0] = zaposleni.getID();
            sadrzaj[i][1] = zaposleni.getIme();
            sadrzaj[i][2] = zaposleni.getPrezime();
            sadrzaj[i][3] = zaposleni.getKorisnickoIme();
            sadrzaj[i][4] = zaposleni.getKorisnickaSifra();
            sadrzaj[i][5] = zaposleni.getJmbg();
            sadrzaj[i][6] = zaposleni.getAdresa();
            sadrzaj[i][7] = zaposleni.getPlata();
        }

        tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
        zaposleniTabela = new JTable(tableModel);

        zaposleniTabela.setRowSelectionAllowed(true);
        zaposleniTabela.setColumnSelectionAllowed(false);
        zaposleniTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        zaposleniTabela.setDefaultEditor(Object.class, null);
        zaposleniTabela.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(zaposleniTabela);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initActions() {
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String korisnickoIme = (String) zaposleniTabela.getModel().getValueAt(zaposleniTabela.getSelectedRow(), 3);
                tableModel.removeRow(zaposleniTabela.getSelectedRow());
                Zaposleni zaposleniZaBrisanje = biblioteka.nadjiZaposlenog(korisnickoIme);
                biblioteka.obrisiZaposlenog(zaposleniZaBrisanje);
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String korisnickoIme = (String) zaposleniTabela.getModel().getValueAt(zaposleniTabela.getSelectedRow(), 3);
                Zaposleni zaposleniZaEdit = biblioteka.nadjiZaposlenog(korisnickoIme);
                IzmeniZaposlenogProzor izp = new IzmeniZaposlenogProzor(zaposleniZaEdit, ZaposleniProzor.this);
                izp.setVisible(true);
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DodajZaposlenogProzor dzp = new DodajZaposlenogProzor(ZaposleniProzor.this, biblioteka);
                dzp.setVisible(true);
            }
        });
    }


    public void updateTable() {
        Object[][] sadrzaj = null;
        int size = 0;
        if (uloga.equals("administratori")) {
            sadrzaj = new Object[biblioteka.getAdmini().size()][zaglavlja.length];
            size = biblioteka.getAdmini().size();
        } else {
            sadrzaj = new Object[biblioteka.getBibliotekari().size()][zaglavlja.length];
            size = biblioteka.getBibliotekari().size();
        }
        for (int i = 0; i < size; i++) {
            Zaposleni zaposleni;
            if (uloga.equals("administratori")) {
                zaposleni = biblioteka.getAdmini().get(i);
            } else {
                zaposleni = biblioteka.getBibliotekari().get(i);
            }
            sadrzaj[i][0] = zaposleni.getID();
            sadrzaj[i][1] = zaposleni.getIme();
            sadrzaj[i][2] = zaposleni.getPrezime();
            sadrzaj[i][3] = zaposleni.getKorisnickoIme();
            sadrzaj[i][4] = zaposleni.getKorisnickaSifra();
            sadrzaj[i][5] = zaposleni.getJmbg();
            sadrzaj[i][6] = zaposleni.getAdresa();
            sadrzaj[i][7] = zaposleni.getPlata();
        }
        tableModel.setDataVector(sadrzaj, zaglavlja);
    }

    public Biblioteka getBiblioteka() {
        return biblioteka;
    }

    public String getUloga() {
        return uloga;
    }
}
