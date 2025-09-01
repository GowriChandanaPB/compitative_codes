// 1. Contains Duplicate   

class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> dup = new HashSet<>();
        for(int i: nums){
            if(dup.contains(i)){
                return true;
            }
            dup.add(i);
        }
        return false;
    }
}
