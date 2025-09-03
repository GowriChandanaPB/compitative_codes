// 1. valid Parentheses

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            } else {
                if (stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}


// 2 min Stack. 

class MinStack {

    private Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        Stack<Integer> tmp = new Stack<>();
        int min = stack.peek();

        while (!stack.isEmpty()) {
            min = Math.min(min, stack.peek());
            tmp.push(stack.pop());
        }

        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }

        return min;
    }
}