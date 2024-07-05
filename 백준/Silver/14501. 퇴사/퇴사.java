import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] schedule;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine()); // N까지만 일 함
        schedule = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            schedule[i][0] = Integer.parseInt(st.nextToken()); // 상담 하는데 걸리는 일 수
            schedule[i][1] = Integer.parseInt(st.nextToken()); // 돈
        }
        
        result = 0;
        int S = 1 << N; // 2^N
        
        // 모든 가능한 상태를 비트마스크로 표현하여 탐색
        for (int i = 0; i < S; i++) {
            int day = 0;
            int pay = 0;
            boolean valid = true;
            
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) { // j번째 상담을 선택한 경우
                    if (day <= j) { // 상담을 시작할 수 있는 날인지 확인
                        day = j + schedule[j][0];
                        if (day <= N) {
                            pay += schedule[j][1];
                        } else {
                            valid = false; // 상담을 끝마칠 수 없는 경우
                            break;
                        }
                    } else {
                        valid = false; // 상담을 시작할 수 없는 경우
                        break;
                    }
                }
            }
            if (valid) {
                result = Math.max(result, pay);
            }
        }
        
        System.out.println(result);
    }
}