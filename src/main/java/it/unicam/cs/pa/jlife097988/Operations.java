package it.unicam.cs.pa.jlife097988;

import it.unicam.cs.pa.jlife097988.Model.Board;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.util.logging.Logger;

public class Operations {

    private final static Logger logger = Logger.getLogger("it.unicam.cs.pa.jlife097988.Operations");

    /**
     * scorre la matrice e applica l'algoritmo del gioco
     **/
    public void nextGen(Board b) {
        for (int i = 0; i < b.getBoardWidth(); i++)
            for (int j = 0; j < b.getBoardHeight(); j++) {
                int neighbours = b.neighborCount(i, j);
                b.getCell(i, j).setNewState(b.regola(b.getCell(i, j), neighbours));

            }
    }

    public void generateRandomCells(Board campo, int numInput) {
        int alive = campo.aliveCount();
        int x;
        int y;

        if (alive != campo.getBoardWidth() * campo.getBoardHeight()) {
            for (int i = 0; i < numInput; i++) {
                x = (int) ((Math.random() * (campo.getBoardWidth())) + 0);
                y = (int) ((Math.random() * (campo.getBoardHeight())) + 0);

                if (!campo.getCell(x, y).isAlive()) {
                    campo.getCell(x, y).setNewState(true);
                } else {
                    i--;
                }
            }
        }
    }

    /**
     * @param b campo dal quale vengono cancellate tutte le cellule viventi
     **/
    public void clearBoard(Board b) {
        int boardWidth = b.getBoardWidth();
        int boardHeight = b.getBoardHeight();

        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                if (b.getCell(i, j).isAlive()) {
                    b.getCell(i, j).changeState();
                    b.getCell(i, j).updateState();
                }
            }
        }
    }

    /**
     * @param input oggetto TextField contenente un input.
     * @return stringa contenente l'input.
     **/
    public String inputConverter(TextField input) {
        return input.getText().trim();
    }

    /**
     * @param input stringa contenente il numero da verificare.
     * @return true se la stringa contiene un numero.
     * @throws NumberFormatException eccezione sollevata nel caso la stringa non contenga un numero.
     **/

    public boolean inputIsInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            logger.warning("Input non corretto.");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore");
            alert.setHeaderText("Errore: " + input + " non è valido");
            alert.setContentText("Inserire un intero valido");
            alert.showAndWait();
            return false;
        }
    }

}
