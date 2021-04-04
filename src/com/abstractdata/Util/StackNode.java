package com.abstractdata.Util;

/**
 * Stack node class
 *
 * @author Matt Jones
 * @param <T> Abstract data type
 */
@SuppressWarnings("unused")
public class StackNode<T> {
	private final T data;
    private StackNode<T> next;
    private StackNode<T> top;

    /**
     * Constructor
     * @param data node data
     */
    public StackNode(T data) {
        this.data = data;
    }

//    public T pop() {
//        if (top == null) throw new EmptyStackException();
//        T item = top.data;
//        top = top.next;
//        return item;
//    }
//
//    public void push(T item) {
//        StackNode<T> t = new StackNode<>(item);
//        t.next = top;
//        top = t;
//    }
//
//    public T peek() {
//        if (top == null) throw new EmptyStackException();
//        return top.data;
//    }

    /**
     * @return true if is empty
     */
    public boolean isEmpty() {
        return top == null;
    }

}

