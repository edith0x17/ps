#include <iostream>
#include <unordered_map>
#include <set>
using namespace std;
int t, n;
int main(){
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> t;

	while(t--){
		set<string> s;
		unordered_map<string, int> mp;

		cin >> n;

		for(int i = 0; i < n; i++){		
			string ss, sss;
			cin >> ss >> sss; // 의상의 이름과 의상의 종류

			s.insert(sss);
			mp[sss]++;
		}

		int ret = 1;
		for(string temp: s){
			ret *= (mp[temp] + 1);
		}

		cout << ret - 1 << '\n';
	}
	return 0;
}