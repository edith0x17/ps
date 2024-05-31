import java.io.*;

public class Main{
    static int n;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        go(0, 0);

        bw.write(sb + "");
        bw.flush();
        bw.close();
    }

    static void go(int here, int depth){
        if(depth == n){
            if (isPrime(here)){
//                System.out.println(here);
                sb.append(here).append("\n");
            }
            return;
        }

        for(int i = 0; i < 10; i++){
            int there = here * 10 + i; // 자릿수
            if(isPrime(there))go(there, depth + 1);
        }
    }

    static boolean isPrime(int num) {
        if (num < 2) return false; // 0, 1

        for (int i = 2; i <= Math.sqrt(num); i++) { // 2, 3, 4, ...
            if (num % i == 0) return false;
        }
        return true;
    }
}