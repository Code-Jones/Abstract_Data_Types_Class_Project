package com.abstractdata.Util;

/**
 * Queue node
 *
 * @param <D> Abstract Data Type
 * @author Matt Jones
 */
@SuppressWarnings("unused")
public class QueueNode<D> {
	private final D data;
	private QueueNode<D> next;
    private QueueNode<D> first;
    private QueueNode<D> last;

    /**
     * Constructor
     *
     * @param data for node
     */
    public QueueNode(D data) {
        this.data = data;
    }


    /**
     * @param item data to be added to node
     */
    public void add(D item) {
        QueueNode<D> t = new QueueNode<D>(item);
        if (last != null) {
            last.next = t;
        }
        last = t;
        if (first == null) {
            first = last;
        }
    }

//    public D remove() {
//        if (first == null) throw new NoSuchElementException();
//        D data = first.data;
//        first = first.next;
//        if (first == null) {
//            last = null;
//        }
//        return data;
//    }
//
//    public D peek() {
//        if (first == null) throw new EmptyStackException();
//        return first.data;
//    }

    /**
     * @return true if empty
     */
    public boolean isEmpty() {
        return first == null;
    }
}

