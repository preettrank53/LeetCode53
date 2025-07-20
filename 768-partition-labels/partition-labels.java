class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        int[] lastAppearance = new int[26];
        int end = 0, size = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            lastAppearance[ch-'a'] = i;
        }

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            size++;
            end = Math.max(lastAppearance[ch-'a'], end);
            if(i == end){
                list.add(size);
                size = 0;
            }
        }
        return list;
    }
}