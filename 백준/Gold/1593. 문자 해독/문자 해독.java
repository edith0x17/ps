import java.io.*;
import java.util.*;

public class Main {
    static int g, s;
    static String W, S;
    static int[] wCount = new int[52];
    static int[] sCount = new int[52];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        g = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        W = br.readLine();
        S = br.readLine();
        for (int i = 0; i < g; i++) {
            wCount[getIndex(W.charAt(i))]++;
        }
        for (int i = 0; i < g; i++) {
            sCount[getIndex(S.charAt(i))]++;
        }

        int answer = 0;
        if (Arrays.equals(wCount, sCount)) {
            answer++;
        }
        
        for (int i = g; i < s; i++) {
            // 뒤
            sCount[getIndex(S.charAt(i - g))]--;
            // 앞
            sCount[getIndex(S.charAt(i))]++;
            // 비교
            if (Arrays.equals(wCount, sCount)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    // 대소문자 구분한 알파벳 인덱스 매핑
    static int getIndex(char c) {
        if (Character.isUpperCase(c)) {
            return c - 'A'; // 0 ~ 25
        } else {
            return c - 'a' + 26; // 26 ~ 51
        }
    }
}