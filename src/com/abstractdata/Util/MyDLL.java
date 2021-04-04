package com.abstractdata.Util;

import com.abstractdata.Interface.Iterator;
import com.abstractdata.Interface.ListADT;

/**
 * My Doubly linked list class
 *
 * @author Matt Jones
 * @param <D> abstract data type
 */
@SuppressWarnings({ "serial", "rawtypes", "unused" })
public class MyDLL<D> implements ListADT {
    private MyDLLNode<D> head;
	private MyDLLNode<D> tail;
    private int size;


    /**
     * Constructor
     */
    public MyDLL() {
//        this.head = new MyDLLNode<>();
    }

    /**
     * Exceptions checking method
     *
     * @param index given index to check for exceptions
     */
    public void indexExceptionCheck(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index : " + index + " out of bounds");
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
     * @return list size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * clears list
     */
    @Override
    public void clear() {
        this.head.setData(null);
        this.head.setNext(null);
        this.head.setLast(null);
        size = 0;
    }

    /**
     * helper method to add node after the given node
     *
     * @param node that's before the node being made
     * @param item data that'll go in the new node
     * @return true if it was made successfully
     */
    private boolean addAfter(MyDLLNode<D> node, Object item) {
        MyDLLNode<D> nextNode = node.getNext();
        if (nextNode == null) {
            MyDLLNode<D> newNode = new MyDLLNode<>(item, node, null);
            node.setNext(newNode);
            tail = newNode;
        } else {
            MyDLLNode<D> newNode = new MyDLLNode<>(item, node, nextNode);
            node.setNext(newNode);
            nextNode.setLast(newNode);
        }
        size++;
        return true;
    }

    /**
     * helper method to add node before the given node
     * @param item data to be put in the node
     * @return true if it was made successfully
     */
    private boolean addFirst(D item) {
        MyDLLNode<D> node;
        if (head == null) {
            node = new MyDLLNode<>(item, null, null);
            head = node;
            tail = node;
        } else {
            node = new MyDLLNode<>(item, null, head);
            head.setLast(node);
            head = node;
        }
        size++;
        return true;
    }

    /**
     * @param index The index at which the specified element is to be inserted.
     *              The element is inserted before the existing element at [index],
     *              or at the end if index is equal to the
     *              size (<code>size()</code>).
     * @param toAdd The element to be inserted.
     * @return true if node was added successfully
     * @throws NullPointerException if object was null
     * @throws IndexOutOfBoundsException if index is out of range
     */
    @SuppressWarnings("unchecked")
	@Override
    public boolean add(int index, Object toAdd) throws NullPointerException, IndexOutOfBoundsException {
        nullExceptionPointerCheck(toAdd);
        indexExceptionCheck(index);

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        } else if (index == 0) {
            return addFirst((D) toAdd);
        } else {
            return addAfter(get(index - 1), toAdd);
        }
    }

    /**
     * @param toAdd Element to be appended to this list.
     * @return true if node was added successfully
     * @throws NullPointerException if object was null
     * @throws IndexOutOfBoundsException if index goes out of bounds
     */
    @Override
    public boolean add(Object toAdd) throws NullPointerException, IndexOutOfBoundsException {
        // check
        nullExceptionPointerCheck(toAdd);
        size++;
        MyDLLNode<D> node = new MyDLLNode<>(toAdd);
        if (head == null) {
            head = node;
            return true;
        } else {
            MyDLLNode<D> iter = head;
            // traverse
            while (iter.getNext() != null) {
                iter = iter.getNext();
            }
            // set pointers
            node.setNext(null);
            iter.setNext(node);
            node.setLast(iter);
        }
        return true;
    }

    /**
     * @param toAdd The new sub list to be added.
     * @return true if new list was added successfully
     * @throws NullPointerException if the new list is null
     */
    @Override
    public boolean addAll(ListADT toAdd) throws NullPointerException {
        nullExceptionPointerCheck(toAdd);
        int i = 0;
        while (i < toAdd.size()) {
            add(toAdd.get(i));
            i++;
        }
        return true;
    }

    /**
     * @param index Index of element to return.
     * @return node from the selected index
     * @throws IndexOutOfBoundsException if given index is out of bounce
     */
    @Override
    public MyDLLNode<D> get(int index) throws IndexOutOfBoundsException {
        indexExceptionCheck(index);
        MyDLLNode<D> response = head;
        for (int i = 0; i < index && response != null; i++) {
            response = response.getNext();
        }
        return response;
    }

