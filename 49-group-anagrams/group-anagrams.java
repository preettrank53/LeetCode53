class Solution {

    String help1(String s) { // firsst we sort all strings of strs list
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }


    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> ans = new ArrayList<>();
        Map<String , List<String>> map = new HashMap<>();
        
        for(int i = 0 ; i < strs.length ; i++) {  // call help1
            String newStr = help1(strs[i]);

            if(!map.containsKey(newStr)) {
                map.put(newStr , new ArrayList<>());
            }
            map.get(newStr).add(strs[i]);
        }

        List<String> keys = new ArrayList<>(map.keySet());

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            ans.add(map.get(key));
        }


        return ans;

        
    }
}