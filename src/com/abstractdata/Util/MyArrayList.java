package com.abstractdata.Util;

import com.abstractdata.Interface.Iterator;
import com.abstractdata.Interface.ListADT;

/**
 * Abstract Data Array List
 *
 * @param <D> Abstract data type
 * @author Matt Jones
 */
@SuppressWarnings({"serial", "rawtypes"})
public class MyArrayList<D> implements ListADT {
    private Object[] objArray;
    private int size = 0;

    /**
     * Constructor
     */
    public MyArrayList() {
        this.objArray = new Object[0];
    }

    /**
     * @return copy of list but one size bigger
     */
    private void grow() {
        ++size;
        Object[] temp = new Object[size];
        for (int i = 0; i < objArray.length; i++) {
            temp[i] = objArray[i];
        }
        this.objArray = temp;
    }

    /**
     * @return copy of list but one size smaller
     */
    private Object[] shrink() {
        if (size != 0) {
            --size;
            Object[] temp = new Object[size];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = objArray[i];
            }
            return temp;
        } else return objArray;
    }

    /**
     * @param index to be checked for exceptions
     */
    public void indexExceptionCheck(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index : " + index + " out of bounds");
    }

    /**
     * @param obj to be checked for exceptions
     */
    public void nullExceptionPointerCheck(Object obj) {
        if (obj == null) throw new NullPointerException("Null object");
    }

    /**
     * @return size of this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * clears the list
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            objArray[i] = null;
        }
        size = 0;
    }

    /**
     * @param index The index at which the specified element is to be inserted.
     *              The element is inserted before the existing element at [index],
     *              or at the end if index is equal to the
     *              size (<code>size()</code>).
     * @param toAdd The element to be inserted.
     * @return true if adding the object is successful
     * @throws NullPointerException      if object is null
     * @throws IndexOutOfBoundsException if index given is out of bounds
     */
    @Override
    public boolean add(int index, Object toAdd) throws NullPointerException, IndexOutOfBoundsException {
        indexExceptionCheck(index);
        nullExceptionPointerCheck(toAdd);
        // me
        if (index == 0) {
            add(toAdd);
            return true;
        } else {
            grow();
            for (int i = objArray.length - 1; i <= index; i--) {
                objArray[i + 1] = objArray[i];
            }
//            for (int i = size - 1; i > index; i--) {
//                objArray[i + 1] = objArray[i];
//            }
            objArray[index] = toAdd;
        }
        return true;
    }

    /**
     * @param toAdd Element to be appended to this list.
     * @return true if adding the object is successful
     * @throws NullPointerException      if object is null
     * @throws IndexOutOfBoundsException if index given is out of bounds
     */
    @Override
    public boolean add(Object toAdd) throws NullPointerException, IndexOutOfBoundsException {
        nullExceptionPointerCheck(toAdd);
        if (size == objArray.length) {
            grow();
        }
        if (size == 1) {
            objArray[1] = objArray[0];
            objArray[0] = toAdd;
        } else {
            objArray[size] = toAdd;
        }


        return true;
    }

    /**
     * @param toAdd The new sub list to be added.
     * @return true if adding the new list successful
     * @throws NullPointerException if object is null
     */
    @Override
    public boolean addAll(ListADT toAdd) throws NullPointerException {
        nullExceptionPointerCheck(toAdd);
        for (int i = 0; i < toAdd.size(); i++) {
            add(toAdd.get(i));
        }
        return true;
    }

    /**
     * @param index Index of element to return.
     * @return the object at the given index
     * @throws IndexOutOfBoundsException if index given is out of bounds
     */
    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        indexExceptionCheck(index);
        return objArray[index];
    }

    /**
     * @param index The index of the element to remove.
     * @return object that is being removed from the list
     * @throws IndexOutOfBoundsException if index given is out of bounds
     */
    @Override
    public Object remove(int index) throws IndexOutOfBoundsException {
        indexExceptionCheck(index);
        if (index < size) {
            Object temp = objArray[index];
            for (int i = index; i < size - 1; i++) {
                objArray[i] = objArray[i + 1];
            }
            objArray[size - 1] = null;
            objArray = shrink();
            return temp;
        }
        return null;
    }

    /**
     * @param toRemove The element to be removed from this list.
     * @return object that is being removed from the list
     * @throws NullPointerException if index given is out of bounds
     */
    @Override
    public Object remove(Object toRemove) throws NullPointerException {
        nullExceptionPointerCheck(toRemove);
        Object temp = null;
        for (int i = 0; i < size; i++) {
            if (objArray[i] == toRemove) {
                temp = objArray[i];
                remove(i);
            }
        }
        objArray = shrink();
        return temp;
    }


    /**
     * @param index    The index of the element to replace.
     * @param toChange Element to be stored at the specified position.
     * @return old object data
     * @throws NullPointerException      if object given is null
     * @throws IndexOutOfBoundsException if index given is out of bounds
     */
    @Override
    public Object set(int index, Object toChange) throws NullPointerException, IndexOutOfBoundsException {
        nullExceptionPointerCheck(toChange);
        indexExceptionCheck(index);
        objArray[index] = toChange;
        return toChange;
    }

    /**
     * @return true if list is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param toFind The element whose presence in this list is to be tested.
     * @return true if object given is in this list
     * @throws NullPointerException if given object is null
     */
    @Override
    public boolean contains(Object toFind) throws NullPointerException {
        nullExceptionPointerCheck(toFind);
        if (objArray.length != 0) {
            for (Object o : objArray) {
                if (o.equals(toFind) && size >= 0) return true;
            }
        }
        return false;
    }

    /**
     * @param toFind The element whose presence in this list is to be tested.
     * @return index of the element given
     * @throws NullPointerException if given object is null
     */
    public int containingIndex(Object toFind) throws NullPointerException {
        nullExceptionPointerCheck(toFind);
        for (int i = 0; i < objArray.length; i++) {
            if (objArray[i].equals(toFind) && size >= 0) return i;
        }
        return -1;
    }

    /**
     * @param toHold The array into which the elements of this list are to be
     *               stored, if it is big enough; otherwise, a new array of the
     *               same runtime type is allocated for this purpose.
     * @return object[] that is a copy of this list
     * @throws NullPointerException if given object is null
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object[] toArray(Object[] toHold) throws NullPointerException {
        nullExceptionPointerCheck(toHold);
        for (int i = 0; i < toHold.length; i++) {
            objArray[i] = (D[]) toHold[i];
        }
        return (D[]) objArray;
    }

    /**
     * @return object[] that is a copy of this list
     */
    @Override
    public Object[] toArray() {
//        return (D[]) Arrays.copyOf(objArray, size);
        Object[] temp = new Object[size];
        for (int i = 0; i < size; i++) {
            temp[i] = objArray[i];
        }
        return temp;
    }


    /**
     * @return iterator
     */
    @Override
    public Iterator<D> iterator() {
        return new Iterator<D>() {
            int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < objArray.length && objArray[currentIndex] != null;
            }

            @SuppressWarnings("unchecked")
            @Override
            public D next() {
                return (D) objArray[currentIndex++];
            }
        };
    }
}

