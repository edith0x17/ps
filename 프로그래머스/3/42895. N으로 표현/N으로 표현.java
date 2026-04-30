import java.util.*;

class Solution {
    public int solution(int N, int number) {
        ArrayList<Set<Integer>> dp = new ArrayList<Set<Integer>>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }
        /*dp[1] = {5}
        dp[2] = {55, 10, 0, 25, 1}
        dp[3] = {555, 15, 50, 11, ...}*/

        for (int i = 1; i <= 8; i++) {
            int repeated = 0;
            for (int j = 0; j < i; j++) {
                repeated = repeated * 10 + N;
            }
            dp.get(i).add(repeated);

            for (int j = 1; j < i; j++) {
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i - j)) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b != 0) dp.get(i).add(a / b);
                    }
                }
            }
            if (dp.get(i).contains(number)) return i;
        }
        return -1;
    }
}

//dp[i] = N을 i개 사용해서 만들 수 있는 숫자들의 집합
//dp[i] = dp[1]과 dp[i - 1] 조합