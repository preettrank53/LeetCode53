class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int length = Math.max(v1.length, v2.length);

        for (int i = 0; i < length; i++) {
            int num1 = 0;
            int num2 = 0;

            if (i < v1.length) {
                num1 = Integer.parseInt(v1[i]);
            }

            if (i < v2.length) {
                num2 = Integer.parseInt(v2[i]);
            }

            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
        }

        return 0;
    }
}
