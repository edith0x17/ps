import java.util.Scanner;

public class Solution {
    
    static int n, m;
    static int[][] a;
    static int ret = -987654321;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            n = sc.nextInt();
            m = sc.nextInt();

            ret = -987654321;

            a = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.printf("%d ", a[i][j]);
//                }
//                System.out.println();
//            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    solve(i, j);
                }
            }

            System.out.println("#" + tc + " " + ret);
        }
    }

    static void solve(int x, int y) {

        int sum = 0;

        for(int i = x; i < x + m; i++){
            for(int j = y; j < y + m; j++){
                if(i < 0 || i >= n || j < 0 || j >= n)continue; // 범위 체크
                sum += a[i][j];
            }
        }

        ret = Math.max(ret, sum);
    }
}
