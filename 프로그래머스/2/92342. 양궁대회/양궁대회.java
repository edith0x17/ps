import java.util.*;

class Solution {
    static int maxDiff;
    static int[] lion;
    static int[] answer;

    public int[] solution(int n, int[] info) {
        maxDiff = 0;
        lion = new int[11];
        answer = new int[]{-1};

        combi(0, 0, n, info);

        return answer;
    }

    static void combi(int depth, int start, int n, int[] info) {
        if (depth == n) {
            int diff = check(info);

            if (diff <= 0) return;

            if (diff > maxDiff) {
                maxDiff = diff;
                answer = lion.clone();
            } else if (diff == maxDiff && isBetter()) {
                answer = lion.clone();
            }

            return;
        }

        for (int i = start; i < 11; i++) {
            lion[i]++;
            combi(depth + 1, i, n, info);
            lion[i]--;
        }
    }

    static int check(int[] info) {
        int apeach = 0;
        int ryan = 0;

        for (int i = 0; i < 11; i++) {
            if (info[i] == 0 && lion[i] == 0) continue;

            int score = 10 - i;

            if (info[i] >= lion[i]) {
                apeach += score;
            } else {
                ryan += score;
            }
        }

        return ryan - apeach;
    }

    static boolean isBetter() {
        for (int i = 10; i >= 0; i--) {
            if (lion[i] == answer[i]) continue;

            return lion[i] > answer[i];
        }

        return false;
    }
}