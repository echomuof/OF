package leetcode;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: wangdarui
 * @created: 2020/10/25
 */
public class _212_单词搜索ii {

    public static void main(String[] args) {
        _212_单词搜索ii a = new _212_单词搜索ii();
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> ans = a.findWords(board, words);
        System.out.println();
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        TrieNode root = trie.root;
        for (String word : words) {
            trie.insert(word);
        }
        Set<String> ans = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, words, i, j, ans, root);
            }
        }
        return new ArrayList<>(ans);
    }

    public void dfs(char[][] board, String[] words, int i, int j, Set<String> ans, TrieNode root) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == '#') return;
        char curCh = board[i][j];
        TrieNode cur = root.child[curCh - 'a'];
        if (cur == null) {
            // board[i][j] = '#';
            return;
        }
        if (cur.isLeaf) ans.add(cur.val);

        board[i][j] = '#';
        dfs(board, words, i - 1, j, ans, cur);
        dfs(board, words, i + 1, j, ans, cur);
        dfs(board, words, i, j - 1, ans, cur);
        dfs(board, words, i, j + 1, ans, cur);
        board[i][j] = curCh;
    }
}

class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String s) {
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            if (cur.child[c - 'a'] == null) {
                cur.child[c - 'a'] = new TrieNode();
                cur = cur.child[c - 'a'];
            } else {
                cur = cur.child[c - 'a'];
            }
        }
        cur.isLeaf = true;
        cur.val = s;
    }
}

class TrieNode {

    public String val;
    public TrieNode[] child = new TrieNode[26];
    public boolean isLeaf;

    public TrieNode() {
    }
}