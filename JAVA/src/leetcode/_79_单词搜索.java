package leetcode;

/**
 * @author: wangdarui
 * @created: 2020/10/25
 */
public class _79_单词搜索 {

    public static void main(String[] args) {
        _79_单词搜索 a = new _79_单词搜索();

        char[][] board = {{'A'}};
        String word = "A";
        System.out.println(a.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        Trie trie = new Trie();
        trie.insert(word);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, i, j, trie.root)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, TrieNode root) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == '#') return false;
        char curCh = board[i][j];
        TrieNode cur = root.child[curCh - 'A'];
        if (cur == null) return false;
        board[i][j] = '#';
        boolean ans = cur.isLeaf || dfs(board, i - 1, j, cur)
                || dfs(board, i + 1, j, cur)
                || dfs(board, i, j - 1, cur)
                || dfs(board, i, j + 1, cur);
        board[i][j] = curCh;
        return ans;
    }

    static class Trie {
        public TrieNode root = new TrieNode();

        public void insert(String s) {
            TrieNode cur = root;
            for (char ch : s.toCharArray()) {
                if (cur.child[ch - 'A'] == null) {
                    cur.child[ch - 'A'] = new TrieNode();
                }
                cur = cur.child[ch - 'A'];
            }
            cur.isLeaf = true;
            cur.val = s;
        }
    }

    static class TrieNode {
        public String val;
        public boolean isLeaf;
        public TrieNode[] child = new TrieNode[58];
    }

}
