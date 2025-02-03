import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, k, answer = Integer.MAX_VALUE;
    static int[] arr;
    static ArrayList<Integer> adj = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i <n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] == 1)adj.add(i);
        }
        if(adj.size() < k)answer = -1;
        else{
            int start = 0, end = k - 1;
            while(true){
                if(end == adj.size())break;

                answer = Math.min(answer, adj.get(end) - adj.get(start) + 1);

                start++;
                end++;
            }
        }
        sb.append(answer);
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}