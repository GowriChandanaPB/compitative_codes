//Design Stack with Middle Operation

class Solution {
    // Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer> s) {
        // code here
        int del = (s.size() + 1) / 2-1;
        s.remove(del);
    }
}


//Queue Reversal

class Solution {
    public Queue<Integer> reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (queue.size() > 0) {
            stack.push(queue.poll());
        }
        while (stack.size() > 0) {
            queue.add(stack.pop());
        }

        return queue;
    }
}


//Stack Permutation

import java.util.Stack;
class Solution {
    public boolean checkPerm(int[] a, int[] b) {
        // code here
        int k = 0;
        Stack<Integer> stk = new Stack<>();
        for(int i=0; i<a.length; i++){
            stk.push(a[i]);
            while(!stk.isEmpty() && stk.peek()==b[k]){
                stk.pop();
                k++;
            }
        }
        return k==b.length;
    }
}


//Longest Valid String

class Solution {
    static int findMaxLen(String S) {
        int n=0;
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        for(int i=0;i<S.length();i++){
            char ch=S.charAt(i);
            if(ch=='('){
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                } else {
                    n=Math.max(n,i-stack.peek());
                }
            }
        }
        return n;
    }
}


//The Celebrity Problem

class Solution {
    public int celebrity(int mat[][]) {
        // code here
        int knowme[] = new int[mat.length];
        int iknow[] = new int[mat.length];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == 1){
                    iknow[i]++;
                    knowme[j]++;
                }
            }
        }
        for(int i=0;i<mat.length;i++){
            if(knowme[i] == mat.length && iknow[i] == 1) return i;
        }
        
        return -1;
    }
}


//Next larger Element

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


//Circular-tour

class Solution {
    public int startStation(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = Arrays.stream(gas).sum();
        int totalCost = Arrays.stream(cost).sum();
        
        if (totalGas < totalCost) return -1; 
        int start = 0;
        int balance = 0;
        int deficit = 0;
        
        for (int i = 0; i < n; i++) {
            balance += gas[i] - cost[i];
            if (balance < 0) {
                start = i + 1; 
                deficit += balance; 
                balance = 0;
            }
        }
        
        return (balance + deficit >= 0) ? start : -1; 
    }
}
