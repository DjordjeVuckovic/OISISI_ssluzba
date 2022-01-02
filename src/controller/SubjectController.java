package controller;

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
}
