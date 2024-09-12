package Amazon;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static int romanToInt(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Integer> hm = new HashMap<>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);

        int result = 0;

        for(int i=0; i<s.length();) {
            if(i+1<arr.length && arr[i]=='I' && (arr[i+1]=='V' || arr[i+1]=='X')) {
                result = result + (hm.get(arr[i+1])-hm.get(arr[i]));
                i = i+2;
            }
            else if(i+1<arr.length && arr[i]=='C' && (arr[i+1]=='D' || arr[i+1]=='M')) {
                result = result + (hm.get(arr[i+1])-hm.get(arr[i]));
                i = i+2;
            }
            else if(i+1<arr.length && arr[i]=='X' && (arr[i+1]=='L' || arr[i+1]=='C')) {
                result = result + (hm.get(arr[i+1])-hm.get(arr[i]));
                i = i+2;
            } else {
                result = result + hm.get(arr[i]);
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }
}
