import java.util.*;

class Solution {
    static PriorityQueue<Data> pq = new PriorityQueue<>();
    
    public int[] solution(int[] sequence, int k) {
        int l = 0, r = 0, sum = 0;
        while(true){
            if(sum >= k)sum -= sequence[l++];
            else if(r == sequence.length)break;
            else if(sum < k)sum += sequence[r++];
            
            if(sum == k){
                pq.offer(new Data(l, r - 1, r - l));
            }
        }
        Data data = pq.poll();
        int[] answer = {data.a, data.b};
        return answer;
    }
    
    static class Data implements Comparable<Data>{
        int a, b, l;
        
        Data(int a, int b, int l){
            this.a = a;
            this.b = b;
            this.l = l;
        }
        
        @Override
        public int compareTo(Data o){
            if(this.l == o.l){
                return Integer.compare(this.a, o.a);
            }
            return Integer.compare(this.l, o.l);
        }
    }
}
//길이가 짧은 수열이 여러 개인 경우 앞쪽(시작 인덱스가 작은)에 나오는 수열을 찾습니다.