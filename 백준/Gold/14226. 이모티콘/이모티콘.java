import java.io.*;
import java.util.*;

public class Main {
    static int s;
    static Queue<int[]> q = new ArrayDeque<>();
    static int[][] visited = new int[1004][1004];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Integer.parseInt(br.readLine());
        visited[1][0] = 1;
        q.offer(new int[]{1, 0, 0});//board, clipboard, time
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int board = cur[0];
            int clipboard = cur[1];
            int time = cur[2];

            if (cur[0] == s) {
                System.out.println(time);
                break;
            }

            if (visited[board][board] == 0) {//1
                visited[board][board] = 1;
                q.offer(new int[]{board, board, time + 1});
            }

            if (clipboard > 0 && board + clipboard <= 1000 && visited[board + clipboard][clipboard] == 0) {//2
                visited[board + clipboard][clipboard] = 1;
                q.offer(new int[]{board + clipboard, clipboard, time + 1});
            }

            if (board > 0 && visited[board - 1][clipboard] == 0) {
                visited[board - 1][clipboard] = 1;
                q.offer(new int[]{board - 1, clipboard, time + 1});
            }
        }
    }
}