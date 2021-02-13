import java.util.*;

public class Chapter1 {

    //String builder
    String joinWords(String[] words) {
        StringBuilder sentence = new StringBuilder();
        for (String w : words) {
            sentence.append(w);
        }
        return sentence.toString();
    }

    //Is Unique
    boolean isUnique(String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            for (int j = word.length() - 1; j >= word.length() / 2; j--) {
                if (word.charAt(i) == (word.charAt(j))) {
                    return false;
                }
            }

        }

        return true;
    }

    //Check permutation
    boolean checkPerm(String str1, String str2) {
        HashMap<Character, Integer> str1map = new HashMap<Character, Integer>();
        HashMap<Character, Integer> str2map = new HashMap<Character, Integer>();

        for (int i = 0; i < str1.length(); i++) {
            if (str1map.containsKey(str1.charAt(i))) {
                int count = str1map.get(str1.charAt(i));
                str1map.put(str1.charAt(i), count + 1);
            } else {
                str1map.put(str1.charAt(i), 1);

            }
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str2map.containsKey(str2.charAt(i))) {
                int count = str2map.get(str2.charAt(i));
                str2map.put(str2.charAt(i), count + 1);
            } else {
                str2map.put(str2.charAt(i), 1);

            }
        }

        if (str1map.equals(str2map)) {
            return true;
        } else {
            return false;
        }

    }

    //URLify
    char[] urlify(String str) {

        int[] indexOfSpaces = new int[str.length()];
        int lengthOfOutput = str.length();

        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                indexOfSpaces[counter] = i;
                counter += 1;
                lengthOfOutput += 2;
            }
        }

        char[] output = new char[lengthOfOutput];

        int addToIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                output[i + addToIndex] = str.charAt(i);
            } else {
                output[i] = '%';
                output[i + 1] = '2';
                output[i + 2] = '0';
                addToIndex += 2;

            }
        }

        return output;
    }

    //Palindrome Permutation
    boolean palPer(String str) {
        int len = str.length();
        char[] charArr = new char[len];
        for (int i = 0; i < len; i++) {
            if (Character.isLetter(str.charAt(i))) {
                charArr[i] = Character.toLowerCase(str.charAt(i));
            }
        }


        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < len; i++) {
            if (len % 2 != 0 && i == len / 2) {
                continue;
            }
            if (map.containsKey(charArr[i])) {
                int count = map.get(charArr[i]);
                map.put(charArr[i], count + 1);
            } else {
                map.put(charArr[i], 1);

            }
        }

        for (int i : map.values()) {
            if (i % 2 != 0) return false;
        }

        return true;
    }

    //One Away
    public boolean oneAway(String str1, String str2) {
        int differences = 0;

        char[] bigArr;
        char[] smallArr;

        if (str1.length() > str2.length()) {
            bigArr = str1.toCharArray();
            smallArr = str2.toCharArray();
        } else {
            bigArr = str2.toCharArray();
            smallArr = str1.toCharArray();
        }

        int lenDiff = bigArr.length - smallArr.length;

        List<Character> bigList = new ArrayList<Character>();

        List<Character> smallList = new ArrayList<Character>();

        for (char c : bigArr) {
            Character ch = c;
            bigList.add(ch);
        }

        for (char c : smallArr) {
            Character ch = c;
            smallList.add(ch);
        }

        while (lenDiff > 0) {
            smallList.add(' ');
            lenDiff -= 1;

        }

        int c1 = 0;
        int c2 = 0;

        while (c1 < bigList.size() - 1 && c2 < smallList.size() - 1) {
            if (bigList.get(c1) != smallList.get(c2)) {
                if (bigList.get(c1 + 1) == smallList.get(c2)) {
                    c1 += 1;
                    differences += 1;
                } else if (bigList.get(c1) == smallList.get(c2)) {
                    c2 += 1;
                    differences += 1;
                } else {
                    c1 += 1;
                    c2 += 1;
                    differences += 1;
                }
            } else {
                c1 += 1;
                c2 += 1;
            }

        }

        boolean output = differences > 1 ? false : true;

        return output;


    }


    //String Compression
    public String stringCompression(String str) {
        String output = "";
        for (int i = str.length() - 1; i > 0; i--) {
            int count = 1;
            if (i != 1) {
                while (i != 0 && str.charAt(i) == str.charAt(i - 1)) {
                    count += 1;
                    i -= 1;
                }


            } else {
                if (str.charAt(0) == str.charAt(1)) {
                    count += 1;
                }
            }

            output += count;
            output += str.charAt(i);


        }
        StringBuilder sb = new StringBuilder(output);
        sb.reverse();
        output = sb.toString();
        return output;
    }

    //Rotate Matrix
    // I'm going counter clockwise
    // n x n matrix
    int[][] rotateMatrix(int[][] mat) {

        int n = mat[0].length;
        int[][] output = new int[n][n];

        //decrement to use as index
        n = --n;

        for(int row = n; row>=0; row--){
            for(int ele = n; ele>=0; ele--){

                int num = mat[row][ele];
                int rowidx = n - ele;
                int colidx = row;

                output[rowidx][colidx] = num;


            }

        }


        return output;
    }


    //Zero Matrix
    public int[][] zeroMatrix(int[][] mat) {
        int[][] output = MatrixUtil.makeDummyMatrix(mat);

        Set<Integer> rowZero = new HashSet<Integer>();
        Set<Integer> colZero = new HashSet<Integer>();

        //find the rows and columns that should be zero
        for(int i=0; i<mat.length; i++){

            for(int j=0; j<mat[i].length; j++){
                if(mat[i][j] == 0){
                    rowZero.add(i);
                    colZero.add(j);
                }
            }
        }

        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[i].length; j++){
                if(rowZero.contains(i) || colZero.contains(j)){
                    output[i][j] = 0;
                } else {
                    output[i][j] = mat[i][j];
                }
            }
        }

        return output;

    }

    //String Rotation


    //code driver
    public static void main(String[] args) {
        Chapter1 ch = new Chapter1();

    }


}
