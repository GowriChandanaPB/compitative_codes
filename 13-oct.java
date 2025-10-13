// 1. House Robber

class Solution {
    public int rob(int[] nums) {
        int rob1 = 0, rob2 = 0;

        for (int num : nums) {
            int temp = Math.max(num + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}


// 2. House Robber II

class Solution {

    public int rob(int[] nums) {
        return Math.max(nums[0],
               Math.max(rob2(Arrays.copyOfRange(nums, 1, nums.length)),
               rob2(Arrays.copyOfRange(nums, 0, nums.length - 1))));
    }

    public int rob2(int[] nums) {
        int rob1 = 0, rob2 = 0;

        for (int num : nums) {
            int newRob = Math.max(rob1 + num, rob2);
            rob1 = rob2;
            rob2 = newRob;
        }
        return rob2;
    }
}