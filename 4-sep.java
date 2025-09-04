// 1. Generate Parentheses

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            res.add(new ArrayList<>());
        }
        res.get(0).add("");

        for (int k = 0; k <= n; k++) {
            for (int i = 0; i < k; i++) {
                for (String left : res.get(i)) {
                    for (String right : res.get(k - i - 1)) {
                        res.get(k).add("(" + left + ")" + right);
                    }
                }
            }
        }

        return res.get(n);
    }
}


// 2. Daily Temperatures

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for(int i=0; i<temperatures.length; i++){
            int a = temperatures[i];
            while(!stack.isEmpty() && a>stack.peek()[0]){
                int[] pair = stack.pop();
                res[pair[1]] = i - pair[1];
            } 
            stack.push(new int []{a, i});
        }
        return res;
    }
}