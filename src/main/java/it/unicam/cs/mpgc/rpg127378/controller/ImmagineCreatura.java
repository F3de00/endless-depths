package it.unicam.cs.mpgc.rpg127378.controller;

import java.net.URL;
import java.util.Optional;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public final class ImmagineCreatura {
    private static final String PERCORSO_IMMAGINI = "/it/unicam/cs/mpgc/rpg127378/view/immagini/";

    private ImmagineCreatura() {}

    public static Optional<ImageView> crea(String tipoCreatura, double dimensione) {
        URL percorsoImmagine = ImmagineCreatura.class.getResource(PERCORSO_IMMAGINI + tipoCreatura.toLowerCase() + ".png");
        if (percorsoImmagine == null) {
            return Optional.empty();
        }
        return Optional.of(new ImageView(new Image(percorsoImmagine.toExternalForm(), dimensione, dimensione, true, false)));
    }
}