    /**
     * @param index The index of the element to remove.
     * @return object that is being removed
     * @throws IndexOutOfBoundsException if given index is out of bounds
     */
    @Override
    public Object remove(int index) throws IndexOutOfBoundsException {
        indexExceptionCheck(index);
        Object obj;
        if (index == 0) {
            obj = head.getData();
            this.head = head.getNext();
        } else {
            MyDLLNode<D> iter = head;
            int counter = 0;
            // traverse
            while (counter != index) {
                iter = iter.getNext();
                counter++;
            }
            // set pointers
            obj = iter.getData();
            iter.getLast().setNext(iter.getNext());
            iter.getNext().setLast(iter.getLast());
        }
        size--;
        return obj;
    }

    /**
     * @param toRemove The element to be removed from this list.
     * @return object that is being removed
     * @throws IndexOutOfBoundsException if given index is out of bounds
     */
    @Override
    public Object remove(Object toRemove) throws NullPointerException {
        nullExceptionPointerCheck(toRemove);
        Object obj = null;
        MyDLLNode<D> iter = head;
        if (head.getData() == toRemove) {
            obj = head.getData();
            this.head = head.getNext();
        } else {
            // traverse
            while (iter.getData() != toRemove) {
                iter = iter.getNext();
            }
            // set pointers
            obj = iter.getData();
            iter.getLast().setNext(iter.getNext());
            iter.getNext().setLast(iter.getLast());
        }
        size--;
        return obj;
    }

    /**
     * @param index    The index of the element to replace.
     * @param toChange Element to be stored at the specified position.
     * @return object that is being replaced
     * @throws NullPointerException if object is null
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    @Override
    public Object set(int index, Object toChange) throws NullPointerException, IndexOutOfBoundsException {
        indexExceptionCheck(index);
        nullExceptionPointerCheck(toChange);
        Object obj;
        MyDLLNode<D> iter = head;
        int counter = 0;
        // traverse
        while (counter < index) {
            iter = iter.getNext();
            ++counter;
        }
        // set pointers
        obj = iter.getData();
        iter.setData(toChange);
        return obj;
    }

    /**
     * @return true if list is empty
     */
    @Override
    public boolean isEmpty() {
        return size != 0;
//        return head.getData() != null;
    }

    /**
     * @param toFind The element whose presence in this list is to be tested.
     * @return true if object is in list
     * @throws NullPointerException if object is null
     */
    @Override
    public boolean contains(Object toFind) throws NullPointerException {
        nullExceptionPointerCheck(toFind);
        MyDLLNode<D> iter = head;
        // traverse
        while (iter.getData() != toFind) {
            iter = iter.getNext();
            if (iter.getData() == toFind) return true;
        }
        return false;
    }

    /**
     * @param toHold The array into which the elements of this list are to be
     *               stored, if it is big enough; otherwise, a new array of the
     *               same runtime type is allocated for this purpose.
     * @return object array that is a copy of this list
     * @throws NullPointerException if given list is null
     */
    @Override
    public Object[] toArray(Object[] toHold) throws NullPointerException {
        nullExceptionPointerCheck(toHold);
        MyDLLNode<D> iter = head;
        // traverse
        int counter = 0;
        while (iter.getNext() != null) {
            toHold[counter] = this.get(counter).getData();
            iter = iter.getNext();
            counter++;
        }
        return toHold;
    }

    /**
     * @return Object[] that is a copy of this list
     */
    @Override
    public Object[] toArray() {
        Object[] toHold = new Object[size];
        MyDLLNode<D> iter = head;
        // traverse
        int counter = 0;
        while (iter.getNext() != null) {
            iter = iter.getNext();
            toHold[counter] = iter.getData();
            counter++;
        }
        return toHold;
    }

    /**
     * @return iterator
     */
    @Override
    public Iterator<D> iterator() {
        return new Iterator<D>() {

            MyDLLNode<D> node = head;

            @Override
            public boolean hasNext() {
                return node.getNext() != null;
            }

            @SuppressWarnings("unchecked")
			@Override
            public D next() {
                if (hasNext()) {
                    D data = (D) node.getData();
                    node = node.getNext();
                    return data;
                }
                return null;
            }
        };
    }
}
