package com.CTCI.util;

public class StringUtil {

    public static boolean isSubString(String str, String sub){
        int subLen = sub.length();
        OUTER: for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == sub.charAt(0)){
                int counter = 1;
                try {
                    while(counter < subLen){
                        if(str.charAt(i + counter) == sub.charAt(counter)){
                            counter++;
                        } else {
                            continue OUTER;
                        }
                    }
                    return true;
                } catch(IndexOutOfBoundsException e){
                    return false;
                }



            }

        }
        return false;

    }

    public static String getBiggestSubString(String str1, String str2){
        int maxLen = 0;
        int maxIdx = -1;
        for(int i=0; i<str1.length(); i++){
            for(int j=0; j<str2.length(); j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    int counter = 0;
                    while(j+counter < str2.length() &&
                            i+counter < str1.length() &&
                            str1.charAt(i + counter) == str2.charAt(j + counter)){

                        counter++;
                        if (counter > maxLen){
                            maxLen = counter;
                            maxIdx = i;
                        }
                    }
                }

            }
        }

        StringBuilder outputSB = new StringBuilder(str1);

        return outputSB.substring(maxIdx, maxIdx + maxLen).toString();
    }

    // If the substring is a substring, it returns the string
    // minus the substring, else it returns the original string
    public static String stringMinusSub(String str1, String sub){
        if(isSubString(str1,sub)){
            String output = "";

            StringBuilder sb = new StringBuilder(str1);
            int subStart = sb.indexOf(sub);
            int subEnd = subStart + sub.length();

            output += sb.substring(0, subStart);
            output += sb.substring(subEnd, str1.length());
            return output;

        } else {
            return str1;
        }
    }
}
