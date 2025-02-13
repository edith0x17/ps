import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static ArrayDeque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String s = br.readLine();
            go(s);
        }
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }

    public static void go(String s) {
        if (s.startsWith("push_front")) {
            int x = Integer.parseInt(s.split(" ")[1]);
            deque.addFirst(x);
        } else if (s.startsWith("push_back")) {
            int x = Integer.parseInt(s.split(" ")[1]);
            deque.addLast(x);
        } else if (s.equals("pop_front")) {
            sb.append(deque.isEmpty() ? "-1" : deque.pollFirst()).append("\n");
        } else if (s.equals("pop_back")) {
            sb.append(deque.isEmpty() ? "-1" : deque.pollLast()).append("\n");
        } else if (s.equals("size")) {
            sb.append(deque.size()).append("\n");
        } else if (s.equals("empty")) {
            sb.append(deque.isEmpty() ? "1" : "0").append("\n");
        } else if (s.equals("front")) {
            sb.append(deque.isEmpty() ? "-1" : deque.getFirst()).append("\n");
        } else if (s.equals("back")) {
            sb.append(deque.isEmpty() ? "-1" : deque.getLast()).append("\n");
        }
    }
}