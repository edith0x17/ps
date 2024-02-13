import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.min;

public class Main{

    static int ret;
    static boolean flag;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while(true){
            if(n < 0){ // 불가능한 경우
                flag = true;
                break;
            }
            
            // 5나누고 -> X -> 3빼주고 -> ...
            if(n % 5 == 0){
                ret += n / 5;
                break;
            }else{
                n -= 3;
                ret++;
            }
        }

        if(flag) System.out.println(-1);
        else System.out.println(ret);
    }
}