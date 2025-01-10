import java.io.*;
import java.util.*;

class Solution {
    static int[] arr, ret;
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        arr = new int[numbers.length()];
        ret = new int[numbers.length()];
        
        for(int i = 0; i < numbers.length(); i++){
            arr[i] = numbers.charAt(i) - '0';
        }
        Arrays.sort(arr);
        
        // logic1
        for(int i = 1; i <= numbers.length(); i++){
            visited = new boolean[numbers.length()];
            go(0, i);
        }
        return set.size();
    }
    static void go(int depth, int k){
        if(depth == k){
            // logic2
            int temp = 0;
            for(int i = 0; i < k; i++){
                temp = temp * 10 + ret[i];
            }
            if(temp == 0 || temp == 1)return;// 0, 1 제외 
            if(check(temp))set.add(temp);
            return;
        }
        for(int i = 0; i < arr.length; i++){
            if(visited[i])continue;
            visited[i] = true;
            ret[depth] = arr[i];
            go(depth + 1, k);
            visited[i] = false;
        }
    }
    static boolean check(int temp){
        for(int i = 2; i * i <= temp; i++){
            if(temp % i == 0)return false;
            else continue;
        }
        return true;
    }
}