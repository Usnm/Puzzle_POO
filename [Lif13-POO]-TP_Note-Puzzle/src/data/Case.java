package data;

enum Symbole { ETOILE, TRIANGLE, CARRE };
enum Lien { HORIZONTAL, VERTICAL, INFGAUCHE, INFDROITE, SUPGAUCHE, SUPDROITE, VIDE}

public class Case {
    Symbole symbole;
    Lien lien;
    int i, j;
}
