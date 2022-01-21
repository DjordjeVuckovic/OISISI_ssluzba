package model;

import serial.Serialization;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class BazaKatedri implements AbstractModel, Serializable {
    @Serial
    private static final long serialVersionUID = -801304646706947325L;
    private ArrayList<Department> departments;
    private ArrayList<String> columns;
    private Department katedra;
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
        columns.add("Sifra");
        columns.add("Naziv");
        columns.add("id_sefa_katedre");
    }
    private void init(){

		departments.add(new Department(1,"e42", "Katedra za matematiku", BazaProfesora.getInstance().getProfessorById("321321321")));
        departments.add(new Department(2,"e43", "Katedra za fiziku",BazaProfesora.getInstance().getProfessorById("456456456")));
        departments.add(new Department(3,"e44", "Katedra za elektrotehniku", BazaProfesora.getInstance().getProfessorById("789789789")));
        departments.add(new Department(4,"e45", "Katedra za primenjene racunarske nauke", BazaProfesora.getInstance().getProfessorById("559585632")));
        departments.add(new Department(5,"e46", "Katedra za informatiku", BazaProfesora.getInstance().getProfessorById("721254363")));
        departments.add(new Department(6,"e47", "Katedra za automatiku", BazaProfesora.getInstance().getProfessorById("500500544")));
        deserijalizacija();
    }
    private void deserijalizacija(){
        BazaPodataka bp = Serialization.readFile();
        if(bp !=null)
            this.departments = bp.getDepartments();
    }
    public ArrayList<Department> getDepartments() {
		return departments;
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

    public Department getDepartmanByRow(int row){
		return departments.get(row);
	}

    @Override
    public boolean isEmpty() {
        return false;
    }
    
    public void deleteKatedra(Department d){departments.remove(d);}
    
}
