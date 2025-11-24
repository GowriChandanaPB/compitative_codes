// 1. Minimum Window Substring

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) return new String();
        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, stridx = 0;
        for (char c : t.toCharArray()) map[c]++;

        char[] chS = s.toCharArray();

        while (end < chS.length) {
            if (map[chS[end++]]-- > 0) count--;
            while (count == 0) {
                if (end - start < minLen) {
                    stridx = start;
                    minLen = end - start;
                }
                if (map[chS[start++]]++ == 0) count++;
            }
        }
        return minLen == Integer.MAX_VALUE ? new String() :
                new String(chS, stridx, minLen);
    }
}


// 2. Trapping Rain Water

class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int water = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
            }
        }

        return water;        
    }
}


// 3. Merge k Sorted Lists

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> node = new ArrayList<>();
        for (ListNode lst : lists) {
            while (lst != null) {
                node.add(lst.val);
                lst = lst.next;
            }
        }
        Collections.sort(node);

        ListNode res = new ListNode(0);
        ListNode temp = res;
        for (int i : node) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        return res.next;
    }
}