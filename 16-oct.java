// 1. Maximum Subarray

class Solution {
    public int maxSubArray(int[] nums) {
        int sub = nums[0], sum = 0;
        for (int i : nums) {
            if (sum < 0) {
                sum = 0;
            }
            sum += i;
            sub = Math.max(sub, sum);
        }
        return sub;
    }
}