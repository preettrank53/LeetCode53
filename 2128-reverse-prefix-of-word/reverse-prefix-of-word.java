class Solution {
    public String reversePrefix(String word, char ch) {
        char[] arr = word.toCharArray();
        int j = -1;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                j = i;
                break;
            }
        }

        
        if (j == -1) return word;

        int i = 0;
        while (i <= j) {
           
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }

        return new String(arr);
    }
}
