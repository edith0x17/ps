import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }


        int answer = 0;
        while (true) {
            boolean[][] remove = new boolean[m][n];
            //체크
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j] == '.') continue;

                    if (map[i][j] == map[i][j + 1] &&
                            map[i][j] == map[i + 1][j + 1] &&
                            map[i][j] == map[i + 1][j]
                    ) {
                        remove[i][j] = true;
                        remove[i][j + 1] = true;
                        remove[i + 1][j + 1] = true;
                        remove[i + 1][j] = true;
                    }
                }
            }
            //삭제
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (remove[i][j]) {
                        map[i][j] = '.';
                        cnt++;
                    }
                }
            }
            if (cnt == 0) break;
            answer += cnt;
            //낙하
            for (int j = 0; j < n; j++) {//열
                int write = m - 1;//아래 -> 위
                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] != '.') {
                        map[write][j] = map[i][j];
                        if (write != i) map[i][j] = '.';
                        write--;
                    }
                }
            }
        }
        return answer;
    }
}