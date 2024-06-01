import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean flag = false;
    static int N, Q, now = -1;
    static Stack<Integer> back = new Stack<>();
    static Stack<Integer> front = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "B":
                    if (!back.isEmpty()) {
                        front.push(now);
                        now = back.pop();
                    }
                    break;

                case "A":
                    int num = Integer.parseInt(st.nextToken());

                    front.clear();
                    if (flag) {
                        back.push(now);
                    } else {
                        flag = true;
                    }

                    now = num;
                    break;
                case "F":
                    if (!front.isEmpty()) {
                        back.push(now);
                        now = front.pop();
                    }
                    break;

                case "C":
                    go();
                    break;

                default:
                    bw.write("Invalid command\n");
                    break;
            }
        }

        // Print current page
        if (now != -1) {
            sb.append(now).append("\n");
        } else {
            sb.append("-1\n");
        }

        // Print back stack
        if(!back.isEmpty()) {
            while (!back.isEmpty()) {
                sb.append(back.peek()).append(" ");
                back.pop();
            }
            sb.append("\n");
        }else sb.append("-1\n");

        // Print front stack
        if(!front.isEmpty()) {
            while (!front.isEmpty()) {
                sb.append(front.peek()).append(" ");
                front.pop();
            }
            sb.append("\n");
        }else sb.append("-1\n");

        bw.write(sb + "");
        bw.flush();
        bw.close();
    }

    static void go() {
        List<Integer> tempList = new ArrayList<>();
        int prev = 0;
        while (!back.isEmpty()) {
            if (prev == back.peek()) {
                back.pop();
                continue;
            }
            tempList.add(back.peek());

            prev = back.peek();
            back.pop();
        }

        Collections.reverse(tempList);

        for (int i = 0; i < tempList.size(); i++) {
            back.push(tempList.get(i));
        }
    }
}