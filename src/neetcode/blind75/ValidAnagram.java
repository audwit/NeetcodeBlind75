package neetcode.blind75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "racecar";
        String t = "carrace";

        boolean result = isAnagram(s, t);
        System.out.println(result);
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);

        if(Arrays.equals(sCharArray, tCharArray))
            return true;
        else
            return false;
    }

    public static boolean isAnagramUsingMap(String s, String t) {

            if(s.length() != t.length())
                return false;

            Map<Character, Integer> mapS = new HashMap<>();
            Map<Character, Integer> mapT = new HashMap<>();

            for(int i=0; i<s.length(); i++){
                mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0)+1);
                mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0)+1);
            }


            if(mapS.equals(mapT))
                return true;
            else
                return false;


    }
}
