class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // here we use slow-fast pointe concept to solve this question !!!

        do {
            slow = nums[slow] ;  // here slow = slow +1 
            fast = nums[nums[fast]]; // here fast = fast + 2
        } while(slow != fast);

        slow = nums[0];

        while(slow != fast) {
            slow = nums[slow]; // here slow = slow + 1
            fast = nums[fast]; // here fast = fast +1 
        }

        return slow;
    }
}