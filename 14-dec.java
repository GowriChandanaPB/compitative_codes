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



// 4. best time to buy and sell stock

class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit;
        int max_profit = 0;
        for(int i=0; i<prices.length; i++){
            if(prices[i] <= min) min = prices[i];
            profit = prices[i] - min;
            if(max_profit < profit) max_profit = profit;
        }
        return max_profit;
    }
}



// 5. Reverse Nodes in Even Length Groups

class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if(head.next == null || head.next.next == null) return head;
        ListNode node = head;
        int group = 1;
        while(node != null && node.next != null){
            group++;
            int countNode = 0;
            ListNode temp = node.next;
            while(temp != null && countNode <group){
                temp = temp.next;
                countNode++;
            }
            if(countNode % 2 == 0){
                ListNode cur = node.next, prev = null, nexttt = null;
                for(int i=0; i<countNode; i++){
                    nexttt = cur.next;
                    cur.next = prev;
                    prev = cur;
                    cur = nexttt;
                }
                ListNode tail = node.next;
                tail.next = cur;
                node.next = prev;
                node = tail;
            } else {
                for(int i = 0; i<countNode; i++) node = node.next;
            }
        }
        return head;
    }
}



// 6. group anagrams 

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String i : strs){
        char[] c = i.toCharArray();
        Arrays.sort(c);
        String s = new String(c);
        if(!map.containsKey(s)) map.put(s, new ArrayList<>());
        map.get(s).add(i);
        }
        return new ArrayList<>(map.values());
        }
}