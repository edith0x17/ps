import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] a;
    static int answer = Integer.MAX_VALUE;
    static ArrayList<Integer> A, B;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        a = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int S = (1 << n);
        for(int i = 0; i < S; i++){
            // init
            A = new ArrayList<>();
            B = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if((i & (1 << j)) != 0){// on
                    A.add(j);
                }else{// off
                    B.add(j);
                }
            }
            // logic
            answer = Math.min(answer, Math.abs(goA() - goB()));
        }
        System.out.println(answer);
    }
    static int goA(){
        int ret = 0;
        for(int i = 0; i < A.size(); i++){
            for(int j = i + 1; j < A.size(); j++){
                ret += a[A.get(i)][A.get(j)] + a[A.get(j)][A.get(i)];
            }
        }
        return ret;
    }
    static int goB(){
        int ret = 0;
        for(int i = 0; i < B.size(); i++){
            for(int j = i + 1; j < B.size(); j++){
                ret += a[B.get(i)][B.get(j)] + a[B.get(j)][B.get(i)];
            }
        }
        return ret;
    }
}