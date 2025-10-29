#include <bits/stdc++.h>
using namespace std;
const int dx[] = { -1, 0, 1, 0 };
const int dy[] = { 0, 1, 0, -1 };

int a[5][5], visited[(1 << 25)]; // 성공한 경로...
int ans;
void dfs(int depth, int cnt, int path) { // path -> 경로, cnt -> 'S'개수
    if (depth == 7) {
        if (cnt >= 4) ans++;
        return;
    }

    for (int k = 0; k < 25; k++) {
        if ((path & (1 << k)) == 0) continue; // 이미 포함된 경로
        int x = k / 5;
        int y = k % 5;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int num = nx * 5 + ny;
            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
            if (visited[path | (1 << num)]) continue; // 이미 탐색된 경로 건너뜀

            visited[path | (1 << num)] = 1; // 새로운 경로 방문 처리
            if (a[nx][ny] == 1) dfs(depth + 1, cnt + 1, path | (1 << num));
            else dfs(depth + 1, cnt, path | (1 << num));
        }
    }
}
int main() {
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

    for (int i = 0; i < 5; i++) {
        string s;
        cin >> s;
        for (int j = 0; j < 5; j++) {
            if (s[j] == 'S') a[i][j] = 1;
            else a[i][j] = 0;
        }
    }

    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            visited[1 << (i * 5 + j)] = 1;
            if (a[i][j] == 1) dfs(1, 1, 1 << (i * 5 + j));
            else dfs(1, 0, 1 << (i * 5 + j));
        }
    }
    cout << ans << "\n";
    return 0;
}