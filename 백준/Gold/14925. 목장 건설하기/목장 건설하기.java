import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] map, dp;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n + 4][m + 4];
        dp = new int[n + 4][m + 4];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 0)map[i][j] = 1;
                else map[i][j] = 0;
            }
        }
        int answer = -1;
        // 1 - based
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(i ==0 || j == 0){
                    dp[i][j] = map[i][j];
                }else{
                    if(map[i][j] == 1){
                        dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]) + 1;
                    }
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }
        sb.append(answer);
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}