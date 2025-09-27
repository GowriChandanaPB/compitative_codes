// 1. KthLargest

class KthLargest {
    List<Integer> arr;
    int K;
    public KthLargest(int k, int[] nums) {
        K = k;
        arr = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            arr.add(nums[i]);
        }
    }

    public int add(int val) {
        arr.add(val);
        Collections.sort(arr);
        return arr.get(arr.size() - K);
    }
}


// 2. Last Stone Weight

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        for (int s : stones) {
            min.offer(-s);
        }

        while (min.size() > 1) {
            int first = min.poll();
            int second = min.poll();
            if (second > first) {
                min.offer(first - second);
            }
        }

        min.offer(0);
        return Math.abs(min.peek());
    }
}


// 3. K Closest Points to Origin

public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> (a[0] * a[0] + a[1] * a[1]) -
                                      (b[0] * b[0] + b[1] * b[1]));
        return Arrays.copyOfRange(points, 0, k);
    }
}