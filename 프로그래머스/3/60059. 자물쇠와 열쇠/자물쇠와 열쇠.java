import java.util.*;

class Solution {

    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;//n
        int m = key.length;//m
        int[][] map = new int[n * 3][n * 3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i + n][j + n] = lock[i][j];
            }
        }
        int mapSize = n * 3;
        for (int r = 0; r < 4; r++) {
            for (int x = 0; x <= mapSize - m; x++) {
                for (int y = 0; y <= mapSize - m; y++) {//key 시작점

                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            map[i + x][j + y] += key[i][j];//x, y로 보정
                        }
                    }

                    if (check(map, n)) {
                        return true;
                    }

                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            map[i + x][j + y] -= key[i][j];//x, y로 보정
                        }
                    }
                }
            }
            key = rotate(key);
        }
        return false;
    }

    static boolean check(int[][] map, int n) {
        for (int i = n; i < n * 2; i++) {
            for (int j = n; j < n * 2; j++) {
                if (map[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static int[][] rotate(int[][] key) {
        int m = key.length;
        int[][] ret = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                ret[j][m - 1 - i] = key[i][j];
            }
        }
        return ret;
    }
}