import java.io.*;
import java.util.*;

public class Main {
    static int m, idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder(s);
        m = Integer.parseInt(br.readLine());
        idx = s.length();
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = null;
            if (A.equals("P")) {
                B = st.nextToken();
            }

            if (A.equals("L")) {
                if (idx == 0) idx = 0;
                else idx = idx - 1;
            } else if (A.equals("D")) {
                if (idx == sb.length()) idx = sb.length();
                else idx = idx + 1;
            } else if (A.equals("B")) {
                if (idx != 0) {
                    idx = idx - 1;
                    sb.deleteCharAt(idx);
                }
            } else {//P $
                sb.insert(idx, B);
                idx = idx + 1;
            }
        }
        System.out.println(sb);
    }
}