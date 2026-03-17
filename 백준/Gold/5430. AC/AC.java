import java.io.*;
import java.util.*;

public class Main {
    static int t, n;
    static String op, s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            op = br.readLine();
            n = Integer.parseInt(br.readLine());
            s = br.readLine();
            s = s.substring(1, s.length() - 1);
            Deque<Integer> dq = new ArrayDeque<>();
            if (n > 0) {
                String[] ss = s.split(",");
                for (String x : ss) {
                    dq.offer(Integer.parseInt(x));
                }
            }
            boolean flag = false, flag2 = false;
            for (int i = 0; i < op.length(); i++) {
                if (op.charAt(i) == 'R') {
                    flag = !flag;
                } else {
                    if (dq.isEmpty()) {
                        flag2 = true;
                        System.out.println("error");
                        break;
                    }

                    if (!flag) dq.pollFirst();
                    else dq.pollLast();
                }
            }

            if (!flag2) {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                if (!dq.isEmpty()) {
                    if (!flag) {
                        while (!dq.isEmpty()) {
                            sb.append(dq.pollFirst());
                            if (!dq.isEmpty()) sb.append(",");
                        }
                    } else {
                        while (!dq.isEmpty()) {
                            sb.append(dq.pollLast());
                            if (!dq.isEmpty()) sb.append(",");
                        }
                    }
                }
                sb.append("]");
                System.out.println(sb.toString());
            }
        }
    }
}