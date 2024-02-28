import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // nCk
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- != 0){
            int K = sc.nextInt();
            int N = sc.nextInt();

            int[][] B = new int[N + 1][K + 1];

            for (int i = 0; i <= N; i++) {
                for (int j = 0; j <= Math.min(i, K); j++) { // ME

                    if (j == 0 || j == i) B[i][j] = 1;
                        // nCk = (n - 1)Ck - 1 + (n - 1)Ck
                    else B[i][j] = B[i - 1][j - 1] + B[i - 1][j];
                }
            }

            System.out.println(B[N][K]);
        }
    }
}