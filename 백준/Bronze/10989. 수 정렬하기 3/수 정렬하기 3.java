import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 입력 개수
        int[] cnt = new int[10_001]; // 숫자의 등장 횟수를 저장할 배열 (최대 10,000)

        // 숫자 입력 받기 & 카운팅 배열 업데이트
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            cnt[num]++;
        }

        // 정렬된 순서대로 숫자 출력
        for (int i = 0; i <= 10_000; i++) {
            while (cnt[i]-- > 0) { // 등장한 횟수만큼 반복
                sb.append(i).append("\n"); // StringBuilder에 추가
            }
        }

        // BufferedWriter로 한 번에 출력
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}