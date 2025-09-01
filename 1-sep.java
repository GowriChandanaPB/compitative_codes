// 1. Contains Duplicate   

class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> dup = new HashSet<>();
        for(int i: nums){
            if(dup.contains(i)){
                return true;
            }
            dup.add(i);
        }
        return false;
    }
}


// 2. Valid Anagram   

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr, tArr);
    }
}


// 3. Two Sum   

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int a = target - nums[i];
            if(map.containsKey(a)) {
                return new int[]{map.get(a), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}


// 4. Group Anagrams   

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }
            ans.get(key).add(s);
        }

        return new ArrayList<>(ans.values());        
    }
}


// 5. Top K Frequent Elements

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            arr.add(new int[] {entry.getValue(), entry.getKey()});
        }
        arr.sort((a, b) -> b[0] - a[0]);

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr.get(i)[1];
        }
        return ans;
    }
}


// 6. Encode and Decode Strings   

public class Solution {

    public String encode(List<String> strs) {
        StringBuilder ans = new StringBuilder();
        for (String s : strs) {
            ans.append(s.length()).append('#').append(s);
        }
        return ans.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int n = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + n;
            res.add(str.substring(i, j));
            i = j;
        }
        return res;
    }
}


// 7. Product of Array Except Self   

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }
        return res;
    }
}