package it.unicam.cs.pa.jlife097988;

import it.unicam.cs.pa.jlife097988.Model.Board;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.util.Duration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;


/**
 * Classe che interfaccia i bottoni della UI ai metodi associati
 **/
public class Controller implements Initializable {

    private final FileManager importExport = new FileManager();
    private final Operations operations = new Operations();
    private final Timeline timeline;
    FileChooser fileChooser = new FileChooser();
    private int generation = 0;


    @FXML
    Label gen = new Label();

    @FXML
    VBox mainBox;

    @FXML
    TextField genInput;

    @FXML
    TextField numInput;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileChooser.setInitialDirectory(new File("."));
    }

    public Controller() {
        timeline = new Timeline(
                new KeyFrame(Duration.millis(500),
                        ae -> nextButton()));
        timeline.setCycleCount(Animation.INDEFINITE);
    }

    public void startButton() {
        timeline.play();
    }

    public void pauseButton() {
        timeline.stop();
    }

    public void nextButton() {
        operations.nextGen(Main.board);
        Main.board.update();
        generation++;
        gen.setText("Generazione: " + generation);

    }

    public void generateButton() {
        Board campo = Main.board;
        int numero = 0;
        String stringa = operations.inputConverter(numInput);
        if (operations.inputIsInt(stringa)) {
            numero = Integer.parseInt(stringa);
        }
        operations.generateRandomCells(campo, numero);
        Main.board.update();

    }

    public void stopButton() {
        timeline.stop();

        Board t = Main.board;

        operations.clearBoard(Main.board);

        Main.board.update();
        Main.board.setBoard(t.getBoard());

        generation = 0;
        gen.setText("Generazione: " + generation);
    }


    public void jumpButton() {
        int genNum = 0;
        String stringaSalto = operations.inputConverter(genInput);
        if (operations.inputIsInt(stringaSalto)) {
            genNum = Integer.parseInt(stringaSalto);
        }
        for (int i = 0; i < genNum; i++) {
            nextButton();
        }
        Main.board.update();

    }


    public void about() {
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI("https://it.wikipedia.org/wiki/Gioco_della_vita"));
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void esporta() {
        timeline.stop();

        Board daSalvare = Main.board;
        String testo = importExport.cellToTxt(daSalvare);
        String timeStamp = new SimpleDateFormat("dd-MM-yy HH.mm.ss'.gol'").format(new Date());
        Window stage = mainBox.getScene().getWindow();

        fileChooser.setTitle("Salva configurazione");
        fileChooser.setInitialFileName("Game of Life " + timeStamp);
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Configurazione Game of Life", "*.gol"));

        try {
            File file = fileChooser.showSaveDialog(stage);
            if (file != null) {
                importExport.saveTextToFile(testo, file);
            }
            fileChooser.setInitialDirectory(file.getParentFile());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @FXML
    private void importa() {
        timeline.stop();
        Window stage = mainBox.getScene().getWindow();
        fileChooser.setTitle("Carica configurazione");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Configurazione Game of Life", "*.gol"));

        try {
            File file = fileChooser.showOpenDialog(stage);
            importExport.ReadFile(file);

            Main.board.update();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

