import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] a;
    static ArrayList<Integer> adj = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        int answer = lis();
        System.out.println(answer);
    }
    static int lis(){
        adj.add(a[0]);
        for(int i = 1; i < n; i++){
            if(a[i] > adj.get(adj.size() - 1)){
                adj.add(a[i]);
            }else{
                int pos = Collections.binarySearch(adj, a[i]);
                if(pos < 0)pos = -(pos + 1);
                adj.set(pos, a[i]);
            }
        }
        return adj.size();
    }
}