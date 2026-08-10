import java.util.*;

class Solution {
    static int n, m;
    static int[][] map;

    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        n = key.length;
        m = lock.length;
        map = new int[m * 3][m * 3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                map[i + m][j + m] = lock[i][j];
            }
        }

        for (int d = 0; d < 4; d++) {//90

            for (int x = 0; x <= map.length - n; x++) {//key 시작점
                for (int y = 0; y <= map.length - n; y++) {

                    for (int i = 0; i < n; i++) {//key올림
                        for (int j = 0; j < n; j++) {
                            map[x + i][y + j] += key[i][j];
                        }
                    }
                    if (check(m, map)) return true;
                    for (int i = 0; i < n; i++) {//key내림
                        for (int j = 0; j < n; j++) {
                            map[x + i][y + j] -= key[i][j];
                        }
                    }
                }
            }

            //현재방향을 모두 확인했으면 key를 90도 회전한다
            key = rotate(n, key);
        }

        return answer;
    }

    static int[][] rotate(int n, int[][] key) {
        int[][] ret = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ret[j][n - 1 - i] = key[i][j];
            }
        }

        return ret;
    }

    static boolean check(int m, int[][] map) {
        for (int i = m; i < m * 2; i++) {
            for (int j = m; j < m * 2; j++) {
                if (map[i][j] != 1) return false;
            }
        }
        return true;
    }
}