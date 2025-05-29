import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<Data> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll().num);
            } else {
                pq.offer(new Data(x));
            }
        }
    }

    static class Data implements Comparable<Data> {
        int num;

        public Data(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(Data o) {
            if (Math.abs(this.num) == Math.abs(o.num)) return Integer.compare(this.num, o.num); // 오름차순
            return Integer.compare(Math.abs(this.num), Math.abs(o.num)); // 오름차순
        }
    }
}