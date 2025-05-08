package com.dsa.practice.ds.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedlistTest {

    @Test
    void testEmptyLinkedList() {
        Linkedlist<Integer> linkedList = new Linkedlist<>();

        assertEquals(0, linkedList.getSize());
        assertNull(linkedList.getFirst());
    }

    @Test
    void testLinkedListInitializationFromCollection() {
        List<Integer> elements = List.of(1, 2, 3, 4, 5);
        Linkedlist<Integer> linkedList = new Linkedlist<>(elements);

        assertEquals(elements.size(), linkedList.getSize());
        assertNotNull(linkedList.getFirst());

        Linkedlist.Node<Integer> firstNode = linkedList.getFirst();
        assertEquals(Integer.valueOf(1), firstNode.getData());

        Linkedlist.Node<Integer> currentNode = firstNode;
        for (Integer expectedData : elements) {
            assertNotNull(currentNode);
            assertEquals(expectedData, currentNode.getData());
            currentNode = currentNode.getNext();
        }
    }

    @Test
    void testImmutability() {
        List<Integer> elements = List.of(10, 20, 30);
        Linkedlist<Integer> linkedList = new Linkedlist<>(elements);

        Linkedlist.Node<Integer> firstNode = linkedList.getFirst();
        assertNotNull(firstNode);
        assertEquals(Integer.valueOf(10), firstNode.getData());


        assertEquals(10, linkedList.getFirst().getData());
    }
}