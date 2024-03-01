#include <iostream>
#include <cstring>
#include <unordered_map>
using namespace std;
int n, m;
unordered_map<string, int> mp1; // 문자열 숫자
unordered_map<int, string> mp2; // 숫자 문자열
int main(){
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> n >> m;

	for(int i = 0; i < n; i++){
		// i + 1
		string s;
		cin >> s;
		mp1[s] = i + 1;
		mp2[i + 1] = s;
	}

	for(int i = 0; i < m; i++){
		string s;
		cin >> s;

		if(s[0] <= '9'){
			int num = stoi(s);	
			cout << mp2[num] << '\n';
		}else cout << mp1[s] << '\n';
	}

	return 0;
}