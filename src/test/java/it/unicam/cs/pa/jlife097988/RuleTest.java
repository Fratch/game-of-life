package it.unicam.cs.pa.jlife097988;

import it.unicam.cs.pa.jlife097988.Model.Board;
import it.unicam.cs.pa.jlife097988.Model.Cell;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RuleTest {

    Board field = new Board();
    Rectangle rec = new Rectangle();
    Cell cell = new Cell(0, 0, true, rec);

    @Test
    public void testDieBySolitude() {
        assertFalse(field.regola(cell, 0));
        assertFalse(field.regola(cell, 1));
    }

    @Test
    public void testDieOfOvercrowding() {
        assertFalse(field.regola(cell, 7));
        assertFalse(field.regola(cell, 8));
    }

    @Test
    public void testBornByReproduction() {
        cell.changeState();
        cell.updateState();
        assertFalse(cell.getState());
        assertTrue(field.regola(cell, 3));
    }
}
