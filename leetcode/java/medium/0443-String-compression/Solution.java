class Solution {
    public int compress(char[] chars) {
        int ans = 0;
        for(int i = 0; i < chars.length; i++){
            int start = i;
            while(i+1 < chars.length && chars[i] == chars[i+1]){
                i++;
            }
            int len = i - start + 1;
            chars[ans++] = chars[i];
            String cn = Integer.toString(len);
            if(len > 1){
                for(int j = 0; j < cn.length(); j++ ){
                    chars[ans++] = cn.charAt(j);
                }
            }
        }
        return ans;
    }
}