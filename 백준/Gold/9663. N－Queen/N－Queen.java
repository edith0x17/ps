import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {

    static int n, ret;
    static boolean[] ch = new boolean[104];
    static boolean[] ch1 = new boolean[104];
    static boolean[] ch2 = new boolean[104];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        go(0);

        System.out.println(ret);
    }

    static void go(int idx){

        if(idx == n){
            ret++;
            return;
        }

        for(int j = 0; j < n; j++){

            if(ch[j])continue; // idx -> row, j -> col, => one column one queen
            if(ch1[idx + j])continue;
            if(ch2[idx - j + n])continue;

            ch[j] = true; // idx -> row, j -> col, => one column one queen
            ch1[idx + j] = true;
            ch2[idx - j + n] = true;

            go(idx + 1);

            ch[j] = false; // idx -> row, j -> col, => one column one queen
            ch1[idx + j] = false;
            ch2[idx - j + n] = false;
        }
    }
}