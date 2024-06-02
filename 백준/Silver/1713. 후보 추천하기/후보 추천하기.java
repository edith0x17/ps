import java.io.*;
import java.util.*;

public class Main {
    static class A implements Comparable<A> {
        int num;
        int day;
        int r;

        public A(int num, int day, int r) {
            this.num = num;
            this.day = day;
            this.r = r;
        }

        @Override
        public int compareTo(A o) {
            if (this.r == o.r) {
                return o.day - this.day; // 날짜가 클수록 우선
            }
            return o.r - this.r; // 추천수가 클수록 우선
        }
    }

    static int n, k;
    static List<A> vv = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int temp = Integer.parseInt(st.nextToken());
            A a = new A(temp, i, 1);

            if (!vv.isEmpty()) {
                int ret = check(temp);

                if (ret >= 0) { // 이미 사진에 있으면
                    vv.get(ret).r++;
                } else { // 사진에 없으면
                    if (n < vv.size() + 1) {
                        Collections.sort(vv); // 정렬
                        vv.remove(vv.size() - 1); // 가장 마지막 요소 제거
                    }
                    vv.add(a); // 새로운 사진 추가
                }
            } else { // 비어 있는 경우
                vv.add(a);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (A i : vv) {
            ans.add(i.num);
        }

        Collections.sort(ans);
        for (int i : ans) {
            bw.write(i + " ");
        }

        bw.flush();
        bw.close();
    }

    static int check(int tar) {
        for (int i = 0; i < vv.size(); i++) {
            if (vv.get(i).num == tar) {
                return i;
            }
        }
        return -1;
    }
}