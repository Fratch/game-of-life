package it.unicam.cs.pa.jlife097988;

import it.unicam.cs.pa.jlife097988.Model.Board;
import it.unicam.cs.pa.jlife097988.Model.Cell;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {
    private Operations operations = new Operations();
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
    public void testStillLife() {

        field.getCell(1, 1).setNewState(true);
        field.getCell(1, 2).setNewState(true);
        field.getCell(2, 1).setNewState(true);
        field.getCell(2, 2).setNewState(true);

        field.update();

        operations.nextGen(field);
        field.update();

        assertTrue((field.getCell(1, 1).isAlive()));
        assertTrue((field.getCell(1, 2).isAlive()));
        assertTrue((field.getCell(2, 1).isAlive()));
        assertTrue((field.getCell(2, 2).isAlive()));
    }

    @Test
    public void testOscillator() {

        field.getCell(0, 1).setNewState(true);
        field.getCell(1, 1).setNewState(true);
        field.getCell(2, 1).setNewState(true);

        field.update();

        operations.nextGen(field);
        field.update();

        assertTrue((field.getCell(1, 0).isAlive()));
        assertTrue((field.getCell(1, 1).isAlive()));
        assertTrue((field.getCell(1, 2).isAlive()));

        operations.nextGen(field);
        field.update();

        assertTrue((field.getCell(0, 1).isAlive()));
        assertTrue((field.getCell(1, 1).isAlive()));
        assertTrue((field.getCell(2, 1).isAlive()));

        operations.nextGen(field);
        field.update();

        assertTrue((field.getCell(1, 0).isAlive()));
        assertTrue((field.getCell(1, 1).isAlive()));
        assertTrue((field.getCell(1, 2).isAlive()));

        operations.nextGen(field);
        field.update();

        assertTrue((field.getCell(0, 1).isAlive()));
        assertTrue((field.getCell(1, 1).isAlive()));
        assertTrue((field.getCell(2, 1).isAlive()));

    }

    @Test
    public void testGlider() {

        field.getCell(0, 1).setNewState(true);
        field.getCell(1, 2).setNewState(true);
        field.getCell(2, 0).setNewState(true);
        field.getCell(2, 1).setNewState(true);
        field.getCell(2, 2).setNewState(true);

        field.update();

        for (int i = 0; i < 88; i++) {
            operations.nextGen(field);
            field.update();
        }

        assertTrue((field.getCell(22, 23).isAlive()));
        assertTrue((field.getCell(23, 24).isAlive()));
        assertTrue((field.getCell(24, 22).isAlive()));
        assertTrue((field.getCell(24, 23).isAlive()));
        assertTrue((field.getCell(24, 24).isAlive()));
    }
}
