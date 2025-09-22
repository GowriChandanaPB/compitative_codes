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



// 3.Implement Stack using Queues


class MyStack {

    private Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}


// 4.Queue Reversal

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


// 5. Reverse first k elements of queue

class Solution {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        // code here
        if(q.size() < k) return q;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<k; i++){
            stack.push(q.remove());
        }
        
        while(!stack.isEmpty()){
            q.add(stack.pop());
        }
        
        int size = q.size();
        for(int i=0; i<q.size()-k; i++){
            q.add(q.remove());
        }
        return q;
    }
}