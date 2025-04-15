import java.io.*;
import java.util.*;

public class Main {
    static int x, n, answer1, answer2;
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        // 여러 테스트 케이스 처리
        while ((line = br.readLine()) != null) {
            x = Integer.parseInt(line) * 10000000;
            n = Integer.parseInt(br.readLine());
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(a);
            boolean flag = false;
            int left = 0, right = n - 1;

            while (left < right) {
                int sum = a[left] + a[right];
                if (sum == x) {
                    flag = true;
                    answer1 = a[left];
                    answer2 = a[right];
                    break;
                } else if (sum > x) {
                    right--;
                } else {
                    left++;
                }
            }

            if (flag) {
                System.out.println("yes " + answer1 + " " + answer2);
            } else {
                System.out.println("danger");
            }
        }
    }
}