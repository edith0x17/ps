import java.io.*;
import java.util.*;

public class Main {
    static int n, m, answer;
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            dq.offer(i + 1);
        }
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < m; k++) {
            int target = Integer.parseInt(st.nextToken());
            int idx = 0;
            for (int i : dq) {
                if (i == target) break;
                idx++;
            }

            if (idx <= dq.size() / 2) {//2번연산
                for (int j = 0; j < idx; j++) {
                    dq.offerLast(dq.pollFirst());
                    answer++;
                }
            } else {//3번연산
                for (int j = 0; j < dq.size() - idx; j++) {
                    dq.offerFirst(dq.pollLast());
                    answer++;
                }
            }
            dq.pollFirst();
        }
        System.out.println(answer);
    }
}