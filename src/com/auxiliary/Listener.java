package com.auxiliary;

/**
 * Interface for those classes which get data from a stream
 */
public interface Listener {
    /**
     * Opening sources, getting ready for listening
     */
    void start();

    /**
     * Listening from a stream
     */
    void listen() throws Exception;
}
