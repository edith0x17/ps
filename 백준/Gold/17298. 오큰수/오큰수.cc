#include <iostream>
#include <stack>
using namespace  std;
int n, a[1000004];
stack<pair<int, int>> stk; // {value, idx}
int main(){
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> n;

	for(int i = 0; i < n; i++){
		int value;
		cin >> value;
		
		if(stk.size()){ // O
			if(stk.top().first < value){
				
				while(true){
					if(stk.size()){
						if(stk.top().first < value){
							a[stk.top().second] = value;
							stk.pop();
						}else break;
					}else break;
				}

				stk.push({value, i});
			}else{
				stk.push({value, i});
			}
		}else{ // X
			stk.push({value, i});
		}
	}

	while(!stk.empty()){
		a[stk.top().second] = -1;
		stk.pop();
	}

	for(int i = 0; i < n; i++){
		cout << a[i] << ' ';
	}
	return 0;
}