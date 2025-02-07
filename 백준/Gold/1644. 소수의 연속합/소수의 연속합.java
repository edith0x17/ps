import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, answer;
    static boolean[] isPrime;
    static ArrayList<Integer> adj = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i = 2; i * i <= n; i++){
            if(isPrime[i]){
                for(int j = i * i; j <= n; j += i){
                    isPrime[j] = false;
                }
            }
        }
        for(int i = 2; i <= n; i++){
            if(isPrime[i])adj.add(i);
        }
        int[] temp = new int[adj.size()];
        for(int i = 0; i < adj.size(); i++){
            temp[i] = adj.get(i);
        }
        int left = 0, right = 0, sum = 0;
        while(true){
            if(sum >= n)sum -= temp[left++];
            else if(right == adj.size())break;
            else sum += temp[right++];

            if(sum == n)answer++;
        }
        sb.append(answer);
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}