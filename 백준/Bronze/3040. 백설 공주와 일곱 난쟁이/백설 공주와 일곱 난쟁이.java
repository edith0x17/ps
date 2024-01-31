import java.util.Arrays;
import java.util.Scanner;

public class Main{

    static int n;
    static int[] arr, ret;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        arr = new int[9];
        ret = new int[2];

        for(int i = 0; i < 9; i++){
            arr[i] = sc.nextInt();
        }

//        System.out.println(Arrays.toString(arr));

        go(0, 0);

    }

    static void go(int cnt, int start){
        if(cnt == 2){
//            System.out.println(Arrays.toString(ret));
            check();
            return;
        }

        for(int i = start; i < 9; i++){
            ret[cnt] = i;
            go(cnt + 1, i + 1);
        }
    }

    static void check(){
        int sum = 0;

        for(int i = 0; i < 9; i++){
            if(i == ret[0] || i == ret[1]){ // idx
                continue;
            }else{
                sum += arr[i];
            }
        }

        if(sum == 100){
            for(int i = 0; i < 9; i++){
                if(i == ret[0] || i == ret[1]){ // idx
                    continue;
                }else{
                    System.out.println(arr[i]);
                }
            }

        }

    }
}