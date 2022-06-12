package gui.clanovi;

import biblioteka.Biblioteka;
import biblioteka_paket.Clan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClanoviProzor extends JFrame {
    private JToolBar mainToolbar = new JToolBar();
    private JButton btnAdd = new JButton();
    private JButton btnEdit = new JButton();
    private JButton btnDelete = new JButton();

    private DefaultTableModel tableModel;
    private JTable clanoviTabela;
    private String[] zaglavlja;

    private Biblioteka biblioteka;

    public ClanoviProzor(Biblioteka biblioteka) {
        this.biblioteka = biblioteka;
        setTitle("Clanovi");
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

        zaglavlja = new String[] {"ID", "Ime", "Prezime", "JMBG", "Broj cl karte", "Tip clanarine", "Datum poslednje uplate"};
        Object[][] sadrzaj = new Object[biblioteka.getClanovi().size()][zaglavlja.length];

        for (int i = 0; i < biblioteka.getClanovi().size(); i++) {
            Clan clan = biblioteka.getClanovi().get(i);
            sadrzaj[i][0] = clan.getID();
            sadrzaj[i][1] = clan.getIme();
            sadrzaj[i][2] = clan.getPrezime();
            sadrzaj[i][3] = clan.getJmbg();
            sadrzaj[i][4] = clan.getBrojClanskeKarte();
            sadrzaj[i][5] = clan.getClanarina().getNaziv();
            sadrzaj[i][6] = clan.getDatumPoslednjeUplate();
        }

        tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
        clanoviTabela = new JTable(tableModel);

        clanoviTabela.setRowSelectionAllowed(true);
        clanoviTabela.setColumnSelectionAllowed(false);
        clanoviTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        clanoviTabela.setDefaultEditor(Object.class, null);
        clanoviTabela.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(clanoviTabela);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initActions() {
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = (int) clanoviTabela.getModel().getValueAt(clanoviTabela.getSelectedRow(), 0);
                tableModel.removeRow(clanoviTabela.getSelectedRow());
                Clan clanZaBrisanje = biblioteka.nadjiClana(id);
                biblioteka.obrisiClana(clanZaBrisanje);
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = (int) clanoviTabela.getModel().getValueAt(clanoviTabela.getSelectedRow(), 0);
                Clan clanZaEdit = biblioteka.nadjiClana(id);
                IzmeniClanaProzor icp = new IzmeniClanaProzor(clanZaEdit, ClanoviProzor.this);
                icp.setVisible(true);
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DodajClanaProzor dcp = new DodajClanaProzor(ClanoviProzor.this);
                dcp.setVisible(true);
            }
        });
    }


    public void updateTable() {
        Object[][] sadrzaj = new Object[biblioteka.getClanovi().size()][zaglavlja.length];

        for (int i = 0; i < biblioteka.getClanovi().size(); i++) {
            Clan clan = biblioteka.getClanovi().get(i);
            sadrzaj[i][0] = clan.getID();
            sadrzaj[i][1] = clan.getIme();
            sadrzaj[i][2] = clan.getPrezime();
            sadrzaj[i][3] = clan.getJmbg();
            sadrzaj[i][4] = clan.getBrojClanskeKarte();
            sadrzaj[i][5] = clan.getClanarina().getNaziv();
            sadrzaj[i][6] = clan.getDatumPoslednjeUplate();
        }
        tableModel.setDataVector(sadrzaj, zaglavlja);
    }

    public Biblioteka getBiblioteka() {
        return biblioteka;
    }
}
