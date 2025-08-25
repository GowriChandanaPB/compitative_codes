//1.Maximum and Minimum Element in an Array(easy)

class Solution {
    public Pair<Integer, Integer> getMinMax(int[] arr) {
        // Code Here
        int max = arr[0];
        int min = arr[0];
        for(int i : arr){
            if(i < min){
                min = i;
            } 
            if(i > max){
                max = i;
            }
        }
        return new Pair<>(min, max);
        
    }
}