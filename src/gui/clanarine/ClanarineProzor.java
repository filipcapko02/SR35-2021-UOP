package gui.clanarine;

import biblioteka.Biblioteka;
import biblioteka_paket.Clanarina;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClanarineProzor extends JFrame {

    private JToolBar mainToolbar = new JToolBar();
    private JButton btnAdd = new JButton();
    private JButton btnEdit = new JButton();
    private JButton btnDelete = new JButton();

    private DefaultTableModel tableModel;
    private JTable clanarineTable;
    private String[] zaglavlja;

    private Biblioteka biblioteka;

    public ClanarineProzor(Biblioteka biblioteka) {
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

        zaglavlja = new String[] {"ID", "Naziv", "Cena"};
        Object[][] sadrzaj = new Object[biblioteka.getClanarine().size()][zaglavlja.length];

        for (int i = 0; i < biblioteka.getClanarine().size(); i++) {
            Clanarina clanarina = biblioteka.getClanarine().get(i);
            sadrzaj[i][0] = clanarina.getID();
            sadrzaj[i][1] = clanarina.getNaziv();
            sadrzaj[i][2] = clanarina.getCena();
        }

        tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
        clanarineTable = new JTable(tableModel);

        clanarineTable.setRowSelectionAllowed(true);
        clanarineTable.setColumnSelectionAllowed(false);
        clanarineTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        clanarineTable.setDefaultEditor(Object.class, null);
        clanarineTable.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(clanarineTable);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initActions() {
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String naziv = (String) clanarineTable.getModel().getValueAt(clanarineTable.getSelectedRow(), 1);
                tableModel.removeRow(clanarineTable.getSelectedRow());
                Clanarina clanarinaZaBrisanje = biblioteka.nadjiClanarinu(naziv);
                biblioteka.getClanarine().remove(clanarinaZaBrisanje);
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String naziv = (String) clanarineTable.getModel().getValueAt(clanarineTable.getSelectedRow(), 1);
                Clanarina clanarinaZaEdit = biblioteka.nadjiClanarinu(naziv);
                IzmeniClanarinuProzor icp = new IzmeniClanarinuProzor(clanarinaZaEdit, ClanarineProzor.this);
                icp.setVisible(true);
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DodajClanarinuProzor dcp = new DodajClanarinuProzor(ClanarineProzor.this);
                dcp.setVisible(true);
            }
        });
    }


    public void updateTable() {
        Object[][] sadrzaj = new Object[biblioteka.getClanarine().size()][zaglavlja.length];

        for (int i = 0; i < biblioteka.getClanarine().size(); i++) {
            Clanarina clanarina = biblioteka.getClanarine().get(i);
            sadrzaj[i][0] = clanarina.getID();
            sadrzaj[i][1] = clanarina.getNaziv();
            sadrzaj[i][2] = clanarina.getCena();
        }
        tableModel.setDataVector(sadrzaj, zaglavlja);
    }

    public Biblioteka getBiblioteka() {
        return biblioteka;
    }
}
