import java.io.*;
import java.util.*;

public class Main {
    static Map<Character, int[]> mpLeft = new HashMap<>();
    static Map<Character, int[]> mpRight = new HashMap<>();
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        mpLeft.put('q', new int[]{0, 0});
        mpLeft.put('w', new int[]{0, 1});
        mpLeft.put('e', new int[]{0, 2});
        mpLeft.put('r', new int[]{0, 3});
        mpLeft.put('t', new int[]{0, 4});

        mpLeft.put('a', new int[]{1, 0});
        mpLeft.put('s', new int[]{1, 1});
        mpLeft.put('d', new int[]{1, 2});
        mpLeft.put('f', new int[]{1, 3});
        mpLeft.put('g', new int[]{1, 4});

        mpLeft.put('z', new int[]{2, 0});
        mpLeft.put('x', new int[]{2, 1});
        mpLeft.put('c', new int[]{2, 2});
        mpLeft.put('v', new int[]{2, 3});

        mpRight.put('y', new int[]{0, 1});
        mpRight.put('u', new int[]{0, 2});
        mpRight.put('i', new int[]{0, 3});
        mpRight.put('o', new int[]{0, 4});
        mpRight.put('p', new int[]{0, 5});

        mpRight.put('h', new int[]{1, 1});
        mpRight.put('j', new int[]{1, 2});
        mpRight.put('k', new int[]{1, 3});
        mpRight.put('l', new int[]{1, 4});

        mpRight.put('b', new int[]{2, 0});
        mpRight.put('n', new int[]{2, 1});
        mpRight.put('m', new int[]{2, 2});

        StringTokenizer st = new StringTokenizer(br.readLine());
        char leftStart = st.nextToken().charAt(0);
        char rightStart = st.nextToken().charAt(0);
        String s = br.readLine();

        int[] Lpos = mpLeft.get(leftStart);
        int[] Rpos = mpRight.get(rightStart);

        int lx = Lpos[0], ly = Lpos[1];
        int rx = Rpos[0], ry = Rpos[1];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (mpRight.containsKey(ch)) { //오른손
                int[] to = mpRight.get(ch);
                answer += dist(rx, ry, to[0], to[1]) + 1;
                rx = to[0];
                ry = to[1];
            } else { //왼손
                int[] to = mpLeft.get(ch);
                answer += dist(lx, ly, to[0], to[1]) + 1;
                lx = to[0];
                ly = to[1];
            }
        }
        System.out.println(answer);
    }

    static int dist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}