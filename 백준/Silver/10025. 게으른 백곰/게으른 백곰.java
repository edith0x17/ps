import java.io.*;
import java.util.*;

public class Main{
    static int n, k, maxIdx = Integer.MIN_VALUE, answer = -1;
    static int[] a = new int[1_000_001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            a[x] = g;
            maxIdx = Math.max(maxIdx, x);
        }
        int sum = 0;
        int windowSize = 2 * k + 1;
        for(int i = 0; i <= maxIdx; i++){
            if(i >= windowSize){
                sum -= a[i - windowSize];
            }

            sum += a[i];
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }
}