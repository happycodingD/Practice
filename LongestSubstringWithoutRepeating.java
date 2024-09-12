package Amazon;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {

    public static int lengthOfLongestSubstring(String s) {
        if(s==null || s.isEmpty()) {
            return 0;
        }
        char[] string = s.toCharArray();
        int maxLength = 0;
        for(int i=0; i<s.length(); i++) {
            Set<Character> set = new HashSet<>();
            for(int j=i; j<s.length(); j++) {
                if(!set.contains(string[j])) {
                    set.add(string[j]);
                } else {
                    break;
                }
            }
            maxLength = Math.max(maxLength, set.size());
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring_O_n(String s) {
        if(s==null || s.isEmpty()) {
            return 0;
        }
        int[] indices = new int[128];
        int maxLength = 0;
        for(int i=0, j=0; j<s.length(); j++) {
            i = Math.max(indices[s.charAt(j)], i);
            maxLength = Math.max(maxLength, j-i+1);
            indices[s.charAt(j)] = j+1;
        }
        return maxLength;
    }

    public static void main(String args[]) {
        System.out.println(lengthOfLongestSubstring("$"));
    }

}
