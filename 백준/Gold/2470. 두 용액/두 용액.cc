#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int n, mi = 2000000000;
vector<int> v;
int a, b;

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> n;

	for(int i = 0; i < n; i++){
		int temp;
		cin >> temp;
		v.push_back(temp);
	}

	sort(v.begin(), v.end());

	int l = 0, r = n - 1;
	while(l < r){
		
		int sum = v[l] + v[r];

        if (mi > abs(sum)) {
            mi = abs(sum);

            a = v[l];
            b = v[r]; 

            if (sum == 0)break;
        }

        if(sum < 0)l++;
        else r--;
	}

	cout << a << ' ' << b << '\n';
	return 0;
}
