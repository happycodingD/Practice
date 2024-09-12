package Amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visit = new HashSet<>(wordList);
        int count = 0;
        if(!visit.contains(endWord)) return count;

        int wordLength = beginWord.length();
        queue.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            while (size-- != 0 && queue.peek()!=null) {
                String curr = queue.poll();
                for (String s : wordList) {
                    if(visit.contains(s)) {
                        int diff = 0;
                        for (int i = 0; i < wordLength; i++) {
                            if (s.charAt(i) != curr.charAt(i)) {
                                diff++;
                            }
                        }
                        if (diff == 1) {
                            queue.add(s);
                            visit.remove(s);
                        }
                    }
                }
                if (queue.contains(endWord)) {
                    return ++count;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>(){
            {
                add("hot");
                add("dot");
                add("dog");
                add("lot");
                add("log");
                add("cog");

            }
        };
        System.out.println(ladderLength("hit", "cog", wordList));
    }
}
