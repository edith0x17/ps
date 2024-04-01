import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{

    static int t;
    static int n, r;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= t; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            long ret = nCr(n, r, 1234567891);
            System.out.println("#" + tc + " " + ret);
        }
    }
    static long power(long x, long y, long p){
        long res = 1L;
        x = x % p;

        while(y > 0){
            if(y % 2 == 1)res = (res * x) % p;

            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }
    static long nCr(int n, int r, int p){
        if(r == 0)return 1L;

        long[] fac = new long[n + 1];
        fac[0] = 1;

        for(int i = 1; i <= n; i++)
            fac[i] = fac[i - 1] * i % p;

        return (fac[n] * power(fac[r], p - 2, p)) % p * power(fac[n - r], p - 2, p) % p %p;
    }
}