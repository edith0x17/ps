import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    static int n;
    static int cntW, cntB;
    static int[][] map;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        go(n, 0, 0);

        System.out.println(cntW);
        System.out.println(cntB);

    }

    static boolean check(int s, int x, int y){

        int prev = map[x][y];

        for(int i = x; i < x + s; i++){

            for(int j = y; j < y + s; j++){
                if(prev != map[i][j])return false;
            }
        }

        return true;
    }
    static void go(int s, int x, int y){

        if(check(s, x, y)){
            if(map[x][y] == 1)cntB++;
            else cntW++;

            return;
        }

        int halfS = s / 2;

        go(halfS, x, y);
        go(halfS, x, y + halfS);
        go(halfS, x + halfS, y);
        go(halfS, x + halfS, y + halfS);
    }
}