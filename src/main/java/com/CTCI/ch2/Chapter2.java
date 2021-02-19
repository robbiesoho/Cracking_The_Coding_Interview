package com.CTCI.ch2;

import com.CTCI.util.LinkedListUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Chapter2 {
    LinkedListUtil ll = new LinkedListUtil();

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

    //Delete middle node
    public Node deleteMiddleNode(Node head) {
        int counter = 0;
        Node pointer1 = head;
        Node pointer2 = head;
        Node output = head;

        while(pointer1.next != null && pointer1.next.next != null){
            pointer1 = pointer1.next.next;
            pointer2 = pointer2.next;
            counter++;

        }

        int[] arr = {1,2,3,4,5};
        int[] arr2 = {1,2,3,4,5,6};
        int target;

        target = 0;
        Node copy = head;
        while(counter - 1 > target){
            copy = copy.next;
            target++;

        }
        copy.next = copy.next.next;

        return output;




    }

    public Node partition(Node head, int i) {
        Node copy = head;
        Node output = null;
        ArrayList<Integer> lowList = new ArrayList<Integer>();
        ArrayList<Integer> highList = new ArrayList<Integer>();

        while(copy.next != null){
            if (copy.data < i) lowList.add(copy.data);
            else highList.add(copy.data);
            copy = copy.next;
        }

        if (copy.data < i) lowList.add(copy.data);
        else highList.add(copy.data);

        output = new Node(-999);
        Node outputHead = output;

        for(int p=0; p < lowList.size()-1 ; p++){
            output.data = lowList.get(p);
            output.next = new Node(0);
            output = output.next;

        }
        
        output.data = lowList.get(lowList.size()-1);
        output.next = new Node(0);
        output = output.next;

        output.data = null;
        output.next = new Node(0);
        output = output.next;

        output.data = null;
        output.next = new Node(0);
        output = output.next;

        for(int p=0;p<highList.size()-1;p++){
            output.data = highList.get(p);
            output.next = new Node(0);
            output = output.next;

        }

        output.data = highList.get(highList.size()-1);
        return outputHead;

    }


    public static void main(String[] args) {
        Chapter2 ch2 = new Chapter2();
        Integer[] delMid1 = {1,2,2,3,4,5,5,5};
        Node delHead1 = LinkedListUtil.arrayToLinkedList(delMid1);

        Node rm = ch2.partition(delHead1,4);
        LinkedListUtil.printLinkedList(rm);

//        LinkedList.printLinkedList(ch2.removeDups(h));

    }


}
