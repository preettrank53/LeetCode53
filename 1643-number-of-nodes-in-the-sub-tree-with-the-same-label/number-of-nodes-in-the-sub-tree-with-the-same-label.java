class Solution {

    int[] dfs(Map<Integer, List<Integer>> map, char[] ch, int node, int parent, int[] ans) {
        int[] freq = new int[26]; 
        freq[ch[node] - 'a']++;

        for (int child : map.getOrDefault(node, new ArrayList<>())) {
            if (child == parent) continue;

            int[] childFreq = dfs(map, ch, child, node, ans);

            for (int i = 0; i < 26; i++) {
                freq[i] += childFreq[i];
            }
        }

        ans[node] = freq[ch[node] - 'a'];
        return freq;
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        
        char[] ch = labels.toCharArray();
        int m = edges.length;

        Map<Integer , List<Integer>> map = new HashMap<>(); 

        for(int i = 0 ; i<m ; i++) {
            int u = edges[i][1];
            int v = edges[i][0];

            if(!map.containsKey(u)) {
                map.put(u , new ArrayList<>());
            }
            map.get(u).add(v);

            if(!map.containsKey(v)) {
                map.put(v , new ArrayList<>());
            }
            map.get(v).add(u);
        }

        int[] ans = new int[ch.length];
        dfs(map, ch, 0, -1, ans);
        return ans;


    }
}