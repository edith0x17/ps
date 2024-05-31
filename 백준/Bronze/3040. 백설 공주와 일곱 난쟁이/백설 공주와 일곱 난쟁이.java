import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int[] a = new int[9];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int sum = 0;
        for(int i = 0; i < 9; i++){
            a[i] = Integer.parseInt(br.readLine());
            sum += a[i];
        }

        Arrays.sort(a);

        int A = -1, B = -1;
        boolean flag = false;
        for(int i = 0; i < 9; i++){
            for(int j = i + 1; j < 9; j++){
                int tempSum = sum;
                tempSum = tempSum - a[i];
                tempSum = tempSum - a[j];

                if(tempSum == 100){
                    A = i;
                    B = j;
                    flag = true;
                    break;
                }
            }
            if(flag)break;
        }

        for(int i = 0; i < 9; i++){
            if(i == A || i == B)continue;
            else sb.append(a[i]).append('\n');
        }

        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}