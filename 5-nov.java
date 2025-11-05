// 1. Longest Repeating Character Replacement

class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        int p = 0, q = 0;
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            q = Math.max(q, map.get(s.charAt(i)));
            while((i - p +1) - q > k){
                map.put(s.charAt(p), map.get(s.charAt(p))- 1);
                p++;
            }
            res = Math.max(res, i - p + 1);
        }
        return res;
    }
}


// 2. Permutation in String




