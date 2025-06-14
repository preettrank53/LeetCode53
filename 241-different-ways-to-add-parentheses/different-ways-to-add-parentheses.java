class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();

        int n = expression.length();
        for(int i = 0 ; i < n ; i++) {
            char c = expression.charAt(i);

            if(c=='+' || c=='-' || c=='*') {
                List<Integer> leftResults = diffWaysToCompute(expression.substring(0,i));
                List<Integer> rightResults = diffWaysToCompute(expression.substring(i+1));

                for(int x : leftResults) {
                    for(int y : rightResults) {
                        if(c=='+') {
                            result.add(x+y);
                        }
                        else if (c=='-') {
                            result.add(x-y);
                        }
                        else {
                            result.add(x*y);
                        }
                    }
                }
            }
        }

        //if no operator found , it means the string is number
        if(result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        return result;
    }
}