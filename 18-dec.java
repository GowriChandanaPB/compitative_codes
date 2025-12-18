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



// 3. 2 sum

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                return new int[] {map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}


// 4. Group Anagrams


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String i : strs){
        char[] c = i.toCharArray();
        Arrays.sort(c);
        String s = new String(c);
        if(!map.containsKey(s)) map.put(s, new ArrayList<>());
        map.get(s).add(i);
        }
        return new ArrayList<>(map.values());
        }
}