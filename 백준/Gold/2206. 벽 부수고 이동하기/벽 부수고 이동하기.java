import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static class Data{
        int x;
        int y;
        boolean breakWall;
        int cnt;

        public Data(int x, int y, boolean breakWall, int cnt) {
            this.x = x;
            this.y = y;
            this.breakWall = breakWall;
            this.cnt = cnt;
        }
    }
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][] map;
    static boolean [][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 4][m + 4];
        visited = new boolean[n + 4][m + 4][2];

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        System.out.println(bfs());
    }

    static int bfs(){
        Queue<Data> q = new ArrayDeque<>();

        visited[0][0][0] = true;
        q.offer(new Data(0, 0, false, 1)); // 시작위치 포함 & 끝위치 포함
        while(!q.isEmpty()){
            Data d = q.peek();
            q.poll();

            if(d.x == n - 1 && d.y == m - 1)return d.cnt;

            for(int i = 0; i < 4; i++){
                int nx = d.x + dx[i];
                int ny = d.y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m)continue;

               if(map[nx][ny] == 1){ // 벽 O
                   if(d.breakWall)continue;

                   if(visited[nx][ny][1])continue;
                   visited[nx][ny][1] = true;
                   q.offer(new Data(nx, ny, true, d.cnt + 1));
               }else{ // 벽 X
                    if(!d.breakWall){ // 부수지 않은 경우
                        if(visited[nx][ny][0])continue;
                        visited[nx][ny][0] = true;
                        q.offer(new Data(nx, ny, false, d.cnt + 1));
                    }else{ // 부순 경우
                        if(visited[nx][ny][1])continue;
                        visited[nx][ny][1] = true;
                        q.offer(new Data(nx, ny, true, d.cnt + 1));
                    }
               }
            }
        }

        return -1;
    }
}