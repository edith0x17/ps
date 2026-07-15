import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int n = numbers.length;
        int S = (1 << n);
        for (int i = 0; i < S; i++) {
            ArrayList<Integer> adj = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    adj.add(1);
                } else {
                    adj.add(0);
                }
            }
            int sum = 0;
            for (int j = 0; j < adj.size(); j++) {
                if (adj.get(j) == 1) {
                    sum += numbers[j];
                } else {
                    sum -= numbers[j];
                }
            }
            if (sum == target) answer++;
        }
        return answer;
    }
}