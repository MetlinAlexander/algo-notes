class Solution {
    public boolean checkContains(HashMap<Character, Integer> h1, HashMap<Character, Integer> h2, char c) {
        if ((!h1.containsKey(c)) || (!h2.containsKey(c))) {
            return false;
        }
        return h1.get(c).equals(h2.get(c));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        HashMap<Character, Integer> h1 = new HashMap<>();
        HashMap<Character, Integer> h2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            h1.put(s1.charAt(i), h1.getOrDefault(s1.charAt(i), 0) + 1);
            h2.put(s2.charAt(i), h2.getOrDefault(s2.charAt(i), 0) + 1);
        }
        int matches = 0;
        for (char c : h1.keySet()) {
            if (checkContains(h1, h2, c)) {
                matches += 1;
            }
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            if (matches == h1.size()) {
                return true;
            }
            char c1 = s2.charAt(i - s1.length());
            char c2 = s2.charAt(i);
            if (checkContains(h1, h2, c1)) {
                matches -= 1;
            }
            h2.put(c1, h2.get(c1) - 1);
            if (checkContains(h1, h2, c1)) {
                matches += 1;
            }

            if (checkContains(h1, h2, c2)) {
                matches -= 1;
            }
            h2.put(c2, h2.getOrDefault(c2, 0) + 1);
            if (checkContains(h1, h2, c2)) {
                matches += 1;
            }
        }
        return matches == h1.size();
    }
}