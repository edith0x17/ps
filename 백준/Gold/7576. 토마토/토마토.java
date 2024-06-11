import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static class Data{
        int x;
        int y;

        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m;
    static int[][] a, visited;
    static Queue<Data> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        a = new int[n][m];
        visited = new int[n][m];

        boolean flag = false; // 로직 필요 X
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                a[i][j] = Integer.parseInt(st.nextToken());

                if(a[i][j] != -1)flag = true; // 로직 필요 O

                if(a[i][j] == 1){
                    visited[i][j] = 1;
                    q.offer(new Data(i, j));
                }
            }
        }

        if(flag){
            // 로직
            bfs();
            sb.append(check());
        }else sb.append(0);

        bw.write(sb + "");
        bw.flush();
        bw.close();
    }

    static int check(){
        int ret = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] == 0)return -1;
                ret = Math.max(ret, visited[i][j]);
            }
        }
        return ret - 1;
    }

    static void bfs(){
        while(!q.isEmpty()){
            Data d = q.poll(); // q.front(), q.pop()

            for(int i = 0; i < 4; i++){
                int nx = d.x + dx[i];
                int ny = d.y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] != 0)continue; // 범위 || 방문
                if(a[nx][ny] == 1 || a[nx][ny] == -1)continue; // 토마토 익음 || 토마토 없음 -> 방문X

                if(a[nx][ny] == 0){
                    a[nx][ny] = 1;
                    visited[nx][ny] = visited[d.x][d.y] + 1;
                    q.offer(new Data(nx, ny));
                }
            }
        }
    }
}