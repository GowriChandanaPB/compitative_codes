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
        int[] result = new int[k];
        int index = 0;
        for (int i = list.length - 1; i > 0 && index < k; i--) {
            for (int n : list[i]) {
                result[index++] = n;
                if (index == k) return result;
            }
        }

        return result;
    }
}
 