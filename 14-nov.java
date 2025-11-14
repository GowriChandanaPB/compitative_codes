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


// 5. Accounts Merge

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> owners = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>(); 
        for (List<String> account: accounts) {
            for (int i = 1; i<account.size(); i++) {
                String owner = account.get(0);
                String email = account.get(i);
                parents.put(email, email);
                owners.put(email, owner);
            }
        }
        for (List<String> account: accounts) {
            String p1 = find(parents, account.get(1));
            for (int i = 2; i<account.size(); i++) {
                String p2 = find(parents, account.get(i));
                parents.put(p2, p1);
            }
        }
        
        for (List<String> account: accounts) {
            String p1 = find(parents, account.get(1));
            if (!unions.containsKey(p1)) {
                unions.put(p1, new TreeSet<>());
            }
            Set<String> emailSets = unions.get(p1);
            for (int i = 1; i<account.size(); i++) {
                emailSets.add(account.get(i));
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        for (String p : unions.keySet()) {
            List<String> emails = new ArrayList(unions.get(p));
            emails.add(0, owners.get(p));
            res.add(emails);
        }
        return res;
    }
    public String find(Map<String, String> parents, String node) {
        while (!parents.get(node).equals(node)) {
            parents.put(node, parents.get(parents.get(node))); 
            node = parents.get(node);
        }
        return node;
    }
}


// 6. Sort Colors

class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else { 
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
