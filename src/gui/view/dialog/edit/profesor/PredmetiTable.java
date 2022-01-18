package gui.view.dialog.edit.profesor;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import model.Professor;
import model.Subject;

public class PredmetiTable extends JTable {
    private Professor profesor;
    public PredmetiTable(){
        setRowSelectionAllowed(true);
        setColumnSelectionAllowed(true);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setModel(new AbstractPassedTable());
    }

    public Professor getProfessor() {
        return profesor;
    }

    public void setProfessor(Professor Professor) {
        this.profesor = Professor;
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component c = super.prepareRenderer(renderer, row, column);
        if (isRowSelected(row)) {
            c.setBackground(Color.LIGHT_GRAY);
        } else {
            c.setBackground(Color.WHITE);
        }
        return c;
    }
    public class AbstractPassedTable extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return Professor.getSubjects().size();
        }

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
           Subject subject=Professor.getSubjects().get(rowIndex);
           switch (columnIndex){
               case 0:
                   return subject.getIdS();
               case 1:
                   return subject.getNameSub();
               case 2:
                   return Integer.toString(subject.getESPBpoints());
               case 3:
                   return subject.getProfessor();
               default:
                   return  null;
           }
        }
        public String getColumnName(int column) {
            switch (column){
                case 0:
                    return "Id of Subject";
                case 1:
                    return "Name of Subject";
                case 2:
                    return "ESPB points";
                case 3:
                    return "Profesor na predmetu";
                default:
                    return null;
            }
        }
        public void refreshTable(){

        }

    }


    }

