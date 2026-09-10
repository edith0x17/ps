import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> right = new HashMap<>();
        Set<Integer> left = new HashSet<>();
        for (int i : topping) {
            right.put(i, right.getOrDefault(i, 0) + 1);
        }
        for (int i : topping) {
            //delete
            right.put(i, right.getOrDefault(i, 0) - 1);
            if (right.get(i) <= 0) right.remove(i);
            //insert
            left.add(i);
            //pair
            if (right.size() == left.size()) answer++;
        }
        return answer;
    }
}