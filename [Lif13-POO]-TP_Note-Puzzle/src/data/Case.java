package data;

public class Case {
    private Symbole symbole;
    private Lien lien;
    private int i, j;

    public Case(Symbole symbole, Lien lien, int i, int j) {
        this.symbole = symbole;
        this.lien = lien;
        this.i = i;
        this.j = j;
    }

    public Symbole getSymbole() {
        return symbole;
    }

    public void setSymbole(Symbole symbole) {
        this.symbole = symbole;
    }

    public Lien getLien() {
        return lien;
    }

    public void setLien(Lien lien) {
        this.lien = lien;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
