//1.Maximum and Minimum Element in an Array(easy)

class Solution {
    public Pair<Integer, Integer> getMinMax(int[] arr) {
        // Code Here
        int max = arr[0];
        int min = arr[0];
        for(int i : arr){
            if(i < min){
                min = i;
            } 
            if(i > max){
                max = i;
            }
        }
        return new Pair<>(min, max);
        
    }
}



//2. reverse the array(easy)

class Solution {
    public void reverseArray(int arr[]) {
        // code here
        for(int i=arr.length-1; i>=0; i--){
            System.out.print(arr[i]);
        }
    }
}


// 3. maximum subarray(easy)

class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max_sum = nums[0];
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(sum > max_sum){
                max_sum = sum;
            }
            if(sum<0){
                sum = 0;
            }
        }
        return max_sum;
    }
}


// 4. contains duplicate(easy)

import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true; 
            }
            seen.add(num);
        }
        return false; 
    }
}


// 5. product of array expect self

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length; 
        int left = 1;
        int right = 1;
        int [] sum = new int[n];

        for(int i=n-1; i>=0; i--){
            sum[i] = right;
            right = right*nums[i];
        }
        for(int i=0; i<n; i++){
            sum[i] = sum[i] * left;
            left = left * nums[i];
        }
        return sum;
    }
}