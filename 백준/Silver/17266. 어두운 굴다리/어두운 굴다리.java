import java.io.*;
import java.util.*;

public class Main {
    static int n, m, answer;
    static int[] lamp, road;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        lamp = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            lamp[i] = Integer.parseInt(st.nextToken());
        }
        int left = 1, right = 100_000;
        while(left <= right){
            int mid = (left + right)/ 2;
            if(check(mid)){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
    static boolean check(int mid){
        int prev = 0;
        for(int i = 0; i < m; i++){
            if(lamp[i] - mid <= prev){// 앞부분
                prev = lamp[i] + mid;// 뒷부분
            }else{
                return false;
            }
        }
        return n - prev <= 0;// 뒷부분이 굴다리의 길이보다 크거나 같다
    }
}