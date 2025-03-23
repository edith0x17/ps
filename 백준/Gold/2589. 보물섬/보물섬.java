import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m, answer = Integer.MIN_VALUE;
    static int[][] a, visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                if(s.charAt(j) == 'L')a[i][j] = 1;
                else a[i][j] = 0;// 'W'
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] == 1){
                    bfs(i, j);
                }
            }
        }
        System.out.println(answer - 1);
    }
    static void bfs(int x, int y){
        visited = new int[n][m];
        Queue<Data> q = new ArrayDeque<>();

        visited[x][y] = 1;
        q.offer(new Data(x, y));
        while(!q.isEmpty()){
            Data data = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = data.x + dx[i];
                int ny = data.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m)continue;// 범위
                if(a[nx][ny] == 0 || visited[nx][ny] != 0)continue;// 장애물 || 방문
                visited[nx][ny] = visited[data.x][data.y] + 1;
                answer = Math.max(answer, visited[nx][ny]);
                q.offer(new Data(nx, ny));
            }
        }
    }
    static class Data{
        int x, y;
        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}