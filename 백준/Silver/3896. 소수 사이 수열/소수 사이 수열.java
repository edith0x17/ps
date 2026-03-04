import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 1300000;
    static boolean[] prime = new boolean[MAX + 1];
    static int[] primes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sieve();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            if (prime[k]) {
                System.out.println(0);
                continue;
            }
            int idx = lowerBound(primes, k);
            int right = primes[idx];
            int left = primes[idx - 1];
            System.out.println(right - left);
        }
    }

    static void sieve() {
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i * i <= MAX; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    prime[j] = false;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <= MAX; i++) {
            if (prime[i]) list.add(i);
        }
        primes = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            primes[i] = list.get(i);
        }
    }

    public static int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}