class Solution {
    public int compress(char[] chars) {
        int count = 1 ; 
        List<String> list = new ArrayList<>();

        for(int i = 1 ; i<chars.length ; i++) {
            if(chars[i] == chars[i-1]) {
                count++;
            }

            else {
                list.add(String.valueOf(chars[i-1]));
                if(count > 1) {
                    list.add(String.valueOf(count));
                }
                count = 1;
            }
        }

        list.add(String.valueOf(chars[chars.length - 1]));
        if (count > 1) {
            list.add(String.valueOf(count));
        }

        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            for (int j = 0; j < str.length(); j++) {
                chars[index] = str.charAt(j);
                index++;
            }
        }

        return index; // this is the length of the compressed string
    }
}