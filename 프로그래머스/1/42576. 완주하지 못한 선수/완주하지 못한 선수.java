import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        // 1. 참가자 명단 저장 (이름별로 개수 카운트)
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        // 2. 완주자 명단을 돌며 개수 감소
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }
        
        // 3. 값이 1로 남은 사람이 완주 못한 사람
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                return key;
            }
        }

        return ""; // 없을 경우 빈 문자열 반환 (예외 방지)
    }
}
