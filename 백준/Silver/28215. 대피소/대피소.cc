#include <bits/stdc++.h>
using namespace std;

int n, k;
vector<pair<int, int>> vv;
int ret = 987654321;

void combi(int depth, int start, vector<int>& b) {
    if (depth == k) {
        int mx = -1;
        for (int i = 0; i < n; i++) {
            // 각 점에 대해 최소 거리 계산
            int min_dist = 987654321;
            for (auto at : b) {
                int dist = abs(vv[at].first - vv[i].first) + abs(vv[at].second - vv[i].second);
                min_dist = min(min_dist, dist);
            }
            // 각 점에서의 최소 거리 중 최대 거리 찾기
            mx = max(mx, min_dist);
        }
        ret = min(ret, mx);
        return;
    }

    for (int i = start; i < n; i++) {
        b.push_back(i);
        combi(depth + 1, i + 1, b);
        b.pop_back();
    }
}

int main() {
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

    cin >> n >> k;
    for (int i = 0; i < n; i++) {
        int a, b;
        cin >> a >> b;
        vv.push_back({ a, b });
    }

    vector<int> b;
    combi(0, 0, b);
    cout << ret << "\n";
    return 0;
}