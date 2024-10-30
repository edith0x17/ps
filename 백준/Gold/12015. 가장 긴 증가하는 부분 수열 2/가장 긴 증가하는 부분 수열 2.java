import java.io.*;
import java.util.*;
public class Main{
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, answer;
    static int[] a;
    static ArrayList<Integer> d = new ArrayList<>();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = new int[n + 4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        answer = lis();
        sb.append(answer);
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
    static int lis(){
        d.add(a[0]);

        for(int i = 1; i < n; i++){
            int sum = 0;
            if(a[i] > d.get(d.size() - 1)){
                d.add(a[i]);
            }else{
                int pos = Collections.binarySearch(d, a[i]);
                if(pos < 0)pos = -(pos + 1);
                d.set(pos, a[i]);
            }
        }
        return d.size();
    }
}