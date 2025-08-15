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