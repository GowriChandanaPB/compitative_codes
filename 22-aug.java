// 1. Find k closest elements to a given value

class Solution {
    int[] printKClosest(int[] arr, int k, int x) {
     PriorityQueue<int[]> pq = new PriorityQueue<>(
    (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]
);

      int n=arr.length;
      for(int i=0;i<n;i++){
          if(arr[i]!=x){
              pq.add(new int[]{Math.abs(arr[i]-x),arr[i]});
          }
      }
      
      int[] res=new int[k];
      int index=0;
      while(!pq.isEmpty() && k>0){
          int[] curr=pq.poll();
          res[index]=curr[1];
          index++;
          k--;
      }
    
      return res;
    }
}


// 2. K’th largest element in a stream

class Solution {
    static int[] kthLargest(int k, int[] arr, int n) {
        // code here
        Queue<Integer> pq=new PriorityQueue<>();

        for(int i=0;i<n;i++){
            pq.add(arr[i]);
            while(pq.size()>k) pq.poll();
            arr[i]=pq.size()>=k?pq.peek():-1;
        }
        return arr;
    }
};


// 3. Connect Ropes

class Solution {
    public static int minCost(int[] arr) {
        int minCost = 0;
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        for(int i = 0; i<n;i++){
            pq.add(arr[i]);
        }
        while(pq.size()>1){
            int first = pq.poll();  
            int second = pq.poll();  
            int sum = first+second;
            minCost += sum; 
            pq.add(sum);  
        }
        return minCost;
    }
}


// 4. Merge K Sorted lists

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> allValue = new ArrayList<>();

        for(ListNode list : lists) {
            while(list != null) {
              allValue.add(list.val);
              list = list.next;
            }
        }       

        Collections.sort(allValue);

       ListNode sort = new ListNode(1);
       ListNode dummy = sort;

       for(int i=0;i<allValue.size();i++) {
        dummy.next = new ListNode(allValue.get(i));
        dummy = dummy.next;
       }
       sort = sort.next;
            
        return sort;
    }
}


// 5. Find Median from Data Stream

class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (max.size() == 0 || num <= max.peek()) {
            max.add(num);
        } else {
            min.add(num);
        }

        if (max.size() < min.size()) {
            max.add(min.poll());
        } else if (max.size() > min.size() + 1) {
            min.add(max.poll());
        }
    }

    public double findMedian() {
        if (max.size() == min.size()) {
            return (min.peek() + max.peek()) / 2.0;
        } else {
            return max.peek();
        }
    }
}


// 6. Sliding Window Maximum

class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayDeque<Integer> Deque = new ArrayDeque<>();
        for(int i = 0;i<arr.length;i++){
            if(!Deque.isEmpty() && Deque.getFirst()<=i-k){
                Deque.removeFirst();
            }
            while(!Deque.isEmpty() && arr[Deque.getLast()]<arr[i]){
                Deque.removeLast();
            }
            Deque.addLast(i);
            if(i>=k-1){
                list.add(arr[Deque.getFirst()]);
            }
        }
        return list;
    }
}


// 7. Find the smallest positive number

class Solution {
    public int missingNumber(int[] arr) {
        Map<Integer,Integer> hp=new TreeMap<>();
        int int_max=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                hp.put(arr[i],hp.getOrDefault(arr[i],0)+1);
            } 
        }
        if(hp.size()==0) return 1;
        for(int i=1;i<int_max;i++){
            if(!hp.containsKey(i)){
                return i;
            }
        }
        
        return 1;
    }
}