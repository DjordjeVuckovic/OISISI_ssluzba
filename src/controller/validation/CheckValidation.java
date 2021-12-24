package controller.validation;

import model.BazaPredmeta;
import model.BazaStudenata;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckValidation {
    public static boolean checkName(String name){
        boolean ret=false;
        if(name.matches("[a-zA-Z\u0161\u0111\u010d\u0107\u017e\u0160\u0110\u010c\u0106\u017d ]+")){
            ret = true;
        }
        return ret;
        }
        public static boolean checkDate(String date){
        //date format dd.mm.yyyy
            if(date.isEmpty() || date.isBlank()){
                return false;
            }
            String sEl[] = date.split("\\.");

            if(sEl.length != 3) return false;

            if(sEl[0].length() > 2) return false;
            if(sEl[1].length() > 2) return false;

            for(int i = 0; i < sEl[0].length(); i++) {
                if( !Character.isDigit(sEl[0].charAt(i)) ) return false;
            }
            for(int i = 0; i < sEl[1].length(); i++) {
                if( !Character.isDigit(sEl[1].charAt(i)) ) return false;
            }
            for(int i = 0; i < sEl[2].length(); i++) {
                if( !Character.isDigit(sEl[2].charAt(i)) ) return false;
            }


            int dan= Integer.parseInt(sEl[0]);
            int mesec= Integer.parseInt(sEl[1]);
            int god= Integer.parseInt(sEl[2]);

            if(dan>31) return false;
            if(mesec>12) return false;

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            dateFormat.setLenient(false);
            Date datumRodjenja = null;
            try {
                datumRodjenja = dateFormat.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
                return false;
            }



            return true;
        }
    public static boolean checkPhone(String text) {
        // unos brojeva u rasponu od 3 do 12
        if(text.isEmpty() || text.isBlank()) {
            return false;
        }
        if(text.length()<3 || text.length()>12){
            return false;
        }
        for(int i = 0; i < text.length(); i++) {
            if(!Character.isDigit(text.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public static boolean checkEmail(String mail){
        return mail.matches("([a-zA-Z0-9]+\\.?)*[a-zA-Z0-9]@[a-z0-9]+");
    }
    public static boolean checkAvgGrade(String prosek) {
        prosek = prosek.trim();
        return prosek.matches("(5)|(5\\.0)|(5\\.00)|([6-9](\\.[0-9]{1,2})?)|(10)|(10\\.0)|(10\\.00)");
    }
    public static boolean checkAdress(String adress) {
        adress = adress.trim();
        if(adress.length() == 0)
            return false;
        return true;
    }
    public static boolean checkIndex(String text){
        String sEl[] = text.split("/");
        if(sEl.length != 3) return false;

        for(int i = 0; i < sEl[0].length(); i++) {
            if( !Character.isAlphabetic( sEl[0].charAt(i) ) && !Character.isDigit( sEl[0].charAt(i) ) ) return false;
        }

        for(int i = 0; i < sEl[1].length(); i++) {
            if( !Character.isDigit( sEl[1].charAt(i) ) ) return false;
        }
        for(int i = 0; i < sEl[2].length(); i++) {
            if( !Character.isDigit( sEl[2].charAt(i) ) ) return false;
        }
        if(!BazaStudenata.getInstance().UniqueId(text)) {
            return false;
        }
        return true;
    }
    public static boolean checkAssignYear(String text) {

        if(text.isEmpty() || text.isBlank()) {
            return false;
        }
       //godina ne sme pocinjati sa 0 i mora imati 4 cifre
        if( text.length() != 4) return false;

        for(int i = 0; i < text.length(); i++) {
            if( !Character.isDigit( text.charAt(i) ) ) return false;
        }

        if( text.charAt(0) == '0' ) return false;


        return true;
    }
    public static boolean checkStreet(String text) {
    	if(text.isEmpty() || text.isBlank()) {
            return false;
        }
		return true;
    }
    public static boolean checkStreetNum(String text) {
    	if(text.isEmpty() || text.isBlank()) {
            return false;
        }
		return true;
    }
   
    public static boolean checkSubjectId(String text) {

        if(text.isEmpty() || text.isBlank()) {
            return false;
        }

        // treba da bude jedinstvena
        if(!BazaPredmeta.getInstance().UniqueIdS(text)) {
            return false;
        }



        return true;
    }

    public static boolean checkSubjectName(String text) {
        if(text.isEmpty() || text.isBlank()) {
            return false;
        }

        return true;
    }

    public static boolean checkESPB(String text) {

        if(text.isEmpty() || text.isBlank()) {
            return false;
        }

        if( text.charAt(0) == '0' ) return false;

        for(int i = 0; i < text.length(); i++) {
            if( !Character.isDigit( text.charAt(i) ) ) return false;
        }
        
        return true;
    }

    }

