import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> left = new HashSet<>();
        Map<Integer, Integer> right = new HashMap<>();
        for (int i : topping) {
            right.put(i, right.getOrDefault(i, 0) + 1);
        }
        for (int i = 0; i < topping.length - 1; i++) {//topping.length - 1 -> 두조각
            int t = topping[i];
            left.add(t);//왼쪽
            right.put(t, right.get(t) - 1);//오른쪽
            if (right.get(t) == 0) right.remove(t);//오른쪽

            if (left.size() == right.size()) answer++;
        }
        return answer;
    }
}