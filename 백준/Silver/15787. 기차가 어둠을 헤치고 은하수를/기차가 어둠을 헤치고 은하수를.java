import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] trains;
    static int op, i, num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        trains = new int[n + 1];
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int i, x;
            switch (op) {
                case 1:
                    i = Integer.parseInt(st.nextToken());
                    x = Integer.parseInt(st.nextToken());
                    trains[i] |= (1 << (x - 1));
                    break;
                case 2:
                    i = Integer.parseInt(st.nextToken());
                    x = Integer.parseInt(st.nextToken());
                    trains[i] &= ~(1 << (x - 1));
                    break;
                case 3:
                    i = Integer.parseInt(st.nextToken());
                    trains[i] <<= 1;                     // 뒤로
                    trains[i] &= ((1 << 20) - 1);        // 20칸 초과 버리기
                    break;
                case 4:
                    i = Integer.parseInt(st.nextToken());
                    trains[i] >>= 1;                     // 앞으로
                    break;
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) set.add(trains[i]);
        System.out.println(set.size());
    }
}