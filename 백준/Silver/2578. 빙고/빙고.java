import java.io.*;
import java.util.*;

public class Main{
    static int[][] map = new int[25][25], speach = new int[25][25];
    static boolean[][] visited = new boolean[25][25];
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(br);
        System.out.println(answer);
    }
    static void go(BufferedReader br) throws IOException{
        StringTokenizer st = null;
        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                speach[i][j] = Integer.parseInt(st.nextToken());
                check(speach[i][j]);
                answer++;
                if(i != 0){
                    int ret = 0;
                    ret += go1() + go2() + go3() + go4();
                    if(ret >= 3){
                        return;
                    }
                }
            }
        }
    }
    static void check(int k){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(map[i][j] == k){
                    visited[i][j] = true;
                    break;
                }
            }
        }
    }
    static int go1(){// 가로
        int ret = 0;
        for(int i = 0; i < 5; i++){
            int cnt = 0;
            for(int j = 0; j < 5; j++){
                if(visited[i][j])cnt++;
            }
            if(cnt == 5)ret++;
        }
        return ret;
    }
    static int go2(){// 세로
        int ret = 0;
        for(int j = 0; j < 5; j++){
            int cnt = 0;
            for(int i = 0; i < 5; i++){
                if(visited[i][j])cnt++;
            }
            if(cnt == 5)ret++;
        }
        return ret;
    }
    static int go3(){// 왼 오 대각선
        if(visited[0][0] && visited[1][1] && visited[2][2] && visited[3][3] && visited[4][4])return 1;
        else return 0;
    }
    static int go4(){// 오 왼 대각선
        if(visited[0][4] && visited[1][3] && visited[2][2] && visited[3][1] && visited[4][0])return 1;
        else return 0;
    }
}