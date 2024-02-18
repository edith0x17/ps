#include <iostream>
using namespace std;
int n, m;
int p[1000004];
// p[i] -> i의 부모, p[i]는 i의 부모가 누구에요???
int Find(int x){
    if(x == p[x])return x; // 부모 찾음
    else return p[x] = Find(p[x]); // 부모 못찾음
}

void Union(int x, int y){
    x = Find(x); // x의 부모
    y = Find(y); // y의 부모
    p[y] = p[x]; // y의 부모 <- x의 부모
}
int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m;
    
    for(int i = 0; i <= n + 1; i++)p[i] = i;

    for(int i = 0; i < m; i++){
        int type, x, y;
		cin >> type >> x >> y;

        if (type == 0) {
			Union(x, y);
		}
		else {
			if (Find(x) == Find(y))cout << "YES\n";
			else cout << "NO\n";
		}
    }
    return 0;
}
