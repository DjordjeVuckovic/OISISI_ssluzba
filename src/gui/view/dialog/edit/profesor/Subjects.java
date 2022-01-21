package gui.view.dialog.edit.profesor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import gui.view.MainWindow;
import gui.view.center.ProfessorsTable;
import gui.view.dialog.edit.profesor.AddSubjectForProfessor;
//import gui.view.dialog.edit.Professor.GradeDialog;
import model.Professor;
import model.Subject;

public class Subjects extends JPanel{
    private ArrayList<Subject> Subjects;
    private Professor Professor;
    private JButton buttonAdd;
    private JButton buttonDelete;
    private SubjectsTable SubjectsTable;
    private Subjects SubjectsThis;
    private  Subject subject;

    public Subjects(JDialog parent,Professor pr){
        this.Professor = pr;
        setLayout(new BorderLayout());
        Subjects = Professor.getSubjects();
        SubjectsThis = this;

        JPanel downPane = new JPanel();
        downPane.setPreferredSize(new Dimension(30,30));
        JPanel rightPane = new JPanel();
        rightPane.setPreferredSize(new Dimension(30,30));
        JPanel leftPane = new JPanel();
        leftPane.setPreferredSize(new Dimension(30,30));
        SubjectsTable = new SubjectsTable();
        JScrollPane failedPane = new JScrollPane(SubjectsTable);
        JPanel cenPane = new JPanel(new BorderLayout());
        cenPane.add(failedPane,BorderLayout.CENTER);
        cenPane.add(rightPane,BorderLayout.EAST);
        cenPane.add(leftPane,BorderLayout.WEST);
        cenPane.add(downPane,BorderLayout.SOUTH);

        JPanel buttonPane = new JPanel(new FlowLayout(20,15,10));
        buttonPane.setPreferredSize(new Dimension(50,50));
        buttonAdd=new JButton("Dodaj");
        buttonDelete=new JButton("Brisanje");


        buttonPane.add(Box.createHorizontalStrut(0));
        buttonPane.add(buttonAdd);
        buttonPane.add(buttonDelete);

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddSubjectForProfessor(parent,SubjectsThis,Professor);
            }
        });

        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int selectedRow = SubjectsTable.getSelectedRow();
                if(selectedRow == -1) {
                    JOptionPane.showMessageDialog(parent, "Please select subject from table", "Warning", 0, null);
                }else {
                    int choice = JOptionPane.showConfirmDialog(MainWindow.getInstance(),"Upozorenje", "Da li ste sigurni?",0);
                    if(choice ==JOptionPane.YES_OPTION){
                        Subject sub = Subjects.get(selectedRow);
                        Subjects.remove(selectedRow);
                        Professor.removeSubjects(sub);
                        refreshTableIspiti();
                    }
                }
            }
        });


        this.add(buttonPane,BorderLayout.NORTH);
        this.add(cenPane,BorderLayout.CENTER);



    }
    private class SubjectsTable extends  JTable{
        public SubjectsTable(){
            setRowSelectionAllowed(true);
            setColumnSelectionAllowed(true);
            setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            setModel(new AbstractIspitiTable());
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
    }
    private class AbstractIspitiTable extends AbstractTableModel{
        @Override
        public int getRowCount() {
            return Subjects.size();
        }

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Subject subject=Subjects.get(rowIndex);
            switch (columnIndex){
                case 0:
                    return subject.getIdS();
                case 1:
                    return subject.getNameSub();
                case 2:
                    return Integer.toString(subject.getESPBpoints());
                case 3:
                    return subject.getYearOfStudy().name();
                case 4:
                    return subject.getSemester().name();
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
                    return "Year of study";
                case 4:
                    return "Semester";
                default:
                    return null;
            }
        }
    }
    public void refreshTableIspiti(){
        AbstractIspitiTable model = (AbstractIspitiTable) SubjectsTable.getModel();
        model.fireTableDataChanged();
        validate();
    }

}
