import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, answer;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        int left = 1, right = 0;
        for(int i = 0; i < m; i++){
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]);
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid) <= n) { // n명 이하로 나눌 수 있으면 더 작은 mid 탐색
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        sb.append(answer);
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
    static int check(int mid){
        int sum = 0;
        for(int i = 0; i < m; i++){
            sum += arr[i]/ mid;
            if(arr[i] % mid != 0){
                sum += 1;
            }
        }
        return sum;
    }
//        arr[i] / mid: 기본적으로 나눠줄 수 있는 사람 수 계산.
//        arr[i] % mid != 0: 남는 보석이 있으면 한 명 더 추가.
//        최종적으로 sum에 누적하여 필요한 총 인원 수를 반환.
}