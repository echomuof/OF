package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wangdarui
 * @date: 2020/9/23
 */
public class TODO_127_单词接龙 {

    public static void main(String[] args) {
        String beginWord = "hot";
        String endWord = "dog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dog","cog","pot","dot"));
        TODO_127_单词接龙 a = new TODO_127_单词接龙();
        int length = a.ladderLength(beginWord, endWord, wordList);
        System.out.println(length);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        if (beginWord.length() == 1 && wordList.contains(beginWord)) {
            return 2;
        }
        wordList.remove(beginWord);
        dfs(beginWord, endWord, wordList, 0);
        return minStep == Integer.MAX_VALUE ? 0 : minStep + 1;
    }

    private int minStep = Integer.MAX_VALUE;

    public void dfs(String cur, String target, List<String> wordList, int step) {
        if (cur.equals(target)) {
            minStep = Math.min(step, minStep);
            return;
        }
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            int diff = 0;
            for (int j = 0; j < cur.length(); j++) {
                if (cur.charAt(j) != word.charAt(j) && ++diff > 1) {
                    break;
                }
            }
            if (diff == 1) {
                wordList.remove(i);
                dfs(word, target, wordList, step + 1);
                wordList.add(word);
            }
        }
    }

}
