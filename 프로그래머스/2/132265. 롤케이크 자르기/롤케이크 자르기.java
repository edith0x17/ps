import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> left = new HashSet<>();
        Map<Integer, Integer> right = new HashMap<>();

        // 처음에는 모든 topping을 right에 넣기
        for (int i : topping) {
            right.put(i, right.getOrDefault(i, 0) + 1);
        }
        for (int x : topping) {
            // x 하나를 왼쪽으로 이동
            left.add(x);

            // right에서 x의 개수 1 감소
            // 개수가 0이면 right에서 remove
            right.put(x, right.get(x) - 1);
            if (right.get(x) == 0) right.remove(x);
            
            // left.size() == right.size()면 answer++
            if (left.size() == right.size()) answer++;
        }
        return answer;
    }
}