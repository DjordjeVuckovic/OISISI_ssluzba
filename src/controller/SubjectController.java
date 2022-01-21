package controller;

import java.util.ArrayList;

import gui.view.MainWindow;
import gui.view.center.SubjectTable;
import model.BazaPredmeta;
import model.Subject;

public class SubjectController {
    private static  SubjectController instance = null;
    public static SubjectController getInstance(){
        if(instance==null){
            instance = new SubjectController();
        }
        return instance;
    }
    private SubjectController (){}
    public void addSubject(Subject subject){
        BazaPredmeta.getInstance().addSubject(subject);
        SubjectTable.getInstance().refreshTable();
    }
    public Subject findSubjectById( String id){
        Subject subject =BazaPredmeta.getInstance().findSubjectById(id);
        return subject;
    }
    public void editSubject(Subject oldSub,Subject nSub ){
        oldSub.setNameSub(nSub.getNameSub());
        oldSub.setIdS(nSub.getIdS());
        oldSub.setESPBpoints(nSub.getESPBpoints());
        oldSub.setYearOfStudy(nSub.getYearOfStudy());
        oldSub.setSemester(nSub.getSemester());
        SubjectTable.getInstance().refreshTable();
    }
    
    public Subject getPredmet(int rowIndex) {
		Subject p=BazaPredmeta.getInstance().getPredmet(rowIndex);		
		return p;
	}
    
    public ArrayList<Subject> getPredmeti() {
		return BazaPredmeta.getInstance().getSubjects();
	}
    
    public void editSubject2(int i, Subject p) {
		BazaPredmeta.getInstance().editSubject2(i, p);
		SubjectTable.getInstance().refreshTable();
	}
}
