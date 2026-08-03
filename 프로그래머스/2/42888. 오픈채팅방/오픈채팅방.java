import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> mp = new HashMap<>();//uid, nickname
        ArrayList<String[]> logs = new ArrayList<>();
        for (String s : record) {
            String[] ss = s.split(" ");
            String status = ss[0];
            String uid = ss[1];
            if (status.equals("Enter")) {
                mp.put(uid, ss[2]);
                logs.add(new String[]{status, uid});
            } else if (status.equals("Leave")) {
                logs.add(new String[]{status, uid});
            } else {//"Change"
                mp.put(uid, ss[2]);
            }
        }
        ArrayList<String> answer = new ArrayList<>();
        for (String[] log : logs) {
            String nickname = mp.get(log[1]);
            if (log[0].equals("Enter")) {
                nickname += "님이 들어왔습니다.";
            } else {
                nickname += "님이 나갔습니다.";
            }
            answer.add(nickname);
        }
        return answer.toArray(new String[0]);
    }
}