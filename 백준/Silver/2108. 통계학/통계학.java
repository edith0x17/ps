import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[] arr, checkArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        checkArr = new int[8001];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            arr[i] = temp;
            checkArr[temp + 4000]++; // 음수 처리를 위해 +4000 변환
            sum += temp;
        }
        Arrays.sort(arr);
        sb.append(Math.round((double) sum / n)).append("\n");
        sb.append(arr[n / 2]).append("\n");
        int maxFreq = 0, mode = 0;
        boolean secondMode = false; // 두 번째 최빈값을 찾기 위한 변수
        for (int i = 0; i <= 8000; i++) {
            if (checkArr[i] > maxFreq) {
                maxFreq = checkArr[i];
                mode = i - 4000; // 원래 숫자로 변환
                secondMode = false; // 새로운 최빈값이 나오면 초기화
            } else if (checkArr[i] == maxFreq && !secondMode) {
                mode = i - 4000; // 두 번째로 작은 최빈값 선택
                secondMode = true;
            }
        }
        sb.append(mode).append("\n");
        sb.append(arr[n - 1] - arr[0]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}