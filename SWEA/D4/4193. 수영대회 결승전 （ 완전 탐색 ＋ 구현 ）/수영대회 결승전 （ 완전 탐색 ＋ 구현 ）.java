import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//swea userProblem 4193 수영대회 결승전 ( 완전 탐색 + 구현 ) 
public class Solution {
	static int N;
	static int res;
	static int[][] map;
	static int sx, sy, ex, ey;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int t = 1; t <= TC; t++) {
			res = Integer.MAX_VALUE;
			
			N = sc.nextInt();
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j< N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			sy = sc.nextInt();
			sx = sc.nextInt();
			ey = sc.nextInt();
			ex = sc.nextInt();
			//입력 완료
			//bfs로 최단거리 구하기, 소용돌이를 만나면 늦게 이동함로 큐에 넣을때 
			//소용돌이 감한한 카운트 증가 이동
			//큐에서 빼낼때 이동횟수가 가장 먼저 나오도록 하는것이 유리함으로 우선순위 큐 사용
			//Data 빈 관리
			bfs();
			res = res == Integer.MAX_VALUE ? -1 : res;
			System.out.println("#" + t + " " + res);
		}

	}
	static int[] dx = { 1, -1, 0, 0};
	static int[] dy = { 0, 0, 1, -1};
	private static void bfs() {
		// 우선순위큐와 방문체크 배열 사용
		PriorityQueue<Data> pq = new PriorityQueue<>(new Comparator<Data>() {

			@Override
			public int compare(Data o1, Data o2) {
				// TODO Auto-generated method stub
				return (o1.cnt - o2.cnt);
			}
		});
		boolean[][] v = new boolean[N][N];
		//첫번째 시작위치를 큐에 삽입하고 방문체크
		//큐가 빌때까지 로직 구현
		//큐가 비기전에 목적지 도착하면 완료
		//큐가 비었는데 목적지 도착못하면 -1
		pq.offer(new Data(sx,sy,0));
		v[sy][sx] = true;
		Data cur;
		int nx, ny;
		while(!pq.isEmpty()) {
			cur = pq.poll();
			//도착지 체크
			if(cur.x == ex && cur.y == ey) {
				res = cur.cnt;
				return;
			}
			//그렇지 않으면 현재위치에서 원하는 시뮬레이셔 구현(4방위 탐색)
			for(int d = 0; d < 4; d++) {
				nx = cur.x + dx[d];
				ny = cur.y + dy[d];
				//범위 체크 || //방문 체크
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || v[ny][nx]) {
					continue;
				}

				//시뮬레이션체크-1 장애물 체크
				if(map[ny][nx] == 1) {
					continue;
				}

				//시뮬레이션체크-2 소용돌이 체크
				if(map[ny][nx] == 2) {
					int time = 2 - (cur.cnt % 3);

					pq.offer(new Data(nx, ny, cur.cnt + time + 1));

					v[ny][nx] = true;
					continue;
				}
				//방문하지 않았다면 큐에 삽입
				pq.offer(new Data(nx, ny, cur.cnt + 1));
				v[ny][nx] = true;
			}
			
		}
		
	}
	static class Data{
		int x, y;
		int cnt; // 이동횟수(이동시간)
		
		public Data(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Data [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
		}
		
	}

}
