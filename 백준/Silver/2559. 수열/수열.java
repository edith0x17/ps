import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, k, check, answer = Integer.MIN_VALUE;
    static int[] a, aSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        a = new int[n + 1];
        aSum = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            a[i] = Integer.parseInt(st.nextToken());
            aSum[i] = aSum[i - 1] + a[i];// 이전의 누적합 + 현재의 합 
        }
        for(int i = k; i <= n; i++){
            answer = Math.max(answer, aSum[i] - aSum[check++]);
        }
        sb.append(answer);
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}