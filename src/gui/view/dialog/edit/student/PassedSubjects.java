package gui.view.dialog.edit.student;

import controller.StudentController;
import gui.view.MainWindow;
import model.Grade;
import model.Student;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PassedSubjects extends JPanel {
    private JButton btCancelGrade;
    private JTextField txtAvgGrade;
    private JTextField txtSumPoints;
    private PassedSubjectsTable passedSubjectsTable;
    private Student student;

    public PassedSubjects(){};

    public PassedSubjects(Student student){
        this.student = student;
        Dimension dimension = new Dimension(50,20);
        setLayout(new BorderLayout());
        txtAvgGrade= new JTextField();
        txtSumPoints = new JTextField();
        txtSumPoints.setEditable(false);
        txtSumPoints.setPreferredSize(dimension);
        txtSumPoints.setBorder(null);
        txtAvgGrade.setBorder(null);
        txtAvgGrade.setEditable(false);

        JPanel cancelGradePane = new JPanel(new FlowLayout(20,10,10));
        JPanel centralTablePane = new JPanel(new BorderLayout());
        JPanel AvgSumPane = new JPanel();
        BoxLayout AvgSumBox = new BoxLayout(AvgSumPane,BoxLayout.Y_AXIS);
        AvgSumPane.setLayout(AvgSumBox);

        passedSubjectsTable= new PassedSubjectsTable();
        JScrollPane panScroll = new JScrollPane(passedSubjectsTable);
        centralTablePane.add(panScroll,BorderLayout.CENTER);

        btCancelGrade = new JButton("Cancel Grade");
        cancelGradePane.add(btCancelGrade);
        btCancelGrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedSubject = passedSubjectsTable.getSelectedRow();
                if(selectedSubject==-1){
                    JOptionPane.showMessageDialog(MainWindow.getInstance(),"Odaberite predmet za brisanje","Upozorenje",0,null);
                }
                else{
                    int choice = JOptionPane.showConfirmDialog(MainWindow.getInstance(),"Upozorenje", "Da li ste sigurni?",0);
                    if(choice ==JOptionPane.YES_OPTION){
                        Grade grade = student.getGradeTable(selectedSubject);
                        student.cancelGrade(grade);

                    }
                }
            }
        });    //- ovde dodajes akciju brisanja
        JLabel lbAvgGrade  =new JLabel("Prosecna ocena:");
        JLabel lbSum = new JLabel("Ukupno ESPB:");
        lbAvgGrade.setPreferredSize(new Dimension(100,20));
        lbSum.setPreferredSize(new Dimension(100,20));

        JPanel panAvgGrade = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel panSum = new JPanel(new FlowLayout(FlowLayout.LEFT));

        panAvgGrade.add(lbAvgGrade);
        panAvgGrade.add(txtAvgGrade);
        panSum.add(lbSum);
        panSum.add(txtSumPoints);
        AvgSumPane.add(panAvgGrade);
        AvgSumPane.add(panSum);

        this.add(cancelGradePane,BorderLayout.NORTH);
        this.add(centralTablePane,BorderLayout.CENTER);
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        this.add(leftPanel,BorderLayout.EAST);
        this.add(rightPanel,BorderLayout.WEST);
        this.add(AvgSumPane,BorderLayout.SOUTH);


    }
    private class PassedSubjectsTable extends JTable {
        public PassedSubjectsTable(){
            setRowSelectionAllowed(true);
            setColumnSelectionAllowed(true);
            setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            setModel(new AbstractPassedTable());
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
    private class AbstractPassedTable extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return student.getPassedExams().size();
        }

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Grade grade=student.getPassedExams().get(rowIndex);
            switch (columnIndex){
                case 0:
                    return grade.getSubject().getIdS();
                case 1:
                    return grade.getSubject().getNameSub();
                case 2:
                    return Integer.toString(grade.getSubject().getESPBpoints());
                case 3:
                    return Integer.toString(grade.getGrade());
                case 4:
                    return grade.getExamDateString();
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
                    return "Grade";
                case 4:
                    return "Date";
                default:
                    return null;
            }
        }

    }


    public void refreshTable(){

    }
}
