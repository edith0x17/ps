import java.io.*;
import java.util.*;

public class Main {
    static int s;
    static boolean[][] visited = new boolean[1004][1004];//[screen][clip]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Integer.parseInt(br.readLine());
        Queue<int[]> q = new ArrayDeque<>();
        visited[1][0] = true;
        q.offer(new int[]{1, 0, 0});
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int screen = tmp[0];
            int clip = tmp[1];
            int time = tmp[2];
            if (screen == s) {
                System.out.println(time);
                return;
            }
            if (!visited[screen][screen]) {//복사
                visited[screen][screen] = true;
                q.offer(new int[]{screen, screen, time + 1});
            }
            if (clip > 0 && screen + clip <= 1000 && !visited[screen + clip][clip]) {//붙여넣기
                visited[screen + clip][clip] = true;
                q.offer(new int[]{screen + clip, clip, time + 1});
            }
            if (screen > 0 && !visited[screen - 1][clip]) {//삭제
                visited[screen - 1][clip] = true;
                q.offer(new int[]{screen - 1, clip, time + 1});
            }
        }
    }
}