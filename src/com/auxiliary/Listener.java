package com.auxiliary;

/**
 * Interface for those classes which get data from a stream
 */
public interface Listener {
    /**
     * Opening sources, getting ready for listening
     */
    public void start();

    /**
     * Listening from a stream
     */
    public void listen();

    /**
     * Close all the sources, ready to be closed
     */
    public void finish();
}
