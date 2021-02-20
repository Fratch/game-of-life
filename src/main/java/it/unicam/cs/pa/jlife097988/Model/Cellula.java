package it.unicam.cs.pa.jlife097988.Model;

/**
 * Responsabilità: definisce una singola cellula.
 **/
public interface Cellula {

    /**
     * Metodo invocato per cambiare lo stato binario di una cellula.
     *
     * @param state stato della cellula da settare.
     **/
    void setNewState(boolean state);

    /**
     * Metodo invocato per aggiornare lo stato binario di una cellula
     * sul campo.
     **/
    void updateState();

    /**
     * Metodo invocato per cambiare lo stato binario di una cellula
     * in occasione del click sul campo.
     **/
    void changeState();

    /**
     * Verifica se la cellula è viva.
     *
     * @return <code>true</code> se la posizione è valida.
     */
    boolean isAlive();
}
