class Solution {

    List<Integer> result = new ArrayList<>();
    int count = 0;

    void bfs(Map<Integer , List<Integer>> map , int[] inNode , Queue<Integer> queue , int V) {
        while(!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            count++;
            
            for(int nbr : map.getOrDefault(node , new ArrayList<>())) {
                inNode[nbr]--;
                if(inNode[nbr] == 0) {
                    queue.offer(nbr);
                }
            }
        }
    }


    public int[] findOrder(int numCourses, int[][] arr) {
        int n = arr.length;
         if (n == 0) {
            int[] result = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                result[i] = numCourses - 1 - i; 
            }
            return result;
        }

        Map<Integer , List<Integer>> map = new HashMap<>();

        for(int i = 0 ; i<n ; i++) {
            int u = arr[i][1];
            int v = arr[i][0];

            if(!map.containsKey(u)) {
                map.put(u , new ArrayList<>());
            }
            map.get(u).add(v);
        }

        int[] inNode = new int[numCourses];

        for(int i = 0 ; i<inNode.length ; i++) {
            for(int nbr : map.getOrDefault(i , new ArrayList<>())) {
                inNode[nbr]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0 ; i<inNode.length ; i++) {
            if(inNode[i] == 0) {
                queue.offer(i);
            }
        }

        bfs(map , inNode , queue , numCourses);

        if(count < numCourses) {
            return new int[]{};
        }
        int[] ans = new int[numCourses];
        for(int i = 0 ; i<result.size() ; i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}