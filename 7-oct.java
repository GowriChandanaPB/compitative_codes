// 1. Implement Trie (Prefix Tree)

class TrieNode {
    TrieNode[] child = new TrieNode[26];
    boolean endOfWord = false;
}

class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.child[i] == null) {
                cur.child[i] = new TrieNode();
            }
            cur = cur.child[i];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) {
                return false;
            }
            cur = cur.children[i];
        }
        return cur.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) {
                return false;
            }
            cur = cur.children[i];
        }
        return true;
    }
}


// 2. Design Add and Search Word Data Structure

class WordDictionary {

    private List<String> store;

    public WordDictionary() {
        store = new ArrayList<>();
    }

    public void addWord(String word) {
        store.add(word);
    }

    public boolean search(String word) {
        for (String w : store) {
            if (w.length() != word.length()) continue;
            int i = 0;
            while (i < w.length()) {
                if (w.charAt(i) == word.charAt(i) ||
                    word.charAt(i) == '.') {
                    i++;
                } else {
                    break;
                }
            }
            if (i == w.length()) {
                return true;
            }
        }
        return false;
    }
}


// 3. Word Search II

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int row = board.length, COLS = board[0].length;
        List<String> res = new ArrayList<>();

        for (String word : words) {
            boolean flag = false;
            for (int r = 0; r < row && !flag; r++) {
                for (int c = 0; c < COLS; c++) {
                    if (board[r][c] != word.charAt(0)) continue;
                    if (backtrack(board, r, c, word, 0)) {
                        res.add(word);
                        flag = true;
                        break;
                    }
                }
            }
        }
        return res;
    }

    private boolean backtrack(char[][] board, int r, int c, String word, int i) {
        if (i == word.length()) return true;
        if (r < 0 || c < 0 || r >= board.length ||
            c >= board[0].length || board[r][c] != word.charAt(i))
            return false;

        board[r][c] = '*';
        boolean ret = backtrack(board, r + 1, c, word, i + 1) ||
                      backtrack(board, r - 1, c, word, i + 1) ||
                      backtrack(board, r, c + 1, word, i + 1) ||
                      backtrack(board, r, c - 1, word, i + 1);
        board[r][c] = word.charAt(i);
        return ret;
    }
}