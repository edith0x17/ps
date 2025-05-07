import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static Jewel[] jewels;
    static int[] bags;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        jewels = new Jewel[n];
        bags = new int[k];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(m, v);
        }
        for(int i = 0; i < k; i++){
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(jewels);
        Arrays.sort(bags);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long total = 0;
        int j = 0;
        for(int i = 0; i < k; i++){
            int bagWeight = bags[i];
            while(j < n && jewels[j].m <= bagWeight){
                pq.add(jewels[j].v);
                j++;
            }
            if(!pq.isEmpty()){
                total += pq.poll();
            }
        }
        System.out.println(total);
    }
    static class Jewel implements Comparable<Jewel>{
        int m, v;
        public Jewel(int m, int v) {
            this.m = m;
            this.v = v;
        }
        @Override
        public int compareTo(Jewel o){
            return Integer.compare(this.m, o.m);
        }
    }
}