import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int N, M, ret = Integer.MAX_VALUE;
    static int[] app;
    static int[] cost;
    static int[][] dp = new int[104][10004]; // 1 ≤ N ≤ 100, 0 ≤ c1, ..., cN ≤ 100
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        app = new int[N + 1];
        cost = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            app[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++){

            for(int j = 0; j <= 10000; j++){

                if(cost[i] > j){ // 앱 종료 비용 > 비용
                    dp[i][j] = dp[i - 1][j]; // 갱신 X
                }else{ // 앱 종료 비용 <= 비용
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost[i]] + app[i]); // max(갱신 X, 갱신 O)
                    if(dp[i][j] >= M){
                        ret = Math.min(ret, j);
                    }
                }
            }
        }

        System.out.println(ret);
    }
}