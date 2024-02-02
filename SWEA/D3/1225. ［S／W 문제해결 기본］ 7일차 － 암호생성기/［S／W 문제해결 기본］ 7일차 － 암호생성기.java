

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = 10;

        for (int tc = 1; tc <= 10; tc++) {

            int kkk  = sc.nextInt();

            Queue<Integer> q = new ArrayDeque<>();

            for (int i = 0; i < 8; i++) {
                int temp = sc.nextInt();
                q.offer(temp);
            }

            int cnt = 0;
            while (true) {
                cnt++;

                if (cnt == 6)
                    cnt = 1;

                int out = q.poll();

                if (out - cnt <= 0) {
                    q.offer(0);
                    break;
                } else {
                    out = out - cnt;
                    q.offer(out);
                }



            }

            System.out.print("#" + tc + " ");
            while (q.size() != 0) {
                System.out.printf("%d ", q.poll());
            }
            System.out.println();
        }
    }
}