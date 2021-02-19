package com.CTCI.ch2;

public class Node {
    public Node next = null;
    public Integer data;

    public Node(Integer data){
        this.data = data;
    }

    public void appendToTail(Integer d){
        Node end = new Node(d);
        Node n = this;
        while (n.next != null){
            n = n.next;
        }

        n.next = end;
    }
}
