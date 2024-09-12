package Amazon;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

 */

import java.util.ArrayList;

public class isValidParanthesis {
    public static boolean isValid(String s) {
        ArrayList<Character> arr = new ArrayList<>();
        arr.add(s.charAt(0));
        int count = 1;
        for(int i=0; i<s.length()-1; i++) {
            if(arr.get(i)==s.charAt(i+1)) {
                arr.remove(s.charAt(i+1));
                count--;
            } else {
                arr.add(s.charAt(i+1));
                count++;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        String s = "{}";
        System.out.println("Output: " + isValid(s));
    }
}
