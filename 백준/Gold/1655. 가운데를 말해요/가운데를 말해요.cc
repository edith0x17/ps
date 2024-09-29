#include <bits/stdc++.h>
using namespace std;

int n, num;
/*
1. 최대힙의 크기는 최소힙의 크기보다 하나 더 크거나 같아야 합니다.
2. 최대힙의 최대 원소는 최소힙의 최소원소보다 작거나 같아야 합니다.
*/
priority_queue<int> mx;  // 중간값 이하 중 최대
priority_queue<int, vector<int>, greater<int>> mi;  // 중간값 이상 중 최소

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;
    cin >> num;
    mx.push(num);  // 첫 번째 입력은 무조건 최대힙에 넣는다.
    cout << mx.top() << " ";  // 첫 번째 중간값은 바로 출력

    for (int i = 1; i < n; i++) {
        cin >> num;

        if (num <= mx.top()) {  // 최대힙의 top 값과 비교
            mx.push(num);
        }
        else {
            mi.push(num);
        }

        // 최대힙의 크기가 최소힙보다 2개 이상 크면 안됨
        if (mx.size() > mi.size() + 1) {
            mi.push(mx.top());
            mx.pop();
        }
        else if (mi.size() > mx.size()) {  // 최소힙이 더 크면 균형 맞추기
            mx.push(mi.top());
            mi.pop();
        }

        cout << mx.top() << "\n";  // 최대힙의 top 값을 출력 (중간값)
    }
    return 0;
}