package com.CTCI.util;

import com.CTCI.ch2.Node;

public class LinkedList {

    public static Node deleteNode(Node head, int d){
        if(head == null) return null;
        Node n = head;

        if(n.data == d){
            return head.next;
        }

        while(n.next != null){
            if(n.next.data == d){
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        return head;
    }


    public static Node arrayToLinkedList(int[] arr){
        Node head = new Node(arr[0]);;
        Node currNode = head;
        int counter =1;
        while(counter < arr.length){
            currNode.next = new Node(arr[counter++]);
            currNode = currNode.next;

        }
        return head;
    }

    public static void printLinkedList(Node no){
        while(no.next != null){
            System.out.println(no.data);
            no = no.next;
        }
        System.out.println(no.data);
    }

    public static boolean linkedListEquals(Node no1, Node no2){
        if(no1.data != no2.data) return false;
        try{
            while(no1.next != null){
                if(no1.next.data != no2.next.data){
                    return false;
                }
                no1 = no1.next;
                no2 = no2.next;
            }
            if(no1.data != no2.data) return false;

        }catch(NullPointerException e){
            return false;
        }

        return true;
    }


}


