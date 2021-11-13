package com.testharness;

public class SinglyLinkedList {

    public Node head;
    public Node tail;
    public int size;

    //singly linked list with one node
    public Node createSinglyLinkedList(int nodeValue) {
        head = new Node();
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;

        return head;
    }

    //insert
    public void insert(int nodeValue, int location) {

        Node node = new Node();
        node.value = nodeValue;

        if(head ==null) {
            createSinglyLinkedList(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
        } else if (location >= size) { //insert at the end
            node.next = null;
            tail.next = node;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;

            while (index < location -1) {
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
        }
        size++;
    }

    //SinglyLinkedList traversal
    public void traverseSinglyLinkedList() {

        if(head==null) {
            System.out.println("SinglyLinkedList does not exist");
        } else {
            Node tempNode = head;

            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);

                if(i !=size -1) {
                    System.out.print(" -> ");
                }
                tempNode= tempNode.next;
            }
        }

        System.out.println("\n");
    }

    //search sll
    boolean searchNode(int nodeValue) {

        if (head != null) {
            Node tempNode = head;

            for (int i = 0; i < size; i++) {

                if(tempNode.value == nodeValue) {
                    System.out.print("Found the node at location " + i + "\n");
                    return true;
                }
                tempNode = tempNode.next;

            }
        }

        System.out.println("Node not found");
        return false;
    }

    //delete from sll
    public void delete(int location) {

        if(head == null) {
            System.out.println("The SLL does not exist");
            return;
        } else if (location == 0) { //first element
            head = head.next;
            size--;

            if (size == 0) {
                tail = null;
            }
        } else if (location >=size) { // if location is at the end or greater than size of sll

            Node tempNode = head;

            for (int i = 0; i < size - 1; i++) { //size -1 to get the node just b4 the last
                tempNode = tempNode.next;
            }

            if (tempNode == head) {
                tail = head = null;
                size--;
                return;
            }

            tempNode.next = null;
            tail = tempNode;
            size--;

        } else { //deleting anywhere
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }

            tempNode.next = tempNode.next.next; //chaning the reference of the node that is after the node we want to delete
            size--;
        }
    }

    //detete entire sll
    public void nukeSLL() {
        head = null;
        tail = null;
    }
}
