import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	static int n, q;
	static Stack<Integer> back = new Stack<>();

	static int access;

	static Stack<Integer> front = new Stack<>();

	static int flag;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		q = sc.nextInt();
		
		sc.nextLine();
		
		for (int i = 0; i < q; i++) {
			String s = sc.nextLine();
			String[] strArr = s.split(" "); // strArr[0] -> op, strArr[1] -> num

			if (strArr[0].equals("B")) {
				B();
			} else if (strArr[0].equals("A")) {
				flag++; // @@@
				A(strArr[1]);

			} else if (strArr[0].equals("F")) {
				F();
			} else if(strArr[0].equals("C")){
				C();
			}

//			for(String temp: strArr) {
//				System.out.printf("%s ", temp);
//			}
			
		}

		// print access, back, front
		System.out.println(access);

		if (back.isEmpty()) {
			System.out.print(-1);
		} else {
			while (!back.isEmpty()) {
				System.out.printf("%d ", back.pop());
			}
		}

		System.out.println();

		if (front.isEmpty()) {
			System.out.print(-1);
		} else {
			while (!front.isEmpty()) {
				System.out.printf("%d ", front.pop());
			}
		}
		
		System.out.println();
	}

	static void B() {
		if (back.isEmpty()) {
			return;
		}

		// 1)
		front.push(access);

		// 2)
		access = back.peek();
		back.pop();
	}

	static void A(String num) {
		front.clear();

		if (flag == 1) {
			access = Integer.parseInt(num);
		} else {
			back.push(access);
			access = Integer.parseInt(num);
		}

	}

	static void F() {
		if (front.isEmpty()) {
			return;
		}

		// 1)
		back.push(access);

		// 2)
		access = front.peek();
		front.pop();
	}

	static void C() {
		List<Integer> tempList = new ArrayList<>();

		int prev = 0;
		while (!back.isEmpty()) {
			if (prev == back.peek()) {
				back.pop();
				continue;
			}

			tempList.add(back.peek());

			prev = back.peek();
			
			back.pop();
		}
		
		Collections.reverse(tempList);

		for (int i = 0; i < tempList.size(); i++) {
			back.push(tempList.get(i));
//			System.out.println(tempList.get(i));
		}

	}
}