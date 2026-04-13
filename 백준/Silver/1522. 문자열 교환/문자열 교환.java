import java.io.*;
import java.util.*;

public class Main {
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        int aCnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') aCnt++;
        }
        int bCnt = 0, ans = 0;
        for (int i = 0; i < aCnt; i++) {
            if (str.charAt(i) == 'b') bCnt++;
        }
        ans = bCnt;
        str = str + str;
        int l = 0;
        for (int i = aCnt; i < str.length(); i++) {
            if (str.charAt(l++) == 'b') bCnt--;//왼
            if (str.charAt(i) == 'b') bCnt++;//오
            ans = Math.min(ans, bCnt);
        }
        System.out.println(ans);
    }
}