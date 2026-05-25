class Solution {
    public boolean isPalindrome(String s) {
        int p1 = 0;
        int p2 = s.length() - 1;
        while(p1 < p2){
            while(p1 < p2 && !Character.isLetterOrDigit(s.charAt(p1))){
                p1++;
            }
            while(p1 < p2 && !Character.isLetterOrDigit(s.charAt(p2))){
                p2--;
            }
            char c1 = Character.toLowerCase(s.charAt(p1));
            char c2 = Character.toLowerCase(s.charAt(p2));
            if(c1 != c2){
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }
}