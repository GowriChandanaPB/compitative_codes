// 1. Palindrome Partitioning

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(String s, int start, List<String> path, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (isPalindrome(s, start, end - 1)) {
                path.add(s.substring(start, end));
                backtrack(s, end, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int p, int q) {
        while (p < q) {
            if (s.charAt(p++) != s.charAt(q--)) {
                return false;
            }
        }
        return true;
    }
}


// 2. Letter Combinations of a Phone Number 

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) {
            return res;
        }
        
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        backtrack(digits, 0, new StringBuilder(), res, map);
        
        return res;        
    }

    private void backtrack(String digits, int idx, StringBuilder comb, List<String> res, Map<Character, String> map) {
        if (idx == digits.length()) {
            res.add(comb.toString());
            return;
        }
        
        String letters = map.get(digits.charAt(idx));
        for (char letter : letters.toCharArray()) {
            comb.append(letter);
            backtrack(digits, idx + 1, comb, res, map);
            comb.deleteCharAt(comb.length() - 1);
        }
    }    
}


// 3. LRU Cache

class LRUCache {
    private final Map<Integer, Integer> cache;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > LRUCache.this.capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}