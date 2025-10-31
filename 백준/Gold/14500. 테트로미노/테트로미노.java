import java.io.*;
import java.util.*;

public class Main{
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                visited[i][j] = true;
                go(i, j, 1, map[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.println(answer);
    }
    static void go(int x, int y, int cnt, int sum){
        if(cnt == 4){
            answer = Math.max(answer, sum);
            return;
        }
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny])continue;// 범위 || 방문
            if(cnt == 2){
                visited[nx][ny] = true;
                go(x, y, cnt + 1, sum + map[nx][ny]);
                visited[nx][ny] = false;
            }
            visited[nx][ny] = true;
            go(nx, ny, cnt + 1, sum + map[nx][ny]);
            visited[nx][ny] = false;
        }
    }
}