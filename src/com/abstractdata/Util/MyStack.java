package com.abstractdata.Util;

import com.abstractdata.Interface.Iterator;
import com.abstractdata.Interface.StackADT;

/**
 * Abstract Data Stack
 *
 * @param <D> Abstract data
 * @author Matt Jones
 */
@SuppressWarnings({"serial", "rawtypes"})
public class MyStack<D> implements StackADT {
    MyArrayList<D> arrayList;

    public MyStack() {
        this.arrayList = new MyArrayList<>();
    }

    /**
     * Exception checker method
     *
     * @param obj to be checked
     */
    public void nullExceptionPointerCheck(Object obj) {
        if (obj == null) throw new NullPointerException("Null object");
    }

    /**
     * take out the top object from the list
     *
     * @return top object from list
     * @throws NullPointerException if list is null
     */
    @Override
    public Object pop() throws NullPointerException {
        nullExceptionPointerCheck(arrayList);
        return arrayList.remove(0);
    }

    /**
     * @param item to be put in stack
     * @throws NullPointerException if list is null
     */
    @Override
    public void push(Object item) throws NullPointerException {
        nullExceptionPointerCheck(item);
        arrayList.add(0, item);
    }

    /**
     * @return top object to be see but not removed
     * @throws NullPointerException if list is null
     */
    @Override
    public Object peek() throws NullPointerException {
        nullExceptionPointerCheck(arrayList);
        if (!arrayList.isEmpty()) return arrayList.get(0);
        else return null;
    }

    /**
     * clears list
     *
     * @throws NullPointerException if list is null
     */
    @Override
    public void clear() throws NullPointerException {
        nullExceptionPointerCheck(arrayList);
        arrayList.clear();
    }

    /**
     * @return true if list is empty
     */
    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    /**
     * @return Object[] that is a copy of this list
     * @throws NullPointerException if list is null
     */
    @Override
    public Object[] toArray() throws NullPointerException {
        nullExceptionPointerCheck(arrayList);
        return arrayList.toArray();
    }

    /**
     * @param holder is list to be copied too
     * @return object[] that is a copy of this list
     * @throws NullPointerException if list is null
     */
    @Override
    public Object[] toArray(Object[] holder) throws NullPointerException {
        nullExceptionPointerCheck(holder);
        return arrayList.toArray(holder);
    }

    /**
     * @param data object to be found
     * @return true if object is in list
     * @throws NullPointerException if list is null
     */
    @Override
    public boolean contains(Object data) throws NullPointerException {
        nullExceptionPointerCheck(data);
        return arrayList.contains(data);
    }

    /**
     * @param data object to be found
     * @return index of object in list
     * @throws NullPointerException if list is null
     */
    @Override
    public int search(Object data) throws NullPointerException {
        nullExceptionPointerCheck(data);
        return arrayList.containingIndex(data);
    }

    /**
     * @return iterator
     */
    @Override
    public Iterator<D> iterator() {
        return new Iterator<D>() {
            @Override
            public boolean hasNext() {
                return arrayList.iterator().hasNext();
            }

            @Override
            public D next() {
                return arrayList.iterator().next();
            }
        };
    }

    /**
     * @param stack the stack ADT to be compared to this stack.
     * @return true if stacks are the same
     */
    @Override
    public boolean equals(StackADT stack) {
        for (int i = 0; i < stack.size(); i++) {
            if (!arrayList.get(i).equals(stack.pop())) return false;
        }
        return true;
    }

    /**
     * @return size of list
     */
    @Override
    public int size() {
        return arrayList.size();
    }
}
