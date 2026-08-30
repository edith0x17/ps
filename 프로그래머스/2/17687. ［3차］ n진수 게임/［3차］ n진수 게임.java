class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        int num = 0;
        int turn = 0;      // 전체에서 몇 번째 문자인지
        while (answer.length() < t) {
            String str = Integer.toString(num, n).toUpperCase();

            for (int i = 0; i < str.length(); i++) {
                if (turn % m == p - 1) {
                    answer.append(str.charAt(i));
                    if (answer.length() == t) break;
                }
                
                turn++;
            }

            num++;
        }
        return answer.toString();
    }
}