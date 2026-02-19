import java.io.*;
import java.util.*;

class Solution {
    static int[] a, ret;
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        a = new int[numbers.length()];
        for(int i = 0; i < numbers.length(); i++){
            a[i] = numbers.charAt(i) - '0';
        }
        ret = new int[numbers.length()];
        visited = new boolean[numbers.length()];
        
        for(int i = 1; i <= numbers.length(); i++){
            go(0, i);
        }
        return set.size();
    }
    static boolean check(int x){
        if (x < 2) return false;
        for (int i = 2; i * i <= x; i++){
            if(x % i == 0) return false;
        }
        return true;
    }
    static void go(int depth, int s){
        if(depth == s){
            int x = 0;
            for (int i = 0; i < s; i++) {
                x = x * 10 + ret[i];
            }
            if(check(x)){
                set.add(x);
            }
            return ;
        }
        for(int i = 0; i < a.length; i++){
            if(visited[i])continue;
            ret[depth] = a[i];
            visited[i] = true;
            go(depth + 1, s);
            visited[i] = false;
        }
    }
}