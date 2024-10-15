import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{

    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static boolean[][] a;
    static int answer = 54 * 54;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new boolean[n + 4][m + 4];
        for(int i = 0; i < n; i++){
            String temp = br.readLine();
            for(int j = 0; j < m; j++){
                if(temp.charAt(j) == 'W')a[i][j] = false;
                else a[i][j] = true;
            }
        }
        for(int i = 0; i <= n - 8; i++){
            for(int j = 0; j <= m - 8; j++){
                answer = Math.min(answer, check(i, j));
            }
        }
        sb.append(answer);
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
    static int check(int x, int y){
        int cnt = 0;
        boolean check = a[x][y];
        for(int i = x; i < x + 8; i++){
            for(int j = y; j < y + 8; j++){
                if(check != a[i][j])cnt++;// 예상하는 결과값 다를 시 cnt++
                check = !check;// B -> W, W -> B
            }
            check = !check;// ...
        }
        return Math.min(cnt, 64 - cnt);
    }
}