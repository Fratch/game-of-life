package it.unicam.cs.pa.jlife097988;

import it.unicam.cs.pa.jlife097988.Model.Cell;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CellTest {


    @Test
    public void testUpdateState() {
        Rectangle rec = new Rectangle();
        Cell c = new Cell(0, 0, false, rec);

        c.setNewState(true);
        c.updateState();
        assertTrue(c.getState());

        c.setNewState(false);
        c.updateState();
        assertFalse(c.getState());
    }

    @Test
    public void testConstructor() {
        Rectangle rec = new Rectangle();
        Cell c = new Cell(0, 0, true, rec);

        assertEquals(true, c.getState());
    }
}