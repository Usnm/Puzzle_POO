package mvc;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Observable;

import data.Grille;
import mvc.libInterpreteurExpr.Node;

/**
 *
 * @author fred
 */
public class Modele extends Observable {

    private Grille grille;
    private boolean err = false;

    public Grille getGrille() {
        return grille;
    }

    public boolean getErr() {
        return err;
    }

}