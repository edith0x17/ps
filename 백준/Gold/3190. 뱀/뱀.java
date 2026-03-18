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
        n = Integer.parseInt(br.readLine());
        a = new int[n][n];
        Deque<int[]> snake = new ArrayDeque<>();
        a[0][0] = 1;
        snake.offer(new int[]{0, 0});
        k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            a[x - 1][y - 1] = 2;//사과
        }
        l = Integer.parseInt(br.readLine());
        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            map.put(x, c);
        }
        int time = 0;
        while (true) {
            time++;
            int nx = snakeX + dx[snakeDir];
            int ny = snakeY + dy[snakeDir];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) break;//벽
            if (a[nx][ny] == 1) break;//자기자신의 몸

            if (a[nx][ny] == 2) {
                a[nx][ny] = 1;
                snake.offerFirst(new int[]{nx, ny});
            } else {
                a[nx][ny] = 1;
                snake.offerFirst(new int[]{nx, ny});
                int[] tail = snake.pollLast();
                a[tail[0]][tail[1]] = 0;
            }
            snakeX = nx;
            snakeY = ny;
            if (map.containsKey(time)) {
                char c = map.get(time);
                if (c == 'L') snakeDir = (snakeDir + 4 - 1) % 4;
                else snakeDir = (snakeDir + 1) % 4;
            }
        }
        System.out.println(time);
    }
}