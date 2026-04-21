import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] increase = new int[24];//i시에 증설한 서버 수
        //현재 운영중인 서버 수 = increase[i - k + 1] + ... + increase[i] 합계
        for(int i = 0; i < players.length; i++){
            int cur = 0;
            for(int j = Math.max(0, i - k + 1); j <= i; j++){
                cur += increase[j];
            }
            int need = cur - (players[i] / m);
            if(need < 0){
                increase[i] = Math.abs(need);
                answer += Math.abs(need);
            }
        }
        return answer;
    }
}