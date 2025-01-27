import java.io.*;

public class Main {
    static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long left = 0, right = n;
        while (left <= right) {
            long mid = (left + right) / 2;
            if(Math.pow(mid, 2) >= n) {
                answer = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
}