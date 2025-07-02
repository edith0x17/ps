import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] numbers;
    static Character[] operators;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n / 2 + 1];
        operators = new Character[n / 2];
        int idx1 = 0, idx2 = 0;
        String s = br.readLine();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (i % 2 == 0) numbers[idx1++] = ch - '0';
            else operators[idx2++] = ch;
        }
        go(0, numbers[0]);
        System.out.println(answer);
    }

    static int oper(char a, int b, int c) {
        if (a == '+') return b + c;
        if (a == '-') return b - c;
        if (a == '*') return b * c;
        return 0;
    }

    static void go(int here, int sum) {
        if (here == numbers.length - 1) {
            answer = Math.max(answer, sum);
            return;
        }
        // 1.
        go(here + 1, oper(operators[here], sum, numbers[here + 1]));
        // 2.
        if (here + 2 <= numbers.length - 1) {
            int temp = oper(operators[here + 1], numbers[here + 1], numbers[here + 2]);
            go(here + 2, oper(operators[here], sum, temp));
        }
    }
}