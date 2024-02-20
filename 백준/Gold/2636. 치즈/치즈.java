import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static ArrayList<Data> arrayList = new ArrayList<>();
    static int[][] a;
    static boolean[][] visited;
    static int cntTime, cntLast;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n][m];

        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            arrayList.clear();
            visited = new boolean[n][m];
            cntLast = 0;

            dfs(0, 0);

            for(Data d: arrayList){ // 치즈 녹이기
                a[d.x][d.y] = 0;
                cntLast++;
            }

            boolean flag = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (a[i][j] != 0) flag = true; // 치즈 O
                }
            }

            cntTime++;
            if(!flag)break; // 치즈 X
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cntTime).append('\n').append(cntLast);
        System.out.println(sb);

//        System.out.println(cntTime);
//        System.out.println(cntLast);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        if(a[x][y] == 1){ // 치즈 -> 넣기
            arrayList.add(new Data(x, y));
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) continue;

            dfs(nx, ny);
        }
    }

    static class Data{ // pair
        int x;
        int y;

        public Data() {
        }

        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}