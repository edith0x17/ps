import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int r, c;
    static int[][] a;
    static boolean[] visited;
    static int ret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        a = new int[r][c];
        visited = new boolean[26];

        for(int i = 0; i < r; i++){
            String s = br.readLine();
            for(int j = 0; j < c; j++){
                a[i][j] = s.charAt(j) - 'A'; // 0에서 25까지...
            }
        }

        visited[a[0][0]] = true;
        go(0, 0, 1);

        sb.append(ret);

        bw.write(ret + "");
        bw.flush();
        bw.close();
    }

    static void go(int x, int y, int cnt){
        ret = Math.max(ret, cnt);

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= r || ny < 0 || ny >= c)continue;

            int next = a[nx][ny];
            if(!visited[next]){
                visited[next] = true;
                go(nx, ny, cnt + 1);
                visited[next] = false;
            }
        }
    }
}