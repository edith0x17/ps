import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
class Data{

    int x;
    int y;

    public Data(){

    }
    public Data(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static boolean flag;
    static boolean check1[][] = new boolean[104][104]; // 행
    static boolean check2[][] = new boolean[104][104]; // 열
    static boolean check3[][] = new boolean[104][104]; // ㅁ -> (i/ 3) * 3 + (j/ 3)
    static int[][] a = new int[9][9];
    static ArrayList<Data> vv = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 9; i++){
            String s = br.readLine();
            for(int j = 0; j < 9; j++){
                a[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));

                int value = a[i][j];
                if(value == 0){ // 0인 지점 O
                    vv.add(new Data(i, j));
                }else{ // 0인 지점 X
                    check1[i][value] = true; // 행
                    check2[j][value] = true; // 열
                    int idx = (i/ 3) * 3 + (j/ 3);
                    check3[idx][value] = true;
                }
            }
        }

        solve(0);
    }

    static void solve(int depth){
        if(depth == vv.size()){
            flag = true;
            print();
            return;
        }

        int x = vv.get(depth).x; int y = vv.get(depth).y;
        for(int i = 1; i<= 9; i++){
            if(check1[x][i])continue; // 행 체크
            if(check2[y][i])continue; // 열 체크
            int sum = (x / 3) * 3 + (y / 3);
            if(check3[sum][i])continue; // ㅁ 체크

            a[x][y] = i;
            check1[x][i] = true;
            check2[y][i] = true;
            check3[sum][i] = true;

            solve(depth + 1);
            if(flag)return; // 사전순 출력

            check1[x][i] = false;
            check2[y][i] = false;
            check3[sum][i] = false;
        }
    }

    static void print(){
        for(int i = 0; i < 9; i++){

            for(int j = 0; j < 9; j++){

                System.out.printf("%d", a[i][j]);
            }
            System.out.println();
        }
    }
}
