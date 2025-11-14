// 1. Longest Increasing Subsequence

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int p[] = new int[nums.length];
        Arrays.fill(p, 1);

        for(int i=1; i<nums.length; ++i){
            for(int j=0; j<i; ++j ){
                if(nums[i]>nums[j]) p[i] = Math.max(p[i], p[j] + 1);
            }
        }
        int max = Arrays.stream(p).max().orElse(0);
        return max;
    }
}
