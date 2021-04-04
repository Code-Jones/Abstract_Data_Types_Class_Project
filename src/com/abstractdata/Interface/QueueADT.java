package com.abstractdata.Interface;

import java.io.Serializable;

/**
 * This is the Queue Interface that includes several
 * helper methods.
 *
 * @author Matt Jones
 */
public interface QueueADT<D> extends Serializable {

    /**
     * Adds object to queue
     * @param item is object to be added
     */
    void add(D item) throws NullPointerException;

    /**
     * Returns the first object from the queue
     * @return D is object to be removed
     */
    D remove() throws NullPointerException;

    /**
     * Returns the first object from the queue without removing it
     * @return D is object to be seen
     */
    D peek() throws NullPointerException;

    /**
     * Clears the queue
     */
    void clear() throws NullPointerException;

    /**
     * Returns if the queue is empty
     * @return true if it is empty
     */
    boolean isEmpty() throws NullPointerException;

    /**
     * Returns an iterator
     * @return an iterator
     */
    Iterator<D> iterator();

    /**
     * Returns if the queue is equal to the given queue
     *
     * @param queue list to be compared too
     * @return true if it is equal
     */
    boolean equals(QueueADT<D> queue) throws NullPointerException;

    /**
     * Returns a copy of the queue
     * @return an array containing the elements of this queue.
     */
    Object[] toArray() throws NullPointerException;

    /**
     * Returns a copy of the queue
     *
     * @param holder list to be copied too
     * @return an array containing the elements of this queue.
     * @throws NullPointerException if the specified array is null.
     */
    D[] toArray(D[] holder) throws NullPointerException;

    /**
     * Returns the size of the queue
     * @return the size of the queue
     */
    int size();
}
