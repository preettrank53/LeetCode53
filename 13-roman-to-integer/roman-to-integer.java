class Solution {
    public int romanToInt(String s) {
        int n = s.length();
        int count = 0;
        Map<Character , Integer> map = new HashMap<>();

        map.put('I' , 1);
        map.put('V' , 5);
        map.put('X' , 10);
        map.put('L' , 50);
        map.put('C' , 100);
        map.put('D' , 500);
        map.put('M' , 1000);

        int i = 0;

        while (i < n) {
            if (i + 1 < n && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                count = count + map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
                i = i + 2;
            } else {
                count = count + map.get(s.charAt(i));
                i++;
            }
        }

        return count;
    }
}
