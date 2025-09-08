import java.io.*;
import java.util.*;

public class Main {
    static int a, t, c;
    static char ch;
    static int n = 1;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = Integer.parseInt(br.readLine());
        t = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());
        if (c == 0) ch = 'A';
        else ch = 'B';
        int p = 0;  // 사람 번호

        while (true) {
            String s = "ABAB";
            for (int i = 0; i < n + 1; i++) s += "A";
            for (int i = 0; i < n + 1; i++) s += "B";

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ch) {
                    cnt++;
                    if (cnt == t) {
                        System.out.println(p);
                        return;
                    }
                }
                p++;
                if (p >= a) p = 0;
            }

            n++;
        }
    }
}