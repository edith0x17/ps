import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> mp = new HashMap<>();
        for (String s : terms) {
            String[] ss = s.split(" ");
            mp.put(ss[0], Integer.parseInt(ss[1]) * 28);
        }
        int target = dayCal(today), idx = 1;
        ArrayList<Integer> ret = new ArrayList<>();
        for (String s : privacies) {
            String[] ss = s.split(" ");
            int day = dayCal(ss[0]) + mp.get(ss[1]);
            if (target >= day) ret.add(idx);
            idx++;
        }
        int[] answer = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            answer[i] = ret.get(i);
        }
        return answer;
    }

    static int dayCal(String s) {
        String[] ss = s.split("\\.");
        int y = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);
        int d = Integer.parseInt(ss[2]);
        return y * 12 * 28 + m * 28 + d;
    }
}
//모든 달은 28일까지 있다고 가정