package gui.view.dialog.edit.student;

import gui.view.dialog.MyDialog;
import model.AbstractModel;
import model.BazaPredmeta;
import model.Student;
import model.Subject;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;
import java.util.ArrayList;

public class AddSubjectForStudent extends JDialog {
    @Serial
    private static final long serialVersionUID = 5072538040319452064L;

    private ArrayList<Subject> possibleSubjects;
    private SubjectTableEdit subjectTableEdit;

    public AddSubjectForStudent(JDialog parent,FailedSubjects failedSubjects,Student student){
        super(parent,"Add subject",true);
        setSize(450,450);
        setResizable(false);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());


        possibleSubjects = BazaPredmeta.getInstance().getPossibleSubject(student);
        JPanel cenPane = new JPanel(new BorderLayout());
        cenPane.setBackground(Color.CYAN);
        subjectTableEdit = new SubjectTableEdit();
        JScrollPane subPane = new JScrollPane(subjectTableEdit);
        cenPane.add(subPane,BorderLayout.CENTER);
        refreshSbTable();

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int selectedRow = subjectTableEdit.getSelectedRow();

                if(selectedRow == -1) {
                    JOptionPane.showMessageDialog(parent, "Please select subject", "Warning", 0, null);
                }
                else {
                    // add to failed subject
                    Subject sub = possibleSubjects.get(selectedRow);
                    student.addFailedExam(sub);
                    failedSubjects.refreshTableFailed();
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

    private class SubjectTableEdit extends JTable{
        public SubjectTableEdit(){
            setRowSelectionAllowed(true);
            setColumnSelectionAllowed(true);
            setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            setModel(new AbstractSubjectTableEdit());

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
    private class AbstractSubjectTableEdit extends AbstractTableModel{

        @Override
        public int getRowCount() {
            return possibleSubjects.size();
        }

        @Override
        public int getColumnCount() {
            return 1;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Subject sub = possibleSubjects.get(rowIndex);
            return sub.getIdS() + "-" + sub.getNameSub();
        }
        public String getColumnName(int column) {
            return "Subjects";
        }
    }
    public void refreshSbTable(){
        AbstractSubjectTableEdit model = (AbstractSubjectTableEdit) subjectTableEdit.getModel();
        model.fireTableDataChanged();
        validate();
    }
}
