package clase;

import interfete.TipPersoana;

public class Persoana {

    private String nume;
    private String prenume;
    private int varsta;
    private TipPersoana tipPersoana;
    private boolean isAngajat;
    private String locMunca;
    private String functie;
    private float salariu;

    public Persoana(String nume, String prenume, int varsta, TipPersoana tipPersoana, boolean isAngajat, String locMunca, String functie, float salariu) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.tipPersoana = tipPersoana;
        this.isAngajat = isAngajat;
        this.locMunca = locMunca;
        this.functie = functie;
        this.salariu = salariu;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public TipPersoana getTipPersoana() {
        return tipPersoana;
    }

    public void setTipPersoana(TipPersoana tipPersoana) {
        this.tipPersoana = tipPersoana;
    }

    public boolean isAngajat() {
        return isAngajat;
    }

    public void setAngajat(boolean angajat) {
        isAngajat = angajat;
    }

    public String getLocMunca() {
        return locMunca;
    }

    public void setLocMunca(String locMunca) {
        this.locMunca = locMunca;
    }

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public float getSalariu() {
        return salariu;
    }

    public void setSalariu(float salariu) {
        this.salariu = salariu;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", varsta=" + varsta +
                ", tipPersoana=" + tipPersoana +
                ", isAngajat=" + isAngajat +
                ", locMunca='" + locMunca + '\'' +
                ", functie='" + functie + '\'' +
                ", salariu=" + salariu +
                '}';
    }
}
