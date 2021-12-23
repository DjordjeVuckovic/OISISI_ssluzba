package model;

public interface AbstractModel {
    int getColumnCount();
    int getRowCount();
    String getColumnName(int col);
    Object getValueAt(int rowIndex, int columnIndex);
    boolean isEmpty();
}
