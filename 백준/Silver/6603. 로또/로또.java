import java.util.Scanner;

public class Main{

    static int k;
    static int[] arr, ret;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            k = sc.nextInt();

            if(k == 0)break;

            arr = new int[k + 4];
            ret = new int[6];

            for(int i = 1; i <= k; i++){
                arr[i] = sc.nextInt();
            }

            go(0, 1);

            System.out.println();
        }
    }

    static void go(int cnt, int start){
        if(cnt == 6){
            for(int idx: ret){
                System.out.printf("%d ", arr[idx]);
            }
            System.out.println();
            return;
        }

        for(int i = start; i <= k; i++){
            ret[cnt] = i;
            go(cnt + 1, i + 1);
        }
    }
}