import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static long m; // 인원수는 long으로 변경
    static long[] a; // 배열도 long으로 변경
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken()); // 인원수 입력을 long으로 받음
        a = new long[n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Long.parseLong(st.nextToken()); // 각 심사대 시간도 long으로 받음
        }
        
        Arrays.sort(a);
        long l = 0, r = a[n - 1] * m; // r의 범위를 long으로 변경
        
        while (l <= r) {
            long mid = (l + r) / 2; // 중간값도 long
            long sum = 0;
            
            for (int i = 0; i < n; i++) {
                sum += mid / a[i];
                if (sum >= m) break; // 오버플로우 방지를 위해 중간에 종료
            }
            
            if (sum >= m) {
                answer = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}