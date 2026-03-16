import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            dq.offer(i);
        }
        st = new StringTokenizer(br.readLine());
        int answer = 0;
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            int idx = 0;
            for (int x : dq) {
                if (x == target) break;
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