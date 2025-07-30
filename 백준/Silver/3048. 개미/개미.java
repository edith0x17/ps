import java.io.*;
import java.util.*;

public class Main {
    static int n1, n2, t;
    static Data[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n1 = Integer.parseInt(st.nextToken());
        n2 = Integer.parseInt(st.nextToken());
        A = new Data[n1 + n2];
        String s = br.readLine();
        int idx = 0;
        for(int i = n1 - 1; i >= 0; i--){
            A[idx++] = new Data(s.charAt(i), 1);
        }
        s = br.readLine();
        for(int i = 0; i < n2; i++){
            A[idx++] = new Data(s.charAt(i), -1);
        }
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            for (int i = 0; i < n1 + n2 - 1; i++) {
                if (A[i].dir == 1 && A[i + 1].dir == -1) {
                    Data tmp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = tmp;
                    i++;
                }
            }
        }
        for(int i = 0; i < n1 + n2; i++){
            System.out.printf("%c", A[i].ch);
        }
    }
    static class Data{
        Character ch;
        int dir;

        public Data(Character ch, int dir) {
            this.ch = ch;
            this.dir = dir;
        }
    }
}