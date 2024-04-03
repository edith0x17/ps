import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- != 0){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

            ArrayDeque<Integer> dq = new ArrayDeque<>();
            for(int i = 0; i < n; i++) {
                int temp = Integer.parseInt(st.nextToken());
                dq.add(temp);
            }

//            System.out.println("p: " + p);
//            System.out.println(Arrays.toString(dq.toArray()));

            AC(p, dq);
        }
        System.out.println(sb);
    }

     static void AC(String ss, ArrayDeque<Integer> deque) {
        boolean dir = true;
        for(char ch : ss.toCharArray()) {

            // R
            if(ch == 'R') {
                dir = !dir;	// 방향을 바꿔준다.
                continue;
            }else{ // D
                if(deque.size() == 0){
                    sb.append("error\n");
                    return;
                }else{
                    if(dir == true){ // front
                        deque.pollFirst();
                    }else{ // back
                        deque.pollLast();
                    }
                }
            }
        }

        makePrintString(deque, dir);
    }

    static void makePrintString(ArrayDeque<Integer> deque, boolean dir) {

        sb.append('[');

        if(deque.size() > 0) {
            if(dir) {
                sb.append(deque.pollFirst());
                while(!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            }else {
                sb.append(deque.pollLast());
                while(!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }
        }

        sb.append(']').append('\n');
    }
}