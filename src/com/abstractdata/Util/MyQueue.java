package com.abstractdata.Util;

import com.abstractdata.Interface.Iterator;
import com.abstractdata.Interface.QueueADT;

/**
 * My Queue ADT class
 *
 * @param <D> Abstract data type
 * @author Matt Jones
 */
@SuppressWarnings({ "serial", "rawtypes" })
public class MyQueue<D> implements QueueADT {
    MyDLL<D> dll;

    /**
     * constructor
     */
    public MyQueue() {
        this.dll = new MyDLL<>();
    }

    /**
     * Exceptions checking method
     *
     * @param obj given to check for exceptions
     */
    public void nullExceptionPointerCheck(Object obj) {
        if (obj == null) throw new NullPointerException("Null object");
    }

    /**
     * @param item is object to be added
     * @throws NullPointerException if obj null
     */
    @Override
    public void add(Object item) throws NullPointerException {
        nullExceptionPointerCheck(item);
        dll.add(item);
    }

    /**
     * @return object from front of list
     * @throws NullPointerException if obj null
     */
    @Override
    public Object remove() throws NullPointerException {
        nullExceptionPointerCheck(dll);
        return dll.remove(0);
    }

    /**
     * @return object from front of list to be seen but not removed
     * @throws NullPointerException if obj null
     */
    @Override
    public Object peek() throws NullPointerException {
        nullExceptionPointerCheck(dll);
        return dll.get(0);
    }

    /**
     * clears the list
     *
     * @throws NullPointerException if obj null
     */
    @Override
    public void clear() throws NullPointerException {
        nullExceptionPointerCheck(dll);
        dll.clear();
    }

    /**
     * @return true if list is empty
     * @throws NullPointerException if obj null
     */
    @Override
    public boolean isEmpty() throws NullPointerException {
        nullExceptionPointerCheck(dll);
        return dll.isEmpty();
    }


    /**
     * @return iterator
     */
    @Override
    public Iterator<D> iterator() {
        return new Iterator<D>() {
            @Override
            public boolean hasNext() {
                return dll.iterator().hasNext();
            }

            @Override
            public D next() {
                return dll.iterator().next();
            }
        };
    }

    /**
     * @param queue list to be compared too
     * @return true if the list are equal
     * @throws NullPointerException if list is null
     */
    @Override
    public boolean equals(QueueADT queue) throws NullPointerException {
        nullExceptionPointerCheck(queue);
        for (int i = 0; i < dll.size(); i++) {
            if (!(dll.get(i).getData() == queue.remove())) return false;
        }
        return true;
    }

    /**
     * @return object[] that's a copy of this list
     * @throws NullPointerException if this list is null
     */
    @Override
    public Object[] toArray() throws NullPointerException {
        nullExceptionPointerCheck(dll);
        return dll.toArray();
    }

    /**
     * @param holder list to be copied too
     * @return object[] that's a copy of this list
     * @throws NullPointerException if this list is null
     */
    @Override
    public Object[] toArray(Object[] holder) throws NullPointerException {
        nullExceptionPointerCheck(holder);
        return dll.toArray();
    }

    /**
     * @return size of this list
     */
    @Override
    public int size() {
        return dll.size();
    }
}
