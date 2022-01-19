package gui.view.search;

import gui.view.center.ProfessorsTable;
import model.BazaProfesora;
import model.Professor;

import java.util.ArrayList;

public class SearchProfessor {
    public SearchProfessor(){}
    public void searchProfessors(String string){
        if(string.isBlank() || string.isEmpty()){
            BazaProfesora.getInstance().setSearchMode(false);
            ProfessorsTable.getInstance().refreshTable();
        }
        else{
            BazaProfesora.getInstance().setSearchMode(true);
        }
        ArrayList<Professor> search = new ArrayList<>();
        string.trim().toLowerCase();
        String[] arraySt =string.split(",");
        // 123456789, Pera Peric
        if(arraySt.length ==3){
            for(Professor Professor :BazaProfesora.getInstance().getProfessors()){
                if(Professor.getIdNumber().toLowerCase().contains(arraySt[0].trim()) && Professor.getName().toLowerCase().contains(arraySt[1].trim()) && Professor.getSurname().contains(arraySt[2].trim())){
                    search.add(Professor);
                }
            }
        }
        //surname,name
        else if(arraySt.length ==2){
            for(Professor Professor :BazaProfesora.getInstance().getProfessors()){
                if(Professor.getSurname().toLowerCase().contains(arraySt[0].trim()) && Professor.getName().toLowerCase().contains(arraySt[1].trim())){
                    search.add(Professor);
                }
            }
        }
        //surname
        else if(arraySt.length ==1){
            for(Professor Professor:BazaProfesora.getInstance().getProfessors()){
                if(Professor.getSurname().toLowerCase().contains(arraySt[0].trim())){
                    search.add(Professor);
                }
            }
        }
        else{
            BazaProfesora.getInstance().setSearchMode(false);
        }
        BazaProfesora.getInstance().setSearchProfessors(search);
        ProfessorsTable.getInstance().refreshTable();
    }
}
