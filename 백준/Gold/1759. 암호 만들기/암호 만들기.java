import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{

    static int l, c; // c개 주어지면 ->  l개 선택
    static int[] a;
    static int[] ret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        a = new int[c];
        ret = new int[l];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < c; i++){
            a[i] = st.nextToken().charAt(0) - 'a';
        }

        Arrays.sort(a); // 정렬
        
        combi(0, 0);

    }

    static boolean check(int[] input){
        int cnt1 = 0, cnt2 = 0; // 모음, 자음
        for(int i = 0; i < input.length; i++){
            if(input[i] + 'a' == 'a' || input[i] + 'a' == 'e' || input[i] + 'a' == 'i' || input[i] + 'a' == 'o' || input[i] + 'a' == 'u')cnt1++;
            else cnt2++;
        }

        if(cnt1 >= 1 && cnt2 >= 2)return true;
        else return false;
    }

    static void combi(int depth, int start){

        if(depth == l){
            if(check(ret)){
                for(int i: ret){
                    System.out.printf("%c", i + 'a');
                }
                System.out.println();
            }
            return;
        }

        for(int i = start; i < a.length; i++){
            ret[depth] = a[i];
            combi(depth + 1, i+ 1);
        }
    }


}