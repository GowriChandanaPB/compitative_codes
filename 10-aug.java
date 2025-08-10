//6. Design Stack with Middle Operation


class Solution {
    // Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer> s) {
        // code here
        int del = (s.size() + 1) / 2-1;
        s.remove(del);
    }
}
