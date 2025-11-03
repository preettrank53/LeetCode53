class Solution {

    void addList(ArrayList<Integer> list , int x) {
        if(list.isEmpty() || list.get(list.size() - 1) != x) {
            list.add(x);
        }
    }

    public int[] intersection(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        ArrayList<Integer> list = new ArrayList<>();
        
        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] == arr2[j]) {
                addList(list , arr1[i]);
                i++;
                j++;
            }
            else {
                if(arr1[i] < arr2[j]) {
                    i++;
                }
                else {
                    j++;
                }
            }
        }

        int[] result = new int[list.size()];
        for(int k = 0 ; k<result.length ; k++) {
            result[k] = list.get(k);
        }

        return result;
    }
}