import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int left = 0, right = 0;
        int oddCount = 0;  // 현재 구간 내의 홀수 개수
        int maxLen = 0;

        while (right < n) {
            if (arr[right] % 2 == 1) oddCount++; // 홀수면 카운트 증가

            // 홀수를 너무 많이 삭제했으면 왼쪽 줄이기
            while (oddCount > k) {
                if (arr[left] % 2 == 1) oddCount--;
                left++;
            }

            // 짝수 개수 = (right - left + 1) - oddCount
            maxLen = Math.max(maxLen, (right - left + 1) - oddCount);
            right++;
        }

        System.out.println(maxLen);
    }
}