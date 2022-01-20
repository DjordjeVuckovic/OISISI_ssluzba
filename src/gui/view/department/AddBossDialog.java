package gui.view.department;

import gui.view.center.DepartmentsTable;
import model.BazaProfesora;
import model.Professor;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddBossDialog extends JDialog {
    private ArrayList<Professor> possibleBosses;
    private TableBoss table;
    private Professor selectedBoss = null;
    public AddBossDialog(JDialog parent){
        super(parent,"Odabir mogucih šefova",true);
        setSize(450,400);
        setResizable(false);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());
        possibleBosses = BazaProfesora.getInstance().checkForBosses();

        JPanel cenPane = new JPanel(new BorderLayout());
        cenPane.setBackground(Color.CYAN);
        table = new TableBoss();
        JScrollPane subPane = new JScrollPane(table);
        cenPane.add(subPane,BorderLayout.CENTER);
        this.refreshTable();

        JButton btnAdd = new JButton("Postavi šefa");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int selectedRow = table.getSelectedRow();

                if(selectedRow == -1) {
                    JOptionPane.showMessageDialog(parent, "Please select boss", "Warning", 0, null);
                }
                else {
                    selectedBoss = possibleBosses.get(selectedRow);
                    refreshTable();
                    DepartmentsTable.getInstance().refreshTable();
                    dispose();
                }

            }
        });

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });
        JPanel btnPane = new JPanel(new FlowLayout(5,10,10));
        btnPane.setPreferredSize(new Dimension(50,50));
        btnPane.add(Box.createHorizontalStrut(30));
        btnPane.add(btnAdd);
        btnPane.add(Box.createHorizontalStrut(15));
        btnPane.add(btnCancel);

        JPanel downPane = new JPanel();
        JPanel leftPane = new JPanel();
        JPanel rightPane = new JPanel();
        downPane.setPreferredSize(new Dimension(30,30));
        leftPane.setPreferredSize(new Dimension(10,10));
        rightPane.setPreferredSize(new Dimension(10,10));
        add(downPane, BorderLayout.NORTH);
        add(btnPane, BorderLayout.SOUTH);
        add(leftPane, BorderLayout.WEST);
        add(rightPane, BorderLayout.EAST);
        add(cenPane, BorderLayout.CENTER);

        setVisible(true);

    }
        private  class TableBoss extends JTable{
            public TableBoss(){
                setRowSelectionAllowed(true);
                setColumnSelectionAllowed(true);
                setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                setModel(new AbstractBoss());
            }
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                if (isRowSelected(row)) {
                    c.setBackground(Color.LIGHT_GRAY);
                } else {
                    c.setBackground(Color.WHITE);
                }
                return c;
            }
        }
    private class AbstractBoss extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return possibleBosses.size();
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Professor professor = possibleBosses.get(rowIndex);
            switch(columnIndex) {
                case 0:
                    return professor.getIdNumber();
                case 1:
                    return  professor.getName();
                case 2:
                    return professor.getSurname();
                default:
                    return null;
               // return professor.getIdNumber() + " " + professor.getName() + " " + professor.getSurname();
            }
        }
        public String getColumnName(int column) {
            switch(column) {
                case 0:
                return "Id";
                case 1:
                    return "Ime";
                case 2:
                    return "Prezime";
                default:
                    return null;
            }
        }
    }
    public void refreshTable(){
        AbstractBoss model = (AbstractBoss) table.getModel();
        model.fireTableDataChanged();
        validate();
    }
    public Professor getSelectedBoss(){
        return selectedBoss;
    }
}
