package com.abstractdata.Util;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Doubly linked list tests
 */
class MyDLLTest {
    MyDLL<Integer> dll;

    @BeforeEach
    void setUp() {
        dll = new MyDLL<>();
    }

    @AfterEach
    void tearDown() {
        dll = null;
    }

    @Test
    void indexExceptionCheck() {
        dll.add(2);
        dll.add(3);
        dll.add(4);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> dll.remove(6));
    }

    @Test
    void nullExceptionPointerCheck() {
        Assertions.assertThrows(NullPointerException.class, () -> dll.add(null));
    }

    @Test
    void size() {
        dll.add(2);
        dll.add(3);
        dll.add(4);
        Assert.assertEquals(dll.size(), 3);
    }

    @Test
    void clear() {
        dll.add(2);
        dll.add(3);
        dll.add(4);
        dll.clear();
        Assert.assertEquals(dll.size(), 0);
    }

    @Test
    void add() {
        dll.add(2);
        dll.add(3);
        dll.add(4);
        dll.add(54);
        Assert.assertEquals(dll.get(4).getData(), 54);
    }


    @Test
    void addAll() {
        dll.add(2);
        dll.add(3);
        dll.add(4);
        MyDLL<Integer> test = new MyDLL<>();
        test.add(2);
        test.add(3);
        test.add(4);
        dll.addAll(test);
        Assert.assertEquals(dll.size(), 6);
    }

    @Test
    void get() {
        dll.add(2);
        dll.add(3);
        dll.add(4);
        Assert.assertEquals(dll.get(2).getData(), 3);
    }

    @Test
    void remove() {
        dll.add(2);
        dll.add(3);
        dll.add(4);
        dll.remove(1);
        Assert.assertEquals(dll.size(), 2);
    }

    @Test
    void set() {
        dll.add(2);
        dll.add(3);
        dll.add(4);
        dll.set(1, 55);
        dll.set(0, 45);
        Assert.assertEquals(dll.get(1).getData(), 55);
        Assert.assertEquals(dll.get(0).getData(), 45);
    }

    @Test
    void isEmpty() {
        dll.add(2);
        dll.add(3);
        dll.add(4);
        Assert.assertFalse(dll.isEmpty());
    }

    @Test
    void contains() {
        dll.add(2);
        dll.add(3);
        dll.add(4);
        Assert.assertTrue(dll.contains(3));
    }

    @Test
    void toArray() {
        dll.add(2);
        dll.add(3);
        dll.add(4);
        Object[] dd = dll.toArray();
        Assert.assertEquals(dd.length, 3);
    }

    @Test
    void testToArray() {
        dll.add(2);
        dll.add(3);
        dll.add(4);
        Object[] dd = new Object[6];
        dd[0] = 23;
        dd[1] = 32;
        dd[2] = 54;
        dd = dll.toArray(dd);
        Assert.assertEquals(dd.length, 6);
    }

    @Test
    void iterator() {
        dll.add(3);
        dll.add(3);
        Assert.assertTrue(dll.iterator().hasNext());
    }
}