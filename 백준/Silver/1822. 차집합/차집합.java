import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        HashSet<Integer> bSet = new HashSet<>();
        ArrayList<Integer> answerList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) bSet.add(Integer.parseInt(st.nextToken()));

        for (int num : a) {
            if (!bSet.contains(num)) answerList.add(num);
        }

        Collections.sort(answerList); // 사전순 정렬
        System.out.println(answerList.size());
        for (int num : answerList) System.out.print(num + " ");
    }
}