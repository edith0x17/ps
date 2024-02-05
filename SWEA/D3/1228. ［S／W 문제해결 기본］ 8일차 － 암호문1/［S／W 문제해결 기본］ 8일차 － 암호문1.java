
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int tc = 10;
		
		for(int t = 1; t <= tc; t++) {
			List<Integer> list = new ArrayList<>();
			
			int n = sc.nextInt();
			for(int i = 0; i < n; i++) {
				int num = sc.nextInt();
				list.add(num);
			}
			
			
			int m = sc.nextInt();
			for(int i = 0; i < m; i++) {
				 char ch = sc.next().charAt(0);
				 int here = sc.nextInt();
				 int range = sc.nextInt();
				 
				 int cnt = 0;
				 for(int j = here; j < here + range; j++) {
					 int temp = sc.nextInt();
					 list.add(j + cnt, temp);
				 }
				
			}
			
			
			
			
			
			
			
			
			
			
			System.out.print("#" + t + " ");
			for(int i = 0; i < 10; i++)System.out.printf("%d ", list.get(i));
            System.out.println();
		}

	}

}
