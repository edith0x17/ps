import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int ret = -987654321;
    static int n;
    static int[] s;
    static int[] w;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = new int[n];
        w = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken());
            w[i] = Integer.parseInt(st.nextToken());
        }

//        System.out.println(Arrays.toString(s));
//        System.out.println(Arrays.toString(w));

        go(0);

        System.out.println(ret);

    }

    static void go(int idx) {

        if (idx == n) { // 끝
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (s[i] <= 0) cnt++; // 깨진거
            }
            ret = Math.max(ret, cnt); // MAX
            return;
        }


        if (s[idx] <= 0) { // 선택 그러나 깨진거 -> 오른쪽 이동
            go(idx + 1);
        } else { // 선택 안깨진거
            boolean flag = false; // 쳤는지 안쳤는지

            for (int i = 0; i < n; i++) {
                if (idx == i || s[i] <= 0) continue; // 자기자신 || 깨진거

                s[idx] -= w[i];
                s[i] -= w[idx];
                flag = true;

                go(idx + 1); // 오른쪽 이동

                s[idx] += w[i]; // 원복
                s[i] += w[idx]; // 원복
            }

            if (!flag) go(n); // 다 깨짐
        }

    }

}