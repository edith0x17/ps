#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

struct xy {int x, y;};
string board[5];

int abs(int a) {return a < 0 ? -a : a;}

bool isConnected(const vector<xy> &v) {
    queue<int> Q;
    Q.push(6);
    bool vis[6];
    for(int i=0; i<6; i++) vis[i] = false;
    while(!Q.empty()) {
        int cur = Q.front(); Q.pop();
        for(int nxt = 0; nxt < 6; nxt++) {
            if(vis[nxt]) continue;
            if(abs(v[nxt].x - v[cur].x) + abs(v[nxt].y - v[cur].y) == 1) {
                vis[nxt] = true;
                Q.push(nxt);
            }
        }
    }
    for(bool x:vis) if(!x) return false;
    return true;
}

int main() {
    ios::sync_with_stdio(0); cin.tie(0);
    for(int i=0; i<5; i++) cin >> board[i];
    
    int ans = 0;
    vector mask(25, 1);
    for(int i=0; i<7; i++) mask[i] = 0;
    do {
        vector<xy> selected;
        for(int i=0; i<25; i++)
            if(mask[i] == 0) selected.push_back({ i / 5, i % 5 });
        if(!isConnected(selected)) continue;

        int cnt = 0;
        for(const auto &[x, y]:selected)
            if(board[x][y] == 'S' && ++cnt == 4) break;
        if(cnt == 4) ans++;
    } while(next_permutation(mask.begin(), mask.end()));
    cout << ans;
}