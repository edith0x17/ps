import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            int tmp = 100 - progresses[i];
            if (tmp % speeds[i] == 0) q.offer(tmp / speeds[i]);
            else q.offer((tmp / speeds[i]) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            int cnt = 1, cur = q.poll();
            while (!q.isEmpty() && q.peek() <= cur) {
                q.poll();
                cnt++;
            }
            list.add(cnt);
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}