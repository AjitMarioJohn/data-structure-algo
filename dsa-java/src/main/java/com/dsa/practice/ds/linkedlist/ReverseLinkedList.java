package com.dsa.practice.ds.linkedlist;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
//        reverseUsingStack(head);
//        return head;
//        return reverseUsingIterator(head);
        return reverseUsingRecursion(head);
    }

    private void reverseUsingStack(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            temp.val = stack.pop();
            temp = temp.next;
        }
    }

    private ListNode reverseUsingIterator(ListNode node) {
        ListNode currentNode = node;
        ListNode prev = null;

        while (currentNode != null) {
            ListNode front = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = front;
        }
        return prev;
    }

    private ListNode reverseUsingRecursion(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode newHead = reverseUsingRecursion(node.next);
        ListNode front = node.next;
        front.next = node;
        node.next = null;
        return newHead;
    }
}