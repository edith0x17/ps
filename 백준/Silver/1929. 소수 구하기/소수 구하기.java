    import java.io.*;
    import java.util.*;

    public class Main{
        static StringBuilder sb = new StringBuilder();
        static int m, n;
        public static void main(String[] args)throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            for(int i = m; i <= n; i++){
                boolean flag  = false;
                for(int j = 2; j <= Math.sqrt((double)i); j++){
                    if(i % j == 0){
                        flag = true;
                        break;
                    }
                }
                if(!flag && i != 1)sb.append(i + "\n");
            }
            System.out.println(sb);
        }
    }