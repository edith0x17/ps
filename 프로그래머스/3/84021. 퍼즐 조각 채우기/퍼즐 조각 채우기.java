import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;

    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        ArrayList<ArrayList<int[]>> empties = new ArrayList<>();
        ArrayList<ArrayList<int[]>> blocks = new ArrayList<>();
        //game_board//0은 빈칸, 1은 이미 채워진 칸
        visited = new boolean[game_board.length][game_board[0].length];
        for (int i = 0; i < game_board.length; i++) {
            for (int j = 0; j < game_board[0].length; j++) {
                if (game_board[i][j] == 0 && !visited[i][j]) {
                    ArrayList<int[]> tmp = dfs(i, j, game_board, 0);
                    empties.add(tmp);
                }
            }
        }
        //table//0은 빈칸, 1은 조각이 놓인 칸
        visited = new boolean[table.length][table[0].length];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (table[i][j] == 1 && !visited[i][j]) {
                    ArrayList<int[]> tmp = dfs(i, j, table, 1);
                    blocks.add(tmp);
                }
            }
        }
        /*ArrayList<ArrayList<int[]>> empties = new ArrayList<>();
        ArrayList<ArrayList<int[]>> blocks = new ArrayList<>();*/
        for (int i = 0; i < empties.size(); i++) {
            empties.set(i, normalize(empties.get(i)));
        }
        for (int i = 0; i < blocks.size(); i++) {
            blocks.set(i, normalize(blocks.get(i)));
        }

        boolean[] used = new boolean[blocks.size()];
        for (ArrayList<int[]> empty : empties) {//빈

            for (int i = 0; i < blocks.size(); i++) {//블록
                if (used[i]) continue;

                ArrayList<int[]> cur = blocks.get(i);

                if (empty.size() != cur.size()) continue;

                for (int d = 0; d < 4; d++) {
                    if (same(empty, cur)) {
                        used[i] = true;
                        answer += empty.size();
                        break;
                    }
                    cur = rotate(cur);
                }
                if (used[i]) break;
            }
        }
        return answer;
    }

    static boolean same(ArrayList<int[]> a, ArrayList<int[]> b) {
        if (a.size() != b.size()) return false;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i)[0] != b.get(i)[0]) return false;
            if (a.get(i)[1] != b.get(i)[1]) return false;
        }
        return true;
    }

    static ArrayList<int[]> rotate(ArrayList<int[]> shape) {
        ArrayList<int[]> ret = new ArrayList<>();
        for (int[] p : shape) {
            int x = p[0];
            int y = p[1];
            ret.add(new int[]{-y, x});
        }
        return normalize(ret);
    }

    static ArrayList<int[]> normalize(ArrayList<int[]> shape) {
        ArrayList<int[]> ret = new ArrayList<>();
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        for (int[] tmp : shape) {
            minX = Math.min(minX, tmp[0]);
            minY = Math.min(minY, tmp[1]);
        }
        for (int[] tmp : shape) {
            ret.add(new int[]{tmp[0] - minX, tmp[1] - minY});
        }
        ret.sort((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        return ret;
    }

    static ArrayList<int[]> dfs(int x, int y, int[][] map, int flag) {
        ArrayList<int[]> ret = new ArrayList<>();
        visited[x][y] = true;
        ret.add(new int[]{x, y});
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
            if (visited[nx][ny]) continue;
            if (map[nx][ny] != flag) continue;
            ret.addAll(dfs(nx, ny, map, flag));
        }
        return ret;
    }
}