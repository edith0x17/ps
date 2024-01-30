import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n, m;
    static ArrayList<int[]> v;
    static int[] a;

    static void fastIO() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }

        m = scanner.nextInt();

        v = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            v.add(new int[]{x, y});
        }
    }

    static void solve() {
        for (int[] p : v) { // <성별, 스위치 번호>
            if (p[0] == 1) { // 남자
                for (int i = 1; i <= n; i++) {
                    if (i % p[1] == 0) { // 배수 -> 반전
                        if (a[i] == 1) a[i] = 0; // ON
                        else a[i] = 1; // OFF
                    }
                }
            } else { // 여자
                int left = p[1], right = p[1];

                int cnt = 0;
                while (true) {
                    if (left - 1 < 1 || right + 1 > n) break;

                    if (a[left - 1] != a[right + 1]) break;

                    left = left - 1;
                    right = right + 1;
                    cnt++;
                }

                if (cnt == 0) { // 대칭 X
                    if (a[p[1]] == 1) a[p[1]] = 0;
                    else a[p[1]] = 1;
                } else { // 대칭 O
                    for (int i = left; i <= right; i++) {
                        if (a[i] == 1) a[i] = 0;
                        else a[i] = 1;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(a[i] + " ");
            if (i % 20 == 0) System.out.println();
        }
    }

    public static void main(String[] args) {
        fastIO();
        solve();
    }
}
