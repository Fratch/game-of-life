package it.unicam.cs.pa.jlife097988.Model;

/**
 * Responsabilità: definisce il campo di gioco.
 **/

public interface Campo {

    Cell[][] getBoard();

    /**
     * Restituisce la cellula indicata dalle coordinate in ingresso.
     *
     * @param i coordinata x della cellula da ottenere
     * @param j coordinata y della cellula da ottenere
     *
     * @return cellula che si trova nel punto specificato dalle coordinate.
     **/
    Cell getCell(int i, int j);

    void setBoard(Cell[][] table);

    /**
     * Aggiorna lo stato di tutte le cellule nel campo.
     **/
    void update();

    /**
     * Restituisce il numero di cellule vive sul campo.
     *
     * @return il numero di cellule vive sul campo.
     */
    int aliveCount();
}
