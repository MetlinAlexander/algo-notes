class Solution {
    public static String sortString(String str){
        char[] temp = str.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> anag = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            String sorted = sortString(strs[i]);
            if(!anag.containsKey(sorted)){
                anag.put(sorted, new ArrayList<String>());
            }
            anag.get(sorted).add(strs[i]);
        } 
        List<List<String>> ans = new ArrayList<>();
        for(String c : anag.keySet()){
            ans.add(anag.get(c));
        }
        return ans;  
    }
}