import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            mp.put(want[i], number[i]);
        }
        for (int start = 0; start <= discount.length - 10; start++) {
            Map<String, Integer> tmp = new HashMap<>(mp);
            for (int i = start; i < start + 10; i++) {
                String item = discount[i];
                tmp.put(item, tmp.getOrDefault(item, 0) - 1);
                if (tmp.get(item) <= 0) tmp.remove(item);
            }
            if (tmp.isEmpty()) answer++;
        }
        return answer;
    }
}