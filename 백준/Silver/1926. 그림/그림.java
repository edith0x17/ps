import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int n, m, cnt, answer;
    static int[][] a;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] == 1 && !visited[i][j]){// 장애물 방문
                    cnt++;
                    answer = Math.max(answer, dfs(i, j));
                }
            }
        }
        System.out.println(cnt);
        System.out.println(answer);
    }
    static int dfs(int x, int y){
        visited[x][y] = true;
        int ret = 1;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m)continue;// 범위
            if(a[nx][ny] != 1)continue;// 장애물
            if(visited[nx][ny])continue;// 방문
            ret += dfs(nx, ny);
        }
        return ret;
    }
}