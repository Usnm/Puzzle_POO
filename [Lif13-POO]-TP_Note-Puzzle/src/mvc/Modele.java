package mvc;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Observable;

import data.Case;
import data.Grille;
import data.Lien;
import data.Symbole;
import mvc.libInterpreteurExpr.Node;

/**
 *
 * @author fred
 */
public class Modele extends Observable {

    private Grille grille;
    private boolean err = false;

    public boolean getErr() {
        return err;
    }

    private int column_max = 3;
    private int row_max = 3;

    // On initialise la grille côté modèle
    public Modele() {
        Case[][] tmp = new Case[3][3];
        this.grille = new Grille();

        for (int i = 0; i < row_max; i++) {
            for (int j = 0; j < column_max; j++) {

                if(i == 0 && j == 0) { tmp[i][j] = new Case(Symbole.CERCLE, null, i, j); }
                else if(i == 0 && j == column_max-1) { tmp[i][j] = new Case(Symbole.TRIANGLE, null, i, j); }
                else if(i == row_max-1 && j == column_max-2) { tmp[i][j] = new Case(Symbole.CERCLE, null, i, j); }
                else if(i == row_max-1 && j == column_max-1) { tmp[i][j] = new Case(Symbole.TRIANGLE, null, i, j); }
                else { tmp[i][j] = new Case(null, Lien.VIDE, i, j); }

            }
        }

        this.grille.setTab(tmp);
    }

    public Grille getGrille() {
        return grille;
    }
}