package Amazon;

/*
Given an array of strings strs, group the anagrams together.
You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the
letters of a different word or phrase, typically using all the
original letters exactly once.

 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String st : strs) {
            char[] s = st.toCharArray();
            Arrays.sort(s);
            String key = String.valueOf(s);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(st);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }

}
