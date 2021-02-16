package com.test.ch2;

import com.CTCI.ch2.Chapter2;
import com.CTCI.util.LinkedList;
import com.CTCI.ch2.Node;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Chapter2Test {
    Chapter2 ch2 = new Chapter2();
    static Node dupeHead;
    static Node dupeAns;

    @BeforeAll
    static void setUp() {
        //#1
        int[] dupeArr = {1,2,2,3,3,4,5,5,5};
        dupeHead = LinkedList.arrayToLinkedList(dupeArr);

        int[] dupeArrAns = {1,2,3,4,5};
        dupeAns = LinkedList.arrayToLinkedList(dupeArrAns);

    }

    @Test
    void removeDupsTest(){
        Node ans = ch2.removeDups(dupeHead);
        assertTrue(LinkedList.linkedListEquals(ans, dupeAns));
    }

    @Test
    void getKthToLastTest(){
        assert(ch2.getKthToLast(dupeAns,2) == 4);
        assert(ch2.getKthToLast(dupeHead,7) == 2);
        assert(ch2.getKthToLast(dupeAns,1) == 5);
    }
}
