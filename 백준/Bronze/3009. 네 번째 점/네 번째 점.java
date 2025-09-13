import java.io.*;
import java.util.*;

public class Main {
    static int[][] a = new int[3][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }
        int x = a[0][0] ^ a[1][0] ^ a[2][0];
        int y = a[0][1] ^ a[1][1] ^ a[2][1];
        System.out.println(x + " " + y);
    }
}