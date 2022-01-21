package model;

import serial.Serialization;

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
		/*
		 * Subject sub=new Subject("R01","Analiza 1",Semester.SUMMER, YearofStudy.I,8);
		 * this.subjects.add(sub); sub=new Subject("R02","Analiza 2",Semester.WINTER,
		 * YearofStudy.II,8); this.subjects.add(sub); sub=new
		 * Subject("R03","Nemacki",Semester.SUMMER, YearofStudy.I,2);
		 * this.subjects.add(sub); sub=new
		 * Subject("R04","Metode graviranja",Semester.SUMMER, YearofStudy.II,2);
		 * this.subjects.add(sub);
		 */
        //ovako radis Subject(String idS, String nameSub, Semester semester, YearofStudy yearOfStudy, Professor professor, int pointsESPB)
       subjects.add(new Subject("p1","osnove programiranja",Semester.WINTER,YearofStudy.I,BazaProfesora.getInstance().getProfessorById("321321321"),7));
       subjects.add(new Subject("p2","statistika",Semester.SUMMER,YearofStudy.III,BazaProfesora.getInstance().getProfessorById("321321321"),8));
       subjects.add(new Subject("p3","algoritmi i strukture podataka",Semester.SUMMER,YearofStudy.II,BazaProfesora.getInstance().getProfessorById("321321321"),9));
       subjects.add(new Subject("p4","LPRS",Semester.WINTER,YearofStudy.III,BazaProfesora.getInstance().getProfessorById("321321321"),7));
       subjects.add(new Subject("p5","matematika",Semester.SUMMER,YearofStudy.I,null,11));
       subjects.add(new Subject("p6","xml i web servisi",Semester.SUMMER,YearofStudy.IV,null,6));
       subjects.add(new Subject("p7","Metode optimizacije",Semester.WINTER,YearofStudy.III,null,6));
       subjects.add(new Subject("p8","osnove elektrotehnike",Semester.SUMMER,YearofStudy.I,BazaProfesora.getInstance().getProfessorById("100100144"),11));
       subjects.add(new Subject("p9","Sociologija",Semester.WINTER,YearofStudy.I,BazaProfesora.getInstance().getProfessorById("100100144"),10));
       subjects.add(new Subject("p10","Filozofija",Semester.WINTER,YearofStudy.I,BazaProfesora.getInstance().getProfessorById("100100144"),4));
       subjects.add(new Subject("p11","ORT",Semester.SUMMER,YearofStudy.II,null,7));
       subjects.add(new Subject("p12","NANS",Semester.SUMMER,YearofStudy.II,BazaProfesora.getInstance().getProfessorById("200020244"),5));
       subjects.add(new Subject("p13","Organizacija podataka",Semester.WINTER,YearofStudy.II,BazaProfesora.getInstance().getProfessorById("200020244"),7));
       subjects.add(new Subject("p14","Baze podataka",Semester.WINTER,YearofStudy.II,BazaProfesora.getInstance().getProfessorById("200020244"),6));
       subjects.add(new Subject("p15","paralelno programiranje",Semester.WINTER,YearofStudy.II,BazaProfesora.getInstance().getProfessorById("559585632"),8));
       subjects.add(new Subject("p16","konkurentno programiranje",Semester.SUMMER,YearofStudy.II,BazaProfesora.getInstance().getProfessorById("559585632"),9));
       subjects.add(new Subject("p17","Operativni sistemi",Semester.SUMMER,YearofStudy.II,null,8));
       subjects.add(new Subject("p18","Algebra",Semester.WINTER,YearofStudy.I,null,15));
       subjects.add(new Subject("p19","Diskretna matematika",Semester.SUMMER,YearofStudy.III,null,14));
       subjects.add(new Subject("p20","Upravljacki sistemi",Semester.SUMMER,YearofStudy.III,null,8));
       subjects.add(new Subject("p21","Osnovi elektronike",Semester.WINTER,YearofStudy.II,null,7));
       subjects.add(new Subject("p22","Slucajni procesi",Semester.SUMMER,YearofStudy.IV,null,9));
       subjects.add(new Subject("p23","Racunarstvo visokih performansi",Semester.SUMMER,YearofStudy.IV,null,10));
       subjects.add(new Subject("p24","Analiza 1",Semester.WINTER,YearofStudy.I,null,20));
       subjects.add(new Subject("p25","Informaciona bezbednost",Semester.SUMMER,YearofStudy.IV,BazaProfesora.getInstance().getProfessorById("400400444"),9));
       subjects.add(new Subject("p26","Elektronsko placanje",Semester.WINTER,YearofStudy.III,BazaProfesora.getInstance().getProfessorById("500500544"),8));
       subjects.add(new Subject("p27","Distribuirani sistemi",Semester.SUMMER,YearofStudy.IV,BazaProfesora.getInstance().getProfessorById("600600644"),6));
       subjects.add(new Subject("p28","Projektovanje softvera",Semester.WINTER,YearofStudy.III,BazaProfesora.getInstance().getProfessorById("500500544"),5));
       subjects.add(new Subject("p29","Informacioni sistemi",Semester.WINTER,YearofStudy.IV,BazaProfesora.getInstance().getProfessorById("400400444"),6));
       subjects.add(new Subject("p30","Masinsko ucenje",Semester.SUMMER,YearofStudy.IV,null,7));
       deserijalizacija();
    }
    private void deserijalizacija(){
        BazaPodataka bp = Serialization.readFile();
        if(bp !=null)
            this.subjects = bp.getSubjects();
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
    
    public void deleteSubject(Subject s){subjects.remove(s);}
    
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
    
    public Subject getSubjectByRow(int row){
		return subjects.get(row);
	}
    
    public  ArrayList<Subject> getPossibleSubjectP(Professor profesor){
        ArrayList<Subject> subs = new ArrayList<>();
        for(Subject subject : subjects){
            if(profesor.checkProf(subject,profesor)){
                 subs.add(subject);
            }
        }
        return subs;
    }
    public void deleteStudentForSubject(String idSt){
        int lenght;
        for(Subject sub: subjects ){
            lenght = sub.getFailed().indexOf(BazaStudenata.getInstance().getStudentById(idSt));
            if(lenght>=0){
                sub.getFailed().remove(lenght);
            }
        }
    }
}
