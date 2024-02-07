import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] a = new int[100][100];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for(int k = 0; k < n; k++){
            int y, x;
            StringTokenizer st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());

            // x행 y열
            for(int i = x; i < x + 10; i++ ){
                for(int j = y; j < y + 10; j++){
                    if(i < 0 || i >= 100 || j < 0 || j >= 100)continue;

                    a[i][j] = 1;
                }
            }
        }

        int ret = 0;
        for(int i = 0; i < 100; i++ ){
            for(int j = 0; j < 100; j++){
                ret += a[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ret).append('\n');
        System.out.println(sb);
//        System.out.println(ret);
    }
}
