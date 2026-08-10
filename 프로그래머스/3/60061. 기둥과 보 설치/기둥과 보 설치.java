import java.util.*;

class Solution {
    static boolean[][] pillar = new boolean[104][104];
    static boolean[][] beam = new boolean[104][104];

    public int[][] solution(int n, int[][] build_frame) {

        for (int[] buildFrame : build_frame) {
            int x = buildFrame[0];
            int y = buildFrame[1];
            int a = buildFrame[2];
            int b = buildFrame[3];

            if (a == 0) { // pillar

                if (b == 0) { // delete
                    pillar[x][y] = false;
                } else { // insert
                    pillar[x][y] = true;
                }

                if (!check(n)) {
                    if (b == 0) {
                        pillar[x][y] = true;
                    } else {
                        pillar[x][y] = false;
                    }
                }

            } else { // beam

                if (b == 0) { // delete
                    beam[x][y] = false;
                } else { // insert
                    beam[x][y] = true;
                }

                if (!check(n)) {
                    if (b == 0) {
                        beam[x][y] = true;
                    } else {
                        beam[x][y] = false;
                    }
                }
            }
        }

        List<int[]> list = new ArrayList<>();

        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {

                if (pillar[x][y]) {
                    list.add(new int[]{x, y, 0});
                }

                if (beam[x][y]) {
                    list.add(new int[]{x, y, 1});
                }
            }
        }

        int[][] answer = new int[list.size()][3];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    static boolean canPillar(int x, int y) {
        if (y == 0) return true;
        if (beam[x][y]) return true;
        if (x > 0 && beam[x - 1][y]) return true;
        if (y > 0 && pillar[x][y - 1]) return true;

        return false;
    }

    static boolean canBeam(int x, int y) {
        if (y > 0 && pillar[x][y - 1]) return true;
        if (y > 0 && pillar[x + 1][y - 1]) return true;
        if (x > 0 && beam[x - 1][y] && beam[x + 1][y]) return true;

        return false;
    }

    static boolean check(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {

                if (pillar[i][j] && !canPillar(i, j)) {
                    return false;
                }

                if (beam[i][j] && !canBeam(i, j)) {
                    return false;
                }
            }
        }

        return true;
    }
}