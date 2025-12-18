// 1. Contains Duplicate

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            if(set.contains(i)) return true;
            set.add(i);
        }
        return false;
    }
}


// 2. valid Anagram

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] s_new = s.toCharArray();
        char[] t_new = t.toCharArray();
        Arrays.sort(s_new);
        Arrays.sort(t_new);
        return Arrays.equals(s_new, t_new);
    }
}