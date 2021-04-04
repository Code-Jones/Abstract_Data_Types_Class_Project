package com.abstractdata.Interface;

import java.io.Serializable;

/**
 * This is the Stack Interface for an Abstract Stack
 * This Stack embodies all the standard Stack operations,
 * and includes several helper methods that will
 * give the data structure more flexibility and use.
 *
 * @author Matt Jones
 * @version 1
 */
public interface StackADT<D> extends Serializable {

    /**
     * Returns the top object from stack
     * @return D object to be taken from stack
     */
    public D pop();

    /**
     * Puts a object to the top of the stack
     * @param item to be put in stack
     */
    public void push(D item);

    /**
     * Returns the first object of the stack
     * @return D top of the stack
     */
    public D peek();

    /**
     * Clears the list from objects
     */
    public void clear();

    /**
     * Checks if list is empty
     * @return true if it is empty
     */
    public boolean isEmpty();

    /**
     * Returns a copy of the original array
     * @return Object[] new list
     */
    public Object[] toArray();

    /**
     * Returns a copy of the original array
     * @param holder is list to be copied too
     * @return D[] new list
     */
    public D[] toArray(D[] holder) throws NullPointerException;

    /**
     * Checks if the list contains a object and returns if true
     * @param data object to be found
     * @return true if found
     */
    public boolean contains(D data) throws NullPointerException;

    /**
     * Searches for a object and returns the index
     * @param data object to be found
     * @return index of object
     */
    public int search(D data);

    /**
     * Returns an iterator
     *
     * @return an iterator
     */
    public Iterator<D> iterator();

    /**
     * Used to compare two Stack ADT's
     * @param stack the stack ADT to be compared to this stack.
     * @return true if equal.
     */
    public boolean equals(StackADT<D> stack);

    /**
     * Returns the size of the stack.
     * @return the size
     */
    public int size();

}
