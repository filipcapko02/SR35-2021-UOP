package gui.primerci;

import biblioteka.Biblioteka;
import biblioteka_paket.PrimerakKnjige;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimerciProzor extends JFrame {

    private JToolBar mainToolbar = new JToolBar();
    private JButton btnAdd = new JButton();
    private JButton btnEdit = new JButton();
    private JButton btnDelete = new JButton();

    private DefaultTableModel tableModel;
    private JTable primerciTabela;
    private String[] zaglavlja;

    private Biblioteka biblioteka;

    public PrimerciProzor(Biblioteka biblioteka) {
        this.biblioteka = biblioteka;
        setTitle("Primerci knjiga");
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

        zaglavlja = new String[] {"ID", "Knjiga", "Broj strana", "Povez", "Godina stampanja", "Jezik", "Iznajmljena"};
        Object[][] sadrzaj = new Object[biblioteka.getPrimerciKnjiga().size()][zaglavlja.length];

        for (int i = 0; i < biblioteka.getPrimerciKnjiga().size(); i++) {
            PrimerakKnjige primerakKnjige = biblioteka.getPrimerciKnjiga().get(i);
            sadrzaj[i][0] = primerakKnjige.getID();
            sadrzaj[i][1] = primerakKnjige.getKnjiga().getNaslovKnjige();
            sadrzaj[i][2] = primerakKnjige.getBrojStrana();
            sadrzaj[i][3] = primerakKnjige.getPovez();
            sadrzaj[i][4] = primerakKnjige.getGodinaStampanja();
            sadrzaj[i][5] = primerakKnjige.getJezik();
            sadrzaj[i][6] = primerakKnjige.isIznajmljena() ? "Da" : "Ne";
        }

        tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
        primerciTabela = new JTable(tableModel);

        primerciTabela.setRowSelectionAllowed(true);
        primerciTabela.setColumnSelectionAllowed(false);
        primerciTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        primerciTabela.setDefaultEditor(Object.class, null);
        primerciTabela.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(primerciTabela);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initActions() {
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = (int) primerciTabela.getModel().getValueAt(primerciTabela.getSelectedRow(), 0);
                tableModel.removeRow(primerciTabela.getSelectedRow());
                PrimerakKnjige knjigaZaBrisanje = biblioteka.nadjiPrimerakKnjige(id);
                biblioteka.obrisiPrimerakKnjige(knjigaZaBrisanje);
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = (int) primerciTabela.getModel().getValueAt(primerciTabela.getSelectedRow(), 0);
                PrimerakKnjige knjigaZaEdit = biblioteka.nadjiPrimerakKnjige(id);
                IzmenaPrimerkaProzor ipp = new IzmenaPrimerkaProzor(knjigaZaEdit, PrimerciProzor.this);
                ipp.setVisible(true);
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DodajPrimerakProzor dpp = new DodajPrimerakProzor(PrimerciProzor.this);
                dpp.setVisible(true);
            }
        });
    }


    public void updateTable() {
        Object[][] sadrzaj = new Object[biblioteka.getPrimerciKnjiga().size()][zaglavlja.length];

        for (int i = 0; i < biblioteka.getPrimerciKnjiga().size(); i++) {
            PrimerakKnjige primerakKnjige = biblioteka.getPrimerciKnjiga().get(i);
            sadrzaj[i][0] = primerakKnjige.getID();
            sadrzaj[i][1] = primerakKnjige.getKnjiga().getNaslovKnjige();
            sadrzaj[i][2] = primerakKnjige.getBrojStrana();
            sadrzaj[i][3] = primerakKnjige.getPovez();
            sadrzaj[i][4] = primerakKnjige.getGodinaStampanja();
            sadrzaj[i][5] = primerakKnjige.getJezik();
            sadrzaj[i][6] = primerakKnjige.isIznajmljena() ? "Da" : "Ne";
        }
        tableModel.setDataVector(sadrzaj, zaglavlja);
    }

    public Biblioteka getBiblioteka() {
        return biblioteka;
    }
}
