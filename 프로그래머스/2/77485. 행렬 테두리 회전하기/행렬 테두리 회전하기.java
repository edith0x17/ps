import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int idx = 1;
        int[][] a = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                a[i][j] = idx++;
            }
        }
        idx = 0;
        for (int[] query : queries) {
            int mi = Integer.MAX_VALUE;
            int sx = query[0] - 1, sy = query[1] - 1, ex = query[2] - 1, ey = query[3] - 1;
            int n = ex - sx + 1, m = ey - sy + 1;
            for (int layer = 0; layer < 1; layer++) {
                int top = layer + sx, bot = n - 1 - layer + sx;
                int left = layer + sy, right = m - 1 - layer + sy;
                int tmp = a[top][left];
                mi = Math.min(mi, tmp);
                //왼
                for (int i = top; i < bot; i++) {
                    a[i][left] = a[i + 1][left];
                    mi = Math.min(mi, a[i][left]);
                }
                //아래
                for (int j = left; j < right; j++) {
                    a[bot][j] = a[bot][j + 1];
                    mi = Math.min(mi, a[bot][j]);
                }
                //오른쪽
                for (int i = bot; i > top; i--) {
                    a[i][right] = a[i - 1][right];
                    mi = Math.min(mi, a[i][right]);
                }
                //위
                for (int j = right; j > left; j--) {
                    a[top][j] = a[top][j - 1];
                    mi = Math.min(mi, a[top][j]);
                }
                a[top][left + 1] = tmp;
                answer[idx++] = mi;
            }
        }
        return answer;
    }
}