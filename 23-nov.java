// 1.  Find All Anagrams in a String

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] pcount = new int[26];
        int[] scount = new int[26];
        List<Integer> result = new ArrayList<>();
        for (char c : p.toCharArray()) pcount[c - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            scount[s.charAt(i) - 'a']++;
            if (i >= p.length()) scount[s.charAt(i - p.length()) - 'a']--;
            if (Arrays.equals(pcount, scount)) result.add(i - p.length() + 1);
        }
        return result;
    }
}


// 2. Minimum Height Trees

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

    List<Set<Integer>> adj = new ArrayList<>(n);
    for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
    for (int[] edge : edges) {
        adj.get(edge[0]).add(edge[1]);
        adj.get(edge[1]).add(edge[0]);
    }

    List<Integer> leaves = new ArrayList<>();
    for (int i = 0; i < n; ++i)
        if (adj.get(i).size() == 1) leaves.add(i);

    while (n > 2) {
        n -= leaves.size();
        List<Integer> newLeaves = new ArrayList<>();
        for (int i : leaves) {
            int j = adj.get(i).iterator().next();
            adj.get(j).remove(i);
            if (adj.get(j).size() == 1) newLeaves.add(j);
        }
        leaves = newLeaves;
    }
    return leaves;
    }
}


// 3. Task Scheduler

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int [] count = new int[26];
        for(char i:tasks){
            count[i-'A']++;
        }
        Arrays.sort(count);
        int max = count[25];
        int idle = (max - 1) * n;

        for(int i=24; i>=0; i--){
            idle -= Math.min(max - 1, count[i]);
        }
        return Math.max(0, idle) + tasks.length;
    }
}


// 4. LRU Cache

class LRUCache {
    private final Map<Integer, Integer> cache;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > LRUCache.this.capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}