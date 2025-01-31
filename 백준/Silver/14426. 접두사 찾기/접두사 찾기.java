import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, answer;
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr);
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid].startsWith(s)) { // 접두사 검사
                    answer++;
                    break;
                }

                if (s.compareTo(arr[mid]) < 0) { // s < arr[mid] → 왼쪽 탐색
                    right = mid - 1;
                } else if (s.compareTo(arr[mid]) > 0) { // s > arr[mid] → 오른쪽 탐색
                    left = mid + 1;
                }
            }
        }
        sb.append(answer);
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}