import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] a;
    static int sum = Integer.MAX_VALUE, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int temp = a[i] + a[j] + a[k];
                    if(temp > m)continue;
                    
                    if (sum > Math.abs(m - temp)) {
                        sum = Math.abs(m - temp);
                        answer = temp;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}