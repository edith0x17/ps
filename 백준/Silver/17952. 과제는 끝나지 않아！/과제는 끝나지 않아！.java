import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static class A {
        int score;
        int time;

        public A(int score, int time) {
            super();
            this.score = score;
            this.time = time;
        }

    }

    static int n, ret;
    static Stack<A> stk = new Stack<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a, b, c;
            a = Integer.parseInt(st.nextToken());

            if (a == 0) {
                if (!stk.empty()) {

                    A temp = stk.peek();
                    temp.time--;

                    if (temp.time <= 0) { // check
                        ret += temp.score;
                        stk.pop();
                    }
                }

            } else {
                b = Integer.parseInt(st.nextToken()); // score
                c = Integer.parseInt(st.nextToken()); // time

                if (c - 1 <= 0) {
                    ret += b; // score
                } else {
                    stk.push(new A(b, c - 1));
                }

            }
        }

        System.out.println(ret);
    }

}