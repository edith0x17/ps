import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    static int n;
    static int map[][];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i = 0; i < n; i++){

            String s = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

//        for(int i = 0; i < n; i++){
//            System.out.println(Arrays.toString(map[i]));
//        }

        go(n, 0, 0);

        System.out.println(sb);
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
            if(map[x][y] == 1){
                sb.append("1");
            }else{ // map[x][y] == 0
                sb.append("0");
            }

            return;
        }

        int halfS = s / 2;

        sb.append("(");

        go(halfS, x, y);
        go(halfS, x, y + halfS);
        go(halfS, x + halfS, y);
        go(halfS, x + halfS, y + halfS);

        sb.append(")");

    }
}

//((110(0101))(0010)1(0001))
//(((1)(1)(0)((0)(1)(0)(1)((0)(0)(1)(0)(1)((0)(0)(0)(1)