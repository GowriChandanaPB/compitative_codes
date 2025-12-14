// 1. find pivot index

class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for(int i : nums) total += i;
        int leftsum = 0;
        for(int i=0; i<nums.length; i++){
            int rightsum = total - leftsum - nums[i];
            if(rightsum == leftsum) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}


// 2. Subarray Sum Equals K

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - k)) count += map.get(sum-k);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}


// 3. Continuous Subarray Sum

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            int remainder = sum%k;
            if(map.containsKey(remainder)){
                if(i-map.get(remainder)>1) return true;
                else map.put(remainder, i);
            }
        }
        return false;
    }
}



// 4. 