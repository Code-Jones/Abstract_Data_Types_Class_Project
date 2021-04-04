package com.abstractdata.Util;


import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Queue list testing
 */
class MyQueueTest {
    MyQueue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new MyQueue<>();
    }

    @AfterEach
    void tearDown() {
        queue = null;
    }

    @Test
    void nullExceptionPointerCheck() {
        Assertions.assertThrows(NullPointerException.class, () -> queue.add(null));
    }
    @Test
    void add1() {
        queue.add(65);
        Assert.assertEquals(queue.size(), 1);
    }

    @Test
    void add() {
        queue.add(65);
        queue.add(77);
        Assert.assertEquals(queue.size(), 2);
    }

    @Test
    void remove() {
        queue.add(65);
        queue.add(77);
        queue.remove();
        Assert.assertEquals(queue.size(), 1);
    }

    @Test
    void clear() {
        queue.add(65);
        queue.add(77);
        queue.clear();
        Assert.assertEquals(queue.size(), 0);
    }

    @Test
    void isEmpty() {
        queue.add(65);
        queue.add(77);
        Assert.assertFalse(queue.isEmpty());
    }

    @Test
    void iterator() {
        queue.add(65);
        queue.add(77);
        queue.add(89);
        Assert.assertTrue(queue.iterator().hasNext());
    }

    @Test
    void testEquals() {
        queue.add(65);
        queue.add(77);
        queue.add(89);
        MyQueue<Integer> qu = new MyQueue<>();
        qu.add(65);
        qu.add(77);
        qu.add(89);
        Assert.assertTrue(queue.equals(qu));
    }

    @Test
    void toArray() {
        Object[] qu = new Object[0];
        queue.add(65);
        Assert.assertEquals(queue.toArray(qu).length, 1);
    }

    @Test
    void testToArray() {
        queue.add(65);
        Object[] nu = queue.toArray();
        Assert.assertEquals(nu[0], 65);
    }

    @Test
    void size() {
        queue.add(65);
        queue.add(43);
        queue.add(32);
        Assert.assertEquals(queue.size(), 3);
    }
}