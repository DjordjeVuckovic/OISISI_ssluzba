package model;

public interface AbstractTableModel {
    int getColumnCount();
    int getRowCount();
    String getColumnName(int col);
    Object getValueAt(int rowIndex, int columnIndex);
    boolean isEmpty();
}
