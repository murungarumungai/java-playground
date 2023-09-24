package com.testharness;

public class SinglyLinkedListTest {

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.createSinglyLinkedList(5);
        /*System.out.println(sll.head.value);

        sll.insert(10,0);
        System.out.println(sll.head.value);

        sll.insert(11,3);
        System.out.println(sll.head.next.next.value);

        sll.insert(12,4);
        System.out.println(sll.head.next.next.next.value);

        sll.insert(9,1);
        System.out.println(sll.head.next.next.value);*/

        sll.insert(6,1);
        sll.insert(7,3);
        sll.insert(8,4);
        sll.insert(9,0);

        sll.traverseSinglyLinkedList();

        sll.searchNode(9);
        sll.searchNode(7);

        sll.delete(3);
        sll.traverseSinglyLinkedList();

        sll.nukeSLL();
        sll.traverseSinglyLinkedList();

    }
}
