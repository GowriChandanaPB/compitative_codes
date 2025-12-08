// 1. remove duplicate from sorted array

class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != nums[j-1]){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}



// 2. valid palindrome

class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]","");
        int left = 0, right = s.length()-1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}


// 3. container with most water

class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int res = 0;

        while (l < r) {
            int area = Math.min(heights[l], heights[r]) * (r - l);
            res = Math.max(res, area);
            if (heights[l] <= heights[r]) l++;
            else r--;
        }
        return res;
    }
}



// 4. move zeroes

class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}


// 5. reverse string

class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length-1;
        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}



// 6.  Squares of a Sorted Array 

class Solution {
    public int[] sortedSquares(int[] nums) {
        int [] res = new int[nums.length];
        int left = 0, right = nums.length-1, idx = nums.length-1;
        while(left <= right){
            int lsq = nums[left] * nums[left];
            int rsq = nums[right] * nums[right];
            if(lsq > rsq){
                res[idx--] = lsq;
                left++;
            } else {
                res[idx--] = rsq;
                right--;
            }
        }
        return res;
    }
}



// 7. Subarray Product Less Than K 

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int sum = nums[0];
        if(sum<k) res++;
        int left = 0, right = 1;
        while(right != nums.length){
            int val = nums[right];
            sum = sum*val;
            if(sum < k) res += right-left+1;
            else{
                while(sum>=k){
                    sum = sum/nums[left];
                    left++;
                }
                res += right-left+1;
            }
            right++;
        }
        return res;
    }
}



// 8. Remove Element

class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=val){
                nums[count]=nums[i]; 
                count++;  
            }
        }
        return count;
    }
}


// 9. Two sum

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


// 10. Remove Nth Node From End of List

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0, head);
        ListNode temp = res;

        for(int i=0; i<n; i++) head = head.next;

        while(head != null){
            head = head.next;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return res.next; 
    }
}