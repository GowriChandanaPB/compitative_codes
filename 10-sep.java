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

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int match = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) {
                match++;
            }
        }

        int l = 0;
        for (int i = s1.length(); i < s2.length(); i++) {
            if (match == 26) {
                return true;
            }

            int idx = s2.charAt(i) - 'a';
            s2Count[idx]++;
            if (s1Count[idx] == s2Count[idx]) {
                match++;
            } else if (s1Count[idx] + 1 == s2Count[idx]) {
                match--;
            }

            idx = s2.charAt(l) - 'a';
            s2Count[idx]--;
            if (s1Count[idx] == s2Count[idx]) {
                match++;
            } else if (s1Count[idx] - 1 == s2Count[idx]) {
                match--;
            }
            l++;
        }
        return match == 26;
    }
}