// 1. Two sum

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1; 
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) return new int[]{left+1, right+1};
            else if (sum < target) left++;
            else right--;
        }
        return new int[]{0, 0};
    }
}


// 2. 3 sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        Arrays.sort(nums);
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    s.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum < target) j++;
                else k--;
            }
        }
        res.addAll(s);
        return res;
    }
}