import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows][columns];
        int cnt = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = cnt++;
            }
        }
        int idx = 0;
        for (int[] query : queries) {
            int sx = query[0] - 1, sy = query[1] - 1, ex = query[2] - 1, ey = query[3] - 1;
            int tmp = map[sx][sy];
            int ret = tmp;
            //left
            for (int i = sx; i < ex; i++) {
                map[i][sy] = map[i + 1][sy];
                ret = Math.min(ret, map[i][sy]);
            }
            //bot
            for (int i = sy; i < ey; i++) {
                map[ex][i] = map[ex][i + 1];
                ret = Math.min(ret, map[ex][i]);
            }
            //right
            for (int i = ex; i > sx; i--) {
                map[i][ey] = map[i - 1][ey];
                ret = Math.min(ret, map[i - 1][ey]);
            }
            //top
            for (int i = ey; i > sy; i--) {
                map[sx][i] = map[sx][i - 1];
                ret = Math.min(ret, map[sx][i]);
            }
            map[sx][sy + 1] = tmp;
            answer[idx++] = ret;
        }
        return answer;
    }
}