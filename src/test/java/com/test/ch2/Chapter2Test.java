package com.test.ch2;

import com.CTCI.ch2.Chapter2;
import com.CTCI.util.LinkedListUtil;
import com.CTCI.ch2.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Chapter2Test {
    Chapter2 ch2 = new Chapter2();
    static Node dumbHead;
    static Node dumbAns;
    static Node dumbHead1;
    static Node dumbHead2;
    static Node dumbHead3;

    @BeforeEach
    void setUp() {
        //#1
        Integer[] dumbArr = {1,2,2,3,3,4,5,5,5};
        dumbHead = LinkedListUtil.arrayToLinkedList(dumbArr);
        Integer[] dupeArrAns = {1,2,3,4,5};
        dumbAns = LinkedListUtil.arrayToLinkedList(dupeArrAns);

        Integer[] dumbArr3 = {1,2,3,4,5,6,7,8,9};
        dumbHead3 = LinkedListUtil.arrayToLinkedList(dumbArr3);
    }

    @Test
    void removeDupsTest(){
        Node ans = ch2.removeDups(dumbHead);
        assertTrue(LinkedListUtil.linkedListEquals(ans, dumbAns));
    }

    @Test
    void getKthToLastTest(){
        assert(ch2.getKthToLast(dumbAns,2) == 4);
        assert(ch2.getKthToLast(dumbHead,7) == 2);
        assert(ch2.getKthToLast(dumbAns,1) == 5);
    }

    @Test
    void deleteMiddleNodeTest(){
        Integer[] delMid1 = {1,2,2,3,4,5,5,5};
        dumbHead1 = LinkedListUtil.arrayToLinkedList(delMid1);

        Integer[] delMid2 = {1,2,4,5};
        dumbHead2 = LinkedListUtil.arrayToLinkedList(delMid2);

        assertTrue(LinkedListUtil.linkedListEquals(ch2.deleteMiddleNode(dumbHead),dumbHead1));
        assertTrue(LinkedListUtil.linkedListEquals(ch2.deleteMiddleNode(dumbAns),dumbHead2));
    }

    @Test
    void partitionTest(){
        Integer[] dumbArr3 = {1,2,3,4,5,null,null,6,7,8,9};
        Node dumbAns3 = LinkedListUtil.arrayToLinkedList(dumbArr3);

        assertTrue(LinkedListUtil.linkedListEquals(ch2.partition(dumbHead3, 6),dumbAns3));


    }
}

