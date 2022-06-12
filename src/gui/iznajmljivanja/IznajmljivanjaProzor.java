package gui.iznajmljivanja;

import biblioteka.Biblioteka;
import biblioteka_paket.Iznajmljivanje;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IznajmljivanjaProzor extends JFrame {

    private JToolBar mainToolbar = new JToolBar();
    private JButton btnAdd = new JButton();
    private JButton btnEdit = new JButton();
    private JButton btnDelete = new JButton();

    private DefaultTableModel tableModel;
    private JTable iznajmljivanjaTabela;
    private String[] zaglavlja;

    private Biblioteka biblioteka;

    public IznajmljivanjaProzor(Biblioteka biblioteka) {
        this.biblioteka = biblioteka;
        setTitle("Iznajmljivanja");
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

        zaglavlja = new String[] {"ID", "Zaposleni(izdao)", "Clan", "Datum iznajmljivanja", "Datum vracanja", "Primerak knjige"};
        Object[][] sadrzaj = new Object[biblioteka.getIznajmljivanja().size()][zaglavlja.length];

        for (int i = 0; i < biblioteka.getIznajmljivanja().size(); i++) {
            Iznajmljivanje iznajmljivanje = biblioteka.getIznajmljivanja().get(i);
            sadrzaj[i][0] = iznajmljivanje.getID();
            sadrzaj[i][1] = iznajmljivanje.getZaposleni().getKorisnickoIme();
            sadrzaj[i][2] = iznajmljivanje.getClan();
            sadrzaj[i][3] = iznajmljivanje.getDatumIznajmljivanja();
            sadrzaj[i][4] = iznajmljivanje.getDatumVracanja();
            sadrzaj[i][5] = iznajmljivanje.getPrimerakKnjige().getKnjiga().getNaslovKnjige();
        }

        tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
        iznajmljivanjaTabela = new JTable(tableModel);

        iznajmljivanjaTabela.setRowSelectionAllowed(true);
        iznajmljivanjaTabela.setColumnSelectionAllowed(false);
        iznajmljivanjaTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        iznajmljivanjaTabela.setDefaultEditor(Object.class, null);
        iznajmljivanjaTabela.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(iznajmljivanjaTabela);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initActions() {
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = (int) iznajmljivanjaTabela.getModel().getValueAt(iznajmljivanjaTabela.getSelectedRow(), 0);
                tableModel.removeRow(iznajmljivanjaTabela.getSelectedRow());
                Iznajmljivanje iznajmljivanjeZaBrisanje = biblioteka.nadjiIznajmljivanje(id);
                biblioteka.obrisiIznajmljivanje(iznajmljivanjeZaBrisanje);
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = (int) iznajmljivanjaTabela.getModel().getValueAt(iznajmljivanjaTabela.getSelectedRow(), 0);
                Iznajmljivanje iznajmljivanjeZaEdit = biblioteka.nadjiIznajmljivanje(id);
                IzmeniIzmajmljivanjeProzor iip = new IzmeniIzmajmljivanjeProzor(iznajmljivanjeZaEdit, IznajmljivanjaProzor.this);
                iip.setVisible(true);
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DodajIznajmljivanjeProzor dip = new DodajIznajmljivanjeProzor(IznajmljivanjaProzor.this);
                dip.setVisible(true);
            }
        });
    }


    public void updateTable() {
        Object[][] sadrzaj = new Object[biblioteka.getIznajmljivanja().size()][zaglavlja.length];

        for (int i = 0; i < biblioteka.getIznajmljivanja().size(); i++) {
            Iznajmljivanje iznajmljivanje = biblioteka.getIznajmljivanja().get(i);
            sadrzaj[i][0] = iznajmljivanje.getID();
            sadrzaj[i][1] = iznajmljivanje.getZaposleni().getKorisnickoIme();
            sadrzaj[i][2] = iznajmljivanje.getDatumIznajmljivanja();
            sadrzaj[i][3] = iznajmljivanje.getDatumVracanja();
            sadrzaj[i][4] = iznajmljivanje.getPrimerakKnjige().getKnjiga().getNaslovKnjige();
        }
        tableModel.setDataVector(sadrzaj, zaglavlja);
    }

    public Biblioteka getBiblioteka() {
        return biblioteka;
    }


}
