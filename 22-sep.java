// 1. Implement two stacks in an Array

class twoStacks {
    int arr[];
    int s1, s2;
    twoStacks() {
       arr = new int[100];
       s1 = -1;
       s2 = 100;
    }

    // Function to push an integer into the stack1.
    void push1(int x) {
        // code here
        if(s1+1 == s2) return;
        s1++;
        arr[s1] = x;
    }

    // Function to push an integer into the stack2.
    void push2(int x) {
        
        // code here
        if(s1 == s2-1) return;
        s2--;
        arr[s2] = x;
    }

    // Function to remove an element from top of the stack1.
        
    int pop1() {
        // code here
        if(s1 == -1) return -1;
        return arr[s1--];
    }

        
    // Function to remove an element from top of the stack2.
    int pop2() {
        // code here
        if(s2 == 100) return -1;
        return arr[s2++];
    }
}


// 2.Evaluation of Postfix Expression

class Solution {
    public int evaluate(String[] arr) {
        // code here
        Stack<Integer> res = new Stack<Integer>();
        for(int i=0; i<arr.length; i++){
            switch (arr[i]){
                case "+":
                    if(res.size()>=2){
                        int last = res.pop();
                        int first = res.pop();
                        res.push(first + last);
                    }
                    break;
                    case "-":
                        if(res.size()>=2){
                            int last = res.pop();
                            int first = res.pop();
                            res.push(first - last);
                        }
                    break;
                    case "*":
                        if(res.size()>=2){
                            int last= res.pop();
                            int first = res.pop();
                            res.push(first * last);
                    }
                    break;
                    case "/":
                        if(res.size()>=2){
                            int last= res.pop();
                            int first = res.pop();
                            res.push(first / last);
                    }
                    break;
                default:
                    int temp = Integer.parseInt(arr[i]);
                    res.push(temp);
            }
            
        }
        return res.pop();
    }
                        
            } 