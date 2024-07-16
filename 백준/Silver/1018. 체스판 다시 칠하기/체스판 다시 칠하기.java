import java.io.*;
import java.util.StringTokenizer;

public class Main{

    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m;
    static boolean[][] a;
    static int ret = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new boolean[n][m];

        for(int i = 0; i < n; i++){
            String s = "";
            s = br.readLine();
            for(int j = 0; j < m; j++){
                if(s.charAt(j) == 'W')a[i][j] = true; //W
                else a[i][j] = false; //B
            }
        }

        for(int i = 0; i <= n - 8; i++){
            for(int j = 0; j <= m - 8; j++){
                ret = Math.min(ret, go(i, j));
            }
        }

        sb.append(ret);

        bw.write(sb + "");
        bw.flush();
        bw.close();
    }

    static int go(int x, int y){
        int cnt = 0;
        boolean check = a[x][y]; //W

        for(int i = x; i < x + 8; i++){
            for(int j = y; j < y + 8; j++){
                if(check != a[i][j])cnt++;

                check = !check; //BWBW
            }
            check = !check; //WBWB, 반대로
        }

        return Math.min(cnt, 64 - cnt);
    }
}