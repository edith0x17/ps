import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main{
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
//		System.out.println(n);
		
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i = 1; i <= n; i++) {
			q.offer(i);
		}
		
		// System.out.println("q.size() : " + q.size());
		
		while(q.size() != 1) {
			// 첫번째 삭제
			q.poll(); 
			
			// 두번째 삭제 후 큐에 삽입
			int p = q.poll(); 
			q.offer(p); 
		}
		
		System.out.println(q.poll());
	}
}