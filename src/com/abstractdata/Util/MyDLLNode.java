package com.abstractdata.Util;

/**
 * Doubly linked list node class
 *
 * @author Matt Jones
 * @param <D> Abstract Data Type
 */
public class MyDLLNode<D> {
    private Object data;
    private MyDLLNode<D> next;
    private MyDLLNode<D> last;

    /**
     * Default constructor
     */
    public MyDLLNode() {}

    /**
     * @param data for this node
     */
    public MyDLLNode(Object data) {
        this.data = data;
    }

    /**
     * @param data for this node
     * @param next pointer to next node
     * @param last pointer to last node
     */
    public MyDLLNode(Object data, MyDLLNode<D> next, MyDLLNode<D> last) {
        this.data = data;
        this.next = next;
        this.last = last;
    }

    /**
     * @return data object
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data Set this objects data
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * @return next node
     *
     */
    public MyDLLNode<D> getNext() {
        return next;
    }

    /**
     * @param next node of this node
     */
    public void setNext(MyDLLNode<D> next) {
        this.next = next;
    }

    /**
     * @return node of the last of this node
     */
    public MyDLLNode<D> getLast() {
        return last;
    }

    /**
     * @param last node to this node
     */
    public void setLast(MyDLLNode<D> last) {
        this.last = last;
    }

}
