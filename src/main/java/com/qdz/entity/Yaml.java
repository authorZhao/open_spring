package com.qdz.entity;

import java.util.LinkedList;

public class Yaml{
    Node first;
    Node last;

    private static class Node {
        String item;
        Node next;
        Node prev;
        Node(Node prev, String element, Node next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

}
