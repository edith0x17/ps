import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        int l = 0, r = distance;
        while (l <= r) {
            int mid = (l + r) / 2;
            int remove = check(mid, rocks, distance);
            if (remove <= n) {
                answer = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return answer;
    }

    int check(int mid, int[] rocks, int distance) {
        int remove = 0;
        int prev = 0;
        for (int rock : rocks) {
            if (rock - prev < mid) remove++;
            else prev = rock;
        }
        if (distance - prev < mid) remove++;
        return remove;
    }
}