//1. Heap Sort

class Solution {
    // Function to sort an array using Heap Sort.
    public void heapSort(int arr[]) {
        // code here
        int n = arr.length;
        for(int i=n/2-1; i>=0; i--) {
            heapify(arr,n,i);
        }
        for(int i=n-1; i>0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr,i,0);
        }
    }
    public void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if(left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if(right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if(largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapify(arr, n, largest);
        }
    }
}


// 2. Top K Frequent Elements

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] list = new List[nums.length + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int index = 0;
        for (int i = list.length - 1; i > 0 && index < k; i--) {
            for (int n : list[i]) {
                res[index++] = n;
                if (index == k) return res;
            }
        }
        return res;
    }
}


// 3. k largest elements in an array

import java.util.*;
class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        // Your code here
        for(int i = 0;i<arr.length;i++){
            int v = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]<v){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = v;
        }
        ArrayList<Integer> res = new ArrayList<>();
        if(k>=1 && k<=arr.length){
            for(int i=0;i<k;i++){
            res.add(arr[i]);
            }
            return res;
        }
        return res;
    }
}
 

// 4. Next Greater Element

class Solution {
    
    public ArrayList<Integer> nextLargerElement(int[] a) {
        // code here
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        int[] ans = new int[a.length];

        for (int i = a.length; i > 0; i--) {
            int temp = a[i - 1];
            while (!st.isEmpty() && st.peek() <= temp) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i - 1] = -1;
            } else {
                ans[i - 1] = st.peek();
            }
            st.push(temp);
        }
        for (int val : ans) {
            res.add(val);
        }
        return res;
        
    }
}


// 5. K’th Smallest/Largest Element in Unsorted Array

class Solution {
    public static int kthSmallest(int[] arr, int k) {
        int max = 0;
         for(int i=0; i<arr.length; i++){
             if(arr[i]>max){
                 max=arr[i];
             }
         }
         int[] ar = new int[max+1];
         for(int i = 0; i<arr.length;i++){
             ar[arr[i]]=arr[i];
         }
         int count = 0;
         int res = 0;
         for(int i = 0;i<ar.length;i++){
             if(count==k){
                 break;
             }
             if(ar[i]!=0){
                 count++;
                 res = ar[i];
             }
         }
         return res;
    }
}


// 6. Find the maximum repeating number in O(n) time and O(1) extra space

class Solution {
     int maxRepeating(int k, int[] arr) {
       int[]a = new int[k];
        for(Integer n: arr){
            a[n]++;
        }
        int max = 0, min = k-1;
        for(int i=0; i<k; i++){
            if(a[i]>max){
               
                min = i;
                max = a[i];
                
            }else if(a[i]!=0&&max==a[i]){
                if(min>i){
                    min = i;
                }
            }
        }
        return min;
    }
}