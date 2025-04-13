import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(lis());
    }
    static int lis(){
        ArrayList<Integer> adj = new ArrayList<>();
        adj.add(a[0]);
        for(int i = 1; i < n; i++){
            if(adj.get(adj.size() - 1) < a[i]){
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