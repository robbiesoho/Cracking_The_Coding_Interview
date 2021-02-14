public class StringUtil {
    public static boolean isSubString(String str, String sub){
        int subLen = sub.length();

        OUTER: for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == sub.charAt(0)){
                int counter = 1;
                while(counter < subLen){
                    if(str.charAt(i + counter) == sub.charAt(counter)){
                        counter++;
                    } else {
                        continue OUTER;
                    }
                }
                return true;


            }

        }
        return false;

    }
}
