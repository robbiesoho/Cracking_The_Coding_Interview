import java.util.HashMap;
import java.util.Map;

public class Chapter1 {

    //String builder
    String joinWords(String[] words){
        StringBuilder sentence = new StringBuilder();
        for(String w : words){
            sentence.append(w);
        }
        return sentence.toString();
    }

    //Is Unique
    boolean isUnique(String word){
        for(int i=0; i < word.length()/2; i++){
            for(int j=word.length()-1; j>=word.length()/2; j--){
                if (word.charAt(i) == (word.charAt(j))){
                    return false;
                }
            }

        }

        return true;
    }

    //Check permutation
    boolean checkPerm(String str1, String str2){
        HashMap<Character, Integer> str1map = new HashMap<Character, Integer>();
        HashMap<Character, Integer> str2map = new HashMap<Character, Integer>();

        for (int i=0; i< str1.length(); i++){
            if (str1map.containsKey(str1.charAt(i))){
                int count = str1map.get(str1.charAt(i));
                str1map.put(str1.charAt(i), count+1);
            } else {
                str1map.put(str1.charAt(i), 1);

            }
        }

        for (int i=0; i< str1.length(); i++){
            if (str2map.containsKey(str2.charAt(i))){
                int count = str2map.get(str2.charAt(i));
                str2map.put(str2.charAt(i), count+1);
            } else {
                str2map.put(str2.charAt(i), 1);

            }
        }

        if(str1map.equals(str2map)) {return true;}
        else {return false;}

    }
    //URLify


    //code driver
    public static void main(String[] args) {
        Chapter1 ch = new Chapter1();
        System.out.println(ch.checkPerm("12345", "54321"));
    }
}
