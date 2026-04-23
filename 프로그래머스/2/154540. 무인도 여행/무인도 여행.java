import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static int n, m;
    static int[][] a;
    static boolean[][] visited;
    static Queue<int[]> q = new ArrayDeque<>();
    
    public int[] solution(String[] maps) {
        n = maps.length; m = maps[0].length();
        a = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(maps[i].charAt(j) == 'X') a[i][j] = -999;
                else a[i][j] = maps[i].charAt(j) - '0';
            }
        }
        ArrayList<Integer> ret = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] != -999 && !visited[i][j]){
                    ret.add(bfs(i, j));
                }
            }
        }
        int[] answer = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            answer[i] = ret.get(i);
        }
        Arrays.sort(answer);
        if(answer.length == 0)return new int[]{-1};
        else return answer;
    }
    
    static int bfs(int x, int y){
        int ret = a[x][y];
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
                if(a[nx][ny] == -999)continue;
                ret += a[nx][ny];
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
        return ret;
    }
}