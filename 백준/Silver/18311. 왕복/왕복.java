import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long k;
    static long[] a, aSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Long.parseLong(st.nextToken());
        a = new long[n + 1];
        aSum = new long[2 * (n + 1)];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= n; i++){
            aSum[i] = aSum[i - 1] + a[i];
        }
        int temp = 1;
        for(int i = n + 1; i <= 2 * n; i++){
            aSum[i] = aSum[i - 1] + a[i - temp];
            temp += 2;
        }
        temp = 1;
        for(int i = 1; i <= 2 * n; i++){
            if(k < aSum[i] && i <= n){
                System.out.println(i);
                break;
            }else if(k < aSum[i] && i > n){
                System.out.println(i - temp);
                break;
            }
            if(i > n)temp += 2;
        }
    }
}