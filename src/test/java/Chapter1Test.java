import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class Chapter1Test {
    Chapter1 ch1 = new Chapter1();

    @Test
    void isUniqueTest(){
        String str = "ABCD";
        boolean test = ch1.isUnique(str);
        assertTrue(test);

        str = "AABBCC";
        test = ch1.isUnique(str);
        assertFalse(test);
    }

    @Test
    void checkPermutationTest(){
        String str1 = "abcd";
        String str2 = "cbda";
        String str3 = "aabc";

        assertTrue(ch1.checkPerm(str1, str2));
        assertFalse(ch1.checkPerm(str1, str3));
    }

    @Test
    void uRLifyTest(){
        String str = "ab c";
        char[] answer = {'a','b','%','2','0','c'};
        char[] test = ch1.urlify(str);

        assertTrue(Arrays.equals(answer, test));

    }

    @Test
    void palindromePermutationTest(){
        String pass = "aAbB12345#@#$c%!C@@";
        String fail = "a2123DSSS";

        assertTrue(ch1.palPer(pass));
        assertFalse(ch1.palPer(fail));
    }

    @Test
    void oneAwayTest(){
        String str1 = "pale";
        String str2 = "ple";
        assertTrue(ch1.oneAway(str1,str2));

        str1 = "pales";
        str2 = "pale";
        assertTrue(ch1.oneAway(str1,str2));

        str1 = "pale";
        str2 = "bale";
        assertTrue(ch1.oneAway(str1,str2));

        str1 = "pale";
        str2 = "bake";
        assertFalse(ch1.oneAway(str1,str2));


    }

    @Test
    void stringCompressionTest(){
        String str = "aabcccccaaa";
        String answer = "a2b1c5a3";
        assert(ch1.stringCompression(str).equals(answer));

        String str2 = "aaaaaaaa";
        String ans2 = "a8";

        assertEquals(ans2,ch1.stringCompression(str2));
    }

    @Test
    void rotateMatrixTest(){

        int[][] matrix1 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int[][] ans1 = {
                {3,6,9},
                {2,5,8},
                {1,4,7}
        };
        /*
        #       in      out
        1       0,0     2,0
        2       0,1     1,0
        3       0,2     0,0
        4       1,0     2,1
        5       1,1     1,1
        6       1,2     0,1
        7       2,0     1,0
        8       2,1     1,2
        9       2,2     0,2
         */

        int[][] matrix2 = {
                {1,2},
                {3,4}
        };

        int[][] ans2 = {
                {2,4},
                {1,3}
        };

        int[][] matrix3 = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        int[][] ans3 = {
                {4,8,12,16},
                {3,7,11,15},
                {2,6,10,14},
                {1,5,9,13}
        };

        assertTrue(MatrixUtil.matrixEquals(ch1.rotateMatrix(matrix1), ans1));
        assertTrue(MatrixUtil.matrixEquals(ch1.rotateMatrix(matrix2), ans2));
        assertTrue(MatrixUtil.matrixEquals(ch1.rotateMatrix(matrix3), ans3));


    }

    @Test
    void zeroMatrixTest(){
        int[][] matrix1 = {
                {0,2,3},
                {4,5,6},
                {7,8,9}
        };

        int[][] ans1 = {
                {0,0,0},
                {0,5,6},
                {0,8,9}
        };

        int[][] matrix2 = {
                {2,4},
                {1,0}
        };

        int[][] ans2 = {
                {2,0},
                {0,0}
        };

        int[][] matrix3 = {
                {1,0,3,4},
                {5,6},
                {9,10,11,0},
                {13,14}
        };

        int[][] ans3 = {
                {0,0,0,0},
                {5,0},
                {0,0,0,0},
                {13,0}
        };

        assertTrue(MatrixUtil.matrixEquals(ch1.zeroMatrix(matrix1), ans1));
        assertTrue(MatrixUtil.matrixEquals(ch1.zeroMatrix(matrix2), ans2));
        assertTrue(MatrixUtil.matrixEquals(ch1.zeroMatrix(matrix3), ans3));

    }

//    @Test
//    void stringRotationTest(){
//        assertTrue(ch1.stringRotation("watterbottle", "erbottlewat"));
//
//    }

}

