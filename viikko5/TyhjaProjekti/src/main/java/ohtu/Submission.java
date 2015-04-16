package ohtu;

import java.util.ArrayList;
import java.util.List;

public class Submission {
    private String student_number;
    private int hours;
    private boolean[] a;
    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;
    private boolean a11;
    private boolean a12;

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public int getHours() {
        return hours;
    }

    public int tehdytTehtavat() {
        return tehtavat().size();
    }

    public String tehtavaString() {
        StringBuilder s = new StringBuilder();
        for (int t : tehtavat()) {
            s.append(t).append(" ");
        }
        return s.toString();
    }

    @Override
    public String toString() {
        return "tehtyjä tehtäviä yhteensä: " + tehdytTehtavat() + ", aikaa kului: " + hours + ", tehdyt tehtavat: " + tehtavaString();
    }

    private List<Integer> tehtavat() {
        List<Integer> tehtavat = new ArrayList();
        if (a1) {
            tehtavat.add(1);
        }
        if (a2) {
            tehtavat.add(2);
        }
        if (a3) {
            tehtavat.add(3);
        }
        if (a4) {
            tehtavat.add(4);
        }
        if (a5) {
            tehtavat.add(5);
        }
        if (a6) {
            tehtavat.add(6);
        }
        if (a7) {
            tehtavat.add(7);
        }
        if (a8) {
            tehtavat.add(8);
        }
        if (a9) {
            tehtavat.add(9);
        }
        if (a10) {
            tehtavat.add(10);
        }
        if (a11) {
            tehtavat.add(11);
        }
        if (a12) {
            tehtavat.add(12);
        }
        return tehtavat;
    }
    
}