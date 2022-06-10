package gui.knjige;

import biblioteka.Biblioteka;
import biblioteka_paket.Knjiga;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KnjigeProzor extends JFrame {

    private JToolBar mainToolbar = new JToolBar();
    private JButton btnAdd = new JButton();
    private JButton btnEdit = new JButton();
    private JButton btnDelete = new JButton();

    private DefaultTableModel tableModel;
    private JTable knjigeTabela;
    private String[] zaglavlja;

    private Biblioteka biblioteka;

    public KnjigeProzor(Biblioteka biblioteka) {
        this.biblioteka = biblioteka;
        setTitle("Knjige");
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

        zaglavlja = new String[] {"ID", "Naslov", "Zanr", "Ime pisca", "Godina"};
        Object[][] sadrzaj = new Object[biblioteka.getKnjige().size()][zaglavlja.length];

        for (int i = 0; i < biblioteka.getKnjige().size(); i++) {
            Knjiga knjiga = biblioteka.getKnjige().get(i);
            sadrzaj[i][0] = knjiga.getID();
            sadrzaj[i][1] = knjiga.getNaslovKnjige();
            sadrzaj[i][2] = knjiga.getZanr().getOznaka();
            sadrzaj[i][3] = knjiga.getImePisca();
            sadrzaj[i][4] = knjiga.getGodinaObjave();
        }

        tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
        knjigeTabela = new JTable(tableModel);

        knjigeTabela.setRowSelectionAllowed(true);
        knjigeTabela.setColumnSelectionAllowed(false);
        knjigeTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        knjigeTabela.setDefaultEditor(Object.class, null);
        knjigeTabela.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(knjigeTabela);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initActions() {
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = (int) knjigeTabela.getModel().getValueAt(knjigeTabela.getSelectedRow(), 0);
                tableModel.removeRow(knjigeTabela.getSelectedRow());
                Knjiga knjigaZaBrisanje = biblioteka.nadjiKnjigu(id);
                biblioteka.obrisiKnjigu(knjigaZaBrisanje);
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = (int) knjigeTabela.getModel().getValueAt(knjigeTabela.getSelectedRow(), 0);
                Knjiga knjigaZaEdit = biblioteka.nadjiKnjigu(id);
                IzmenaKnjigeProzor ikp = new IzmenaKnjigeProzor(knjigaZaEdit, KnjigeProzor.this);
                ikp.setVisible(true);
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DodajKnjiguProzor dkp = new DodajKnjiguProzor(KnjigeProzor.this);
                dkp.setVisible(true);
            }
        });
    }


    public void updateTable() {
        Object[][] sadrzaj = new Object[biblioteka.getKnjige().size()][zaglavlja.length];

        for (int i = 0; i < biblioteka.getKnjige().size(); i++) {
            Knjiga knjiga = biblioteka.getKnjige().get(i);
            sadrzaj[i][0] = knjiga.getID();
            sadrzaj[i][1] = knjiga.getNaslovKnjige();
            sadrzaj[i][2] = knjiga.getZanr().getOznaka();
            sadrzaj[i][3] = knjiga.getImePisca();
            sadrzaj[i][4] = knjiga.getGodinaObjave();
        }
        tableModel.setDataVector(sadrzaj, zaglavlja);
    }

    public Biblioteka getBiblioteka() {
        return biblioteka;
    }
}
