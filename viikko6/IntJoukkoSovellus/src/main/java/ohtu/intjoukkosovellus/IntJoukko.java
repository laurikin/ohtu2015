
package ohtu.intjoukkosovellus;

import java.util.ArrayList;

public class IntJoukko {

    public final static int OLETUSKAPASITEETTI = 5;

    private ArrayList<Integer> luvut; 

    public IntJoukko() {
        this(OLETUSKAPASITEETTI, 0);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, 0);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        validoiPositiivinen(kapasiteetti, "Kapasiteetti");
        validoiPositiivinen(kasvatuskoko, "Kasvatuskoko");

        this.luvut = new ArrayList<Integer>(kapasiteetti);
    }


    public boolean lisaa(int luku) {

        if (!sisaltaa(luku)) {
            luvut.add(luku);
            return true;
        } else {
            return false;
        }
    }

    public boolean sisaltaa(int luku) {
        return luvut.contains(luku);
    }

    public boolean poista(int luku) {
        int index = luvut.indexOf(luku);
        if (index == -1) {
            return false;
        } else {
            luvut.remove(index);
            return true;
        }
    }

    public int koko() {
        return luvut.size();
    }

    public int[] toIntArray() {
        int[] arr = new int[luvut.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = luvut.get(i);
        }
        return arr;
    }

    @Override
    public String toString() {
        switch (luvut.size()) {
            case 0:
                return "{}";
            case 1:
                return "{" + luvut.get(0) + "}";
            default:
                return montaLukuaToString();
        }
    }

    public static IntJoukko yhdiste(IntJoukko A, IntJoukko B) {
        IntJoukko yhdiste = new IntJoukko();
        for (Integer luku : B.luvut)
            yhdiste.lisaa(luku);
        for (Integer luku : A.luvut)
            yhdiste.lisaa(luku);
        return yhdiste;
    }

    public static IntJoukko leikkaus(IntJoukko A, IntJoukko B) {
        IntJoukko leikkaus = new IntJoukko();
        for (Integer luku : B.luvut) {
            if (A.sisaltaa(luku));
                leikkaus.lisaa(luku);
        }
        return leikkaus;
    }
    
    public static IntJoukko erotus ( IntJoukko A, IntJoukko B) {
        IntJoukko erotus = new IntJoukko();
        for (Integer luku : A.luvut) {
            if (!B.sisaltaa(luku));
                erotus.lisaa(luku);
        }
        return erotus;
    }

    private String montaLukuaToString() {
        StringBuilder s = new StringBuilder();
        s.append("{");
        for (Integer luku : luvut) {
            s.append(luku).append(", ");
        }
        s.delete(s.length() -2, s.length());
        return s.append("}").toString();
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }

    private void validoiPositiivinen(int kapasiteetti, String nimi) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException(nimi + " pitaa olla positiivinen");
        }
    }

    private int summa() {
        int sum = 0;
        for (Integer luku : luvut) {
            sum += luku;
        }
        return sum;
    }
}