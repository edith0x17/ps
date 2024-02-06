#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

struct A {
	int num;
	int day;
	int r;
};
int n, k;
vector<int> v;
vector<A> vv;


bool cmp(A a, A b) {// 날짜, 추천수
	if (a.r == b.r) return a.day > b.day;// 0, 1, 2, 3 -> 내림차순

	return a.r > b.r; // 내림차순
}


int check(int tar) {
	for (int i = 0; i < vv.size(); i++) {
		if (vv[i].num == tar) return i;
	}

	return -1;
}

int main() {
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

	cin >> n >> k;


	for (int i = 0; i < k; i++) {
		int temp;
		A a; 
		cin >> temp;

		a.num = temp;
		a.day = i;
		a.r = 1;


		if (vv.size()) { // 차
			int ret = check(temp);

			if (0 <= ret) {// 사진속에 있냐
				vv[ret].r++;
			}
			else {// 사진속에 없냐
				if (n < vv.size() + 1) {
					sort(vv.begin(), vv.end(), cmp); // 정렬

					vv.pop_back(); // 빼주기
				}
				vv.push_back(a); // 넣기
			}
		}
		else { // 빈
			vv.push_back(a);
		}
	}

	vector<int> ans;
	for (A i : vv) {
		ans.push_back(i.num);
	}

	sort(ans.begin(), ans.end());
	for (int i : ans)cout << i << " ";

	return 0;
}
