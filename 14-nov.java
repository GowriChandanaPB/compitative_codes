// 1. Longest Increasing Subsequence

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int p[] = new int[nums.length];
        Arrays.fill(p, 1);

        for(int i=1; i<nums.length; ++i){
            for(int j=0; j<i; ++j ){
                if(nums[i]>nums[j]) p[i] = Math.max(p[i], p[j] + 1);
            }
        }
        int max = Arrays.stream(p).max().orElse(0);
        return max;
    }
}


// 2. Largest Divisible Subset

class Solution {
public List<Integer> largestDivisibleSubset(int[] nums) {
    int[] l = new int[nums.length]; 
    int[] prev = new int[nums.length];
    Arrays.sort(nums);
    int max = 0;
    int index = -1;
    for (int i = 0; i < nums.length; i++){
        l[i] = 1;
        prev[i] = -1;
        for (int j = i - 1; j >= 0; j--){
            if (nums[i] % nums[j] == 0 && l[j] + 1 > l[i]){
                l[i] = l[j] + 1;
                prev[i] = j;
            }
        }
        if (l[i] > max){
            max = l[i];
            index = i;
        }
    }
    List<Integer> res = new ArrayList<Integer>();
    while (index != -1){
        res.add(nums[index]);
        index = prev[index];
    }
    return res;
}

}


// 3. Russian Doll Envelopes

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] p = new int[envelopes.length];
        int ans = 0;
        for (int[] env : envelopes) {
            int height = env[1];
            int left = Arrays.binarySearch(p, 0, ans, height);
            if (left < 0) left = -left - 1;
            if (left == ans) ans++;
            p[left] = height;
        }
        return ans;
    }
}


// 4. Time Based Key-Value Store

class TimeMap {

    public Map<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) map.put(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.get(key);
        if(treeMap == null) return "";
        Integer floor = treeMap.floorKey(timestamp);
        if(floor == null) return "" ;
        return treeMap.get(floor);
    }
}