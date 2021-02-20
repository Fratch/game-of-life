package it.unicam.cs.pa.jlife097988.Model;


@FunctionalInterface
public interface Regola {
    /**
     * Stabilisce e implementa serie di regole per il corretto
     * svolgimento del Gioco della Vita di Conway.
     *
     * @param cell   stato corrente della cellula
     * @param vicini numero di cellule vive vicine a quella esaminata
     * @return prossimo stato della cellula
     */
    boolean regola(Cell cell, int vicini);
}
