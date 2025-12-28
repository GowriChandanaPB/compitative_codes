// 1. Exclusive Time of Functions

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> stk = new Stack<>();
        int prev = 0;
        for(String log : logs){
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String type = parts[1];
            int time = Integer.parseInt(parts[2]);
            if(type.equals("start")){
                if(!stk.isEmpty()) result[stk.peek()] += time - prev;
                stk.push(id);
                prev = time;
            } else {
                result[stk.pop()] += time - prev + 1;
                prev = time + 1;
            }
        }
        return result;
    }
}


// 2. Integer to Roman

