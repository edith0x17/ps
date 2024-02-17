import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution{
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static Data start, end;
    static boolean flag;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 10;
        while(t-- != 0){
            flag = false;
            int tc = Integer.parseInt(br.readLine());

            map = new int[100][100];
            visited = new boolean[100][100];

            for(int i = 0; i < 100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                for(int j = 0; j < s.length(); j++){
                    map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));

                    if(map[i][j] == 2){ // 출발
                        start = new Data(i, j);
                    }
                    if(map[i][j] == 3){ // 도착
                        end = new Data(i, j);
                    }
                }
            }

//            for(int i = 0; i < 100; i++){
//
//                for(int j = 0; j < 100; j++){
//                    System.out.printf("%d ", map[i][j]);
//                }
//                System.out.println();
//            }

            bfs(start.x, start.y);

            int ret = 0;
            if(flag)ret = 1;
            else ret = 0;

            System.out.println("#" + tc + " " + ret);
        }
    }

    static void bfs(int x, int y){
        Queue<Data> q = new ArrayDeque<>();
        q.add(new Data(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            x = q.peek().x; y = q.peek().y;
            q.poll();

            if(x == end.x && y == end.y)flag = true; //

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= 100 || ny < 0 || ny >= 100 || visited[nx][ny])continue; // 범위 || 방문

                if(map[nx][ny] == 1)continue; // 벽,

                q.add(new Data(nx, ny)); // push
                visited[nx][ny] = true; // visit
            }
        }

    }

    static class Data{
        int x;
        int y;

        public Data() {
        }

        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}