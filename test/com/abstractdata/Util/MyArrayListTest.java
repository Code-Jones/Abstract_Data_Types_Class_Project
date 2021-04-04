package com.abstractdata.Util;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyArrayListTest {
    MyArrayList<String> strList;
    MyArrayList<Integer> intList;
    @BeforeEach
    void setUp() {
        this.strList = new MyArrayList<>();
        this.intList = new MyArrayList<>();
    }

    @AfterEach
    void tearDown() {
        strList = null;
        intList = null;
    }

    @Test
    void indexExceptionCheck() {
        strList.add("Uno");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> strList.get(2));
    }

    @Test
    void nullExceptionPointerCheck() {
        Assertions.assertThrows(NullPointerException.class, () -> intList.add(null));
    }

    @Test
    void checkGrow() {
        intList.add(3);
        intList.add(1);
        Assert.assertEquals(intList.size(), 2);
    }

    @Test
    void size() {
        intList.add(1);
        intList.add(2);
        intList.add(3);
        Assert.assertEquals(intList.size(), 3);
    }

    @Test
    void clear() {
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.clear();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> intList.get(1));
    }

    @Test
    void add() {
        intList.add(1);
        intList.add(2);
        intList.add(3);
        Assert.assertEquals(intList.get(1), 2);
    }

    @Test
    void addAll() {
        MyArrayList<Integer> second = new MyArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        second.add(1);
        second.add(2);
        second.add(3);
        intList.addAll(second);
        Assert.assertEquals(intList.get(1), 2);
        Assert.assertEquals(intList.get(4), 2);
    }

    @Test
    void get() {
        intList.add(1);
        intList.add(2);
        intList.add(3);
        Assert.assertEquals(intList.get(1), 2);
    }

    @Test
    void remove() {
        intList.add(1);
        intList.add(2);
        intList.add(3);
        Assert.assertEquals(intList.remove(1), 2);
    }

    @Test
    void set() {
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.set(0, 55);
        Assert.assertEquals(intList.get(0), 55);
    }

    @Test
    void isEmpty() {
        intList.add(1);
        intList.add(2);
        intList.add(3);
        Assert.assertFalse(intList.isEmpty());
    }

    @Test
    void contains() {
        intList.add(1);
        intList.add(2);
        intList.add(3);
        Assert.assertFalse(intList.contains(55));
    }

    @Test
    void toArray() {
        Object[] second;
        intList.add(1);
        intList.add(2);
        intList.add(3);
        second = intList.toArray();
        Assert.assertEquals(second.length, 3);
    }


    @Test
    void iterator() {
        intList.add(1);
        intList.add(2);
        intList.add(3);
        Assert.assertTrue(intList.iterator().hasNext());
    }
}