import java.util.Arrays;
import java.util.Scanner;

public class Main{

    static int n, m;
    static int[] arr, sum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n + 1];
        sum = new int[n + 1];

        for(int i = 1; i <= n; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 1; i <= n; i++){
            sum[i] = sum[i - 1] + arr[i];
        }

        for(int i = 0; i < m; i++){
            int f= sc.nextInt();
            int t = sc.nextInt();

            System.out.println(sum[t] - sum[f - 1]);
        }
    }
}