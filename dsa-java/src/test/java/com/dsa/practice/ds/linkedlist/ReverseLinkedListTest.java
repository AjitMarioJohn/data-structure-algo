package com.dsa.practice.ds.linkedlist;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListTest {

    @Test
    void testReverseList() {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

        // Create linked list: 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // Reverse it: 4 -> 3 -> 2 -> 1
        ListNode reversedHead = reverseLinkedList.reverseList(head);

        // Validate results
        assertNotNull(reversedHead);
        assertEquals(4, reversedHead.val);
        assertEquals(3, reversedHead.next.val);
        assertEquals(2, reversedHead.next.next.val);
        assertEquals(1, reversedHead.next.next.next.val);
        assertNull(reversedHead.next.next.next.next); // Last node should point to null
    }

    @Test
    void testReverseListWithSingleNode() {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode head = new ListNode(42);

        ListNode reversedHead = reverseLinkedList.reverseList(head);

        assertNotNull(reversedHead);
        assertEquals(42, reversedHead.val);
        assertNull(reversedHead.next);
    }

    @Test
    void testReverseListWithEmptyList() {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode reversedHead = reverseLinkedList.reverseList(null);

        assertNull(reversedHead);
    }
}