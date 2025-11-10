import java.util.*;

class Solution {

    int bfs(String startGene , String endGene , Set<String> setBank ) {

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        visited.add(startGene);

        int level = 0;
        char[] choices = {'A', 'C', 'G', 'T'};

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int s = 0; s < size; s++) {
                String str = queue.poll();

                if(str.equals(endGene)) return level;

                char[] ch = str.toCharArray();

                for(int i = 0 ; i < ch.length ; i++) {
                    char original = ch[i];

                    for(char c : choices) {
                        if(c == original) continue;

                        ch[i] = c;
                        String newGene = new String(ch);

                        if(setBank.contains(newGene) && !visited.contains(newGene)) {
                            visited.add(newGene);
                            queue.offer(newGene);
                        }
                    }

                    ch[i] = original; 
                }
            }

            level++;
        }

        return -1;
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> setBank = new HashSet<>();

        for(int i = 0 ; i < bank.length ; i++) {
            setBank.add(bank[i]);
        }

        return bfs(startGene, endGene, setBank);
    }
}
