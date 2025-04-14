import java.io.*;
import java.util.*;

public class Main {
    static int N, M, L;
    static int[] restAreas;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        restAreas = new int[N + 2]; // 시작점 0, 끝점 L 포함
        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                restAreas[i] = Integer.parseInt(st.nextToken());
            }
        }
        restAreas[0] = 0;
        restAreas[N + 1] = L;
        Arrays.sort(restAreas);
        int left = 1, right = L - 1;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }

    // 휴게소 없는 구간의 최대 길이를 maxDist 이하로 만들 수 있는가?
    static boolean isPossible(int maxDist) {
        int count = 0;
        for (int i = 1; i < restAreas.length; i++) {
            int dist = restAreas[i] - restAreas[i - 1];
            if (dist > maxDist) {
                count += (int)(Math.ceil(dist / (double) maxDist)) - 1;
            }
        }
        return count <= M;
    }
}