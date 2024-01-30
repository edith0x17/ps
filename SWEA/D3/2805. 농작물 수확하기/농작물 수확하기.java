

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for (int t = 1; t <= TC; t++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            
            sc.nextLine(); // 개행문자 비우기

            for (int i = 0; i < n; i++) {
                String s = sc.nextLine();
                for (int j = 0; j < s.length(); j++) {
                    arr[i][j] = s.charAt(j) - '0';
                }
            }

            int ret = 0;
            int start = n / 2;
            int end = n / 2;

            for (int i = 0; i < n; i++) {
                for (int j = start; j <= end; j++) { // 행마다 가운데
                    ret += arr[i][j];
                }

                if (i < n / 2) { // 상
                    start -= 1; // 시작을 줄이고
                    end += 1; // 끝을 늘이고
                } else { // 하
                    start += 1; // 시작을 늘이고
                    end -= 1; // 끝을 줄이고
                }
            }

            System.out.println("#" + t + " " + ret);
        }
    }
}