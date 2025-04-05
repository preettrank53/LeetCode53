class Solution {

    boolean isPalindrome(String s , int start , int end) {
        while(start<end) {
            if(s.charAt(start)!=s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    void helper(List<List<String>> res , List<String> combi , int parIndex , String s ) {

        //base case
        if(parIndex==s.length()){
            res.add(new ArrayList<>(combi));
            return;
        }

        for(int i = parIndex ; i<s.length() ; i++) {
            if(isPalindrome(s , parIndex , i)) {
                combi.add(s.substring(parIndex , i+1));

                helper(res , combi , i+1 , s);

                //backtrack
                combi.remove(combi.size()-1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> combi = new ArrayList<>();

        helper(res , combi , 0 , s);
        return res;
    }
}