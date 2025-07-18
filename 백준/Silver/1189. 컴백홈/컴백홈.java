import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int r, c, k;
    static char[][] a;
    static boolean[][] visited;
    static int[] check = new int[29];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        a = new char[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                a[i][j] = s.charAt(j);
            }
        }
        visited[r-1][0] = true;
        go(r - 1, 0, 0);
        System.out.println(check[k]);
    }
    static void go(int x, int y, int cnt){
        if(x == 0 && y == c - 1){
            check[cnt + 1]++;
            return;
        }
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= r || ny < 0 || ny >= c || visited[nx][ny])continue; // 범위 || 방문
            if(a[nx][ny] == 'T')continue; // 장애물
            visited[nx][ny] = true;
            go(nx, ny, cnt + 1);
            visited[nx][ny] = false;
        }
    }
}