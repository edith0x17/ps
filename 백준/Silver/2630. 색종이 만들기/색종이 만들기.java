import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, ansW, ansB;
    static int[][] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        a = new int[n + 4][n + 4];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        go(n, 0, 0);

        sb.append(ansW).append("\n").append(ansB);

        bw.write(sb + "");
        bw.flush();
        bw.close();
    }

    static boolean check(int s, int x, int y){
        int prev = a[x][y];

        for(int i = x; i < x + s; i++){
            for(int j = y; j < y + s; j++){
                if(prev != a[i][j])return false;
            }
        }
        return true;
    }

/*    void go(){
        탈출조건
        if(...){

        }

        분할정복
    }*/

    static void go(int s, int x, int y){
        if(check(s, x, y)){ // 모두 같은 색 O
            if(a[x][y] == 0)ansW++;
            else ansB++;
        }else{ // 모두 같은 색 X
            int halfS = s/ 2;

            go(halfS, x, y);
            go(halfS, x + halfS, y);
            go(halfS, x, y  + halfS);
            go(halfS, x + halfS, y + halfS);
        }
    }
}