import java.io.*;
import java.util.*;

public class Main {
    static int mi = Integer.MAX_VALUE, mx = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        go(s, 0);
        System.out.println(mi + " " + mx);
    }

    static void go(String s, int cnt) {
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) - '0') % 2 != 0) cnt++;
        }

        if (s.length() == 1) {
            mi = Math.min(mi, cnt);
            mx = Math.max(mx, cnt);
            return;
        } else if (s.length() == 2) {
            int temp = (s.charAt(0) - '0') + (s.charAt(1) - '0');
            go(Integer.toString(temp), cnt);
        } else { //2개
            //0 ~ i
            //i ~ j
            for (int i = 1; i < s.length(); i++) {
                for (int j = i + 1; j < s.length(); j++) {
                    int a = Integer.parseInt(s.substring(0, i));
                    int b = Integer.parseInt(s.substring(i, j));
                    int c = Integer.parseInt(s.substring(j));
                    int temp = a + b + c;
                    go(Integer.toString(temp), cnt);
                }
            }
        }
    }
}