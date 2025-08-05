import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int cnt = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') cnt++;
            else {
                if (check(cnt)) {
                    sb.append(".");
                    flag = true;
                    cnt = 0;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        if (check(cnt)) {
            flag = true;
            cnt = 0;
        } else {
            flag = false;
        }

        if(flag) System.out.println(sb);
        else System.out.println(-1);
    }

    static boolean check(int cnt) {
        int A = cnt / 4;
        int B = cnt % 4;
//        System.out.println("A = " + A);
//        System.out.println("B = " + B);
        if (B % 2 == 0) {
            for (int i = 0; i < A; i++) {
                sb.append("AAAA");
            }
            for (int i = 0; i < B/ 2; i++) {
                sb.append("BB");
            }
            return true;
        }else return false;
    }
}