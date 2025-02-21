import java.io.*;
import java.util.*;

public class Main {
    static int T, n, m;
    static int[] A, B;
    static List<Integer> subA = new ArrayList<>();
    static Map<Integer, Integer> mapA = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        // 배열 A 입력 및 부분합 계산
        n = Integer.parseInt(br.readLine());
        A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 B 입력
        m = Integer.parseInt(br.readLine());
        B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 1️⃣ A의 모든 부 배열 합을 구해서 해시맵에 저장
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                mapA.put(sum, mapA.getOrDefault(sum, 0) + 1);
            }
        }

        // 2️⃣ B의 모든 부 배열 합을 구하면서, T에서 (B의 부 배열 합)을 뺀 값이 A에서 몇 번 나오는지 찾음
        long answer = 0; // 정답 개수
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                if (mapA.containsKey(T - sum)) {
                    answer += mapA.get(T - sum); // A에서 해당 합이 몇 번 나오는지 누적
                }
            }
        }

        System.out.println(answer);
    }
}