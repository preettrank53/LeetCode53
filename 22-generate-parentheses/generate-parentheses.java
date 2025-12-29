class Solution {

    boolean isValid(String str) {
    int balance = 0;

    for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);

        if (ch == '(') {
            balance++;
        } else {
            balance--;
        }

        if (balance < 0) {
            return false; 
        }
    }

        return balance == 0; 
    }

    void helper(int n , String str , List<String> list) {
        if(str.length() == n) {
            if(isValid(str)) {
                list.add(str);
            }
            return;
        }

        helper(n , str + '(' , list);
        helper(n , str + ')' , list);
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();

        String str = "";
        helper(2*n , str , list);

        return list;
    }
}