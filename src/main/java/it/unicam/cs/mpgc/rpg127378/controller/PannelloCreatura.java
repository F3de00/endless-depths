package it.unicam.cs.mpgc.rpg127378.controller;

import it.unicam.cs.mpgc.rpg127378.model.creature.Entita;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public final class PannelloCreatura {
    private static final double DIMENSIONE_IMMAGINE = 64;

    private PannelloCreatura() {}

    public static VBox crea(Entita creatura) {
        Label nome = new Label(creatura.getNome());
        nome.getStyleClass().add("nome-creatura");
        VBox pannello = new VBox(6, nome, rigaBarra(creatura.getVita(), creatura.getVitaMassima(), "barra-vita"));
        if (creatura.getManaMassimo() > 0) {
            pannello.getChildren().add(rigaBarra(creatura.getMana(), creatura.getManaMassimo(), "barra-mana"));
        }
        ImmagineCreatura.crea(creatura.getTipo(), DIMENSIONE_IMMAGINE).ifPresent(immagine -> pannello.getChildren().addFirst(immagine));
        pannello.setAlignment(Pos.CENTER);
        return pannello;
    }

    private static HBox rigaBarra(int valoreAttuale, int valoreMassimo, String stileBarra) {
        ProgressBar barra = new ProgressBar((double) valoreAttuale / valoreMassimo);
        barra.getStyleClass().add(stileBarra);
        Label valore = new Label(valoreAttuale + "/" + valoreMassimo);
        valore.getStyleClass().add("valore-barra");
        HBox riga = new HBox(8, barra, valore);
        riga.setAlignment(Pos.CENTER);
        return riga;
    }
}
