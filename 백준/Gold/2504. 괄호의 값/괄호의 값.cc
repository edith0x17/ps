#include <bits/stdc++.h>
using namespace std;
string str;
stack<char> stk;
int main(){
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> str;
	int temp = 1, sum = 0;
	for(int i = 0; i < str.length(); i++){
		if (str[i] == '('){
			temp *= 2;
			stk.push('(');
		}else if (str[i] == '['){
			temp *= 3;
			stk.push('[');
		}else if(str[i] == ')'){
			if(stk.empty() || stk.top() != '('){
				sum = 0;
				break;
			}else if(str[i - 1] == '('){ // 파고 들어가기 
				sum += temp;
			}
			temp /= 2;
			stk.pop();
		}else if(str[i] == ']'){
			if(stk.empty() || stk.top() != '['){
				sum = 0;
				break;
			}else if(str[i - 1] == '['){ // 파고 들어가기 
				sum += temp;
			}
			temp /= 3;
			stk.pop();
		}
	}
	if (!stk.empty())sum = 0;
	cout << sum << "\n";
	return 0;
}