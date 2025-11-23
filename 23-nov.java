// 1.  Find All Anagrams in a String

class Solution {
    public List<Integer> findAnagrams(String s, String t) {
        List<Integer> res = new LinkedList<>();
        if(t.length()> s.length()) return res;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();
        int begin = 0, end = 0;
        int len = Integer.MAX_VALUE; 
        while(end < s.length()){        
            char c = s.charAt(end);
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) counter--;
            }
            end++;
            while(counter == 0 ){
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0) counter++;
                }
                begin++;
            }
        }
        return res;
    }
}