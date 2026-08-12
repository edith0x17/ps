import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            mp.put(String.valueOf((char) (i + 65)), i + 1);
        }
        int cnt = 26;
        String w = String.valueOf(msg.charAt(0));
        for (int i = 1; i < msg.length(); i++) {
            String next = w + msg.charAt(i);
            if (mp.containsKey(next)) {
                w = next;
            } else {
                list.add(mp.get(w));
                mp.put(next, ++cnt);
                w = String.valueOf(msg.charAt(i));
            }
        }
        list.add(mp.get(w));//
        
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}