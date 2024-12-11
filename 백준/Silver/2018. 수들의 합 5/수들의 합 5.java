import java.io.*;
import java.util.*;

public class Main{
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int left = 1, right = 1, sum = 1, cnt = 1;// 자기자신
        while(right != n){
            if(sum > n){
                // 현재 left가 가리키는 값 빼기
                sum -= left;
                left++;
            }else if(sum == n){
                cnt++;
                // 현재 right가 가리키는 값 증가 후 더하기
                right++;
                sum += right;
            }else{// sum < n
                // 현재 right가 가리키는 값 증가 후 더하기
                right++;
                sum += right;
            }
        }
        sb.append(cnt);
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}