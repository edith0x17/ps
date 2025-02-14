import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static String s;
    static Stack<Character> stk = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {// < > 나올 경우
                while (!stk.isEmpty()) {
                    sb.append(stk.pop());
                }

                int idx = s.indexOf('>', i);
                for (int j = i; j <= idx; j++) {
                    sb.append(s.charAt(j));
                }
                i = idx;
            } else if (s.charAt(i) == ' ') { // 공백이 나올 경우
                while (!stk.isEmpty()) {
                    sb.append(stk.pop());
                }
                sb.append(' ');
            } else { // 
                stk.push(s.charAt(i));
            }
        }

        // 남은 문자 출력
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}