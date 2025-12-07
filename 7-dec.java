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


// 3. 4 sum

class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> temp = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;
                int p = j + 1;
                int q = n - 1;
                while (p < q) {
                    long sum = (long) arr[i] + arr[j] + arr[p] + arr[q];
                    if (sum < target) {
                        p++;
                    } else if (sum > target) {
                        q--;
                    } else {
                        temp.add(Arrays.asList(arr[i], arr[j], arr[p], arr[q]));
                        while (p < q && arr[p] == arr[p + 1]) p++;
                        while (p < q && arr[q] == arr[q - 1]) q--;
                        p++;
                        q--;
                    }
                }
            }
        }
        return temp;
    }
}
