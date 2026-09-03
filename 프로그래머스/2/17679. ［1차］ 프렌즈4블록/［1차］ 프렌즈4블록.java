import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] arr = new char[m][n];
        for (int i = 0; i < m; i++) {
            arr[i] = board[i].toCharArray();
        }
        while (true) {
            boolean flag = false;
            boolean[][] map = new boolean[m][n];

            // 1. 전체 보드 돌면서 2x2 찾기
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char c = arr[i][j];
                    // 이미 삭제된 공간이면 검사 X
                    if (c == ' ') continue;
                    if (arr[i][j + 1] == c
                            && arr[i + 1][j + 1] == c
                            && arr[i + 1][j] == c) {
                        flag = true;
                        map[i][j] = true;
                        map[i][j + 1] = true;
                        map[i + 1][j + 1] = true;
                        map[i + 1][j] = true;
                    }
                }
            }

            // 2. 삭제할 게 없으면 종료
            if (!flag) break;

            // 3. 표시된 블록 실제 삭제
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j]) {
                        arr[i][j] = ' ';
                        answer++;
                    }
                }
            }

            // 4. 블록 아래로 내리기
            for (int col = 0; col < n; col++) {
                int write = m - 1;
                for (int row = m - 1; row >= 0; row--) {
                    if (arr[row][col] != ' ') {
                        arr[write][col] = arr[row][col];
                        write--;
                    }
                }
                while (write >= 0) {
                    arr[write][col] = ' ';
                    write--;
                }
            }
        }
        return answer;
    }
}