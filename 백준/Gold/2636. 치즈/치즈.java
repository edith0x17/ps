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

    static final int dx[] = {-1, 0, 1, 0};
    static final int dy[] = {0, 1, 0, -1};

    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m;
    static int[][] a;
    static boolean[][] visited;
    static ArrayList<Data> adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n][m];
        visited = new boolean[n][m];
        adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cntTime = 0, cntLast = 0;
        while(true){
            // init
            visited = new boolean[n][m];
            adj.clear();
            cntLast = 0;
            
            go(0, 0);

            for(Data d: adj){
                a[d.x][d.y] = 0;
                cntLast++;
            }
            cntTime++;

            boolean flag = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (a[i][j] == 1)flag = true;
                }
            }

            if (!flag)break;
        }

        sb.append(cntTime + "\n" + cntLast);

        bw.write(sb + "");
        bw.flush();
        bw.close();
    }

    static void go(int x, int y){
        visited[x][y] = true;

        if(a[x][y] == 1){
            adj.add(new Data(x, y));
            return;
        }

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny])continue; // 방문 || 범위

            go(nx, ny);
        }
    }
}