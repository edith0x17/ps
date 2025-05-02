import java.io.*;
import java.util.*;

public class Main {
    static int p;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        p = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        while(p-- > 0){
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            a = new int[20];
            for(int i = 0; i < 20; i++){
                a[i] = Integer.parseInt(st.nextToken());
            }
            ArrayList<Integer> adj = new ArrayList<>();
            for(int i = 0; i < 20; i++){
                int h = a[i], pos = 0;
                while(pos < adj.size() && adj.get(pos) < h){
                    pos++;
                }
                answer += adj.size() - pos;
                adj.add(pos, h);
            }
            System.out.println(num + " " + answer);
        }
    }
}