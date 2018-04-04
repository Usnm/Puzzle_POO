package data;

import java.util.List;

public class Grille {
    List<Case> lst;
    Case[][] tab;

    public Case[][] getTab() {
        return tab;
    }

    public void setTab(Case[][] tab) {
        this.tab = tab;
    }
}
