import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);

			if (abs1 == abs2)
				return o1 - o2;
			return abs1 - abs2;
		});

		while (n-- != 0) {
			int temp = Integer.parseInt(br.readLine());
			if (temp == 0) {
				if (pq.isEmpty()) System.out.println(0);
				else System.out.println(pq.poll());
			} else {
				pq.offer(temp);
			}
		}
	}
}

//class Data implements Comparator<Data> {
//
//	int num;
//
//	public Data(int num) {
//		super();
//		this.num = num;
//	}
//
//	@Override
//	public int compare(Data o1, Data o2) {
//		if (Math.abs(o1.num) == Math.abs(o2.num)) {
//			return o1.num - o2.num;
//		}
//		return Math.abs(o1.num) - Math.abs(o2.num);
//	}
//
//}