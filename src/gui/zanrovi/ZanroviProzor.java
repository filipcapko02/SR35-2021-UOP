package gui.zanrovi;

import biblioteka.Biblioteka;
import biblioteka_paket.Clanarina;
import biblioteka_paket.Zanr;
import gui.clanarine.ClanarineProzor;
import gui.clanarine.DodajClanarinuProzor;
import gui.clanarine.IzmeniClanarinuProzor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZanroviProzor extends JFrame {

    private JToolBar mainToolbar = new JToolBar();
    private JButton btnAdd = new JButton();
    private JButton btnEdit = new JButton();
    private JButton btnDelete = new JButton();

    private DefaultTableModel tableModel;
    private JTable zanroviTable;
    private String[] zaglavlja;

    private Biblioteka biblioteka;

    public ZanroviProzor(Biblioteka biblioteka) {
        this.biblioteka = biblioteka;
        setTitle("Clanarine");
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

        zaglavlja = new String[] {"ID", "Oznaka", "Opis"};
        Object[][] sadrzaj = new Object[biblioteka.getZanrovi().size()][zaglavlja.length];

        for (int i = 0; i < biblioteka.getZanrovi().size(); i++) {
            Zanr zanr = biblioteka.getZanrovi().get(i);
            sadrzaj[i][0] = zanr.getID();
            sadrzaj[i][1] = zanr.getOznaka();
            sadrzaj[i][2] = zanr.getOpis();
        }

        tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
        zanroviTable = new JTable(tableModel);

        zanroviTable.setRowSelectionAllowed(true);
        zanroviTable.setColumnSelectionAllowed(false);
        zanroviTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        zanroviTable.setDefaultEditor(Object.class, null);
        zanroviTable.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(zanroviTable);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initActions() {
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oznaka = (String) zanroviTable.getModel().getValueAt(zanroviTable.getSelectedRow(), 1);
                tableModel.removeRow(zanroviTable.getSelectedRow());
                Zanr zanrZaBrisanje = biblioteka.nadjiZanr(oznaka);
                biblioteka.obrisiZanr(zanrZaBrisanje);
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oznaka = (String) zanroviTable.getModel().getValueAt(zanroviTable.getSelectedRow(), 1);
                Zanr zanrZaEdit = biblioteka.nadjiZanr(oznaka);
                IzmeniZanrProzor izp = new IzmeniZanrProzor(zanrZaEdit , ZanroviProzor.this);
                izp.setVisible(true);
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DodajZanrProzor dzp = new DodajZanrProzor(ZanroviProzor.this);
                dzp.setVisible(true);
            }
        });
    }


    public void updateTable() {
        Object[][] sadrzaj = new Object[biblioteka.getZanrovi().size()][zaglavlja.length];

        for (int i = 0; i < biblioteka.getZanrovi().size(); i++) {
            Zanr zanr = biblioteka.getZanrovi().get(i);
            sadrzaj[i][0] = zanr.getID();
            sadrzaj[i][1] = zanr.getOznaka();
            sadrzaj[i][2] = zanr.getOpis();
        }
        tableModel.setDataVector(sadrzaj, zaglavlja);
    }

    public Biblioteka getBiblioteka() {
        return biblioteka;
    }
}
