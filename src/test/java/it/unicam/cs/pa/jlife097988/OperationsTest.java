package it.unicam.cs.pa.jlife097988;

import it.unicam.cs.pa.jlife097988.Model.Board;
import it.unicam.cs.pa.jlife097988.Model.Cell;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationsTest {

    private Operations operations = new Operations();

    @Test
    public void testClearBoard() {
        // setup
        int size = 25;
        Board testField = new Board();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Rectangle rec = new Rectangle();

                Cell c = new Cell(i, j, true, rec);
                testField.getBoard()[i][j] = c;
            }
        }

        // esecuzione
        operations.clearBoard(testField);

        // verifica
        assertEquals(0, testField.aliveCount());
    }
}
