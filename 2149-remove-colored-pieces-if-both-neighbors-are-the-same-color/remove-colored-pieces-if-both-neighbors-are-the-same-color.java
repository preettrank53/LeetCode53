class Solution {
    public boolean winnerOfGame(String colors) {
        
        char[] ch = colors.toCharArray();
        int n = ch.length;

        int alice = 0;
        int bob = 0; 

        for (int i = 1; i < n - 1; i++) {
            if (ch[i] == ch[i - 1] && ch[i] == ch[i + 1]) {
                if (ch[i] == 'A') {
                    alice++;
                } else {
                    bob++;
                }
            }
        }

        // Alice wins only if she has strictly more moves than Bob
        return alice > bob;  // Because Alice starts first, she needs more moves to make the last move and win

        // Note:
        // If alice == bob, then after all turns are taken, Bob will make the last move (since they alternate starting from Alice),
        // and Alice will have no move left, so she loses.
    }
}
