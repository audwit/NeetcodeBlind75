package neetcode.blind75;

import java.util.*;
import java.util.stream.Collectors;


class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str:strs){
            String sortedWord = sortStr(str); // Write this sorting method
            map.putIfAbsent(str, new ArrayList<>());
            map.get(sortedWord).add(str);
        }
        return convertMapValuesToString(map);
    }

    private String sortStr(String word){
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String (chars);
    }

    private List<List<String>> convertMapValuesToString(Map<String, List<String>> map){
        List<List<String>> result = map.values().stream().collect(Collectors.toList());
        return result;
    }
}
