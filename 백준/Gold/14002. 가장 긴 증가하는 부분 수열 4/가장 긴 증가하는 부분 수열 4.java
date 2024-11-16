import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[] a, trace;
    static ArrayList<Integer> lis = new ArrayList<>();
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        trace = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        lis.add(a[0]);
        trace[0] = 0;

        for (int i = 1; i < n; i++) {
            if (a[i] > lis.get(lis.size() - 1)) {
                lis.add(a[i]);
                trace[i] = lis.size() - 1;
            } else {
                int pos = Collections.binarySearch(lis, a[i]);
                if (pos < 0) pos = -(pos + 1);
                lis.set(pos, a[i]);
                trace[i] = pos;
            }
        }

        // LIS 복원
        int len = lis.size();
        for (int i = n - 1; i >= 0; i--) {
            if (trace[i] == len - 1) {
                answer.add(a[i]);
                len--;
            }
        }
        Collections.reverse(answer); // 역순 복원

        // 결과 출력
        sb.append(answer.size()).append("\n");
        for (int x : answer) {
            sb.append(x).append(" ");
        }
        System.out.println(sb);
    }
}