//6. Design Stack with Middle Operation


class Solution {
    // Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer> s) {
        // code here
        int del = (s.size() + 1) / 2-1;
        s.remove(del);
    }
}

//4.Queue Reversal

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
