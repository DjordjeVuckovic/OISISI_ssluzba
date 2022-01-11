/*
 * package gui.view.dialog.edit.professor;
 * 
 * import model.Grade; import model.Professor;
 * 
 * import javax.swing.*; import javax.swing.table.AbstractTableModel; import
 * javax.swing.table.TableCellRenderer; import java.awt.*; import
 * java.util.HashMap; import java.util.Map;
 * 
 * public class SubjectsTable extends JTable { private Professor profesor;
 * private JTextField txtAvgGrade; private JTextField txtEspbSum; public
 * SubjectsTable(){ setRowSelectionAllowed(true);
 * setColumnSelectionAllowed(true);
 * setSelectionMode(ListSelectionModel.SINGLE_SELECTION); setModel(new
 * AbstractPassedTable()); }
 * 
 * public Professor getProfessor() { return profesor; }
 * 
 * public void setProfessor(Professor Professor) { this.profesor = Professor; }
 * 
 * @Override public Component prepareRenderer(TableCellRenderer renderer, int
 * row, int column) { Component c = super.prepareRenderer(renderer, row,
 * column); if (isRowSelected(row)) { c.setBackground(Color.LIGHT_GRAY); } else
 * { c.setBackground(Color.WHITE); } return c; } public class
 * AbstractPassedTable extends AbstractTableModel {
 * 
 * @Override public int getRowCount() { return Professor.getSubjects().size(); }
 * 
 * @Override public int getColumnCount() { return 5; }
 * 
 * @Override public Object getValueAt(int rowIndex, int columnIndex) { Grade
 * grade=Professor.getSubjects().get(rowIndex); switch (columnIndex){ case 0:
 * return grade.getSubject().getIdS(); case 1: return
 * grade.getSubject().getNameSub(); case 2: return
 * Integer.toString(grade.getSubject().getESPBpoints()); case 3: return
 * Integer.toString(grade.getGrade()); case 4: return grade.getExamDateString();
 * default: return null; } } public String getColumnName(int column) { switch
 * (column){ case 0: return "Id of Subject"; case 1: return "Name of Subject";
 * case 2: return "ESPB points"; case 3: return "Grade"; case 4: return "Date";
 * default: return null; } } public void refreshTable(){
 * 
 * }
 * 
 * }
 * 
 * 
 * 
 * }
 * 
 */