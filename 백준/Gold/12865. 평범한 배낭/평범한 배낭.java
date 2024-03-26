import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] weight = new int[104];
    static int[] value = new int[100004];
    static int[][] dp = new int[104][100004];

    /*

    d[n][k] = c
    n번째 물건까지 왔고,
    가방의 무게가 k일때,
    가방에 담긴 물건의 가치는 c

    */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++){

            for(int j = 1; j <= k; j++){

                if(j >= weight[i]){ // 담을 수 있다
                    dp[i][j] = Math.max(dp[i - 1][j - weight[i]] + value[i], dp[i - 1][j]); // 담는 경우, 담지 않는 경우
                }else dp[i][j] = dp[i - 1][j]; // 담을 수 없다
            }
        }

        System.out.println(dp[n][k]);
    }
}