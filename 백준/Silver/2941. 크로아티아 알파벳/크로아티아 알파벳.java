import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static String s;
    static String[] targets = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        for(String target: targets){
            int index = 0;
            while((index = s.indexOf(target, index)) != -1){
                answer++;
                s = s.substring(0, index) + "*" +s.substring(index + target.length());
            }
        }
        for(char ch: s.toCharArray()){
            if(ch != '*')answer++;
        }
        sb.append(answer);
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}