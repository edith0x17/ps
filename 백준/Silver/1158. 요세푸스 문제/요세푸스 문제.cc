#include <iostream>
#include <list>
using namespace std;

int main() {
	int n, k;
	list<int> lst;
	list<int>::iterator itr;
	
	cin >> n >> k;

	for (int i = 1; i <= n; i++) {
		lst.push_back(i);
	}

	cout << "<";

	itr = lst.begin();

	while (lst.size() != 1) {
		for (int i = 0; i < k - 1; i++) { // 해당 지점 포함
			itr++;
			if (itr == lst.end())
				itr = lst.begin();
		}

		cout << *itr << ", ";

		itr = lst.erase(itr); // erase()함수의 반환값 == 삭제 원소 다음에 있는 원소의 반복자

		if (itr == lst.end())  //끝의 요소 다음이 lst.end()인 경우
			itr = lst.begin();
	}

	cout << *itr << ">";
	return 0;
}