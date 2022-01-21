package model;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class BazaPredmeta implements AbstractModel, Serializable {

    @Serial
    private static final long serialVersionUID = 3513823599632994126L;

    private static BazaPredmeta instance = null;

    public static BazaPredmeta getInstance() {
        if(instance == null) {
            instance = new BazaPredmeta();
        }
        return instance;
    }
    private ArrayList<Subject> subjects;
    private ArrayList<String> columns;

    private BazaPredmeta(){
        initSubjects();
        this.columns = new ArrayList<>();
        this.columns.add("Šifra predmeta");
        this.columns.add("Naziv predmeta");
        this.columns.add("Broj ESPB bodova");
        this.columns.add("Godina u kojoj se predmet izvodi");
        this.columns.add("Semestar u kome se predmet izvodi");
    }
    private void initSubjects(){
        this.subjects=new ArrayList<>();
        Subject sub=new Subject("R01","Analiza 1",Semester.SUMMER, YearofStudy.I,8);
        this.subjects.add(sub);
        sub=new Subject("R02","Analiza 2",Semester.WINTER, YearofStudy.II,8);
        this.subjects.add(sub);
        sub=new Subject("R03","Nemacki",Semester.SUMMER, YearofStudy.I,2);
        this.subjects.add(sub);
        sub=new Subject("R04","Metode graviranja",Semester.SUMMER, YearofStudy.II,2);
        this.subjects.add(sub);
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public ArrayList<String> getColumns() {
        return columns;
    }

    public void setColumns(ArrayList<String> columns) {
        this.columns = columns;
    }

    @Override
    public int getColumnCount() {
        return this.columns.size();
    }

    @Override
    public int getRowCount() {
        return this.subjects.size();
    }

    @Override
    public String getColumnName(int col) {
        return this.columns.get(col);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Subject sub= this.subjects.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sub.getIdS();
            case 1:
                return sub.getNameSub();
            case 2:
                return Integer.toString(sub.getESPBpoints());
            case 3:
                return sub.getYearOfStudy().name();
            case 4:
                return sub.getSemester().name();
            default:
                return null;
        }
    }
    public void addSubject(Subject sub) {
        subjects.add(sub);
    }
    public boolean UniqueIdS(String ids) {
        for (Subject predmet : subjects) {
            if(predmet.getIdS().equals(ids)) {
                return false;
            }
        }
        return true;
    }
    public Subject findSubjectById(String id){
        for(Subject subject :subjects){
            if(subject.getIdS().equals(id)){
                return subject;
            }
        }
        return null;
    }
    @Override
    public boolean isEmpty() {
        return false;
    }

    public  ArrayList<Subject> getPossibleSubject(Student student){
        ArrayList<Subject> subs = new ArrayList<>();
        for(Subject subject : subjects){
            if(student.checkYears(subject,student)){
                if(!student.checkExams(subject)){
                    subs.add(subject);
                }
            }
        }
        return subs;
    }
}
