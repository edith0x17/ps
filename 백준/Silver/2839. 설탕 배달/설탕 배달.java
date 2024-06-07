import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, ans;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        while(true){
            if(n < 0){ // 불가능한 경우
                flag = true;
                break;
            }

            // 5나누고 -> 안되면 -> 3빼주고
            if(n % 5 == 0){
                ans += n / 5;
                break;
            }else{
                n -= 3;
                ans++;
            }
        }

        if(flag)sb.append(-1);
        else sb.append(ans);

        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}