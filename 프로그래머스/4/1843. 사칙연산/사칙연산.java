import java.util.*;

class Solution {
    static int n;
    static int[] numbers;
    static char[] operators;
    static int[][] max, min;
    public int solution(String arr[]) {
        n = arr.length/ 2 + 1;
        numbers = new int[n];
        operators = new char[n - 1];
        max = new int[n][n];
        min = new int[n][n];
        
        parse(arr);
        init();
        /*
        ✔ d (구간 길이)
        ✔ i (구간 시작 인덱스)
        ✔ j (구간 끝 인덱스, i + d)
        ✔ k (연산자가 위치한 인덱스, i ≤ k < j)
        */
        for(int d = 0; d < n; d++){// 구간 길이
            for(int i = 0; i < n - d; i++){// 시작 인덱스
                int j = i + d;// 끝 인덱스
                if(i == j){
                    max[i][j] = numbers[i];
                    min[i][j] = numbers[i];
                    continue;
                }
                for(int k = i; k < j; k++){// 연산자가 위치한 인덱스
                    go(i, j, k);
                }
            }
        }
        return max[0][n - 1];
    }
    static void parse(String[] arr){
        for(int i = 0; i < arr.length; i++){
            if (i % 2 == 0) { // 피연산자
                numbers[i / 2] = Integer.parseInt(arr[i]);
            } else { // 연산자
                operators[i / 2] = arr[i].charAt(0);
            }
        }
    }
    static void init(){
        for(int i = 0; i < n; i++){
            Arrays.fill(max[i], Integer.MIN_VALUE);
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }
    }
    static void go(int i, int j, int k){
        if(operators[k] == '+'){
            max[i][j] = Math.max(max[i][j], max[i][k] + max[k + 1][j]);
            min[i][j] = Math.min(min[i][j], min[i][k] + min[k + 1][j]);
        }else{// '-'
            max[i][j] = Math.max(max[i][j], max[i][k] - min[k + 1][j]);
            min[i][j] = Math.min(min[i][j], min[i][k] - max[k + 1][j]);
        }
    }
}