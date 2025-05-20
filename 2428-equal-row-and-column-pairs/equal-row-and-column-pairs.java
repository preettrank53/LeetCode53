class Solution {
    public int equalPairs(int[][] grid) {
        List<List<Integer>> row = new ArrayList<>();
        List<List<Integer>> column = new ArrayList<>();

        for(int i = 0 ; i < grid.length ; i++) {
            List<Integer> innerList1 = new ArrayList<>();
            for(int j = 0 ; j < grid.length ; j++ ) {
                innerList1.add(grid[i][j]);
            }

            row.add(innerList1);
        }

        for(int i = 0 ; i < grid.length ; i++) {
            List<Integer> innerList2 = new ArrayList<>();
            for(int j = 0 ; j < grid.length ; j++ ) {
                innerList2.add(grid[j][i]);
            }

            column.add(innerList2);
        }

        int count = 0 ;

        for(int i = 0 ; i<row.size() ; i++) {
            for(int j = 0 ; j<column.size() ; j++) {
                if(row.get(i).equals(column.get(j))) {
                    count++;
                }
            }
        }
        return count;

    }
}