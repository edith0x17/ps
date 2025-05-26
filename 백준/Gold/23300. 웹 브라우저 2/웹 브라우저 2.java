import java.io.*;
import java.util.*;

public class Main {
    static int n, Q, here = -1;
    static Stack<Integer> backStk = new Stack<>();
    static Stack<Integer> frontStk = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if (s.equals("B")) {
                if (backStk.isEmpty()) continue;
                frontStk.push(here);
                here = backStk.pop();
            } else if (s.equals("F")) {
                if (frontStk.isEmpty()) continue;
                backStk.push(here);
                here = frontStk.pop();
            } else if (s.equals("C")) {
                ArrayList<Integer> adj = new ArrayList<>();
                while (!backStk.isEmpty()) {
                    adj.add(backStk.pop());
                }
                Collections.reverse(adj);
                Stack<Integer> newBack = new Stack<>();
                int prev = -1;
                for (int x : adj) {
                    if (x != prev) {
                        newBack.push(x);
                        prev = x;
                    }
                }
                backStk = newBack;
            } else if (s.equals("A")) {
                int x = Integer.parseInt(st.nextToken());
                if (here != -1) backStk.push(here);  // ✅ 핵심 수정
                here = x;
                frontStk.clear();
            }
        }

        // 출력
        System.out.println(here);

        if (backStk.isEmpty()) {
            System.out.println(-1);
        } else {
            List<Integer> list = new ArrayList<>(backStk);
            Collections.reverse(list);
            for (int x : list) System.out.print(x + " ");
            System.out.println();
        }

        if (frontStk.isEmpty()) {
            System.out.println(-1);
        } else {
            List<Integer> list = new ArrayList<>(frontStk);
            Collections.reverse(list);
            for (int x : list) System.out.print(x + " ");
            System.out.println();
        }
    }
}