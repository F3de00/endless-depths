package it.unicam.cs.mpgc.rpg127378.controller;

import it.unicam.cs.mpgc.rpg127378.model.Partita;
import it.unicam.cs.mpgc.rpg127378.model.Potenziamento;
import it.unicam.cs.mpgc.rpg127378.model.creature.Entita;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ControllerPotenziamento {
    private final Partita partita;
    private final Navigatore navigatore;

    @FXML
    private VBox contenitoreEroe;
    @FXML
    private Label etichettaEroe;
    @FXML
    private HBox contenitorePotenziamenti;

    public ControllerPotenziamento(Partita partita, Navigatore navigatore) {
        this.partita = partita;
        this.navigatore = navigatore;
    }

    @FXML
    private void initialize() {
        Entita eroe = partita.getEroe();
        contenitoreEroe.getChildren().setAll(PannelloCreatura.crea(eroe));
        etichettaEroe.setText("Attacco " + eroe.getAttacco() + " | Velocità " + eroe.getVelocita());
        for (Potenziamento potenziamento : Potenziamento.values()) {
            Button pulsante = new Button(potenziamento.getDescrizione());
            pulsante.getStyleClass().add("pulsante");
            pulsante.setOnAction(evento -> scegli(potenziamento));
            contenitorePotenziamenti.getChildren().add(pulsante);
        }
    }

    private void scegli(Potenziamento potenziamento) {
        partita.scegliPotenziamento(potenziamento);
        navigatore.mostraEsplorazione();
    }
}
