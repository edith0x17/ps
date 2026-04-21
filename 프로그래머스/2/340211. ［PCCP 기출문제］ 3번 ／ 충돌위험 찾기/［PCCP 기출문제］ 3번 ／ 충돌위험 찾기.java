import java.util.*;

class Solution {
    static int answer = 0, n;
    static Queue<int[]>[] records;

    public int solution(int[][] points, int[][] routes) {
        n = routes.length;
        records = new ArrayDeque[n + 4];
        for (int i = 0; i < n + 4; i++) {
            records[i] = new ArrayDeque<>();
        }

        go(points, routes);
        check();
        return answer;
    }

    static void check() {
        int robotCnt = 0;
        while (robotCnt != n) {
            robotCnt = 0;
            int[][] map = new int[101][101];
            for (int i = 0; i < n; i++) {
                if (records[i].isEmpty()) {
                    robotCnt++;
                    continue;
                }
                int[] tmp = records[i].poll();//초마다 뽑기
                map[tmp[0]][tmp[1]]++;
            }
            for (int i = 0; i < 101; i++) {
                for (int j = 0; j < 101; j++) {
                    if (map[i][j] > 1) answer++;
                }
            }
        }
    }

    static void go(int[][] points, int[][] routes) {
        for (int i = 0; i < routes.length; i++) {
            int start = routes[i][0];//i번 로봇 x번
            int sx = points[start - 1][0];//x번 x
            int sy = points[start - 1][1];//x번 y
            records[i].offer(new int[]{sx, sy});
            for (int j = 1; j < routes[i].length; j++) {
                int end = routes[i][j];//i번 로봇 nx번
                int ex = points[end - 1][0];//nx번 x
                int ey = points[end - 1][1];//nx번 y
                while (sx != ex) {
                    if (sx < ex) sx++;
                    else sx--;
                    records[i].offer(new int[]{sx, sy});
                }
                while (sy != ey) {
                    if (sy < ey) sy++;
                    else sy--;
                    records[i].offer(new int[]{sx, sy});
                }
            }
        }
    }
}