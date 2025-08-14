import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s.length() % 5 != 0) { System.out.println(-1); return; }

        int[] stage = new int[4]; //q,u,a,c 대기 수
        int active = 0, maxActive = 0;
        boolean seenQ = false;
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case 'q':
                    stage[0]++; active++; maxActive = Math.max(maxActive, active);
                    seenQ = true;
                    break;
                case 'u':
                    if (stage[0] == 0) { System.out.println(-1); return; } //전단계 만족 빼기
                    stage[0]--; stage[1]++; break;
                case 'a':
                    if (stage[1] == 0) { System.out.println(-1); return; } //전단계 만족 빼기
                    stage[1]--; stage[2]++; break;
                case 'c':
                    if (stage[2] == 0) { System.out.println(-1); return; } //전단계 만족 빼기
                    stage[2]--; stage[3]++; break;
                case 'k':
                    if (stage[3] == 0) { System.out.println(-1); return; } //전단계 만족 빼기
                    stage[3]--; active--; break;
                default:
                    System.out.println(-1); return;
            }
        }
        if (!seenQ || active != 0) { System.out.println(-1); return; }
        System.out.println(maxActive);
    }
}