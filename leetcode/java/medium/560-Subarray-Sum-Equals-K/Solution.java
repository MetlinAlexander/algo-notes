class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sums = new HashMap<>();
        int curSum = 0;
        int ans = 0;
        sums.put(0, 1); // this is necessary for a situation where curSum == k
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (sums.containsKey(curSum - k)) {
                ans += sums.get(curSum - k);
            }
            sums.put(curSum, sums.getOrDefault(curSum, 0) + 1);
        }
        return ans;
    }
}