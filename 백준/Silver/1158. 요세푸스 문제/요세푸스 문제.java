import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		Queue<Integer> q = new ArrayDeque<>();

		for (int i = 1; i <= n; i++) {
			q.offer(i);
		}
		
		System.out.printf("<");
		int cnt = 0;
		while (q.size() != 1) {

			cnt++;
			if (cnt % k == 0) {
				cnt = 0;
				System.out.printf("%d, ", q.poll());
			} else {
				int here = q.poll();
				q.offer(here);
			}
		}
		System.out.printf("%d>%n", q.poll());

	}

}
