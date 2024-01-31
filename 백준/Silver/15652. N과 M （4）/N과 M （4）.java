import java.util.Scanner;

public class Main{

    static int n, m;
    static int[] ret;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        ret = new int[m];

//        go(int cnt, int start);
        go(0, 1);
    }

    static void go(int cnt, int start){
        if(cnt == m){
            for(int num: ret){
                System.out.printf("%d ", num);
            }
            System.out.println();
            return;
        }

        for(int i = start; i <= n; i++){
            ret[cnt] = i;
            go(cnt + 1, i);
        }

    }
}