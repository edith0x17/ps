import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int t, k;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> mp = new TreeMap<>();
            for(int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                if(op.equals("I")) {
                    int num = Integer.parseInt(st.nextToken());
                    mp.put(num, mp.getOrDefault(num, 0) + 1); // 기존 값이 있으면 +1, 없으면 1로 초기화
                }else {
                    if(mp.size() == 0) continue;
                    int type = Integer.parseInt(st.nextToken());
                    int num = -1;
                    if(type == 1) { //최댓값 삭제
                        num = mp.lastKey();
                    }else { // 최솟값 삭제
                        num = mp.firstKey();
                    }
                    if(mp.put(num, mp.get(num) -1) == 1){
                        mp.remove(num);
                    }
                }
            }
            if (mp.size()==0) {
                sb.append("EMPTY\n");
            } else {
                sb.append(mp.lastKey() + " " + mp.firstKey() + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}