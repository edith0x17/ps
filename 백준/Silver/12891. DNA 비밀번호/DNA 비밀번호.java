import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int S, P;
    static char[] dna;
    static int[] checkArr = new int[4];
    static int[] myArr = new int[4];
    static int ans = 0;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        dna = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < P; i++) { // 첫 부분문자열 셋팅 (0 ~ P)까지
            if (dna[i]=='A') myArr[0]++;
            if (dna[i]=='C') myArr[1]++;
            if (dna[i]=='G') myArr[2]++;
            if (dna[i]=='T') myArr[3]++;
        }

        if (checkCounting())// {‘A’, ‘C’, ‘G’, ‘T’} 4개의 문자가 모두 최소개수를 만족했다면
            ans++; // 만들 수 있는 비밀번호 개수 증가

        /*
         * 부분문자열 만들기 => 이전 부분문자열의 첫 문자는 제외하고, 끝에서 한 문자를 더 추가한다.
         */

        int i = -1;
        for (int j = P; j < S; j++) { // 부분문자열의 끝을 나타내는 위치
            i = j - P; // 이전 부분문자열의 시작을 나타내는 위치

            // 이전 부분문자열의 시작 문자 제외
            if (dna[i]=='A') myArr[0]--;
            if (dna[i]=='C') myArr[1]--;
            if (dna[i]=='G') myArr[2]--;
            if (dna[i]=='T') myArr[3]--;

            // 이전 부분문자열의 끝에서 한 문자 추가
            if (dna[j]=='A') myArr[0]++;
            if (dna[j]=='C') myArr[1]++;
            if (dna[j]=='G') myArr[2]++;
            if (dna[j]=='T') myArr[3]++;

            if (checkCounting())// {‘A’, ‘C’, ‘G’, ‘T’} 4개의 문자가 모두 최소개수를 만족했다면
                ans++; // 만들 수 있는 비밀번호 개수 증가
        }

        bw.write(ans +"");
        bw.flush();
        bw.close();
    }

    static boolean checkCounting() {
        for (int i = 0; i < 4; i++) {
            if (myArr[i] < checkArr[i])return false;
        }

        return true;
    }
}