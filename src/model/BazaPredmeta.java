package model;

import java.util.ArrayList;

public class BazaPredmeta implements AbstractModel {
    private static BazaPredmeta instance = null;

    public static BazaPredmeta getInstance() {
        if(instance == null) {
            instance = new BazaPredmeta();
        }
        return instance;
    }
    private ArrayList<Subject> subjects;
    private ArrayList<String> colums;

    private BazaPredmeta(){
        initSubjects();
        this.colums= new ArrayList<>();
        this.colums.add("Šifra predmeta");
        this.colums.add("Naziv predmeta");
        this.colums.add("Broj ESPB bodova");
        this.colums.add("Godina u kojoj se predmet izvodi");
        this.colums.add("Semestar u kome se predmet izvodi");
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

    public ArrayList<String> getColums() {
        return colums;
    }

    public void setColums(ArrayList<String> colums) {
        this.colums = colums;
    }

    @Override
    public int getColumnCount() {
        return this.colums.size();
    }

    @Override
    public int getRowCount() {
        return this.subjects.size();
    }

    @Override
    public String getColumnName(int col) {
        return this.colums.get(col);
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
    @Override
    public boolean isEmpty() {
        return false;
    }
}
