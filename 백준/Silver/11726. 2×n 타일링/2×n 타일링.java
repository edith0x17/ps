import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    final static int INF = 10007;
    static int n;
    static int[] dp = new int[1004];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // init
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        // logic
        for(int i = 4; i <= n; i++){
            dp[i] = ((dp[i - 1] % INF) + (dp[i - 2] % INF)) % INF;
        }
        System.out.println(dp[n]);
    }
}