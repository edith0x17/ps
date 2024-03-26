import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    static int n, k;
    static int[] w = new int[104];
    static int[] v = new int[100004];
    static int[][] dp = new int[104][100004];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        /*
            dp[i][j] = k
            i번째 물건
            가방의 무게 j
            가치의 합 k
        */

        for(int i = 1; i <= n; i++){

            for(int j = 1; j <= k; j++){

                if(j >= w[i]){ // 담을 수 있는 경우
                    dp[i][j] = Math.max(dp[i - 1][j - w[i]] + v[i], dp[i - 1][j]); // 담는 경우 || 담지 않는 경우
                }else dp[i][j] = dp[i - 1][j]; // 담을 수 없는 경우 
            }
        }

        System.out.println(dp[n][k]);

    }
}