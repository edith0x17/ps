import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] a = {1, 2, 3, 4, 5};//5
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};//8
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};//10
        int aa = 0, bb = 0, cc = 0;
        for (int i = 0; i < answers.length; i++) {
            if (a[(i) % 5] == answers[i]) aa++;
            if (b[(i) % 8] == answers[i]) bb++;
            if (c[(i) % 10] == answers[i]) cc++;
        }
        int mx = Math.max(aa, Math.max(bb, cc));
        ArrayList<Integer> list = new ArrayList<>();
        if (aa == mx) list.add(1);
        if (bb == mx) list.add(2);
        if (cc == mx) list.add(3);
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}