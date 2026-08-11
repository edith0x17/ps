import java.util.*;

class Solution {
    static char[][] map;

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        map = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        while (true) {
            boolean[][] remove = new boolean[m][n];
            if (!check(map, remove)) break;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (remove[i][j]) {
                        map[i][j] = '.';
                        answer++;
                    }
                }
            }
            gravity(map);
        }
        return answer;
    }

    static void gravity(char[][] map) {
        for (int j = 0; j < map[0].length; j++) {
            int write = map.length - 1;//m - 1
            for (int i = map.length - 1; i >= 0; i--) {
                if (map[i][j] != '.') {
                    map[write][j] = map[i][j];
                    write--;
                }
            }
            while (write >= 0) {
                map[write][j] = '.';
                write--;
            }
        }
    }

    static boolean check(char[][] map, boolean[][] remove) {
        boolean found = false;
        for (int i = 0; i < map.length - 1; i++) {
            for (int j = 0; j < map[0].length - 1; j++) {
                char ch = map[i][j];
                if (ch == '.') continue;
                if (ch == map[i][j + 1] && ch == map[i + 1][j + 1] && ch == map[i + 1][j]) {
                    remove[i][j] = true;
                    remove[i][j + 1] = true;
                    remove[i + 1][j + 1] = true;
                    remove[i + 1][j] = true;
                    found = true;
                }
            }
        }
        return found;
    }
}