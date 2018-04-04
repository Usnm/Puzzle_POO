package mvc;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Observable;
import java.util.Observer;

import data.Case;
import data.Grille;
import data.Lien;
import data.Symbole;
import javafx.application.Application;

import javafx.event.EventHandler;
import javafx.scene.Scene;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.image.Image;

/**
 *
 * @author freder
 */
public class VueControleur extends Application {
    
    // modèle : ce qui réalise le calcule de l'expression
    Modele m;
    // affiche la saisie et le résultat
    Text affichage;
    
    @Override
    public void start(Stage primaryStage) {
        
        // initialisation du modèle que l'on souhaite utiliser
        m = new Modele();

        /***
         * !!Créer la grille côté modèle dans Modèle.java ou Grille.java
         *
         * Utiliser cette grille pour initialiser la grille côté Vue
         * Quand on pren dun observable avec la VueControlleur, on modifie directement la grille côté modèle
         * Et on remet à jour la grille de la vue pour afficher les nouvelles données du modèle
         * Drap & Drop
         * Test des voisins pour vérifier qu'on peut mettre le bon symbole/lien sur la position finale
         * Bouton de validation pour commencer le parcours de fin et confirmer les chemins créés entre symboles.
         ***/

        // initialisation de la grille du modèle
        Grille mGrille = m.getGrille();
        Case[][] tabCase = mGrille.getTab();

        // gestion du placement (permet de placer le champ Text affichage en haut, et GridPane gPane au centre)
        BorderPane border = new BorderPane();
        int prefWidth = 800;
        int prefHeight = 600;
        border.setPrefSize(prefWidth, prefHeight);

        // permet de placer les diffrents boutons dans une grille
        GridPane gPane = new GridPane();
        
        int column = 0;
        int row = 0;

        int column_max = 3;
        int row_max = 3;

        // la vue observe les "update" du modèle, et réalise les mises à jour graphiques
        m.addObserver(new Observer() {
            
            @Override
            public void update(Observable o, Object arg) {
                /*
                if (!m.getErr()) {
                    affichage.setText(m.getValue() + "");
                } else {
                    affichage.setText("Err");
                }
                */
            }
        });
        
        // on efface affichage lors du clic
        /*
        affichage.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) { affichage.setText(""); }

        });
        */

        for(int i = 0; i < column_max; i++) {
            for(int j = 0; j < row_max; j++) {

                if(tabCase[i][j].getSymbole() != null) {
                    final Text c = new Text(tabCase[i][j].getSymbole().name());
                    c.setWrappingWidth(prefWidth / 3);
                    c.setFont(Font.font("Verdana", 20));
                    c.setTextAlignment(TextAlignment.CENTER);
                    gPane.add(c, column++, row);
                }
                else {
                    if(tabCase[i][j].getLien() == Lien.VIDE) {
                        final Text t = new Text("");
                        t.setWrappingWidth(prefWidth / 3);
                        t.setFont(Font.font("Verdana", 20));
                        t.setTextAlignment(TextAlignment.CENTER);

                        gPane.add(t, column++, row);
                    }
                }

                if (column == 3) {
                    column = 0;
                    row++;
                }

                // un controleur (EventHandler) par bouton écoute et met à jour le champ affichage
                /*
                t.setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        affichage.setText(affichage.getText() + t.getText());
                    }

                });
                */
            }
        }

        Lien[] liensTab = Lien.values();

        for(int lien = 0; lien < liensTab.length; lien++) {

            final Text t = new Text(liensTab[lien].name());
            t.setWrappingWidth(prefHeight / liensTab.length);
            t.setFont(Font.font("Verdana", 20));
            t.setTextAlignment(TextAlignment.CENTER);
            gPane.add(t, column++, row);

        }





        //t.setEffect(new Shadow());
        
        // un controleur écoute le bouton "=" et déclenche l'appel du modèle
        /*
        t.setOnMouseClicked(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                //m.calc(affichage.getText());
            }
        });*/
        
        gPane.setGridLinesVisible(true);
        
        border.setCenter(gPane);
        
        Scene scene = new Scene(border, Color.LIGHTGREEN);
        
        primaryStage.setTitle("Puzzle en JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
