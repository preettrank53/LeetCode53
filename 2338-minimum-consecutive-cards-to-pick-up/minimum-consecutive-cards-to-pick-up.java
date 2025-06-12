class Solution {
    public int minimumCardPickup(int[] cards) {
        int n = cards.length;

        int i = 0 ; 
        int j = 0 ;
        int ans = Integer.MAX_VALUE;

        Map<Integer , Integer> map = new HashMap<>();

        while(j < n) {
            if(map.containsKey(cards[j])) {
                map.put(cards[j] , map.get(cards[j])+1);
            }
            else {
                map.put(cards[j] , 1);
            }


           while (map.get(cards[j]) > 1) {
                ans = Math.min(ans, j - i + 1);
                map.put(cards[i], map.get(cards[i]) - 1);
                i++;
            }

            j++;

            
        }

        if(ans==Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }
}