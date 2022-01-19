package controller.compare;

import java.util.Comparator;

public class StudentAvgGradeCmp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        double br1 = Double.parseDouble(o1);
        double br2 = Double.parseDouble(o2);
        return Double.compare(br1,br2);
    }
}
