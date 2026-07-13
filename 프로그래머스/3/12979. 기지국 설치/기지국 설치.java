import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        int cover = 2 * w + 1;
        for (int station : stations) {
            int len = station - w - start;
            if (len > 0) {
                answer += (int) Math.ceil((double) len / cover);
            }
            start = station + w + 1;
        }
        // 마지막 남은 구간
        int len = n - start + 1;
        if (len > 0) {
            answer += (int) Math.ceil((double) len / cover);
        }
        return answer;
    }
}