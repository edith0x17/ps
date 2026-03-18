import javax.swing.plaf.DesktopIconUI;
import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, k, l;
    static int[][] a;
    static int snakeX = 0, snakeY = 0, snakeDir = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        a = new int[n][n];
        k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            a[x][y] = 2;//사과
        }
        l = Integer.parseInt(br.readLine());
        Map<Integer, Character> mp = new HashMap<>();
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char ch = st.nextToken().charAt(0);
            mp.put(x, ch);
        }
        a[snakeX][snakeY] = 1;//뱀
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{0, 0});
        int t = 0;
        while (true) {
            t++;
            int nx = snakeX + dx[snakeDir];
            int ny = snakeY + dy[snakeDir];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) break;
            if (a[nx][ny] == 1) break;

            if (a[nx][ny] == 2) {
                a[nx][ny] = 1;
                dq.offerFirst(new int[]{nx, ny});
            } else {
                a[nx][ny] = 1;
                dq.offerFirst(new int[]{nx, ny});
                int[] tail = dq.pollLast();
                a[tail[0]][tail[1]] = 0;
            }

            snakeX = nx;
            snakeY = ny;

            if (mp.containsKey(t)) {
                char c = mp.get(t);
                if (c == 'L') snakeDir = (snakeDir + 4 - 1) % 4;
                else snakeDir = (snakeDir + 1) % 4;
            }
        }
        System.out.println(t);
    }
}