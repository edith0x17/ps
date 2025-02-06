import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[] arr;
    static ArrayList<Integer> d = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = lds();
        sb.append(answer);
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
    static int lds(){
        d.add(arr[0]);

        for(int i = 1; i < n; i++){
            if(arr[i] < d.get(d.size() - 1)){// 작을 경우
                d.add(arr[i]);
            } else {// 같거나 클 경우
                int pos = Collections.binarySearch(d, arr[i], Collections.reverseOrder());
                if(pos < 0) pos = -(pos + 1);
                d.set(pos, arr[i]);
            }
        }
        return d.size();
    }
    static int lis(){
        d.add(arr[0]);

        for(int i = 1; i < n; i++){
            if(arr[i] > d.get(d.size() - 1)){// 큰 경우
                d.add(arr[i]);
            }else{// 같거나 작을 경우
                int pos = Collections.binarySearch(d, arr[i]);// 있으면 양수로 들어갈 위치, 없으면 음수로 들어갈 위치 - 1,
                if(pos < 0)pos = -(pos + 1);
                d.set(pos, arr[i]);
            }
        }
        return d.size();
    }
}