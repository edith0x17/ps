import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] durability;
    static boolean[] robot;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        durability = new int[2 * n];
        robot = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2 * n; i++){
            durability[i] = Integer.parseInt(st.nextToken());
        }
        int step = 0;
        while(true){
            step++;
            // 컨베이어벨트, 로봇 이동
            go1();
            // 로봇 이동
            go2();
            // 새로운 로봇
            go3();
            // 체크
            if(go4())break;
        }
        System.out.println(step);
    }
    static void go1(){
        int lastDurability = durability[2 * n - 1];
        for(int i = 2 * n - 1; i > 0; i--){
            durability[i] = durability[i - 1];
        }
        durability[0] = lastDurability;
        for(int i = n - 1; i > 0; i--){
            robot[i] = robot[i - 1];
        }
        robot[0] = false;// 올리는 곳
        robot[n - 1] = false;// 내리는 곳
    }
    static void go2(){
        for(int i = n - 2; i >= 0; i--){// n - 1 -> 내리는 곳,,,
            if(robot[i] && !robot[i + 1] && durability[i + 1] > 0){
                robot[i] = false;

                robot[i + 1] = true;// 로봇
                durability[i + 1]--;// 내구도
            }
        }
        robot[n - 1] = false;// 내리는 곳
    }
    static void go3(){
        if (durability[0] > 0) {
            robot[0] = true;// 로봇
            durability[0]--;// 내구도
        }
    }
    static boolean go4(){
        int count = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (durability[i] == 0) count++;
        }
        return count >= k;
    }
}