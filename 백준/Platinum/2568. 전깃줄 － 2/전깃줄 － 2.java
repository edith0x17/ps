import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<Data> arrayList = new ArrayList<>();
    static int[] arr, trace;
    static int[] dpIdx; // LIS 위치 저장
    static ArrayList<Integer> lis = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        trace = new int[n];
        dpIdx = new int[n];

        // 입력 처리
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arrayList.add(new Data(a, b));
        }

        // A 전봇대 기준 정렬
        Collections.sort(arrayList);

        // B 전봇대 값으로 배열 만들기
        for (int i = 0; i < n; i++) {
            arr[i] = arrayList.get(i).b;
        }

        // LIS 계산
        lis.add(arr[0]);
        trace[0] = 0;
        for (int i = 1; i < n; i++) {
            int value = arr[i];

            if (value > lis.get(lis.size() - 1)) {
                lis.add(value);
                trace[i] = lis.size() - 1;
            } else {
                int pos = Collections.binarySearch(lis, value);
                if (pos < 0) pos = -(pos + 1);
                lis.set(pos, value);
                trace[i] = pos;
            }
        }

        // 출력: 제거할 A 전봇대 번호 찾기
        int len = lis.size() - 1;
        boolean[] isInLIS = new boolean[n];
        for (int i = n - 1; i >= 0; i--) {
            if (trace[i] == len) {
                isInLIS[i] = true;
                len--;
            }
        }

        // 제거 대상 수집
        ArrayList<Integer> removeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!isInLIS[i]) {
                removeList.add(arrayList.get(i).a); // A 전봇대 번호 출력
            }
        }

        // 결과 출력
        System.out.println(removeList.size());
        Collections.sort(removeList);
        for (int num : removeList) {
            System.out.println(num);
        }
    }

    static class Data implements Comparable<Data> {
        int a, b;

        public Data(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Data o) {
            return Integer.compare(this.a, o.a);
        }
    }
}
