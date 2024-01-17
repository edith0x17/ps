import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ret = 0;
        
        if(n < 100){
            System.out.println(n);
        }else{
            ret += 99;
            for(int i = 100; i <= n; i++){
                String s = i + ""; // int -> String

                boolean flag = false;
                int gapInit =  (s.charAt(1) - s.charAt(0)) - '0'; // [10진수 문자] -> [48 '0'] => [문자 - '0' == 10진수 문자]
                for(int j = 1; j < s.length(); j++){
                    int gap = (s.charAt(j) - s.charAt(j - 1)) - '0';

                    if(gapInit == gap){
                        flag = true;
                    }else{
                        flag = false;
                    }
                }
                if(flag)ret++;
            }
            System.out.println(ret);
        }
    }
}