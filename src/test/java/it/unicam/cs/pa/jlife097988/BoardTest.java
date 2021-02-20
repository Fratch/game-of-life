package it.unicam.cs.pa.jlife097988;

import it.unicam.cs.pa.jlife097988.Model.Board;
import it.unicam.cs.pa.jlife097988.Model.Cell;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Serie di test di controllo utili alla verifica del corretto funzionamento
 * dei metodi implementati nella classe Board
 */
public class BoardTest {
    private Board field;
    private int size = 25;

    @BeforeEach
    public void setUp() {
        field = new Board();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Rectangle rec = new Rectangle();

                Cell c = new Cell(i, j, false, rec);
                field.getBoard()[i][j] = c;
            }
        }
    }

    @Test
    public void testGetNeighbours() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field.getCell(i, j).setNewState(true);
                field.getCell(i, j).updateState();
            }
        }

        assertEquals(3, field.neighborCount(0, 0));
        assertEquals(8, field.neighborCount(1, 1));
        assertEquals(5, field.neighborCount(1, 0));
    }


    @Test
    public void testGridStaysTheSame() {

        int before = field.aliveCount();

        field.update();

        int after = field.aliveCount();

        assertEquals(before, after);

    }

    @Test
    void shouldBeAllDead() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                assertFalse((field.getCell(i, j).isAlive()));
            }
        }
    }

}
