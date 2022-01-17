package controller.compare;

import java.util.Comparator;

public class StudentIdComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String id1[] = o1.split("/");
        String id2[] = o2.split("/");
        int num1 = Integer.parseInt(id1[1]);
        int num2 = Integer.parseInt(id2[1]);
        int year1 = Integer.parseInt(id1[2]);
        int year2 = Integer.parseInt(id2[2]);
        // firstly compare departments
        int cmp = id1[0].compareTo(id2[0]);
        if(cmp == 0) {
            cmp = year1 - year2;
            // if years are same we compare number of id for each student
            if(cmp == 0) {
                cmp = num1 - num2;
            }
        }

        return cmp;
    }
}
