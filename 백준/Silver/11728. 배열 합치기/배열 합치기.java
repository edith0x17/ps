import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] a, b, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // BufferedWriter 선언
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n];
        b = new int[m];
        answer = new int[n + m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int aPointer = 0, bPointer = 0, cnt = 0;
        while (aPointer < n && bPointer < m) {
            if (a[aPointer] > b[bPointer]) {
                answer[cnt++] = b[bPointer];
                bPointer++;
            } else if (a[aPointer] < b[bPointer]) {
                answer[cnt++] = a[aPointer];
                aPointer++;
            } else { // a[aPointer] == b[bPointer]
                answer[cnt++] = a[aPointer];
                answer[cnt++] = b[bPointer];
                aPointer++;
                bPointer++;
            }
        }
        while (aPointer < n) {
            answer[cnt++] = a[aPointer];
            aPointer++;
        }
        while (bPointer < m) {
            answer[cnt++] = b[bPointer];
            bPointer++;
        }

        // 결과를 StringBuilder에 추가
        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i).append(" ");
        }

        // BufferedWriter로 출력
        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
    }
}