class Solution { 

    boolean bfs(Map<Integer , List<Integer>> map , int[] inNode , Queue<Integer> queue , int V) {
        int count = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            count++;

            for (int nbr : map.getOrDefault(node, new ArrayList<>())) {
                inNode[nbr]--;
                if (inNode[nbr] == 0) {
                    queue.offer(nbr);
                }
            }
        }

        return count == V;
    }

    public boolean canFinish(int numCourses, int[][] arr) {
        int n = arr.length;

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
        for(int i = 0 ; i<numCourses ; i++) {
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

        return bfs(map , inNode , queue ,numCourses );

    }
}