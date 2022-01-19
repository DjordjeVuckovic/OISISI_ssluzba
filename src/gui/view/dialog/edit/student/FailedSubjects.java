package gui.view.dialog.edit.student;

import gui.view.MainWindow;
import gui.view.center.StudentsTable;
import model.Grade;
import model.Student;
import model.Subject;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FailedSubjects extends JPanel{
    private ArrayList<Subject> failedSubjects;
    private Student student;
    private JButton buttonAdd;
    private JButton buttonDelete;
    private JButton buttonTC;
    private FailedSubjectsTable failedSubjectsTable;
    private FailedSubjects failedSubjectsThis;
    private  Subject subject;

    public FailedSubjects(JDialog parent,Student st){
        this.student = st;
        setLayout(new BorderLayout());
        failedSubjects = student.getFailedExams();
        failedSubjectsThis = this;

        JPanel downPane = new JPanel();
        downPane.setPreferredSize(new Dimension(30,30));
        JPanel rightPane = new JPanel();
        rightPane.setPreferredSize(new Dimension(30,30));
        JPanel leftPane = new JPanel();
        leftPane.setPreferredSize(new Dimension(30,30));
        failedSubjectsTable = new FailedSubjectsTable();
        JScrollPane failedPane = new JScrollPane(failedSubjectsTable);
        JPanel cenPane = new JPanel(new BorderLayout());
        cenPane.add(failedPane,BorderLayout.CENTER);
        cenPane.add(rightPane,BorderLayout.EAST);
        cenPane.add(leftPane,BorderLayout.WEST);
        cenPane.add(downPane,BorderLayout.SOUTH);

        JPanel buttonPane = new JPanel(new FlowLayout(20,15,10));
        buttonPane.setPreferredSize(new Dimension(50,50));
        buttonAdd=new JButton("Dodaj");
        buttonDelete=new JButton("Brisanje");
        buttonTC=new JButton("Polaganje");

        buttonPane.add(Box.createHorizontalStrut(0));
        buttonPane.add(buttonAdd);
        buttonPane.add(buttonDelete);
        buttonPane.add(buttonTC);

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddSubjectForStudent(parent,failedSubjectsThis,student);
            }
        });

        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int selectedRow = failedSubjectsTable.getSelectedRow();
                if(selectedRow == -1) {
                    JOptionPane.showMessageDialog(parent, "Please select subject from table", "Warning", 0, null);
                }else {
                    int choice = JOptionPane.showConfirmDialog(MainWindow.getInstance(),"Upozorenje", "Da li ste sigurni?",0);
                    if(choice ==JOptionPane.YES_OPTION){
                        Subject sub = failedSubjects.get(selectedRow);
                        failedSubjects.remove(selectedRow);
                        student.removeFailedExam(sub);
                        refreshTableFailed();
                    }
                }
            }
        });

        buttonTC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            int selection  = failedSubjectsTable.getSelectedRow();
            if(selection==-1){
                JOptionPane.showMessageDialog(parent, "Please select subject from table", "Warning", 0, null);
            }else{
                subject = failedSubjects.get(selection);
                GradeDialog gradeDialog = new GradeDialog(parent,student,subject);
                gradeDialog.setVisible(true);
                refreshTableFailed();
                StudentsTable.getInstance().refreshTable();
            }

            }
        });




        this.add(buttonPane,BorderLayout.NORTH);
        this.add(cenPane,BorderLayout.CENTER);



    }
    private class FailedSubjectsTable extends  JTable{
        public FailedSubjectsTable(){
            setRowSelectionAllowed(true);
            setColumnSelectionAllowed(true);
            setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            setModel(new AbstractFailedTable());
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
    private class AbstractFailedTable extends AbstractTableModel{
        @Override
        public int getRowCount() {
            return failedSubjects.size();
        }

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Subject subject=failedSubjects.get(rowIndex);
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
    public void refreshTableFailed(){
        AbstractFailedTable model = (AbstractFailedTable) failedSubjectsTable.getModel();
        model.fireTableDataChanged();
        validate();
    }

}
