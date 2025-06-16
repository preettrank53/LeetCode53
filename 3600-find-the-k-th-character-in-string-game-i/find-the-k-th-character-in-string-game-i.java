class Solution {
    public char kthCharacter(int k) {
        String s = "a";

        while(s.length() < k) {
            StringBuilder builder = new StringBuilder();
            for(char ch : s.toCharArray()) {
                if(ch=='z') {
                    builder.append('a');
                }
                else {
                    builder.append((char)(ch+1));
                }
            }
            s = s + builder.toString();
        }
        return s.charAt(k-1);
    }
}