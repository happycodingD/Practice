package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReorderDataLogFiles {

    public static String[] reorderLogFiles(String[] logs) {
        List<String> digitLogs = new ArrayList<>();
        List<String[]> letterLogs = new ArrayList<>();

        for(int i=0; i<logs.length; i++) {
            String[] str = logs[i].split(" ");
            if(Character.isDigit(str[1].toCharArray()[0])) {
                digitLogs.add(logs[i]);
            } else {
                letterLogs.add(new String[]{str[0], logs[i].substring(logs[i].split(" ")[0].length()+1)});
            }
        }
        letterLogs.sort((a,b)->a[1].compareTo(b[1]) == 0 ? a[0].compareTo(b[0]) : a[1].compareTo(b[1]));
        String[] result = new String[logs.length];
        for(int i=0; i<letterLogs.size(); i++) {
            result[i] = letterLogs.get(i)[0] + " " + letterLogs.get(i)[1];
        }
        int resultIdx = letterLogs.size();
        for(int i=0; i<digitLogs.size(); i++) {
            result[resultIdx++] = digitLogs.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        System.out.println(Arrays.toString(reorderLogFiles(logs)));
    }

}
