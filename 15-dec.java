// 1. 3sum

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


// 2. Container With Most Water

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



// 3. Remove K Digits 


class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length()) return "0";
        Stack<Character> stk = new Stack<>();
        int i = 0;
        while(i < num.length()){
            while(k > 0 && !stk.isEmpty() && stk.peek() > num.charAt(i)){
                stk.pop();
                k--;
            }
            stk.push(num.charAt(i));
            i++;
        } 
        while(k > 0){
            stk.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()) sb.append(stk.pop());
        sb.reverse();
        while(sb.length() > 1 && sb.charAt(0)=='0') sb.deleteCharAt(0);
        return sb.toString();

    }
}



// 4. Bulls and Cows


class Solution {
    public String getHint(String secret, String guess) {
    int bull = 0;
    int cow = 0;
    int[] num = new int[10];
    for (int i = 0; i<secret.length(); i++) {
        int s = Character.getNumericValue(secret.charAt(i));
        int g = Character.getNumericValue(guess.charAt(i));
        if (s == g) bull++;
        else {
            if (num[s] < 0) cow++;
            if (num[g] > 0) cow++;
            num[s] ++;
            num[g] --;
        }
    }
    return bull + "A" + cow + "B";
}
}



// 5. Add Two Numbers

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode();
        ListNode cur = temp;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;

            int val = v1 + v2 + carry;
            carry = val / 10;
            val = val % 10;
            cur.next = new ListNode(val);

            cur = cur.next;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        return temp.next;
    }
}
