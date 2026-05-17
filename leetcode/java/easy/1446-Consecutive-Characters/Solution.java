class Solution {
    public int maxPower(String s) {
        char cur = s.charAt(0);
        int ans = 1;
        int len = 1;
        for(int i = 1; i<s.length(); i++){
            if (cur != s.charAt(i)){
                cur = s.charAt(i);
                ans = Math.max(ans, len);
                len = 0;
            }
            len += 1;
            ans = Math.max(ans, len);
        } 
        return ans;
    }
}