class Solution {

    static class Pair {
        String word;
        int steps;
        Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }

    int bfs(Set<String> set, String start, String endWord) {

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(start, 1));
        set.remove(start);

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            String word = curr.word;
            int steps = curr.steps;

            if (word.equals(endWord)) {
                return steps; 
            }

            char[] ch = word.toCharArray();

            for (int i = 0; i < ch.length; i++) {
                char original = ch[i];

                for (char c = 'a'; c <= 'z'; c++) {
                    ch[i] = c;
                    String next = new String(ch);

                    if (set.contains(next)) {
                        queue.offer(new Pair(next, steps + 1));
                        set.remove(next);
                    }
                }
                ch[i] = original; 
            }
        }
        return 0;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return 0;
        }

        return bfs(set, beginWord, endWord);
    }
}
