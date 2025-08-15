//1. Fractional knapsack problem

class Solution {
    double fractionalKnapsack(int[] values, int[] weights, int W) {
        int n = values.length;
        double items[][] = new double[n][2];
        for(int i = 0; i<n; i++){
            items[i][0] = (double)values[i]/weights[i];  
            items[i][1] = i; 
        }
        Arrays.sort(items, (a, b) -> Double.compare(a[0], b[0])); 
        double maxValue = 0;
        for(int i=n-1; i>=0; i--){
            int idx = (int)items[i][1];
            if(W - weights[idx] >= 0){  
                maxValue += values[idx];
                W -= weights[idx]; 
            }else{
                maxValue += W*((double) values[idx] / weights[idx]); 
                break;  
            }
        }
        return maxValue;
    }
}


//2. Find smallest number with given number of digits and digit sum

class Solution {
    public String smallestNumber(int s, int d) {
        // code here
        if(s < 1 || s > d*9){
            return "-1";
        }
        String str = "";
        int p = s;
        int q = 1;
        while(q <= 9){
            if(p-q <= (d-1)*9){
                str += q;
                d--;
                p = p-q;
                q = -1;
            }
            if(d==0) break;
            q++;
        }
        return str;
    }
}



// 3. Maximize sum of consecutive differences circular-array

class Solution {
    public long maxSum(Long[] arr) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);
        int i = 0;
        int j = n-1;
        long sum = 0;
        int k = 0;
        
        while(i < j){
            sum += Math.abs(arr[i] - arr[j]);
            if(k == 0){
                i++;
            } else {
                j--;
            }
            k = 1 - k;
        }
        sum += Math.abs(arr[0] - arr[i]);
        return sum;
    }
}