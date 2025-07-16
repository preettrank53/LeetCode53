class Solution {
    public String intToRoman(int num) {
       int[] arr = new int[]{1000 , 900 , 500 , 400 , 100 , 90 , 50 , 40 , 10 , 9, 5, 4, 1} ;
       String[] str = new String[]{"M" , "CM" ,"D" , "CD" , "C" , "XC" , "L" , "XL" , "X" ,"IX" ,"V" ,"IV" , "I"};

       String result = "";

       for(int i = 0 ; i<13 ; i++) {
            if(num == 0) {
                break;
            }

            int times = num/arr[i];

            for(int j = 0 ; j<times ; j++) {
                result = result + str[i];
            }

            num = num % arr[i];
       }

       return result;
    }
}