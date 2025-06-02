class Solution {
    public int brokenCalc(int startValue, int target) {
        int mulOp = 0;
        int minOp = 0;

        while (target > startValue) {
            if (target % 2 == 0) {
                target /= 2;
                mulOp++; // Simulates reverse of multiply
            } else {
                target += 1;
                minOp++; // Simulates reverse of subtract
            }
        }

        // Now target <= startValue; we need to subtract the rest
        minOp += (startValue - target);

        return mulOp + minOp;
    }
}
