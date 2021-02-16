package com.CTCI.ch2;

import com.CTCI.util.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class Chapter2 {
    LinkedList ll = new LinkedList();

    //Remove Duplicates
    public Node removeDups(Node input){
        if(input == null) return null;

        Node copy = input;
        Node head = copy;

        while(copy.next != null){
            if(copy.data == copy.next.data){
                if(copy.next.next == null){
                    copy.next = null;
                } else {
                    copy.next = copy.next.next;
                }
            } else {
                copy = copy.next;
            }
        }

        //After all copies are removed
        //Return head
        return head;

    }

    //Remote Kth to last
    public int getKthToLast(Node head, int k){
        int counter = 0;
        Node pointer1 = head;
        Node pointer2 = head;

        while(pointer1.next != null && pointer1.next.next != null){
            pointer1 = pointer1.next.next;
            pointer2 = pointer2.next;
            counter++;

        }

        int target;

        if(pointer1.next != null){
            //event number of nodes
            target = (counter * 2 + 1) - (k-1);
            System.out.println("hi");
        } else {
            //odd number of nodes
            target = (counter * 2) - (k-1);
        }

        Node finder = head;
        
        while(target > 0){
            finder = finder.next;
            target--;
        }

        return finder.data;


    }



    public static void main(String[] args) {
        Chapter2 ch2 = new Chapter2();
        int[] arr = {1,2,3,4};

        int[] dupeArr = {1,2,3,4,5,6,7,8,9,10};
        int[] dupeArr2 = {1,2,3,4,5,6,7,8,9,10,11};
        Node dupeHead = LinkedList.arrayToLinkedList(dupeArr);
        Node dupeHead2 = LinkedList.arrayToLinkedList(dupeArr2);

//        int no = ch2.getKthToLast(dupeHead, 2);
        int no2 = ch2.getKthToLast(dupeHead2, 2);
//        System.out.println(no);
        System.out.println(no2);

    }
}
