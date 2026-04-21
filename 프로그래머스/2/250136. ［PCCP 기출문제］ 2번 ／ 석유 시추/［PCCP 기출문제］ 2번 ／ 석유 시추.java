import java.util.*;

class Solution {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    
    static int n, m;
    static boolean[][] visited;
    static int[] colOil;
    
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length; m = land[0].length;
        visited = new boolean[n][m];
        colOil = new int[m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(land[i][j] == 1 && !visited[i][j]){
                    Set<Integer> set = new HashSet<>();
                    int cnt = go(i, j, land, set);
                    //System.out.println("cnt = " + cnt);
                    for(int tmp: set){
                        colOil[tmp] += cnt;
                    }
                }
            }
        }
        for(int i: colOil){
            answer = Math.max(answer, i);
        }
        return answer;
    }
    
    static int go(int x, int y, int[][] land, Set<Integer> set){
        Queue<int[]> q = new ArrayDeque<>();
        int ret = 1;
        set.add(y);
        visited[x][y] = true;
        q.offer(new int[]{x, y});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            x = cur[0]; y = cur[1];
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m)continue;
                if(visited[nx][ny])continue;
                if(land[nx][ny] == 0)continue;
                ret++;
                set.add(ny);
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
        return ret;
    }
}