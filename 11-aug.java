//Find the maximum of minimums for every window size in a given array

class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        // Your code here
        int n = arr.length ; 
        int rightMin[] = new int[n] ; 
        int leftMin[] = new int[n] ; 
        Stack<Integer>st = new Stack<>() ; 
        for(int  i =0 ; i<n ; i++){
             while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                  rightMin[st.peek()] = i ; 
                  st.pop() ; 
             }
             st.push(i) ; 
        }
        while(!st.isEmpty()){
             rightMin[st.peek()] = n ; 
             st.pop() ; 
        }
        for(int i = n-1; i>=0 ; i--){
             while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                 leftMin[st.peek()] = i ; 
                 st.pop() ; 
             }
             st.push(i) ; 
        }
        while(!st.isEmpty()){
             leftMin[st.peek()] = -1 ; 
             st.pop() ; 
        }
        
        int result[] = new int[n] ; 
        for(int  i =0 ; i<n ; i++){
             int a = (rightMin[i] - leftMin[i] )- 1 ;
             result[a-1] = Math.max(result[a-1] ,arr[i]) ; 
        }
        
        for(int i=n-2 ; i>=0 ; i--){
             result[i] = Math.max(result[i] , result[i+1]) ; 
        }
        
        ArrayList<Integer>res = new ArrayList<>() ;
        
        for(int val : result){
            res.add(val) ; 
        }
        
        return res ; 
    }
        

}
