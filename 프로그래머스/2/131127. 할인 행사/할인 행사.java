import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < number.length; i++) {
            mp.put(want[i], number[i]);
        }
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> tmp = new HashMap<>();

            for (int j = i; j < i + 10; j++) {
                tmp.put(discount[j], tmp.getOrDefault(discount[j], 0) + 1);
            }

            boolean flag = true;
            for (Map.Entry<String, Integer> entry : mp.entrySet()) {
                //entry.getKey() entry.getValue()
                if (tmp.get(entry.getKey()) != entry.getValue()) {
                    flag = false;
                    break;
                }
            }
            if (flag) answer++;
        }
        return answer;
    }
}