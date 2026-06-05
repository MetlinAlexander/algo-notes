class Solution {

    public void generateParenthesis(int n, int opened, int closed, char[] buf, List<String> answer) {
        if (opened + closed == n * 2) {
            answer.add(new String(buf));
            return;
        }
        if (opened < n) {
            buf[opened + closed] = '(';
            generateParenthesis(n, opened + 1, closed, buf, answer);
        }
        if (closed < opened) {
            buf[opened + closed] = ')';
            generateParenthesis(n, opened, closed + 1, buf, answer);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        char[] buf = new char[n * 2];
        generateParenthesis(n, 0, 0, buf, answer);
        return answer;
    }
}