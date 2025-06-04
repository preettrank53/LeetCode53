class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(capacity[i] - rocks[i]); // space left in each bag
        }

        Collections.sort(list); // sort ascending

        int count = 0;

        for (int i = 0; i < list.size(); i++) { // FIX: loop from start to end
            int gap = list.get(i);
            if (gap == 0) {
                count++;
            } else if (additionalRocks >= gap) {
                additionalRocks -= gap;
                count++;
            } else {
                break; // can't fill this or any next bag
            }
        }

        return count;
    }
}
