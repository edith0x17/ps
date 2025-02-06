import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[] arr, trace;// 순위를 저장
    static ArrayList<Integer> adj = new ArrayList<>();
    static ArrayList<Integer> answer2 = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        trace = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = lis();
        sb.append(answer + "\n");
        int len = adj.size() - 1;// 0에서 시작 하니깐
        for(int i = n - 1; i >= 0; i--){
            if(trace[i] == len){
                answer2.add(arr[i]);
                len--;
            }
        }
        Collections.reverse(answer2);
        for(int i: answer2){
            sb.append(i + " ");
        }
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
    static int lis(){
        adj.add(arr[0]);
        // 추가
        trace[0] = 0;

        for(int i = 1; i < n; i++){
            if(arr[i] > adj.get(adj.size() - 1)){// 큰 경우
                adj.add(arr[i]);
                // 추가
                trace[i] = adj.size() - 1;
            }else{// 같거나 작을 경우
                int pos = Collections.binarySearch(adj, arr[i]);// 있으면 양수로 들어갈 위치, 없으면 음수로 들어갈 위치 - 1,
                if(pos < 0)pos = -(pos + 1);
                adj.set(pos, arr[i]);
                // 추가
                trace[i] = pos;
            }
        }
        return adj.size();
    }
}