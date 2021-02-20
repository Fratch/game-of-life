package it.unicam.cs.pa.jlife097988.Model;

import java.util.logging.Logger;

/**
 * Rappresenta un campo di gioco memorizzato attraverso una matrice.
 **/
public class Board implements Campo, Regola {
    private final static Logger logger = Logger.getLogger("it.unicam.cs.pa.jlife.Model.Board.");

    private int boardWidth = 25;
    private int boardHeight = 25;

    public void setBoardWidth(int boardWidth) {
        this.boardWidth = boardWidth;
    }

    public void setBoardHeight(int boardHeight) {
        this.boardHeight = boardHeight;
    }

    private Cell[][] table = new Cell[boardWidth][boardHeight];


    public int getBoardWidth() {
        return boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }


    @Override
    public Cell[][] getBoard() {
        return table;
    }

    @Override
    public Cell getCell(int i, int j) {
        return table[i][j];
    }

    @Override
    public void setBoard(Cell[][] table) {
        this.table = table;
    }

    /**
     * Metodo che calcola il numero di vicini viventi
     * della cellula indicata dalle coordinate in ingresso
     *
     * @param i coordinate per la cellula desiderata
     * @param j coordinate per la cellula desiderata
     * @return numero di vicini vivi
     **/

    public int neighborCount(int i, int j) {
        int sum = 0;

        // cellula in alto a sinistra
        if (i != 0 && j != 0) {
            if (getCell(i - 1, j - 1).isAlive()) {
                sum++;
            }
        }
        // cellula in alto
        if (i != 0) {
            if (getCell(i - 1, j).isAlive()) {
                sum++;
            }
        }
        // cellula in alto a destra
        if (i != 0 && j != boardWidth - 1) {
            if (getCell(i - 1, j + 1).isAlive()) {
                sum++;
            }
        }
        // cellula a sinistra
        if (j != 0) {
            if (getCell(i, j - 1).isAlive()) {
                sum++;
            }
        }
        // cellula a destra
        if (j != boardWidth - 1) {
            if (getCell(i, j + 1).isAlive()) {
                sum++;
            }
        }
        //cellula in basso a sinistra
        if (i != boardWidth - 1 && j != 0) {
            if (getCell(i + 1, j - 1).isAlive()) {
                sum++;
            }
        }
        //cellula in basso
        if (i != boardHeight - 1) {
            if (getCell(i + 1, j).isAlive()) {
                sum++;
            }
        }
        // cella in basso a destra
        if (i != boardHeight - 1 && j != boardWidth - 1) {
            if (getCell(i + 1, j + 1).isAlive()) {
                sum++;
            }
        }
        return sum;
    }

    @Override
    public int aliveCount() {
        int count = 0;
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                if (getCell(i, j).isAlive()) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public void update() {
        logger.finest("Update.");
        for (int c = 0; c < boardWidth; c++) {
            for (int r = 0; r < boardHeight; r++) {
                getCell(c, r).updateState();
            }
        }
    }

    @Override
    public boolean regola(Cell cell, int vicini) {
        if (!cell.getState() && vicini == 3) {
            return true;
        } else if (cell.getState() && (vicini < 2 || vicini > 3)) {
            return false;
        } else {
            return cell.getState();
        }
    }
}
