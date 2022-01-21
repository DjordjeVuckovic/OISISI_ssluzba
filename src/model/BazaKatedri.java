package model;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class BazaKatedri implements AbstractModel, Serializable {
    @Serial
    private static final long serialVersionUID = -801304646706947325L;
    private ArrayList<Department> departments;
    private ArrayList<String> columns;
    private static BazaKatedri instance = null;
    public static BazaKatedri getInstance(){
        if(instance ==null){
            instance = new BazaKatedri();
        }
        return instance;
    }
    private BazaKatedri(){
        departments = new ArrayList<>();
        init();
        this.columns = new ArrayList<>();
        columns.add("Naziv");
        columns.add("Sifra");
        columns.add("Id Šefa");
    }
    private void init(){
        departments.add(new Department("KA1","Automatika"));
        departments.add(new Department("KA12","PRNI"));
        departments.add(new Department("KA12","RTRK"));
    }

    @Override
    public int getColumnCount() {
        return columns.size();
    }

    @Override
    public int getRowCount() {
        return departments.size();
    }

    @Override
    public String getColumnName(int col) {
        return columns.get(col);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Department department = departments.get(rowIndex);
        switch(columnIndex){
            case 0:
                return department.getId();
            case 1:
                return department.getName();
            case 2:
                if(department.getDirector() !=null){
                    return department.getDirector().getIdNumber();
                }else {
                    return "NEPOZNAT";
                }
            default:
                return null;
        }
    }
    public void addDepartment(Department dep){
        this.departments.add(dep);
    }
    public Department findDep(String id){
        for(Department dep:departments){
            if(dep.getId().equals(id)){
                return dep;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
