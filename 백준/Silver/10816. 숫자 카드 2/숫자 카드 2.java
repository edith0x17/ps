import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(mp.containsKey(num)){
                Integer cnt = mp.get(num);
                mp.put(num, cnt + 1);
            }else{
                mp.put(num, 1);
            }
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int num = Integer.parseInt(st.nextToken());
            if(mp.containsKey(num)){
                int cnt = mp.get(num);
                sb.append(cnt + " ");
            }else{
                sb.append(0 + " ");
            }
        }
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}