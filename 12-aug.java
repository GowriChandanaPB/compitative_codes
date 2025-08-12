//Activity selection problem greedy algo


class Solution {
    public int activitySelection(int[] start, int[] finish) {
        // code here
        int n = start.length;
        int arr[][] = new int[n][2];
        for(int i  =0; i < n; i++){
            arr[i][0]=start[i];
            arr[i][1]=finish[i];
        }
        Arrays.sort(arr,(a,b) -> a[1] - b[1]);
        int count = 1;
        int j = 0;
        for(int i=1; i<n; i++){
            if(arr[i][0] > arr[j][1]){
                count++;
                j=i;
            }
        }
        return count;
    }
}


//Greedy algorithm to find minimum number of coins

class Solution {
    static List<Integer> minPartition(int N) {
        // code here
        int[] notes = new int[]{1,2,5,10,20,50,100,200,500,2000};
        List<Integer> res = new ArrayList<>();
        int k = notes.length - 1;
        while(N > 0){
            while(N < notes[k]){
                k--;
            }
            while(N >= notes[k] && N > 0){
                N -= notes[k];
                res.add(notes[k]);
            }
        }
        return res;
    }
}


//Minimum sum two numbers formed digits array-2

class Solution {

    public static long minSum(int arr[], int n) {
        // Your code goes here
        Arrays.sort(arr);
        long d1 = 0;
        long d2 = 0;
        for(int i=0; i<arr.length; i=i+2){
            if(i==arr.length-1){
                d1 = 10 * d1 + arr[i];
            } else {
                d1 = 10 * d1 + arr[i];
                d2 = 10 * d2 + arr[i+1];
            }
        }
        long sum = d1 + d2;
        return sum;
    }
}


//Minimum sum absolute difference pairs two arrays

class Solution {
    long findMinSum(int[] A, int[] B, int N) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        long diff = 0;
        for(int i=0; i<N; i++){
            diff += Math.abs(A[i]-B[i]);
        }
        return diff;
    }
}


//Find maximum equal sum of every three stacks

class Solution {
    public static int maxEqualSum(int N1,int N2,int N3, int[] S1, int[] S2, int[] S3) {
        // code here
    int sum1 = Arrays.stream(S1).sum();
        int sum2 = Arrays.stream(S2).sum();
        int sum3 = Arrays.stream(S3).sum();
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < S1.length && j < S2.length && k < S3.length) {
            if (sum1 == sum2 && sum2 == sum3) {
                return sum1;
            }
            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= S1[i++];
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= S2[j++];
            } else if (sum3 >= sum1 && sum3 >= sum2) {
                sum3 -= S3[k++];
            }
        }
        return 0;
    }
}