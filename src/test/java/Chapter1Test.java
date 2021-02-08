import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Chapter1Test {
    Chapter1 ch1 = new Chapter1();


    @Test
    void IsUniqueTest(){
        String str = "ABCD";
        boolean test = ch1.isUnique(str);
        assertTrue(test);

        str = "AABBCC";
        test = ch1.isUnique(str);
        assertFalse(test);
    }

    @Test
    void CheckPermutationTest(){
        String str1 = "abcd";
        String str2 = "cbda";
        String str3 = "aabc";

        assertTrue(ch1.checkPerm(str1, str2));
        assertFalse(ch1.checkPerm(str1, str3));
    }

    @Test
    void URLifyTest(){
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
    }

    @Test
    void rotateMatrixTest(){
        
    }

}
