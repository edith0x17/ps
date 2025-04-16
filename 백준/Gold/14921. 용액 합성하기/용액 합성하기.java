import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        int l = 0, r = n - 1;
        int bestSum = Integer.MAX_VALUE;
        int answer = Integer.MAX_VALUE;
        while (l < r) {
            int sum = a[l] + a[r];
            int abs = Math.abs(sum);
            if (abs < bestSum) {
                bestSum = abs;
                answer = sum; // 지금까지 중 0에 가장 가까움
            }
            // 포인터 이동 조건
            if (sum > 0) {
                r--; // 합이 양수 → 너무 큼 → 더 작게 만들기
            } else {
                l++; // 합이 음수 → 너무 작음 → 더 크게 만들기
            }
        }
        System.out.println(answer);
    }
}