import java.io.*;
import java.util.ArrayList;
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

    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int w, h;
    static int[][] a, visited;
    static int ret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        while(true){
            st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            a = new int[h][w];
            visited = new int[h][w];

            ret = 0;

            if(w == 0 && h == 0)break;

            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    a[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(a[i][j] == 1 && visited[i][j] != 1){
                        dfs(i, j);
                        ret++;
                    }
                }
            }

            sb.append(ret + "\n");
        }

        bw.write(sb + "");
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y){
        visited[x][y] = 1;
        for(int i = 0; i < 8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= h || ny < 0 || ny >= w )continue;

            if(a[nx][ny] == 1 && visited[nx][ny] != 1){
                dfs(nx, ny);
            }
        }
    }
}