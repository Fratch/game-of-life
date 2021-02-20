package it.unicam.cs.pa.jlife097988.Model;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Responsabilità: Cellula posizionata su una griglia di gioco.
 **/
public class Cell extends Pane implements Cellula {

    private final int posX;
    private final int posY;
    private boolean state;
    private boolean newState;
    private final Rectangle rec;

    public Cell(int posX, int posY, boolean state, Rectangle rec) {
        this.posX = posX;
        this.posY = posY;
        this.state = state;
        this.rec = rec;
    }


    public boolean getState() {
        return state;
    }

    @Override
    public void setNewState(boolean state) {
        newState = state;
    }

    @Override
    public void updateState() {
        state = newState;
        rec.setFill(this.isAlive() ? Color.BLACK : Color.WHITE);
    }

    @Override
    public void changeState() {
        setNewState(!state);
    }

    @Override
    public boolean isAlive() {
        return (getState());
    }

}
