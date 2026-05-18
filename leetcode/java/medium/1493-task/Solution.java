class Solution {
    public int longestSubarray(int[] nums) {
        int len = 0;
        int maxLen = 0;
        boolean wasZero = false;
        int lastZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                len += 1;
                maxLen = Math.max(len, maxLen);
            } else if (nums[i] == 0) {
                if (wasZero) {
                    len = i - lastZero - 1;
                    lastZero = i;
                } else {
                    lastZero = i;
                    wasZero = true;
                }
            }
        }
        if (!wasZero) {
            maxLen -= 1;
        }
        return maxLen;
    }
}