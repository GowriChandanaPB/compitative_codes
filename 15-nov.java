// 1. Two Sum II - Input Array Is Sorted

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        while((numbers[left] + numbers[right]) != target){
            if((numbers[left] + numbers[right]) < target) ++left;
            else --right;
        }
        return new int[] {left + 1, right + 1};
    }
}


// 2. 3Sum 

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


// 3. 4sum

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



// 4. Number of Subsequences That Satisfy the Given Sum Condition

class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = 1000000007 , n = nums.length;
        Arrays.sort(nums);
        
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }
        int left = 0 , right = n - 1 , result = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + power[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}


// 5. Two Sum IV - Input is a BST

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set=new HashSet<>();
        return helper(root,k,set);
    }
    public boolean helper(TreeNode node,int k,Set<Integer> seen){
        if(node==null)return false;
        if(seen.contains(k-node.val))return true;
        seen.add(node.val);
        return helper(node.left,k,seen)||helper(node.right,k,seen);
    }
}


// 6. Sum of Squares of Special Integers

class Solution {
    public boolean judgeSquareSum(int c) {
        for (int i = 2; i * i <= c; i++) {
            if (c % i == 0) {
                int count = 0;
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0) {
                    return false;
                }
            }
        }
        return c % 4 != 3;
    }
}


// 7. Boats to Save People

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boatCount = 0;
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        
        while(left <= right){
            int sum = people[left] + people[right];
            if(sum <= limit){
                boatCount++;
                left++;
                right--;
            }
            else{
                boatCount++;
                right--;
            }
        }
        return boatCount;
    }
}

