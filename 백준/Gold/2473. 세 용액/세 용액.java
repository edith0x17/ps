import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static long mi = Long.MAX_VALUE;
    static long[] arr, answer = new long[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int temp = Integer.parseInt(st.nextToken());
            arr[i] = temp;
        }
        Arrays.sort(arr);
        for(int i = 0; i < n - 1; i++){// i가 기준, left -> i + 1, right -> n - 1
            int left = i + 1, right = n - 1;
            while(left < right){
                long hap = arr[i] + arr[left] + arr[right];
                if(Math.abs(hap) < mi){
                    mi = Math.abs(hap);
                    answer[0] = arr[i];
                    answer[1] = arr[left];
                    answer[2] = arr[right];
                    if(Math.abs(hap) == 0)break;
                }

                if(hap >= 0)right--;
                else left++;
            }
        }
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}