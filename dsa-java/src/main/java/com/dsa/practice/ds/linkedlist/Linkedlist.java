package com.dsa.practice.ds.linkedlist;

import java.util.Collection;
import java.util.Objects;

/**
 * Immutable LinkedList implementation
 *
 * @param <E> type of element held in collection
 */
public final class Linkedlist<E> {
    private final int size;
    private final Node<E> first;

    /**
     * Empty constructor
     */
    public Linkedlist() {
        this.size = 0;
        this.first = null;
    }

    /**
     * Constructor with collection
     *
     * @param collection Elements to initialize the list
     */
    public Linkedlist(Collection<? extends E> collection) {
        Objects.requireNonNull(collection, "Collection must not be null");

        // Build linked list immutably from the end
        Node<E> tempFirst = null;
        int tempSize = 0;

        // Since we can't link forward easily immutably, iterate backwards
        // Convert collection to array for reverse iteration
        Object[] elements = collection.toArray();
        for (int i = elements.length - 1; i >= 0; i--) {
            @SuppressWarnings("unchecked")
            E element = (E) elements[i];
            tempFirst = new Node<>(element, tempFirst);
            tempSize++;
        }

        this.size = tempSize;
        this.first = tempFirst;
    }

    /**
     * Get the first node (returns the actual node since it's immutable)
     */
    public Node<E> getFirst() {
        return Objects.isNull(first) ? null : first;
    }

    /**
     * Get size of the linked list
     */
    public int getSize() {
        return size;
    }

    /**
     * Immutable Node class
     *
     * @param <E> type of element held in node
     */
    public static final class Node<E> {
        private final E data;
        private final Node<E> next;

        /**
         * Constructor for creating a new node with an explicit next reference
         */
        private Node(E data, Node<E> next) {
            this.data = Objects.requireNonNull(data, "Data must not be null");
            this.next = next;
        }

        private Node(Node<E> node) {
            this.data = node.data;
            this.next = node.next;
        }

        /**
         * Get the next node (immutable)
         */
        public Node<E> getNext() {
            return Objects.isNull(next) ? null : new Node<>(next);
        }

        /**
         * Get the data stored in the node
         */
        public E getData() {
            return data;
        }
    }
}
