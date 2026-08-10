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
            int sx = query[0] - 1;
            int sy = query[1] - 1;
            int ex = query[2] - 1;
            int ey = query[3] - 1;

            int tmp = map[sx][sy];
            int min = tmp;

            // left : 아래 값을 위로
            for (int x = sx; x < ex; x++) {
                map[x][sy] = map[x + 1][sy];
                min = Math.min(min, map[x][sy]);
            }

            // bottom : 오른쪽 값을 왼쪽으로
            for (int y = sy; y < ey; y++) {
                map[ex][y] = map[ex][y + 1];
                min = Math.min(min, map[ex][y]);
            }

            // right : 위 값을 아래로
            for (int x = ex; x > sx; x--) {
                map[x][ey] = map[x - 1][ey];
                min = Math.min(min, map[x][ey]);
            }

            // top : 왼쪽 값을 오른쪽으로
            for (int y = ey; y > sy; y--) {
                map[sx][y] = map[sx][y - 1];
                min = Math.min(min, map[sx][y]);
            }

            // 처음 좌상단 값 넣기
            map[sx][sy + 1] = tmp;

            answer[idx++] = min;
        }

        return answer;
    }
}