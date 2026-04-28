import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> w = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            w.put(want[i], number[i]);
        }
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> tmp = new HashMap<>();
            for (int j = i; j < i + 10; j++) {
                tmp.put(discount[j], tmp.getOrDefault(discount[j], 0) + 1);
            }
            if (check(w, tmp)) answer++;
        }

        return answer;
    }

    static boolean check(Map<String, Integer> w, Map<String, Integer> tmp) {
        for (Map.Entry<String, Integer> entry : w.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (tmp.getOrDefault(key, 0) != value) return false;
        }
        return true;
    }
}