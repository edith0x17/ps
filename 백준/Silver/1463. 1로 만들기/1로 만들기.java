import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

// 화폐단위 1, 4, 6
public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] D = new int[N + 1];

        D[0] = 0;
        D[1] = 0;

        for(int i = 2; i <= N; i++){
            int min = D[i - 1] + 1;

            if(i % 3 == 0) min = Math.min(D[i / 3] + 1, min);

            if(i % 2 == 0) min = Math.min(D[i / 2] + 1, min);


            D[i] = min;
        }

//        System.out.println(Arrays.toString(D));

        bw.write(D[N] +"");
        bw.flush();

        bw.close();
        br.close();
    }
}