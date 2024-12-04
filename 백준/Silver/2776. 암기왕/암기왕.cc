#include <iostream>
#include <unordered_map>
 
using namespace std;
 
int main()
{
    ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    int t; 
    cin >> t;
    
    while(t--) {
        int n, m;
        unordered_map<int, bool> Map;
        
        cin >> n;
        for(int i = 0; i < n; i++) {
            int a;
            cin >> a;
            Map[a] = true;
        }
        
        cin >> m;
        for(int i = 0; i < m; i++) {
            int a;
            cin >> a;
            
            if(Map[a]) {
                cout << "1\n";
            }
            else cout << "0\n";
        }
    }    
}