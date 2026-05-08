import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> dup = new HashMap<>();//<(A -> B), cnt>
        Map<String, Integer> ret = new HashMap<>();//<B, cnt>
        for (String s : report) {
            if (dup.containsKey(s)) continue;

            dup.put(s, 1);
            String[] ss = s.split(" ");
            //ss[0] -> ss[1]
            ret.put(ss[1], ret.getOrDefault(ss[1], 0) + 1);
        }
        Map<String, Integer> tmp = new HashMap<>();//<A, cnt>
        for (Map.Entry<String, Integer> entry : dup.entrySet()) {
            String[] ss = entry.getKey().split(" ");
            //ss[0] -> ss[1]
            if (ret.get(ss[1]) >= k) {
                tmp.put(ss[0], tmp.getOrDefault(ss[0], 0) + 1);
            }
        }
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = tmp.getOrDefault(id_list[i], 0);
        }
        return answer;
    }
}