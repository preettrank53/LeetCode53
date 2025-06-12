class Solution {
    public String removeDigit(String number, char digit) {
        int n = number.length();
        int removeIndex = -1;

        
        for (int i = 0; i < n - 1; i++) {
            if (number.charAt(i) == digit && number.charAt(i + 1) > digit) {
                return number.substring(0, i) + number.substring(i + 1);
            }
        }

        
        for (int i = n - 1; i >= 0; i--) {
            if (number.charAt(i) == digit) {
                return number.substring(0, i) + number.substring(i + 1);
            }
        }

        return number; 
    }
}
