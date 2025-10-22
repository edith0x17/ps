import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = 0, h = health, cnt = 0;
        int end = attacks[attacks.length - 1][0];
        while(t <= end){ //t <= end
            if(t == 0){
                t++;
                continue;
            }
            
            int attack = 0;
            for(int i = 0; i < attacks.length; i++){
                if(t == attacks[i][0]){
                    attack = attacks[i][1];
                }
            }
            if(attack != 0){ //공격
                h -= attack;
                cnt = 0;
                if(h <= 0)return -1;
            }else{
                h += bandage[1];
                cnt++;
                if(cnt == bandage[0]){
                    h += bandage[2];
                    cnt = 0;
                }
                if(h >= health)h = health;
            }
            // System.out.println(t + " " + h);
            t++;
        }
        int answer = h;
        return answer;
    }
}
//[1, 1, 1], 20, [[1, 5], [4, 1]]