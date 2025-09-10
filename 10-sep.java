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


// 3. Minimum Window Substring

class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char i : t.toCharArray()) {
            countT.put(i, countT.getOrDefault(i, 0) + 1);
        }

        int have = 0, need = countT.size();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (countT.containsKey(c) && window.get(c).equals(countT.get(c))) {
                have++;
            }

            while (have == need) {
                if ((i - l + 1) < resLen) {
                    resLen = i - l + 1;
                    res[0] = l;
                    res[1] = i;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}


// 4. Sliding Window Maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int max = nums[i];
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            output[i] = max;
        }

        return output;
    }
}


// 5. Invert Binary Tree

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}


// 6. Maximum Depth of Binary Tree

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}