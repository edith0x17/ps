import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static class Data{
        int s; //내구도
        int w; //무게

        public Data(int s, int w) {
            this.s = s;
            this.w = w;
        }
    }
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, ret;
    static Data[] data;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        data = new Data[n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            data[i] = new Data(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        go(0);

        sb.append(ret);

        bw.write(ret + "");
        bw.flush();
        bw.close();
    }

    static void go(int idx){
        //종료조건
        if(idx == n){
            int cnt = 0;
            for(int i = 0; i < n; i++){
                if(data[i].s <= 0)cnt++;
            }
            ret = Math.max(ret, cnt);
            return;
        }
        
        //로직
        if(data[idx].s <= 0)go(idx + 1);
        else{
            boolean flag = false;

            for(int i = 0; i < n; i++){
                if(idx == i || data[i].s <= 0)continue; //자기자신 || 깨진거

                data[idx].s -= data[i].w; //손에 든 계란
                data[i].s -= data[idx].w; //고른 계란
                flag = true;

                go(idx + 1);

                data[idx].s += data[i].w; //손에 든 계란
                data[i].s += data[idx].w; //고른 계란
            }

            if(!flag)go(n); //다 깨짐
        }
    }
}