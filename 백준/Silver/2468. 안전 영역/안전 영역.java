import java.io.*;
import java.util.*;

public class Main{
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n + 4][n + 4];
        int mx = -1;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                mx = Math.max(mx, map[i][j]);
            }
        }
        int answer = -1;
        for(int i = 0; i <= mx; i++){
            answer = Math.max(answer, go(i));
        }
        System.out.println(answer);
    }
    static int go(int k){
        int ret = 0;
        int[][] temp = new int[n + 4][n + 4];
        visited = new boolean[n + 4][n + 4];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                temp[i][j] = map[i][j];
                if(temp[i][j] <= k)temp[i][j] = -1;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(temp[i][j] != -1 && !visited[i][j]){
                    dfs(i, j, temp);
                    ret++;
                }
            }
        }
        return ret;
    }
    static void dfs(int x, int y, int[][] temp){
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny])continue;// 범위 || 방문
            if(temp[nx][ny] == -1)continue;
            dfs(nx, ny, temp);
        }
    }
}