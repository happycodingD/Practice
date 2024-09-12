package Amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumVarianceSubstring {

    public static int largestVariance(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int maxVariance = 0;
        for (char c1: map.keySet()) {
            for (char c2: map.keySet()) {
                if(c1 == c2) {
                    continue;
                }
                int freqC1 = 0;
                int freqC2 = 0;
                int remainingC2 = map.get(c2);

                for(int i=0; i<s.length(); i++) {
                    if (s.charAt(i)==c1) {
                        freqC1++;
                    }
                    if (s.charAt(i)==c2) {
                        freqC2++;
                        remainingC2--;
                    }
                    if (freqC1>0 && freqC2>0) {
                        maxVariance = Math.max(maxVariance, freqC1-freqC2);
                    }
                    if (freqC2>freqC1 && remainingC2>0) {
                        freqC1 = 0;
                        freqC2 = 0;
                    }
                }
            }
        }
        return maxVariance;
    }

    public static void main(String args[]) {
        String s = "aababbb";
        System.out.println((largestVariance(s)));
    }
}
