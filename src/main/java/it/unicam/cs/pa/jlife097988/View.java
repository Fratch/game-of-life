package it.unicam.cs.pa.jlife097988;

import it.unicam.cs.pa.jlife097988.Model.Board;
import it.unicam.cs.pa.jlife097988.Model.Cell;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class View {

    /**
     * la funzione inizializza le funzioni del campo
     *
     * @param scene inizializzata nel main
     * @return board inizializzata e funzionante
     **/
    public static Board initLayout(Scene scene) {

        Board board = new Board();
        board.setBoardHeight(25);
        board.setBoardWidth(25);
        GridPane grid = (GridPane) scene.lookup("#grid");
        for (int row = 0; row < board.getBoardWidth(); row++) {
            for (int col = 0; col < board.getBoardHeight(); col++) {
                Rectangle rec = new Rectangle();
                rec.setWidth(20);
                rec.setHeight(20);
                rec.setFill(Color.WHITE);

                Cell c = new Cell(row, col, false, rec);
                board.getBoard()[row][col] = c;
                grid.add(rec, col, row);
                clickOnCell(rec, c);


            }
        }
        return board;

    }

    /**
     * Rende possibile il toggle dello stato delle cellule
     * cliccando sulla cella corrispondente
     *
     * @param rec quadrato della grid corrispondente alla cellula
     * @param c   cellula il cui stato deve cambiare
     **/
    private static void clickOnCell(Rectangle rec, Cell c) {

        rec.setOnMouseClicked(t -> {
            c.changeState();
            c.updateState();
            rec.setFill(c.isAlive() ? Color.BLACK : Color.WHITE);
        });
    }


}
