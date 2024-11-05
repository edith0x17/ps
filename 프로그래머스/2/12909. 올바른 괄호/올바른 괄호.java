import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            // System.out.println(s.charAt(i));
            if(s.charAt(i) == '(')stk.push(s.charAt(i));
            else{
                if(stk.isEmpty())return false;
                else stk.pop();
            }
        }
        if(stk.isEmpty())return true;
        else return false;
    }
}