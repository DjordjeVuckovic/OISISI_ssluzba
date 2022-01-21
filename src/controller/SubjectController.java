package controller;

import gui.view.center.SubjectTable;
import model.BazaPredmeta;
import model.BazaStudenata;
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
    
    public void deleteSubject(int row){
        if(row <0){
            return;
        }
        Subject predmet= BazaPredmeta.getInstance().getSubjectByRow(row);
        BazaPredmeta.getInstance().deleteSubject(predmet);
        //ref zavisnost sa studentom
        BazaStudenata.getInstance().DeleteSubjectForStudent(predmet.getIdS());
        //ref zavisnost sa profesorom
        //BazaProfesora.getInstance().deleteSubjectForProfessor(predmet.getIdS());
        SubjectTable.getInstance().refreshTable();
    }
    
    public void editSubject(Subject oldSub,Subject nSub ){
        oldSub.setNameSub(nSub.getNameSub());
        oldSub.setIdS(nSub.getIdS());
        oldSub.setESPBpoints(nSub.getESPBpoints());
        oldSub.setYearOfStudy(nSub.getYearOfStudy());
        oldSub.setSemester(nSub.getSemester());
        oldSub.setProfessor(nSub.getProfessor());
        SubjectTable.getInstance().refreshTable();
    }
}
