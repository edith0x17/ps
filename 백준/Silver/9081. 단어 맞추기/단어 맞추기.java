import java.io.*;
import java.util.*;

public class Main {
    static boolean nextPerm(char[] a) {
        int n = a.length;
        int i = n - 2;
        //뒤에서부터 오름차순이 깨지는 지점 i 찾기
        while (i >= 0 && a[i] >= a[i + 1]) i--;
        if (i < 0) return false; //마지막 순열

        //뒤에서부터 a[i]보다 큰 가장 오른쪽 원소 j 찾고 swap
        int j = n - 1;
        while (a[j] <= a[i]) j--;
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;

        //i+1..끝을 뒤집어 오름차순으로
        for (int l = i + 1, r = n - 1; l < r; l++, r--) {
            tmp = a[l];
            a[l] = a[r];
            a[r] = tmp;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            char[] w = br.readLine().toCharArray();
            if (nextPerm(w)) out.append(w);
            else out.append(w);
            out.append('\n');
        }
        System.out.print(out);
    }
}