package controller;

import gui.view.center.DepartmentsTable;
import model.BazaKatedri;
import model.BazaProfesora;
import model.Department;
import model.Professor;

public class DepartmentController {
    private static  DepartmentController instance = null;
    public static DepartmentController getInstance(){
        if(instance==null){
            instance = new DepartmentController();
        }
        return instance;
    }
    public void addDepartment(Department dep){
        BazaKatedri.getInstance().addDepartment(dep);
        DepartmentsTable.getInstance().refreshTable();
    }
    public Department getDepById(String id){
        Department dep = BazaKatedri.getInstance().findDep(id);
        return dep;
    }
}
