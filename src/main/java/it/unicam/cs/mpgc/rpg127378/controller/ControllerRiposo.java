package it.unicam.cs.mpgc.rpg127378.controller;

import it.unicam.cs.mpgc.rpg127378.model.Partita;
import it.unicam.cs.mpgc.rpg127378.model.notifiche.RiposoEffettuato;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ControllerRiposo {
    private final Partita partita;
    private final Navigatore navigatore;
    private final RiposoEffettuato riposo;

    @FXML
    private Label etichettaStanza;
    @FXML
    private Label etichettaRecupero;
    @FXML
    private VBox contenitoreEroe;

    public ControllerRiposo(Partita partita, Navigatore navigatore, RiposoEffettuato riposo) {
        this.partita = partita;
        this.navigatore = navigatore;
        this.riposo = riposo;
    }

    @FXML
    private void initialize() {
        etichettaStanza.setText("Stanza " + riposo.numeroStanza() + ": Riposo");
        etichettaRecupero.setText("Vita recuperata: +" + riposo.vitaRecuperata() + "    Mana recuperato: +" + riposo.manaRecuperato());
        contenitoreEroe.getChildren().setAll(PannelloCreatura.crea(partita.getEroe()));
    }

    @FXML
    private void continua() {
        navigatore.mostraEsplorazione();
    }
}
