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

class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int [] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String [] sym = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for(int i=0; i<val.length && num>0; i++){
            while(num >= val[i]){
                num -= val[i];
                sb.append(sym[i]);
            }
        }
        return sb.toString();
    }
}
