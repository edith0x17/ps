import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        int answer = 1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int temp = entry.getValue() + 1;
            answer *= temp;
        }
        answer = answer - 1;
        return answer;
    }
}
