import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{

    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        HashMap<String, Integer> mp = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            String name = br.readLine();
            mp.put(name, 1);
        }
        for(int i = 0; i < m; i++){
            String name = br.readLine();
            if(mp.containsKey(name)){
                int cnt = mp.get(name);
                mp.put(name, cnt + 1);
            }else mp.put(name, 1);
        }
        ArrayList<String> a = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: mp.entrySet()){
            if(entry.getValue() == 2){
                a.add(entry.getKey());
            }
        }
        Collections.sort(a);
        sb.append(a.size() + "\n");
        for(String s: a){
            sb.append(s + "\n");
        }
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}