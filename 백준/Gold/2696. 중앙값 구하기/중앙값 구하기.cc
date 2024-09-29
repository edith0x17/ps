#include <bits/stdc++.h>
using namespace std;

int t, m, num;
/*
1. 최대힙의 크기는 최소힙의 크기보다 하나 더 크거나 같아야 합니다.
2. 최대힙의 최대 원소는 최소힙의 최소원소보다 작거나 같아야 합니다.
*/

int main() {
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

    cin >> t;
    while (t--) {
        priority_queue<int> mx;  // 중간값 이하 중 최대
        priority_queue<int, vector<int>, greater<int>> mi;  // 중간값 이상 중 최소
        vector<int> ans;

        cin >> m;
        cin >> num;
        mx.push(num);
        ans.push_back(num);
        for (int i = 2; i <= m; i++) {
            cin >> num;
            if (i % 2 != 0) {// 홀수
                if (num <= mx.top()) {
                    mx.push(num);
                }
                else mi.push(num);

                if (mx.size() > mi.size() + 1) {
                    mi.push(mx.top());
                    mx.pop();
                }
                else if (mi.size() > mx.size()) {
                    mx.push(mi.top());
                    mi.pop();
                }
                ans.push_back(mx.top());
            }
            else {// 짝수
                if (num <= mx.top()) {// 중간값 이하
                    mx.push(num);
                }
                else mi.push(num);// 중간값 이상

                if (mx.size() > mi.size() + 1) {// 최대힙 > 최소힙 + 1 => 차이는 같거나 혹은 하나 차이
                    mi.push(mx.top());
                    mx.pop();
                }
                else if (mi.size() > mx.size()) {
                    mx.push(mi.top());
                    mi.pop();
                }
            }
        }
        cout << ans.size() << "\n";
        for (int i = 0; i < ans.size(); i++) {
            if (i != 0 && i % 10 == 0) {
                cout << "\n";
            }
            cout << ans[i] << " ";
        }
        cout << "\n";
    }
    return 0;
}